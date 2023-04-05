package ai.lentra.dto.ScoreConfig;

import lombok.Data;

@Data
public class ScoreConfigDTO {

    private Long fieldId;

    private Long scId;
    private String fieldName;
    private String fieldType;
    private Boolean isScoring;
    private String scoreName;
    private Integer scoreValue;

    private Integer minRange;
    private Integer maxRange;
    private Boolean status;
    private Boolean required;
    private Boolean hidden;
    private Boolean rangeIndicator;



}
