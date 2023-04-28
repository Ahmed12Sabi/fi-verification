package ai.lentra.modal.masterconfig;

import java.time.ZonedDateTime;

public class OfflinePdfDataMapping
{
    private long field_id;
    private String field_name;
    private String field_table;
    private String institute_name;
    private ZonedDateTime create_on;
    private String created_by;
    private ZonedDateTime modified_on;
    private String modified_by;

    public OfflinePdfDataMapping(String fieldName, String fieldTable) {
    }

    public long getField_id() {
        return field_id;
    }

    public void setField_id(long field_id) {
        this.field_id = field_id;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getField_table() {
        return field_table;
    }

    public void setField_table(String field_table) {
        this.field_table = field_table;
    }

    public String getInstitute_name() {
        return institute_name;
    }

    public void setInstitute_name(String institute_name) {
        this.institute_name = institute_name;
    }

    public ZonedDateTime getCreate_on() {
        return create_on;
    }

    public void setCreate_on(ZonedDateTime create_on) {
        this.create_on = create_on;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public ZonedDateTime getModified_on() {
        return modified_on;
    }

    public void setModified_on(ZonedDateTime modified_on) {
        this.modified_on = modified_on;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }
}
