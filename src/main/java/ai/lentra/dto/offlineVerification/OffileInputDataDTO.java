package ai.lentra.dto.offlineVerification;

import java.util.List;

public class OffileInputDataDTO {

    private String Header;
    private List<DataFields> dataFields;

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public List<DataFields> getDataFields() {
        return dataFields;
    }

    public void setDataFields(List<DataFields> dataFields) {
        this.dataFields = dataFields;
    }

    public OffileInputDataDTO( List<DataFields> dataFields) {

        this.dataFields = dataFields;
    }
}

