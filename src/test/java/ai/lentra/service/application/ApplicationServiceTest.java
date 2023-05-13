/*
package ai.lentra.service.application;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.core.test.TransactionalTestContainerSupport;
import ai.lentra.dto.application.ApplicationDetailsDTO;
import ai.lentra.dto.headers.HeadersDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.applicant_details.ApplicantDetails;
import ai.lentra.modal.application.ApplicationDetails;
import ai.lentra.repository.allocation.ApplicationRawDataRepository;
import ai.lentra.repository.allocation.ApplicationRepository;
import ai.lentra.serviceImpl.application.ApplicationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ApplicationServiceTest extends TransactionalTestContainerSupport {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationServiceImpl applicationService;

    @Autowired
    private ApplicationRawDataRepository rawRepository;

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    JsonUtils1 jsonUtils1;

    @Test
    public void testAddApplication()  {
        HeadersDTO headers = new HeadersDTO();
        headers.setApplicationId(12345L);
        headers.setProductType("loan");
        headers.setUsername("user1");
        headers.setInstitutionId("inst1");
        headers.setBranchName("branch1");

        ApplicationDetailsDTO application = new ApplicationDetailsDTO();
        application.setCaseId(1L);
        application.setVerificationStage("VERIFICATION");
        application.setVerificationStatus("VERIFICATION INITIATED");
        List<ApplicantDetails> applicantDetailsList = new ArrayList<>();
        ApplicantDetails applicantDetails = new ApplicantDetails();
        applicantDetails.setApplicantId(1L);
        applicantDetails.setBranchName("branch1");
        applicantDetails.setStatus("Initiated");
        applicantDetailsList.add(applicantDetails);
        application.setApplicantDetails(applicantDetailsList);

        ResponseEntity<?> response = applicationService.addApplication(application, headers);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getBody() instanceof ApplicationDetails);
    }

    @Test
    public void testGetApplication() throws ResourceNotFoundException {
        HeadersDTO headers = new HeadersDTO();
        headers.setApplicationId(12345L);
        headers.setProductType("loan");
        headers.setApplicantType("applicant1");

        ApplicationDetails applicationDetails = new ApplicationDetails();
        applicationDetails.setApplicationId(12345L);
        applicationDetails.setProductType("loan");
        applicationDetails.setApplicantDetails(new ArrayList<>());

        ResponseEntity<?> response = applicationService.getApplication(headers);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof ApplicationDetails);
        assertEquals(applicationDetails, response.getBody());
    }
    @Test
    public void testAddApplicationFailure() throws JsonProcessingException {
        ApplicationDetailsDTO applicationDetailsDTO = new ApplicationDetailsDTO();
        applicationDetailsDTO=jsonUtils1.mapper().readValue("{\n" +
                "    \"applicationId\": 2345678,\n" +
                "    \"caseId\": 2222,\n" +
                "    \"productType\": \"PL\",\n" +
                "    \"branchName\": \"Delhi\",\n" +
                "    \"branchCode\": 1231,\n" +
                "    \"applicantDetails\": [\n" +
                "        {\n" +
                "          \n" +
                "            \"applicantId\": 23234,\n" +
                "            \"caseId\": 0,\n" +
                "            \"summary\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"sumRefId\": 5,\n" +
                "                \"otherFindings\": 13,\n" +
                "                \"finalScore\": 13,\n" +
                "                \"remark\": \"12312dsd\",\n" +
                "                \"remarkDateTime\": null,\n" +
                "                \"preparedBy\": \"13\",\n" +
                "                \"dateAndTimePerformed\": null,\n" +
                "                \"reviewedBy\": \"1312123\",\n" +
                "                \"agencyName\": \"123123\",\n" +
                "                \"sumScore\": 13,\n" +
                "                \"finalReviewStatus\": null\n" +
                "            },\n" +
                "            \"commitments\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"bankNameLoc\": \"bankofidia\",\n" +
                "                \"termInsuranceAmt\": 50000,\n" +
                "                \"lifeInsuranceDuration\": 10,\n" +
                "                \"termInsuranceDuration\": 8,\n" +
                "                \"locAmt\": 70000,\n" +
                "                \"carInsuranceAmt\": 30000,\n" +
                "                \"twoWheelerInsuranceDuration\": 7,\n" +
                "                \"npsDuration\": 8,\n" +
                "                \"homeInsuranceAmt\": 90000,\n" +
                "                \"locExpiryDate\": \"13-09-2022\",\n" +
                "                \"carInsuranceDuration\": 10,\n" +
                "                \"insuranceType\": \"health\",\n" +
                "                \"healthInsuranceDuration\": 10,\n" +
                "                \"homeInsuranceDuration\": 10,\n" +
                "                \"npsApplicantName\": \"jagrutibhure\",\n" +
                "                \"healthInsuranceAmt\": 50,\n" +
                "                \"npsAmt\": 50,\n" +
                "                \"lifeInsuranceAmt\": 55,\n" +
                "                \"twoWheelerInsuranceAmt\": 50,\n" +
                "                \"customerId\": 0\n" +
                "            },\n" +
                "            \"familyDetails\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"numberOfDependents\": 2,\n" +
                "                \"motherMidName\": \"Selvi\",\n" +
                "                \"entityConfirmationMother\": true,\n" +
                "                \"motherAge\": 76,\n" +
                "                \"motherFirstName\": \"Tamil\",\n" +
                "                \"motherLastName\": \"M\",\n" +
                "                \"motherReligion\": \"Hindu\",\n" +
                "                \"fatherMidName\": \"Kumar\",\n" +
                "                \"fatherFirstName\": \"Rajesh\",\n" +
                "                \"fatherAge\": 78,\n" +
                "                \"fatherReligion\": \"Hindu\",\n" +
                "                \"fatherLastName\": \"Reddy\",\n" +
                "                \"entityConfirmationFather\": true,\n" +
                "                \"numberOfMinor\": 2,\n" +
                "                \"childEducationLevel\": \"SCHOOL\",\n" +
                "                \"spouseWorking\": true,\n" +
                "                \"spouseLastName\": \"K\",\n" +
                "                \"spouseOccupation\": \"Employment\",\n" +
                "                \"spouseAge\": 2,\n" +
                "                \"entityConfirmationSpouse\": true,\n" +
                "                \"spouseReligion\": \"Hindu\",\n" +
                "                \"spouseCitizenship\": \"Indian\",\n" +
                "                \"spouseMidName\": \"Kumari\",\n" +
                "                \"spouseSuffix\": \"Mrs\",\n" +
                "                \"spouseAlias\": \"Kavya\",\n" +
                "                \"spouseBirthdate\": \"02-07-1975\",\n" +
                "                \"spouseFirstName\": \"Kavitha\"\n" +
                "            },\n" +
                "            \"officeSelfEmployment\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"outOfGeoLimit\": false,\n" +
                "                \"metroLocation\": false,\n" +
                "                \"offcNegativeLocation\": false,\n" +
                "                \"officeConstruction\": \"Painted\",\n" +
                "                \"officeArea\": 123,\n" +
                "                \"officeExterior\": \"Good\",\n" +
                "                \"officeInterior\": \"Good\",\n" +
                "                \"offcNoOfStorey\": \"Two storey\",\n" +
                "                \"easeOfOfficeLocation\": \"Easy\",\n" +
                "                \"itemsSightedInOffice\": \"Sofa\",\n" +
                "                \"noOfEmplyees\": 300,\n" +
                "                \"employmentType\": \"Permanent\",\n" +
                "                \"designation\": \"Clerk\",\n" +
                "                \"company_type\": \"Public\",\n" +
                "                \"jobDomain\": \"IT\",\n" +
                "                \"last_monthSalary\": 50000,\n" +
                "                \"natureOfBusiness\": \"Service provider\",\n" +
                "                \"avgMonthlyTurnOver\": 4000000,\n" +
                "                \"businessBoardSighted\": false,\n" +
                "                \"officeEmailVerified\": false,\n" +
                "                \"entryAllowedInOffice\": false,\n" +
                "                \"offDomainCheck\": false,\n" +
                "                \"officeName\": \"Verinite Technologies\",\n" +
                "                \"officeTelephoneNo\": 9886755337,\n" +
                "                \"extensionNo\": 91,\n" +
                "                \"officeEmail\": \"verinite@gmail.com\",\n" +
                "                \"officeAddressLine1\": \"No 18\",\n" +
                "                \"officeAddressLine2\": \"Aarthi Apartments\",\n" +
                "                \"officeAddressLine3\": \"Gandhi street\",\n" +
                "                \"officeAddressLine4\": \"Tilak nagar\",\n" +
                "                \"officeAddressPincode\": \"625009\",\n" +
                "                \"officeAddressCity\": \"Chennai\",\n" +
                "                \"office_address_state\": \"Tamil nadu\",\n" +
                "                \"officeAddressCountry\": \"India\",\n" +
                "                \"officeCityCode\": \"TF008\",\n" +
                "                \"employeeCode\": \"AST975\",\n" +
                "                \"businessActivitySighted\": \"Sadas\",\n" +
                "                \"officeLocality\": \"Residential\"\n" +
                "            },\n" +
                "            \"contactInformation\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"mobileNumber\": \"8637421223\",\n" +
                "                \"personalEmail\": \"john.g@doe.com\",\n" +
                "                \"simType\": \"POSTPAID\",\n" +
                "                \"mobileNumberVerified\": true,\n" +
                "                \"phoneNumber\": \"9876543210\",\n" +
                "                \"phoneNumberVerified\": true,\n" +
                "                \"personalEmailVerified\": true,\n" +
                "                \"contDomainCheck\": false,\n" +
                "                \"registeredWithBank\": true\n" +
                "            },\n" +
                "            \"personalDetails\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"persRefId\": 123,\n" +
                "                \"loanTakenEarlier\": true,\n" +
                "                \"citizenship\": \"Indian\",\n" +
                "                \"birthDate\": \"01-05-1999\",\n" +
                "                \"religion\": \"Hindu\",\n" +
                "                \"martialStatus\": \"single\",\n" +
                "                \"politicallyExposed\": true,\n" +
                "                \"educationLevel\": \"College\",\n" +
                "                \"age\": 22,\n" +
                "                \"prefix\": \"Dr\",\n" +
                "                \"lastName\": \"Singh\",\n" +
                "                \"alias\": \"Ram\",\n" +
                "                \"middleName\": \"Kumar\",\n" +
                "                \"suffix\": \"Jr\",\n" +
                "                \"firstName\": \"Pravin\",\n" +
                "                \"income\": 130000,\n" +
                "                \"civilStatus\": \"Veteran\",\n" +
                "                \"incomeSource\": \"13\",\n" +
                "                \"incomePeriod\": 13,\n" +
                "                \"dateTimeEndorsed\": \"123\",\n" +
                "                \"dateInspected\": \"123\"\n" +
                "            },\n" +
                "            \"residences\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"residenceCategory\": \"Rented\",\n" +
                "                \"ownershipType\": \"Ownership\",\n" +
                "                \"livingWIth\": \"Friends\",\n" +
                "                \"residenceType\": \"Mansion\",\n" +
                "                \"resNoOfStorey\": \"Single-storey\",\n" +
                "                \"classification\": \"Low cost\",\n" +
                "                \"houseCondition\": \"New\",\n" +
                "                \"propertyMakeType\": null,\n" +
                "                \"propertyInterior\": \"Good\",\n" +
                "                \"namePlateVisible\": true,\n" +
                "                \"appliances\": \"DVD\",\n" +
                "                \"appliancesTotalValue\": 100000,\n" +
                "                \"commuteOptions\": \"Bus\",\n" +
                "                \"neighbourhoodType\": \"Residential\",\n" +
                "                \"communityDominated\": true,\n" +
                "                \"residency\": \"Verified\",\n" +
                "                \"country\": \"India\",\n" +
                "                \"yearsOfStay\": 10,\n" +
                "                \"monthsOfStay\": 6,\n" +
                "                \"distanceFromAddressToActualLoaction\": 8,\n" +
                "                \"monthlyAmortization\": 70000,\n" +
                "                \"rentPerMonth\": 6000,\n" +
                "                \"landlineNum\": 9998636326,\n" +
                "                \"addressLine1\": \"No 16\",\n" +
                "                \"addressLine2\": \"senthil apartments\",\n" +
                "                \"addressLine3\": \"Nehru nagar\",\n" +
                "                \"addressLine4\": \"Thoraipakkam\",\n" +
                "                \"city\": \"Chennai\",\n" +
                "                \"state\": \"Tamil nadu\",\n" +
                "                \"pincode\": \"625008\",\n" +
                "                \"country_code\": 34435,\n" +
                "                \"lattitue\": 7893383,\n" +
                "                \"longitude\": 67326377,\n" +
                "                \"mailDeliveryStatus\": true,\n" +
                "                \"addressProofId\": \"Aadhar card\",\n" +
                "                \"propertyAge\": \"<1 yr\",\n" +
                "                \"ownedBy\": \"Karthik\",\n" +
                "                \"mortagagorName\": \"Rajesh\",\n" +
                "                \"rentedFrom\": \"02-04-1999\",\n" +
                "                \"residenceLandmark\": \"Jain college\",\n" +
                "                \"persMet\": \"Spouse\",\n" +
                "                \"resNegativeLocation\": true,\n" +
                "                \"resScore\": 78\n" +
                "            },\n" +
                "            \"expenses\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"officeTransportationCost\": 300,\n" +
                "                \"electricBillAmt\": 300,\n" +
                "                \"cableNetBillAmt\": 300,\n" +
                "                \"waterBillAmt\": 300,\n" +
                "                \"broadbandBillAmt\": 300,\n" +
                "                \"avgFuelCost\": 300,\n" +
                "                \"otherExpenses\": null,\n" +
                "                \"schoolFeesAmt\": 300,\n" +
                "                \"collegeFeesAmt\": 300\n" +
                "            },\n" +
                "            \"vehicleDetails\": {\n" +
                "                \"applicantId\": 23234,\n" +
                "                \"numberOfVehiclesOwned\": 2,\n" +
                "                \"bikeRegistrationNumber\": 1452,\n" +
                "                \"manufactureYearCar\": 2018,\n" +
                "                \"bikeManufactureName\": \"TVSSd\",\n" +
                "                \"carHypothecatedTo\": \"HDFC\",\n" +
                "                \"carRegistrationNumber\": 1524,\n" +
                "                \"withParkingSpace\": false,\n" +
                "                \"carOwnershipType\": \"Personal-owned\",\n" +
                "                \"manufactureYearTwoWheeler\": 1999,\n" +
                "                \"twoWheelerModel\": \"YAMAHA\",\n" +
                "                \"carIssuingAuthority\": \"HDFC\",\n" +
                "                \"carManufactureName\": \"HONDA\",\n" +
                "                \"bikeOwnershipType\": \"Personal-owned\",\n" +
                "                \"financedFromDateCar\": \"20/01/2020\",\n" +
                "                \"carFuelType\": \"DIESEL\",\n" +
                "                \"bikeHypothecatedTo\": \"HDFC\",\n" +
                "                \"carSeatingCapacity\": 2,\n" +
                "                \"bikeIssuingAuthority\": \"HDFC\",\n" +
                "                \"vehicleType\": \"Two-wheeler\",\n" +
                "                \"carModel\": \"sad\",\n" +
                "                \"financedFromDateBike\": \"20/03/2001\"\n" +
                "            },\n" +
                "            \"id\": \"1\",\n" +
                "            \"applicantType\": \"Borrower\",\n" +
                "            \"applicantName\": \"GOBIKRISHNA\",\n" +
                "            \"addresses\": [\n" +
                "            ],\n" +
                "            \"mobileNumber\": null,\n" +
                "            \"assignedBy\": null,\n" +
                "            \"assignedTo\": null,\n" +
                "            \"loanAmount\": 5000000,\n" +
                "            \"userStatus\": null,\n" +
                "            \"verifierProgress\": null,\n" +
                "            \"inspectedBy\": null,\n" +
                "            \"inspectedDate\": \"2023-01-23\",\n" +
                "            \"inspectedById\": null,\n" +
                "            \"appRole\": null,\n" +
                "            \"branchName\": \"Chennai\",\n" +
                "            \"agencyName\": null,\n" +
                "            \"token\": null,\n" +
                "            \"roleType\": null,\n" +
                "            \"insId\": null,\n" +
                "            \"retrigger\": false,\n" +
                "            \"reVerification\": false,\n" +
                "            \"agency\": false\n" +
                "        }\n" +
                "    ]\n" +
                "}",ApplicationDetailsDTO.class);
        HeadersDTO headers = new HeadersDTO();
        ResponseEntity<?> response = applicationService.addApplication(applicationDetailsDTO, headers);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Error While Adding", ((ResponseDTO)response.getBody()).getMessage());
    }



}


*/
