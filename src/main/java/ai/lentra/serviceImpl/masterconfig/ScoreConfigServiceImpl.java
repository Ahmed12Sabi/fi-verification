package ai.lentra.serviceImpl.masterconfig;

import ai.lentra.dto.ScoreConfig.ScoreConfigDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.scoreconfig.ScoreMaster;
import ai.lentra.modal.scoreconfig.VerificationFormFieldsMaster;
import ai.lentra.repository.masterconfig.ScoreConfigRepository;
import ai.lentra.repository.masterconfig.ScoreMasterRepository;
import ai.lentra.service.masterconfig.ScoreConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ScoreConfigServiceImpl implements ScoreConfigService {


    @Autowired
    private ScoreConfigRepository scoreConfigRepository;
    @Autowired
    private ScoreMasterRepository scoreMasterRepository;

    private ResponseEntity<?> getResponse(int httpStatus, String status, String message, int code) {
        ResponseDTO ResponseDTO = new ResponseDTO();
        ResponseDTO.setStatus(status);
        ResponseDTO.setMessage(message);
        ResponseDTO.setCode(HttpStatus.valueOf(code).toString());
        return ResponseEntity.status(httpStatus).body(ResponseDTO);
    }

    @Override
    public List<ScoreConfigDTO> getAllFieldScoreFields() {
        List<VerificationFormFieldsMaster>  formFieldsMasters=   scoreConfigRepository.findscoringFields();
        List<ScoreConfigDTO> scoreConfigDTOList=new ArrayList<>();
        for (VerificationFormFieldsMaster row:formFieldsMasters) {
            ScoreMaster scoreRow=row.getScoreMaster();
            ScoreConfigDTO scoreDto=new ScoreConfigDTO();
            scoreDto.setFieldId(row.getFieldId());
            scoreDto.setFieldName(row.getFieldName());
            scoreDto.setFieldType(row.getFieldType());
            scoreDto.setHidden(row.getHidden());
            scoreDto.setRequired(row.getRequired());
            scoreDto.setStatus(row.getStatus());
            scoreDto.setScId(row.getScId());
            scoreDto.setScoreName(row.getScoreName());
            scoreDto.setScoring(row.getScoring());
            scoreDto.setScoreValue(scoreRow.getScoreValue());
            scoreDto.setMinRange(scoreRow.getMinRange());
            scoreDto.setMaxRange(scoreRow.getMaxRange());
            scoreDto.setRangeIndicator(scoreRow.getRangeIndicator());
            scoreConfigDTOList.add(scoreDto);

        }
        return scoreConfigDTOList;
    }

    @Override
    public void updateScoreFields(ScoreConfigDTO scoreConfigDTO) {
        Boolean rangeIndicator=scoreConfigDTO.getRangeIndicator();
        String scoreName=scoreConfigDTO.getScoreName();
        Integer minRange=scoreConfigDTO.getMinRange();
        Integer maxRange=scoreConfigDTO.getMaxRange();
        Integer scoreValue=scoreConfigDTO.getScoreValue();
        if(scoreValue==null){
            throw new EntityNotFoundException("scoreValue should not be null ");
        }
        else if(rangeIndicator && minRange>maxRange){
            throw new EntityNotFoundException("minRange should not be greater than maxRange");
        }
        ScoreMaster sm=new ScoreMaster();

        sm.setId(scoreConfigDTO.getScId());
        sm.setScoreValue(scoreValue);
        sm.setScoreName(scoreName);
        sm.setMinRange(minRange);
        sm.setMaxRange(maxRange);
        sm.setRangeIndicator(rangeIndicator);
        scoreMasterRepository.save(sm);

    }
}
