package ai.lentra.dto.masterconfig;


public class RolesDTO {

    private long roleId;

    private String roleName;

    private String VmsRoleName;

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
		return VmsRoleName;
	}

	public void setVmsRoleName(String vmsRoleName) {
		VmsRoleName = vmsRoleName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}
}
