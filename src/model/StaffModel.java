
package model;

public class StaffModel extends PersonModel{
    private RoleModel role;

    public StaffModel() {
        super();
//        this.role = role;
    }
    
    
    
    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
    
    
}
