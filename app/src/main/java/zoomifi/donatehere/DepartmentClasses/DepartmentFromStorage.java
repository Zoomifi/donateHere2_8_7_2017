package zoomifi.donatehere.DepartmentClasses;

import android.content.Context;
import android.content.SharedPreferences;

import zoomifi.donatehere.R;

/**
 * Created by Andrew on 4/27/2016.
 */
public class DepartmentFromStorage
{
    private Context                     context;
    private SharedPreferences           sharedPreferences;
    private SharedPreferences.Editor    editor;

    public DepartmentFromStorage(Context context)
    {
        this.context = context;

        this.sharedPreferences = this.context.getSharedPreferences(this.context.getString(R.string._FIELDS_FILE), Context.MODE_PRIVATE);
        this.editor = this.sharedPreferences.edit();
    }

    public void saveDepartmentName(int ID, String departmentName)
    {
        String value = "";

        switch(ID)
        {
            case DepartmentIDs.DEPARTMENT_ID_1:
                value = this.context.getString(R.string.department_name_1);
                break;
            case DepartmentIDs.DEPARTMENT_ID_2:
                value = this.context.getString(R.string.department_name_2);
                break;
            case DepartmentIDs.DEPARTMENT_ID_3:
                value = this.context.getString(R.string.department_name_3);
                break;
            case DepartmentIDs.DEPARTMENT_ID_4:
                value = this.context.getString(R.string.department_name_4);
                break;
            case DepartmentIDs.DEPARTMENT_ID_5:
                value = this.context.getString(R.string.department_name_5);
                break;
            case DepartmentIDs.DEPARTMENT_ID_6:
                value = this.context.getString(R.string.department_name_6);
                break;
        }

        if(!value.isEmpty())
        {
            this.editor.putString(value, departmentName);
            this.editor.commit();
        }
    }

    public String getDepartmentName(int ID)
    {
        if(getDepartmentNameExists(ID))
        {
            switch(ID)
            {
                case DepartmentIDs.DEPARTMENT_ID_1:
                    return this.sharedPreferences.getString(this.context.getString(R.string.department_name_1), this.context.getString(R.string.AddDepartment));
                case DepartmentIDs.DEPARTMENT_ID_2:
                    return this.sharedPreferences.getString(this.context.getString(R.string.department_name_2), this.context.getString(R.string.AddDepartment));
                case DepartmentIDs.DEPARTMENT_ID_3:
                    return this.sharedPreferences.getString(this.context.getString(R.string.department_name_3), this.context.getString(R.string.AddDepartment));
                case DepartmentIDs.DEPARTMENT_ID_4:
                    return this.sharedPreferences.getString(this.context.getString(R.string.department_name_4), this.context.getString(R.string.AddDepartment));
                case DepartmentIDs.DEPARTMENT_ID_5:
                    return this.sharedPreferences.getString(this.context.getString(R.string.department_name_5), this.context.getString(R.string.AddDepartment));
                case DepartmentIDs.DEPARTMENT_ID_6:
                    return this.sharedPreferences.getString(this.context.getString(R.string.department_name_6), this.context.getString(R.string.AddDepartment));
            }
        }
        else
            return this.context.getString(R.string.AddDepartment);

        return "";
    }

    public void setDepartmentNameExists(int ID, boolean flag)
    {
        String value = "";

        switch(ID)
        {
            case DepartmentIDs.DEPARTMENT_ID_1:
                value = this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_1);
                break;
            case DepartmentIDs.DEPARTMENT_ID_2:
                value = this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_2);
                break;
            case DepartmentIDs.DEPARTMENT_ID_3:
                value = this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_3);
                break;
            case DepartmentIDs.DEPARTMENT_ID_4:
                value = this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_4);
                break;
            case DepartmentIDs.DEPARTMENT_ID_5:
                value = this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_5);
                break;
            case DepartmentIDs.DEPARTMENT_ID_6:
                value = this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_6);
                break;
        }

        if(!value.isEmpty())
        {
            this.editor.putBoolean(value, flag);
            this.editor.commit();
        }

        //setDisplayDepartmentScreen(doAnyDepartmentsExist());
    }

    public boolean getDepartmentNameExists(int ID)
    {
        switch(ID)
        {
            case DepartmentIDs.DEPARTMENT_ID_1:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_1), false);
            case DepartmentIDs.DEPARTMENT_ID_2:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_2), false);
            case DepartmentIDs.DEPARTMENT_ID_3:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_3), false);
            case DepartmentIDs.DEPARTMENT_ID_4:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_4), false);
            case DepartmentIDs.DEPARTMENT_ID_5:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_5), false);
            case DepartmentIDs.DEPARTMENT_ID_6:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string.DEPARTMENT_NAME_EXISTS_6), false);
        }

        return false;
    }

    public void removeDepartmentName(int ID)
    {
        saveDepartmentName(ID, this.context.getString(R.string.DepartmentName));
        setDepartmentNameExists(ID, false);
    }

    public boolean getDisplayDepartmentScreen()
    {
        return this.sharedPreferences.getBoolean(this.context.getString(R.string.DISPLAY_DEPARTMENT_SCREEN), false);
    }

    public void setDisplayDepartmentScreen(boolean flag)
    {
        this.editor.putBoolean(this.context.getString(R.string.DISPLAY_DEPARTMENT_SCREEN), flag).commit();
    }

    public boolean doAnyDepartmentsExist()
    {
        Integer [] departmentIDS =
        {
            DepartmentIDs.DEPARTMENT_ID_1,
            DepartmentIDs.DEPARTMENT_ID_2,
            DepartmentIDs.DEPARTMENT_ID_3,
            DepartmentIDs.DEPARTMENT_ID_4,
            DepartmentIDs.DEPARTMENT_ID_5,
            DepartmentIDs.DEPARTMENT_ID_6
        };

        for(int x = 0; x < 6; x++)
            if(getDepartmentNameExists(departmentIDS[x]))
                return true;

        return false;
    }
}
