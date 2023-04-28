package ai.lentra.serviceImpl.allocation;
import ai.lentra.commons.NotificationUtils;
import ai.lentra.commons.TokenAuth;
import ai.lentra.controller.notification.EmailController;
import ai.lentra.controller.notification.SMSController;
import ai.lentra.dto.allocation.AssignResponse;
import ai.lentra.dto.notification.SMS.Messages;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.applicant_details.ApplicantDetails;
import ai.lentra.modal.allocation.Assignor;
import ai.lentra.dto.allocation.VerifierDetails;
import ai.lentra.modal.allocation.Verification;
import ai.lentra.modal.allocation.Verifiers;
import ai.lentra.repository.allocation.AssignerRepository;
import ai.lentra.repository.allocation.VerificationRepository;
import ai.lentra.repository.allocation.VerifierRepository;
import ai.lentra.repository.applicant.ApplicantDetailsRepository;
import ai.lentra.service.allocation.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static ai.lentra.commons.EmailAndSMSTemplate.*;

import static ai.lentra.commons.FiIdGen.genFiId;



@Service
public class AllocationServiceImpl implements AllocationService {
 @Autowired
 VerificationRepository verificationRepository;
 @Autowired
 AssignerRepository assignerRepository;
    @Autowired
    ApplicantDetailsRepository applicantRepository;
    @Autowired
    VerifierRepository verifierRepository;

