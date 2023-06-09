

package ai.lentra.controller.configuration.scoring;

import ai.lentra.config.I18nMessageKeys;
import ai.lentra.core.i18n.api.I18nHelper;
import ai.lentra.dto.ScoreConfig.ScoreConfigDTO;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.service.masterconfig.ScoreConfigService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/score-configs")
public class ScoreConfigController {

    private static final Logger logger =  LoggerFactory.getLogger(ScoreConfigController.class);

    @Autowired
    private ScoreConfigService scoreConfigService;

    @Operation(summary = "Get all residence")
    @GetMapping(value = "/get-all-score")
    public ResponseEntity<List<ScoreConfigDTO>> getAllScoringFields() throws ResourceNotFoundException {
        logger.info("Started API call to get all Scoring fields");
        List<ScoreConfigDTO>  scoreConfigDTOList=scoreConfigService.getAllFieldScoreFields();

        if (!scoreConfigDTOList.isEmpty()) {

            return  ResponseEntity.status(HttpStatus.OK).body(scoreConfigDTOList);
        }
        throw new EntityNotFoundException("Records not found");

    }

    @Operation(summary = "Update Single score Fields")
    @PutMapping(value = "/update-score-coonfig")
    public ResponseEntity<?> updateScoreFields( @RequestBody ScoreConfigDTO scoreConfigDTO)  {
        logger.info("Started API call to update scoring details  ...");
             scoreConfigService.updateScoreFields(scoreConfigDTO);
        return  new ResponseEntity<>(I18nHelper.msg(I18nMessageKeys.updated_successfull),HttpStatus.OK);
    }
}


