package ai.lentra.modal.masters;



import javax.persistence.*;

@Entity

@Table(name = "m_branch_users")
public class BranchUserMaster {
    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long key;
    private String label;
    private String branchId;
    private String branchName;
    private String product;
    private String user;
    private boolean isActive;
}
