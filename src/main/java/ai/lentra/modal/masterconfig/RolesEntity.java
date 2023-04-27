package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "role_config")
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class RolesEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    private String roleName;

    private String vmsRoleName;

    private String instituteId;

    private Boolean status;

    private ZonedDateTime create_on;
    private String created_by;
    private ZonedDateTime modified_on;
    private String modified_by;

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

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getVmsRoleName() {
        return vmsRoleName;
    }

    public void setVmsRoleName(String vmsRoleName) {
        this.vmsRoleName = vmsRoleName;
    }

    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
