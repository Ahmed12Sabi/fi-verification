package ai.lentra.serviceImpl.scheduler;

import ai.lentra.repository.FamilyDetailsRepository;
import ai.lentra.repository.commitment.CommitmentsRepository;
import ai.lentra.repository.contactInformation.ContactFormRepository;
import ai.lentra.repository.expenses.ExpensesRepository;
import ai.lentra.repository.officeDetails.OfficeSelfEmploymentRepository;
import ai.lentra.repository.personal_details.PersonalDetailsRepository;
import ai.lentra.repository.residence.ResidenceRepository;
import ai.lentra.repository.summary.SummaryRepository;
import ai.lentra.repository.vehicleDetails.VehicleDetailsRepository;
import ai.lentra.service.scheduler.FormCleanUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormCleanUpServiceImpl implements FormCleanUpService {

    @Autowired
    ContactFormRepository contactRepository;
    @Autowired
    ExpensesRepository expensesRepository;
    @Autowired
    PersonalDetailsRepository personalDetailsRepository;
    @Autowired
    ResidenceRepository residenceRepository;
    @Autowired
    SummaryRepository summaryRepository;
    @Autowired
    VehicleDetailsRepository vehicleRepository;
    @Autowired
    CommitmentsRepository commitmentsRepository;
    /* for family details
    @Autowired
    VehicleDetailsRepository vehicleRepository;*/
    @Autowired
    OfficeSelfEmploymentRepository officeSelfEmploymentRepository;
    @Autowired
    FamilyDetailsRepository familyDetailsRepository;
    @Override
    public void doFormCleanUp(){

       /* contactRepository.delete2MonthsData();
        expensesRepository.delete2MonthsData();
        personalDetailsRepository.delete2MonthsData();
        residenceRepository.delete2MonthsData();
        summaryRepository.delete2MonthsData();
        vehicleRepository.delete2MonthsData();
        commitmentsRepository.delete2MonthsData();
        officeSelfEmploymentRepository.delete2MonthsData();
        familyDetailsRepository.delete2MonthsData();*/


    }
}
