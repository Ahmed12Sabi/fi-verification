package ai.lentra.serviceImpl.scheduler;

import ai.lentra.repository.froms.*;
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
