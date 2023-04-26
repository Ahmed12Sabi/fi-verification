package ai.lentra.modal.masterconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;



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
