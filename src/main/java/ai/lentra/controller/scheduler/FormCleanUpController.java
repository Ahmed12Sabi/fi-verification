package ai.lentra.controller.scheduler;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.controller.residence.ResidenceController;
import ai.lentra.dto.ResidenceDto;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.residence.ResidenceDetails;
import ai.lentra.service.residence.ResidenceService;
import ai.lentra.service.scheduler.FormCleanUpService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

import static ai.lentra.commons.EndPointReferer.RESIDENCE_ALL;
import static ai.lentra.commons.ErrorMessage.RESIDENCE_NOT_FOUND;

@Controller
public class FormCleanUpController {

    private static final Logger logger =  LoggerFactory.getLogger(FormCleanUpController.class);

    @Autowired
    FormCleanUpService formCleanUpService;

    public void doFormCleanUp()  {
        logger.info("Started API call to get all residence");
        formCleanUpService.doFormCleanUp();
    }

}
