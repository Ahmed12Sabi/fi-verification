package ai.lentra.serviceImpl.verification;

import ai.lentra.commons.*;
import ai.lentra.controller.notification.EmailController;
import ai.lentra.controller.notification.SMSController;
import ai.lentra.dto.allocation.*;
import ai.lentra.dto.notification.SMS.Messages;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.applicant_details.ApplicantDetails;
import ai.lentra.modal.allocation.*;
import ai.lentra.repository.applicant.ApplicantDetailsRepository;
import ai.lentra.repository.allocation.*;
import ai.lentra.service.VerificationService;
import ai.lentra.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ai.lentra.commons.EmailAndSMSTemplate.*;
import static ai.lentra.commons.ResponseUtils.responseGen;
//todo implement Email and SMS notification
@Service
public class VerificationServiceImpl    implements VerificationService {
@Autowired
BranchDealeRepository branchDealeRepository;
    @Autowired
    private ApplicantDetailsRepository applicantRepository;
    @Autowired
    private AgenciesRepository agenciesRepo;
    @Autowired
    VerificationRepository verificationRepo;
    @Autowired
    VerificationRepositoryHistory verificationHistoryRepo;
    @Autowired
    AssignerRepository assignerRepo;
    @Autowired
    VerifierRepository verifierRepo;
    @Autowired
    VerifierRepositoryHistory  verifierHistoryRepo;

    @Autowired
    VmsConfigDataRepo vmsConfigDataRepo;
    @Autowired
    JsonUtils1 jsonUtils1;
    @Autowired
    NotificationUtils notification;

    @Autowired
    EmailController emailController;
    @Autowired
    SMSController smsController;
    @Autowired
    TokenAuth tokenAuth;



@Override
    public ResponseEntity<Object> getBranchesByLocation(String location) throws ResourceNotFoundException {
      return  ResponseEntity.ok(branchDealeRepository.findAllByLocationIgnoreCase(location).orElseThrow(()-> new ResourceNotFoundException("Branches not found in the specified location")));
    }
    @Override

    public List<BranchDealer> saveBranches(List<BranchDealer> branches) {
      return   branchDealeRepository.saveAll(branches);

    }
    @Override

    public List<Agencies> saveAgencies(List<Agencies> agencies) {
       return agenciesRepo.saveAll(agencies);
    }
    @Override

