package zoomifi.donatehere.DepartmentClasses;

/**
 * Created by Andrew on 4/27/2016.
 */
public class DepartmentEntity
{
    private String  departmentName;
    private int     departmentID;
    private boolean departmentExists;

    public DepartmentEntity(String departmentName, int departmentID, boolean departmentExists)
    {
        this.departmentName     = departmentName;
        this.departmentID       = departmentID;
        this.departmentExists   = departmentExists;
    }

    public void setDepartmentName(String name)      { this.departmentName = name; }
    public void setDepartmentID(int ID)             { this.departmentID = ID; }
    public void setDepartmentExists(boolean exists) { this.departmentExists = exists; }

    public String   getDepartmentName()             { return this.departmentName; }
    public int      getDepartmentID()               { return this.departmentID; }
    public boolean  getDepartmentExists()           { return this.departmentExists; }
}