    @Autowired
    NotificationUtils notification;
    @Autowired
    EmailController emailController;
    @Autowired
    SMSController smsController;
    @Autowired
    TokenAuth tokenAuth;

@Override
 /*For Internal Allocations lis  Branch TL -> Branch Team Member or Agency TL to Agency Team Member*/
    public ResponseEntity<Object> fiAllocationBranch(VerifierDetails verifierDetails, boolean isSelf) throws ResourceNotFoundException {
    boolean isExist = verificationRepository.findByAssignedToAndApplicantId(verifierDetails.getAssignedTo(), verifierDetails.getApplicantId()).isPresent();
    applicantRepository.findByApplicantId(verifierDetails.getApplicantId()).orElseThrow(() -> new ResourceNotFoundException("Requested Applicant Details not found"));
    if (isExist) {
        return ResponseEntity.ok().body("VerificationDTO for the applicant and the verifier is already present");
    }
    String fiId = genFiId().toUpperCase(); //this will return UUID
    Verification verification = new Verification();
    Assignor assignor = new Assignor();
    if (verifierDetails.getFiId() != null) {
        verification.setRefFiId(verifierDetails.getFiId());
        assignor.setRefFiId(verifierDetails.getFiId());
    }
    //update VerificationDTO details
    verification.setFiId(fiId);
    verification.setApplicantName(verifierDetails.getApplicantName());
    verification.setCaseId(verifierDetails.getCaseId());
    verification.setInsId(verifierDetails.getInstitutionId());
    verification.setApplicationId(String.valueOf(verifierDetails.getApplicationId()));
    verification.setApplicantId(verifierDetails.getApplicantId());
    verification.setApplicantType(verifierDetails.getApplicantType());
    verification.setAssignedBy(verifierDetails.getAssignedBy());

    verification.setAgencyName(verifierDetails.getAssignedAgencyName());
    verification.setAgencyCode(verifierDetails.getAssignedAgencyCode());
    verification.setAssignedDateTime(Instant.now().toString());//yet to be added
    verification.setVerificationStatus(verifierDetails.getVerificationStatus());
    verification.setVerificationStage(verifierDetails.getVerificationStage());
    if (isSelf) {
        verification.setAssignedTo(verifierDetails.getAssignedBy()); // assigned to self
        verification.setvStatus("ACCEPTED");  // if it is a self which means he/she accepted the verification by him/her self
        verification.setaStatus("ONGOING");
        verification.setAcceptedDateTime(Instant.now().toString());
    } else {
        verification.setAssignedTo(verifierDetails.getAssignedTo());
        verification.setvStatus("AWAITING ACTION ");
        verification.setaStatus("PENDING");
    }
    verification.setLoanAmount(verifierDetails.getLoanAmount());
    verification.setApplicantAddress(verifierDetails.getApplicantAddress());
    verification.setApplicantPincode(verifierDetails.getApplicantPincode());
    verification.setAddressType(verifierDetails.getAddressType());
    verification.setMobileNumber(verifierDetails.getMobileNumber());
    verification.setRemarks(verifierDetails.getRemarks());
    //Assigner table
    assignor.setFiId(fiId);
    assignor.setCaseId(verifierDetails.getCaseId());
    assignor.setInsId(verifierDetails.getInstitutionId());
    assignor.setApplicationId(String.valueOf(verifierDetails.getApplicationId()));
    assignor.setApplicantId(String.valueOf(verifierDetails.getApplicantId()));
    assignor.setApplicantName(verifierDetails.getApplicantName());
    assignor.setAssignedBy(verifierDetails.getAssignedBy());
    if (verifierDetails.getAssignedAgencyName() != null && verifierDetails.getAssignedAgencyCode() != null) {
        assignor.setAssignedAgencyName(verifierDetails.getAssignedAgencyName());
        assignor.setAssignedAgencyCode(verifierDetails.getAssignedAgencyCode());
    }
    if (verifierDetails.getAssignedBranchName() != null && verifierDetails.getAssignedBranchCode() != null) {
        assignor.setAssignedBranchName(verifierDetails.getAssignedBranchName());
        assignor.setAssignedBranchCode(verifierDetails.getAssignedBranchCode());
    }
    assignor.setAssignedDateTime(verification.getAssignedDateTime());
//        if (isSelf)  check is self-assigned or not
    if (isSelf) {
        assignor.setAssignedTo(verifierDetails.getAssignedBy());
        assignor.setaStatus("ACCEPTED");
        assignor.setaStatus("ONGOING");
        verification.setAcceptedDateTime(Instant.now().toString());
    } else {
        assignor.setAssignedTo(verifierDetails.getAssignedTo());
        assignor.setaStatus("Pending");
        assignor.setvStatus("Awaiting Action");
    } //updated once verifier Status is updated
    assignor.setAddress(verifierDetails.getAddress());
    assignor.setAddressType(verification.getAddressType());
    assignor.setLoanAmount(verification.getLoanAmount());

    assignerRepository.save(assignor);
    verificationRepository.save(verification);

    if (isSelf) {
        //todo: to update applicant details to verifier table with verification details
        ApplicantDetails applicantDetails = applicantRepository.findByApplicantId(verifierDetails.getApplicantId()).orElseThrow(() -> new ResourceNotFoundException("Applicant details not found for the specified applciant id" + verifierDetails.getApplicantId()));
        Verifiers verifiers = new Verifiers();
        verifiers.setAge(applicantDetails.getPersonalDetails().getAge());
        verifiers.setCaseId(String.valueOf(applicantDetails.getCaseId()));
        verifiers.setInsId(applicantDetails.getInsId());
        verifiers.setApplicantId(String.valueOf(applicantDetails.getApplicantId()));
        verifiers.setApplicantType(applicantDetails.getApplicantType());
        verifierRepository.save(verifiers);
        notification.invoke(verifierDetails.getUsername(), "Filed investigation Verification Self assign Successfully \n" +
                "Applicant Details \n" +
                "\n Name  : " + verifierDetails.getApplicantName() +
                "\n Applicant id : " + verifierDetails.getApplicantId() +
                "\n Loan Amount  : " + verifierDetails.getLoanAmount() +
                "\n Address : " + verifierDetails.getApplicantAddress());


        emailController.sendEmail(
                statusUpdateMail(
                        new String[]{verification.getAssignedBy()}, new String[]{}, "Filed investigation Verification Self assign Successfully : " + verification.getFiId(), new String[]{}, new HashSet<>()
                        , "Filed investigation Verification Self assign Successfully \n" +
                                "Applicant Details \n" +
                                "\n Name  : " + verifierDetails.getApplicantName() +
                                "\n Applicant id : " + verifierDetails.getApplicantId() +
                                "\n Loan Amount  : " + verifierDetails.getLoanAmount() +
                                "\n Address : " + verifierDetails.getApplicantAddress()), "application/json", tokenAuth.getToken(), "", "", "SUPERSIXTY", "", "", "HL");
        HashSet<Messages> messageSet = new HashSet();
        messageSet.add(getMessages("en", "", new String[]{"9500055109"}, "1", "1", "Filed investigation Verification Self assign Successfully \n" +
                "Applicant Details \n" +
                "\n Name  : " + verifierDetails.getApplicantName() +
                "\n Applicant id : " + verifierDetails.getApplicantId() +
                "\n Loan Amount  : " + verifierDetails.getLoanAmount() +
                "\n Address : " + verifierDetails.getApplicantAddress()));

        smsController.sendSms(statusUpdateSms(messageSet), "application/json", tokenAuth.getToken(), "", "", "SUPERSIXTY", "", "", "HL");
    } else {
        notification.invoke(verifierDetails.getUsername(), "Filed investigation Allocated  \n" +
                "Applicant Details \n" +
                "\n Name  : " + verifierDetails.getApplicantName() +
                "\n Applicant id : " + verifierDetails.getApplicantId() +
                "\n Loan Amount  : " + verifierDetails.getLoanAmount() +
                "\n Address : " + verifierDetails.getApplicantAddress() +
                "\n Assigned By : " + verifierDetails.getAssignedBy() +
                "\n Assigned Date Time : " + verification.getAssignedDateTime() +
                "\n Date : " + verification.getRefFiId()
        );

        //to send email notification

        emailController.sendEmail(
                statusUpdateMail(
                        new String[]{verification.getAssignedBy()}, new String[]{}, "Verification Status Updated for the  FiId : " + verification.getFiId(), new String[]{}, new HashSet<>()
                        , "A Query has been raised by Verifier " + verification.getAssignedTo() +
                                "Applicant Details \n" +
                                "\n Name  : " + verification.getApplicantName() +
                                "\n Status : " + verification.getvStatus() +
                                "\n Applicant id : " + verification.getApplicantId() +
                                "\n Loan Amount  : " + verification.getLoanAmount() +
                                "\n Query  : " + verification.getvQueries() +
                                "\n Queried  Date: " + verification.getvQueryDate() +
                                "\n Address : " + verification.getApplicantAddress() +
                                "\n Assigned By : " + verification.getAssignedBy() +
                                "\n Assigned Date Time : " + verification.getAssignedDateTime() +
                                "\n Date : " + verification.getRefFiId()), "application/json", tokenAuth.getToken(), "", "", "SUPERSIXTY", "", "", "HL");


        HashSet<Messages> messageSet = new HashSet();
        messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                "Applicant Details \n" +
                "\n Name  : " +verifierDetails.getApplicantName()+
                "\n Applicant id : " +verifierDetails.getApplicantId()+
                "\n Loan Amount  : " +verifierDetails.getLoanAmount()+
                "\n Address : "+verifierDetails.getApplicantAddress()));

        smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
        AssignResponse assignResponse = new AssignResponse();
        assignResponse.setAssignedDate(verification.getAssignedDateTime());
        assignResponse.setAssignedBy(verification.getAssignedBy());
        assignResponse.setAssignedTo(verification.getAssignedTo());
        assignResponse.setFiId(verification.getFiId());
        assignResponse.setRefFiId(verification.getRefFiId());
        assignResponse.setRefFiId(verification.getRefFiId());
        return ResponseEntity.ok().body(assignResponse);
    }
    return ResponseEntity.ok("");
}
    @Override
/*External Allocations lis  Agency TL -> Agency Team Member*/
    public ResponseEntity<Object> fiAllocationAgency(VerifierDetails verifierDetails, boolean isSelf) throws ResourceNotFoundException {

        applicantRepository.findByApplicantId(verifierDetails.getApplicantId()).orElseThrow(()-> new ResourceNotFoundException("Requested Applicant Details not found"));
        boolean isExist= verificationRepository.findByAgencyNameAndApplicantId(verifierDetails.getAgencyName(), verifierDetails.getApplicantId()).isPresent();
        if(isExist) {
            return  ResponseEntity.ok().body("VerificationDTO for the applicant and the agency is already present");
        }
        String fiId= genFiId().toUpperCase();
        Verification verification = new Verification();
        Assignor assignor = new Assignor();
        if (verifierDetails.getFiId()!=null){
            verification.setRefFiId(verifierDetails.getFiId());
            assignor.setRefFiId(verifierDetails.getFiId());
        }
        //update VerificationDTO details
        verification.setFiId(fiId);
        verification.setApplicantName(verifierDetails.getApplicantName());
        verification.setCaseId(verifierDetails.getCaseId());
        verification.setInsId(verifierDetails.getInstitutionId());
        verification.setApplicationId(String.valueOf(verifierDetails.getApplicationId()));
        verification.setApplicantId(verifierDetails.getApplicantId());
        verification.setApplicantType(verifierDetails.getApplicantType());
        verification.setAssignedBy(verifierDetails.getAssignedBy());
        verification.setAssignedTo(verifierDetails.getAssignedTo());
        verification.setAgencyName(verifierDetails.getAssignedAgencyName());
        verification.setAgencyCode(verifierDetails.getAssignedAgencyCode());
        verification.setAssignedDateTime(Instant.now().toString());//yet to be added
        verification.setVerificationStatus(verifierDetails.getVerificationStatus());
        verification.setVerificationStage(verifierDetails.getVerificationStage());
        if (isSelf){
            verification.setAssignedTo(verifierDetails.getAssignedBy());
            verification.setvStatus("ACCEPTED");  // if it is a self which means he/she accepted the verification by him/her self
            verification.setaStatus("ONGOING");
        }else {
            verification.setvStatus("AWAITING ACTION ");
            verification.setaStatus("PENDING");
        }
        verification.setLoanAmount(verifierDetails.getLoanAmount());
        verification.setApplicantAddress(verifierDetails.getApplicantAddress());
        verification.setApplicantPincode(verifierDetails.getApplicantPincode());
        verification.setAddressType(verifierDetails.getAddressType());
        verification.setMobileNumber(verifierDetails.getMobileNumber());
        verification.setRemarks(verifierDetails.getRemarks());

        //Assigner table
        assignor.setFiId(fiId);
        assignor.setCaseId(verifierDetails.getCaseId());
        assignor.setInsId(verifierDetails.getInstitutionId());
        assignor.setApplicationId(String.valueOf(verifierDetails.getApplicationId()));
        assignor.setApplicantId(String.valueOf(verifierDetails.getApplicantId()));
        assignor.setApplicantName(verifierDetails.getApplicantName());
        assignor.setAssignedBy(verifierDetails.getAssignedBy());
        assignor.setAssignedTo(verifierDetails.getAssignedTo());
        if (verifierDetails.getAssignedAgencyName() != null && verifierDetails.getAssignedAgencyCode() != null){
            assignor.setAssignedAgencyName(verifierDetails.getAssignedAgencyName());
            assignor.setAssignedAgencyCode(verifierDetails.getAssignedAgencyCode());
        }
        if (verifierDetails.getAssignedBranchName()!=null && verifierDetails.getAssignedBranchCode() != null){
            assignor.setAssignedBranchName(verifierDetails.getAssignedBranchName());
            assignor.setAssignedBranchCode(verifierDetails.getAssignedBranchCode());
        }
        assignor.setAssignedDateTime(verification.getAssignedDateTime());
        if (isSelf){
            assignor.setAssignedTo(verifierDetails.getAssignedBy());
            assignor.setaStatus("ACCEPTED");
            assignor.setvStatus("ONGOING");
        }else{
            assignor.setaStatus("Pending");
            assignor.setvStatus("Awaiting Action");
        }
      //updated once verifier Status is updated
        assignor.setAddress(verifierDetails.getAddress());
        assignor.setAddressType(verification.getAddressType());
        assignor.setLoanAmount(verification.getLoanAmount());

        assignerRepository.save(assignor);
        verificationRepository.save(verification);
        if (isSelf){
            //todo: to update applicant details to verifier table with verification details
            ApplicantDetails applicantDetails= applicantRepository.findByApplicantId(verifierDetails.getApplicantId()).orElseThrow(()->new ResourceNotFoundException("Applicant details not found for the specified applciant id"+verifierDetails.getApplicantId()));
            Verifiers verifiers=new Verifiers();
            verifiers.setAge(applicantDetails.getPersonalDetails().getAge());
            verifiers.setCaseId(String.valueOf(applicantDetails.getCaseId()));
            verifiers.setInsId(applicantDetails.getInsId());
            verifiers.setApplicantId(String.valueOf(applicantDetails.getApplicantId()));
            verifiers.setApplicantType(applicantDetails.getApplicantType());
            verifierRepository.save(verifiers);
            notification.invoke(verifierDetails.getUsername(), "Filed investigation Verification Self assign Successfully \n" +
                    "Applicant Details \n" +
                    "\n Name  : " +verifierDetails.getApplicantName()+
                    "\n Applicant id : " +verifierDetails.getApplicantId()+
                    "\n Loan Amount  : " +verifierDetails.getLoanAmount()+
                    "\n Address : "+verifierDetails.getApplicantAddress());

            emailController.sendEmail(
                    statusUpdateMail(
                            new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Updated for the  FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                            ,"Filed investigation Verification Self assign Successfully \n" +
                                    "Applicant Details \n" +
                                    "\n Name  : " +verifierDetails.getApplicantName()+
                                    "\n Applicant id : " +verifierDetails.getApplicantId()+
                                    "\n Loan Amount  : " +verifierDetails.getLoanAmount()+
                                    "\n Address : "+verifierDetails.getApplicantAddress() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");



            HashSet<Messages> messageSet = new HashSet();
            messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                    "Applicant Details \n" +
                    "\n Name  : " +verifierDetails.getApplicantName()+
                    "\n Applicant id : " +verifierDetails.getApplicantId()+
                    "\n Loan Amount  : " +verifierDetails.getLoanAmount()+
                    "\n Address : "+verifierDetails.getApplicantAddress()));

            smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
        }else{
            notification.invoke(verifierDetails.getUsername(), "Filed investigation Allocated  \n" +
                    "Applicant Details \n" +
                    "\n Name  : " +verifierDetails.getApplicantName()+
                    "\n Applicant id : " +verifierDetails.getApplicantId()+
                    "\n Loan Amount  : " +verifierDetails.getLoanAmount()+
                    "\n Address : "+verifierDetails.getApplicantAddress()+
                    "\n Assigned By : " +verifierDetails.getAssignedBy()+
                    "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                    "\n Date : " +verification.getRefFiId()
            );
            emailController.sendEmail(
                    statusUpdateMail(
                            new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Updated for the  FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                            ,"Filed investigation Allocated  \n" +
                                    "Applicant Details \n" +
                                    "\n Name  : " +verifierDetails.getApplicantName()+
                                    "\n Applicant id : " +verifierDetails.getApplicantId()+
                                    "\n Loan Amount  : " +verifierDetails.getLoanAmount()+
                                    "\n Address : "+verifierDetails.getApplicantAddress()+
                                    "\n Assigned By : " +verifierDetails.getAssignedBy()+
                                    "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                                    "\n Date : " +verification.getRefFiId() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");


            HashSet<Messages> messageSet = new HashSet();
            messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                    "Applicant Details \n" +
                    "\n Name  : " +verifierDetails.getApplicantName()+
                    "\n Applicant id : " +verifierDetails.getApplicantId()+
                    "\n Loan Amount  : " +verifierDetails.getLoanAmount()+
                    "\n Address : "+verifierDetails.getApplicantAddress()));

            smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
        }
        AssignResponse assignResponse = new AssignResponse();
        assignResponse.setAssignedDate(verification.getAssignedDateTime());
        assignResponse.setAssignedBy(verification.getAssignedBy());
        assignResponse.setAssignedTo(verification.getAssignedTo());
        assignResponse.setFiId(verification.getFiId());
        assignResponse.setRefFiId(verification.getRefFiId());
        return ResponseEntity.ok().body(assignResponse);

    }





}