    public ResponseEntity<Object> getNearByBranches(String location, Long applicantId, String addressType, long applicationId, String productType) throws ResourceNotFoundException {
        ApplicantDetails applicantDetails=applicantRepository.findByApplicantId(applicantId).orElseThrow(()->new ResourceNotFoundException("Requested applicant details not found"));
        Optional<List<BranchDealer>> branches=branchDealeRepository.findAllByLocationIgnoreCase(location);
        if (!branches.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGen("Requested branch details not found", ErrorMessage.NOT_FOUND,"404"));
        }
        BranchAgencyAllocationDTO branchAllocation=  new BranchAgencyAllocationDTO();
        branchAllocation.setBranches(Collections.singletonList(branches.get()));
        branchAllocation.setAddress(location);
        branchAllocation.setAddressType(addressType);
        branchAllocation.setApplicantId(applicantId);
        branchAllocation.setApplicationId(applicationId);
        branchAllocation.setProductType(productType);
        return  ResponseEntity.ok(branchAllocation);
    }
    @Override

    public ResponseEntity<Object> getNearByAgencies(String branchName, long applicantId, String addressType, long applicationId, String productType) throws ResourceNotFoundException {
        ApplicantDetails applicantDetails=applicantRepository.findByApplicantId(applicantId).orElseThrow(()->new ResourceNotFoundException("Requested applicant details not found"));
        Optional<List<Agencies>> agencies=agenciesRepo.findAllByBranchNameIgnoreCase(branchName);
        if (!agencies.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGen("There is no Agency Details for the given location","NOT_FOUND","4000"));
        }
        BranchAgencyAllocationDTO agencyAllocation= new BranchAgencyAllocationDTO();
        agencyAllocation.setBranches(agencies.get().stream().filter(Agencies::isActive).collect(Collectors.toList()));
        agencyAllocation.setAddressType(addressType);
        agencyAllocation.setApplicantId(applicationId);
        agencyAllocation.setApplicationId(applicationId);
        agencyAllocation.setProductType(productType);
        return  ResponseEntity.ok(agencyAllocation);
    }
    @Override

    public ResponseEntity<Object> getUsersFromAgency(String branchName)   {
        List<Agencies> agencies=agenciesRepo.findLabelByBranchNameIgnoreCase(branchName);
        if (agencies==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGen("Resource not found","NOT_FOUND","404"));
        }
        UserNamesDTO user= new UserNamesDTO();
        List<UserNamesDTO>  userNames =agencies.stream().map(u->{
            user.setUserName(u.getLabel());
            user.setBranchId(u.getBranchId());
            return user;
        }).collect(Collectors.toList());
            return ResponseEntity.ok().body(userNames);
    }
    @Override

    public ResponseEntity<Object> getUsersAllocationNameAndStatus(String userName, String status) throws ResourceNotFoundException {
        List<Verification> verifications=verificationRepo.findAllByAssignedToAndVerificationStatusIgnoreCase(userName,status).orElseThrow(()->new ResourceNotFoundException("There is no verification allocations for the specified username and status"));
        StatusCardDTO statusCard = new StatusCardDTO();
        List<StatusCardDTO> allocations=verifications.stream().map(ver->{
            statusCard.setStatus(ver.getaStatus());
            statusCard.setAddress(ver.getApplicantAddress());
            statusCard.setAddressType(ver.getAddressType());
            statusCard.setApplicantId(ver.getApplicantId());
            statusCard.setFiId(ver.getFiId());
            statusCard.setStage(ver.getVerificationStage());
            statusCard.setPincode(ver.getApplicantPincode());
            statusCard.setApplicantName(ver.getApplicantName());
            statusCard.setLoanAmount(ver.getLoanAmount());
            statusCard.setApplicationId(ver.getApplicationId());
            return statusCard;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(allocations);
    }
    @Override

    public ResponseEntity<Object> getUsersAllocationName(String userName) throws ResourceNotFoundException {
        List<Verification> verifications=verificationRepo.findAllByAssignedToIgnoreCase(userName).orElseThrow(()->new ResourceNotFoundException("There is no verification allocations for the specified username and status"));
        StatusCardDTO statusCard = new StatusCardDTO();
        List<StatusCardDTO> allocations=verifications.stream().map(ver->{
            statusCard.setStatus(ver.getaStatus());
            statusCard.setAddress(ver.getApplicantAddress());
            statusCard.setAddressType(ver.getAddressType());
            statusCard.setApplicantId(ver.getApplicantId());
            statusCard.setFiId(ver.getFiId());
            statusCard.setStage(ver.getVerificationStage());
            statusCard.setPincode(ver.getApplicantPincode());
            statusCard.setApplicantName(ver.getApplicantName());
            statusCard.setLoanAmount(ver.getLoanAmount());
            statusCard.setApplicationId(ver.getApplicationId());
            return statusCard;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(allocations);
    }
    @Override

    public ResponseEntity<VerificationDTO> getVerificationBasedOnFiId(String fiId) throws ResourceNotFoundException {
        Verification verification = verificationRepo.findByFiId(fiId).orElseThrow(()->new ResourceNotFoundException("There is no verification for the specified fiId : "+fiId));
       VerificationDTO verificationDTO=jsonUtils1.mapper().convertValue(verification,VerificationDTO.class);
       return  ResponseEntity.ok(verificationDTO);
    }
    @Override

    public ResponseEntity<Object> statusUpdate(String status, StatusUpdateDTO statusUpdate) throws ResourceNotFoundException {
        Assignor assignor=assignerRepo.findByFiId(statusUpdate.getFiId()).orElseThrow(()->new ResourceNotFoundException("There is no assignor for the specified fi id"+statusUpdate.getFiId()) );
        Verification verification=  verificationRepo.findByFiId(statusUpdate.getFiId()).orElseThrow(()->new ResourceNotFoundException("There is no verification for the specified fi id"+statusUpdate.getFiId()) );
        if (status.toUpperCase().equals(STATUS.ACCEPTED.toString())){
            if (!verification.getaStatus().equals(STATUS.CANCELLED.toString())){
                verification.setvStatus(status.toUpperCase());
                verification.setAcceptedDateTime(Instant.now().toString());
                verification.setvMode(statusUpdate.getvMode());
                assignor.setvStatus(status.toUpperCase());
                /*todo: internal logic for update verifier table with applicant details */
                notification.invoke(verification.getAssignedBy(), "Filed investigation Status has been changed to ACCEPTED \n" +
                        "Applicant Details \n" +
                        "\n Name  : " +verification.getApplicantName()+
                        "\n Status : "+verification.getvStatus()+
                        "\n Applicant id : " +verification.getApplicantId()+
                        "\n Loan Amount  : " +verification.getLoanAmount()+
                        "\n Address : "+verification.getApplicantAddress()+
                        "\n Assigned By : " +verification.getAssignedBy()+
                        "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                        "\n Date : " +verification.getRefFiId()
                );
                emailController.sendEmail(
                        statusUpdateMail(
                                new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Update FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                                ,"A Query has been raised by Verifier "+verification.getAssignedTo()+
                                        "Applicant Details \n" +
                                        "\n Name  : " +verification.getApplicantName()+
                                        "\n Status : "+verification.getvStatus()+
                                        "\n Applicant id : " +verification.getApplicantId()+
                                        "\n Loan Amount  : " +verification.getLoanAmount()+
                                        "\n Query  : " +verification.getvQueries()+
                                        "\n Queried  Date: " +verification.getvQueryDate()+
                                        "\n Address : "+verification.getApplicantAddress()+
                                        "\n Assigned By : " +verification.getAssignedBy()+
                                        "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                                        "\n Date : " +verification.getRefFiId() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");


                HashSet<Messages> messageSet = new HashSet();
                messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                        "Applicant Details \n" +
                        "\n Name  : " +verification.getApplicantName()+
                        "\n Applicant id : " +verification.getApplicantId()+
                        "\n Loan Amount  : " +verification.getLoanAmount()+
                        "\n Address : "+verification.getApplicantAddress()));

                smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
            }else {
                return  ResponseEntity.noContent().build();
            }
        //todo: update history tables as well
    }else if (status.toUpperCase().equals(STATUS.DECLINED.toString())){ // Declined by the User
        verification.setvStatus(status.toUpperCase());
        verification.setDeclinedDate(Instant.now().toString());
        verification.setDeclinedReason(statusUpdate.getDeclinedReason());
        verification.setVerificationStatus(status.toUpperCase());
        assignor.setvStatus(status.toUpperCase());
            notification.invoke(verification.getAssignedBy(), "Filed investigation Status has been changed to DECLINED \n" +
                    "Applicant Details \n" +
                    "\n Name  : " +verification.getApplicantName()+
                    "\n Status : "+verification.getvStatus()+
                    "\n Applicant id : " +verification.getApplicantId()+
                    "\n Loan Amount  : " +verification.getLoanAmount()+
                    "\n Declined Date: " +verification.getDeclinedDate()+
                    "\n Declined Reason: " +verification.getDeclinedReason()+
                    "\n Address : "+verification.getApplicantAddress()+
                    "\n Assigned By : " +verification.getAssignedBy()+
                    "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                    "\n Date : " +verification.getRefFiId()
            );
            emailController.sendEmail(
                    statusUpdateMail(
                            new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Update FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                            ,"A Query has been raised by Verifier "+verification.getAssignedTo()+
                                    "Applicant Details \n" +
                                    "\n Name  : " +verification.getApplicantName()+
                                    "\n Status : "+verification.getvStatus()+
                                    "\n Applicant id : " +verification.getApplicantId()+
                                    "\n Loan Amount  : " +verification.getLoanAmount()+
                                    "\n Query  : " +verification.getvQueries()+
                                    "\n Queried  Date: " +verification.getvQueryDate()+
                                    "\n Address : "+verification.getApplicantAddress()+
                                    "\n Assigned By : " +verification.getAssignedBy()+
                                    "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                                    "\n Date : " +verification.getRefFiId() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
            HashSet<Messages> messageSet = new HashSet();
            messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                    "Applicant Details \n" +
                    "\n Name  : " +verification.getApplicantName()+
                    "\n Applicant id : " +verification.getApplicantId()+
                    "\n Loan Amount  : " +verification.getLoanAmount()+
                    "\n Address : "+verification.getApplicantAddress()));

            smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
        } else if (status.toUpperCase().equals(STATUS.QUERY_RAISED.toString())) {
            if (verification.getvQueries()!=null && verification.getaReplyMessage()!=null) {
                verification.setvStatus(status.toUpperCase());
                verification.setvQueryDate(Instant.now().toString());
                verification.setvQueries(statusUpdate.getvQuery());
                verification.setaReplyMessage(null);

                notification.invoke(verification.getAssignedBy(), "A Query has been raised by Verifier "+verification.getAssignedTo()+
                        "Applicant Details \n" +
                        "\n Name  : " +verification.getApplicantName()+
                        "\n Status : "+verification.getvStatus()+
                        "\n Applicant id : " +verification.getApplicantId()+
                        "\n Loan Amount  : " +verification.getLoanAmount()+
                        "\n Query  : " +verification.getvQueries()+
                        "\n Queried  Date: " +verification.getvQueryDate()+
                        "\n Address : "+verification.getApplicantAddress()+
                        "\n Assigned By : " +verification.getAssignedBy()+
                        "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                        "\n Date : " +verification.getRefFiId()
                );

                //email Notification

                emailController.sendEmail(
                        statusUpdateMail(
                                new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Update FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                                ,"A Query has been raised by Verifier "+verification.getAssignedTo()+
                                        "Applicant Details \n" +
                                        "\n Name  : " +verification.getApplicantName()+
                                        "\n Status : "+verification.getvStatus()+
                                        "\n Applicant id : " +verification.getApplicantId()+
                                        "\n Loan Amount  : " +verification.getLoanAmount()+
                                        "\n Query  : " +verification.getvQueries()+
                                        "\n Queried  Date: " +verification.getvQueryDate()+
                                        "\n Address : "+verification.getApplicantAddress()+
                                        "\n Assigned By : " +verification.getAssignedBy()+
                                        "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                                        "\n Date : " +verification.getRefFiId() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
                HashSet<Messages> messageSet = new HashSet();
                messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                        "Applicant Details \n" +
                        "\n Name  : " +verification.getApplicantName()+
                        "\n Applicant id : " +verification.getApplicantId()+
                        "\n Loan Amount  : " +verification.getLoanAmount()+
                        "\n Address : "+verification.getApplicantAddress()));

                smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");

            } else if (verification.getvQueries() != null && verification.getaReplyMessage() == null) {
                return ResponseEntity.badRequest().body("Query is already raised and not yet reviewed");
            }else if (verification.getvQueries()==null && verification.getaReplyMessage()==null){
                verification.setvStatus(status.toUpperCase());
                verification.setvQueryDate(Instant.now().toString());
                verification.setvQueries(statusUpdate.getvQuery());
                notification.invoke(verification.getAssignedBy(), "A Query has been raised by Verifier "+verification.getAssignedTo()+
                        "Applicant Details \n" +
                        "\n Name  : " +verification.getApplicantName()+
                        "\n Status : "+verification.getvStatus()+
                        "\n Applicant id : " +verification.getApplicantId()+
                        "\n Loan Amount  : " +verification.getLoanAmount()+
                        "\n Query  : " +verification.getvQueries()+
                        "\n Address : "+verification.getApplicantAddress()+
                        "\n Assigned By : " +verification.getAssignedBy()+
                        "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                        "\n Date : " +verification.getRefFiId()
                );

                emailController.sendEmail(
                        statusUpdateMail(
                                new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Update FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                                ,"A Query has been raised by Verifier "+verification.getAssignedTo()+
                                        "Applicant Details \n" +
                                        "\n Name  : " +verification.getApplicantName()+
                                        "\n Status : "+verification.getvStatus()+
                                        "\n Applicant id : " +verification.getApplicantId()+
                                        "\n Loan Amount  : " +verification.getLoanAmount()+
                                        "\n Query  : " +verification.getvQueries()+
                                        "\n Queried  Date: " +verification.getvQueryDate()+
                                        "\n Address : "+verification.getApplicantAddress()+
                                        "\n Assigned By : " +verification.getAssignedBy()+
                                        "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                                        "\n Date : " +verification.getRefFiId() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");


                HashSet<Messages> messageSet = new HashSet();
                messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                        "Applicant Details \n" +
                        "\n Name  : " +verification.getApplicantName()+
                        "\n Applicant id : " +verification.getApplicantId()+
                        "\n Loan Amount  : " +verification.getLoanAmount()+
                        "\n Address : "+verification.getApplicantAddress()));

                smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
            }

        } else if (status.toUpperCase().equals(STATUS.APPROVED.toString())) {
          if (verification.getvStatus().equals("COMPLETED")){
              verification.setaStatus("APPROVED");
              verification.setApprovedDate(Instant.now().toString());

              notification.invoke(verification.getAssignedTo(), "Filed investigation Status has been changed to APPROVED"+verification.getAssignedTo()+
                      "Applicant Details \n" +
                      "\n Name  : " +verification.getApplicantName()+
                      "\n Status : "+verification.getvStatus()+
                      "\n Applicant id : " +verification.getApplicantId()+
                      "\n Loan Amount  : " +verification.getLoanAmount()+
                      "\n Address : "+verification.getApplicantAddress()+
                      "\n Approved Date : "+verification.getApprovedDate()+
                      "\n Assigned By : " +verification.getAssignedBy()+
                      "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                      "\n Date : " +verification.getRefFiId()
              );
              emailController.sendEmail(
                      statusUpdateMail(
                              new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Update FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                              ,"A Query has been raised by Verifier "+verification.getAssignedTo()+
                                      "Applicant Details \n" +
                                      "\n Name  : " +verification.getApplicantName()+
                                      "\n Status : "+verification.getvStatus()+
                                      "\n Applicant id : " +verification.getApplicantId()+
                                      "\n Loan Amount  : " +verification.getLoanAmount()+
                                      "\n Query  : " +verification.getvQueries()+
                                      "\n Queried  Date: " +verification.getvQueryDate()+
                                      "\n Address : "+verification.getApplicantAddress()+
                                      "\n Assigned By : " +verification.getAssignedBy()+
                                      "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                                      "\n Date : " +verification.getRefFiId() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
              HashSet<Messages> messageSet = new HashSet();
              messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                      "Applicant Details \n" +
                      "\n Name  : " +verification.getApplicantName()+
                      "\n Applicant id : " +verification.getApplicantId()+
                      "\n Loan Amount  : " +verification.getLoanAmount()+
                      "\n Address : "+verification.getApplicantAddress()));

              smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
          }else {
              return ResponseEntity.badRequest().body("Verification is not yet completed");
          }
        } else if (status.toUpperCase().equals(STATUS.REJECTED.toString())) {
            if (verification.getvStatus().equals("COMPLETED")){
                verification.setaStatus("REJECTED");
                verification.setRejectedDateTime(Instant.now().toString());
                verification.setRejectedReason(statusUpdate.getRejectedReason());
            }else {
                return ResponseEntity.badRequest().body("Verification is not yet completed");
            }
        }else if (status.toUpperCase().equals(STATUS.TRANSFER.toString())){
            if (!verification.getaStatus().equals(STATUS.CANCELLED.toString())){
                verification.setvStatus(status.toUpperCase());
                verification.setAcceptedDateTime(Instant.now().toString());
                verification.setvMode(statusUpdate.getvMode());
                assignor.setvStatus(status.toUpperCase());
                /*todo: internal logic for update verifier table with applicant details */
                notification.invoke(verification.getAssignedBy(), "Filed investigation Status has been changed to ACCEPTED \n" +
                        "Applicant Details \n" +
                        "\n Name  : " +verification.getApplicantName()+
                        "\n Status : "+verification.getvStatus()+
                        "\n Applicant id : " +verification.getApplicantId()+
                        "\n Loan Amount  : " +verification.getLoanAmount()+
                        "\n Address : "+verification.getApplicantAddress()+
                        "\n Assigned By : " +verification.getAssignedBy()+
                        "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                        "\n Date : " +verification.getRefFiId()
                );
                emailController.sendEmail(
                        statusUpdateMail(
                                new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Update FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                                ,"A Query has been raised by Verifier "+verification.getAssignedTo()+
                                        "Applicant Details \n" +
                                        "\n Name  : " +verification.getApplicantName()+
                                        "\n Status : "+verification.getvStatus()+
                                        "\n Applicant id : " +verification.getApplicantId()+
                                        "\n Loan Amount  : " +verification.getLoanAmount()+
                                        "\n Query  : " +verification.getvQueries()+
                                        "\n Queried  Date: " +verification.getvQueryDate()+
                                        "\n Address : "+verification.getApplicantAddress()+
                                        "\n Assigned By : " +verification.getAssignedBy()+
                                        "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                                        "\n Date : " +verification.getRefFiId() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");


                HashSet<Messages> messageSet = new HashSet();
                messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                        "Applicant Details \n" +
                        "\n Name  : " +verification.getApplicantName()+
                        "\n Applicant id : " +verification.getApplicantId()+
                        "\n Loan Amount  : " +verification.getLoanAmount()+
                        "\n Address : "+verification.getApplicantAddress()));

                smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
            }else {
                return  ResponseEntity.noContent().build();
            }
            //todo: update history tables as well

            throw new RuntimeException("Illegal status update");
        }
        VerificationHistory verificationHistory = jsonUtils1.mapper().convertValue(verification,VerificationHistory.class);
        verificationHistoryRepo.save(verificationHistory);
        assignerRepo.save(assignor);
        verificationRepo.save(verification);
        return  ResponseEntity.ok(verification);
    }
    @Override

    public ResponseEntity<Object> cancelVerificationBy(String fiId) throws ResourceNotFoundException {
       //BTL --> BTM
        Verification verification=  verificationRepo.findByFiId(fiId).orElseThrow(()->new ResourceNotFoundException("There is no verification for the specified fi id"+fiId) );
        Assignor assignor= assignerRepo.findByFiId(fiId).orElseThrow(()-> new ResourceNotFoundException("There is no assignment for the specified fi id"+fiId));
        if (verification.getRefFiId()==null) {
            //if RefFiId is null then the verifier should be a Team Member Internal or may be self allocation
            if ((verification.getvStatus().equals(STATUS.ACCEPTED.toString()))){//ACCEPTED the verification
                Verifiers verifier= verifierRepo.findByFiId(fiId).orElseThrow(()->new ResourceNotFoundException("There is no assignment for the specified fi id"+fiId));
                verifier.setActive(false);
                verifier.setaStatus(STATUS.CANCELLED.toString());
                verification.setaStatus(STATUS.CANCELLED.toString());
                verification.setVerificationStatus(STATUS.CANCELLED.toString());
                //todo : notification services
            }else{ // Not yet Accepted
                assignor.setaStatus(String.valueOf(STATUS.CANCELLED));
                verification.setaStatus(String.valueOf(STATUS.CANCELLED));
                verification.setVerificationStatus(String.valueOf(STATUS.CANCELLED));
                //todo :notification services
            }
            //BTL--> ATL
        }else{
            if ((verification.getvStatus().equals(STATUS.ACCEPTED.toString()))){// ACCEPTED VERIFICATION
                Verifiers verifier= verifierRepo.findByFiId(fiId).orElseThrow(()->new ResourceNotFoundException("There is no assignment for the specified fi id"+fiId));
                verifier.setActive(false);
                verifier.setaStatus(STATUS.CANCELLED.toString());
                verifierRepo.save(verifier);
            }else{ // NOT YET ACCEPTED VERIFICATION
                assignor.setaStatus(String.valueOf(STATUS.CANCELLED));
                verification.setaStatus(String.valueOf(STATUS.CANCELLED));
                verification.setVerificationStatus(String.valueOf(STATUS.CANCELLED));

            }

        }
        verificationRepo.save(verification);
        assignerRepo.save(assignor);
       //to notify the assigner

    notification.invoke(verification.getAssignedBy(),"Verification for the Following Applicant was canceled by \n" +
            "Verification Details \n" +
            "Fi Id            : " + verification.getFiId()+
            "Applicant Id     : " + verification.getApplicantId()+
            "Case Id          : " + verification.getCaseId()+
            "Applicant Name   : " +verification.getApplicantName()+
            "Loan Amount      : " +verification.getLoanAmount()+
            "Assigned By      : " +verification.getAssignedBy()+
            "Assigned To      : " +verification.getAssignedTo()+
            "Canceled Date    : " +verification.getRejectedDateTime()+
            "Canceled Reason  : " +verification.getRejectedReason());
        emailController.sendEmail(
                statusUpdateMail(
                        new String[]{verification.getAssignedBy()},new String[]{},"Verification Status Update FiId : " +verification.getFiId(),new String[]{},new HashSet<>()
                        ,"A Query has been raised by Verifier "+verification.getAssignedTo()+
                        "Applicant Details \n" +
                                "\n Name  : " +verification.getApplicantName()+
                                "\n Status : "+verification.getvStatus()+
                                "\n Applicant id : " +verification.getApplicantId()+
                                "\n Loan Amount  : " +verification.getLoanAmount()+
                                "\n Query  : " +verification.getvQueries()+
                                "\n Queried  Date: " +verification.getvQueryDate()+
                                "\n Address : "+verification.getApplicantAddress()+
                                "\n Assigned By : " +verification.getAssignedBy()+
                                "\n Assigned Date Time : " +verification.getAssignedDateTime()+
                                "\n Date : " +verification.getRefFiId() ),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");
        HashSet<Messages> messageSet = new HashSet();
        messageSet.add(getMessages("en","",new String[]{"9500055109"},"1","1","Filed investigation Verification Self assign Successfully \n" +
                "Applicant Details \n" +
                "\n Name  : " +verification.getApplicantName()+
                "\n Applicant id : " +verification.getApplicantId()+
                "\n Loan Amount  : " +verification.getLoanAmount()+
                "\n Address : "+verification.getApplicantAddress()));

        smsController.sendSms(statusUpdateSms(messageSet),"application/json",tokenAuth.getToken(),"","","SUPERSIXTY","","","HL");

        return  ResponseEntity.ok("verification Cancelled for the following fiId: "+fiId);
    }
}
