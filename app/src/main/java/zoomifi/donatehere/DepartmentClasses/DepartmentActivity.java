package zoomifi.donatehere.DepartmentClasses;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import zoomifi.donatehere.R;

public class DepartmentActivity extends Activity implements View.OnClickListener
{
    private DepartmentFromStorage departmentFromStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_departments);

        this.departmentFromStorage = new DepartmentFromStorage(this);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);

        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBoxDDisplayDonations);

        checkBox.setChecked(this.departmentFromStorage.getDisplayDepartmentScreen());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox checkBox1 = (CheckBox) v;
                if(!departmentFromStorage.doAnyDepartmentsExist())
                {
                    checkBox1.setChecked(false);
                    departmentFromStorage.setDisplayDepartmentScreen(false);
                    Toast.makeText(getBaseContext(), "Error: You cannot check this box unless you have at least 1 Department added.", Toast.LENGTH_LONG).show();
                }
                else
                    departmentFromStorage.setDisplayDepartmentScreen(checkBox1.isChecked());
            }
        });

        setUpDepartmentNames();
    }

    private void setUpDepartmentNames()
    {
        ((Button)findViewById(R.id.button1)).setText(this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_1));
        ((Button)findViewById(R.id.button2)).setText(this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_2));
        ((Button)findViewById(R.id.button3)).setText(this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_3));
        ((Button)findViewById(R.id.button4)).setText(this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_4));
        ((Button)findViewById(R.id.button5)).setText(this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_5));
        ((Button)findViewById(R.id.button6)).setText(this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_6));
    }

    public void backPress(View view)
    {
        onBackPressed();
    }

    private void displayDepartmentNameDialog(final int index)
    {
        final Dialog dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_enter_department_name);

        final EditText editText = (EditText)dialog.findViewById(R.id.enterDepartmentNameEditText);

        String currentName = getString(R.string.AddDepartment);
        boolean departmentExists = false;

        switch(index)
        {
            case 0:
                departmentExists = this.departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_1);
                currentName = this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_1);
                break;
            case 1:
                departmentExists = this.departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_2);
                currentName = this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_2);
                break;
            case 2:
                departmentExists = this.departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_3);
                currentName = this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_3);
                break;
            case 3:
                departmentExists = this.departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_4);
                currentName = this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_4);
                break;
            case 4:
                departmentExists = this.departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_5);
                currentName = this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_5);
                break;
            case 5:
                departmentExists = this.departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_6);
                currentName = this.departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_6);
                break;
        }

        if(departmentExists)
        {
            editText.setText(currentName);
            editText.setSelection(currentName.length());
        }
        else
            editText.setHint(getString(R.string.DepartmentName));

        Button button = (Button) dialog.findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(editText.getText() != null && !editText.getText().toString().isEmpty())
                {
                    saveDepartmentName(index, editText.getText().toString());
                    dialog.dismiss();
                }
                else if(editText.getText() != null && editText.getText().toString().isEmpty())
                    displayDeleteDialog(index, dialog);
                else
                    dialog.dismiss();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (editText.getText() != null && !editText.getText().toString().isEmpty())
                        saveDepartmentName(index, editText.getText().toString());
                    else if (editText.getText() != null && editText.getText().toString().isEmpty())
                        displayDeleteDialog(index, dialog);

                    return true;
                }
                return false;
            }
        });

        dialog.findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    private void displayDeleteDialog(final int index, final Dialog renameDialog)
    {
        final Dialog dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_department_name_warning);

        Button button = (Button) dialog.findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (index)
                {
                    case 0:
                        departmentFromStorage.removeDepartmentName(DepartmentIDs.DEPARTMENT_ID_1);
                        ((Button)findViewById(R.id.button1)).setText(getString(R.string.AddDepartment));
                        break;
                    case 1:
                        departmentFromStorage.removeDepartmentName(DepartmentIDs.DEPARTMENT_ID_2);
                        ((Button)findViewById(R.id.button2)).setText(getString(R.string.AddDepartment));
                        break;
                    case 2:
                        departmentFromStorage.removeDepartmentName(DepartmentIDs.DEPARTMENT_ID_3);
                        ((Button)findViewById(R.id.button3)).setText(getString(R.string.AddDepartment));
                        break;
                    case 3:
                        departmentFromStorage.removeDepartmentName(DepartmentIDs.DEPARTMENT_ID_4);
                        ((Button)findViewById(R.id.button4)).setText(getString(R.string.AddDepartment));
                        break;
                    case 4:
                        departmentFromStorage.removeDepartmentName(DepartmentIDs.DEPARTMENT_ID_5);
                        ((Button)findViewById(R.id.button5)).setText(getString(R.string.AddDepartment));
                        break;
                    case 5:
                        departmentFromStorage.removeDepartmentName(DepartmentIDs.DEPARTMENT_ID_6);
                        ((Button)findViewById(R.id.button6)).setText(getString(R.string.AddDepartment));
                        break;
                }

                removeRenameDialog(renameDialog);
                dialog.dismiss();

                if(!departmentFromStorage.doAnyDepartmentsExist())
                {
                    departmentFromStorage.setDisplayDepartmentScreen(false);
                    ((CheckBox)findViewById(R.id.checkBoxDDisplayDonations)).setChecked(false);
                }
            }
        });

        dialog.findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    private void removeRenameDialog(Dialog renameDialog)
    {
        renameDialog.dismiss();
    }

    private void saveDepartmentName(int index, String deptName)
    {
        if (deptName != null && !deptName.isEmpty())
        {
            switch (index)
            {
                case 0:
                    this.departmentFromStorage.saveDepartmentName(DepartmentIDs.DEPARTMENT_ID_1, deptName);
                    this.departmentFromStorage.setDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_1, true);
                    ((Button)findViewById(R.id.button1)).setText(deptName);
                    break;
                case 1:
                    this.departmentFromStorage.saveDepartmentName(DepartmentIDs.DEPARTMENT_ID_2, deptName);
                    this.departmentFromStorage.setDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_2, true);
                    ((Button)findViewById(R.id.button2)).setText(deptName);
                    break;
                case 2:
                    this.departmentFromStorage.saveDepartmentName(DepartmentIDs.DEPARTMENT_ID_3, deptName);
                    this.departmentFromStorage.setDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_3, true);
                    ((Button)findViewById(R.id.button3)).setText(deptName);
                    break;
                case 3:
                    this.departmentFromStorage.saveDepartmentName(DepartmentIDs.DEPARTMENT_ID_4, deptName);
                    this.departmentFromStorage.setDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_4, true);
                    ((Button)findViewById(R.id.button4)).setText(deptName);
                    break;
                case 4:
                    this.departmentFromStorage.saveDepartmentName(DepartmentIDs.DEPARTMENT_ID_5, deptName);
                    this.departmentFromStorage.setDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_5, true);
                    ((Button)findViewById(R.id.button5)).setText(deptName);
                    break;
                case 5:
                    this.departmentFromStorage.saveDepartmentName(DepartmentIDs.DEPARTMENT_ID_6, deptName);
                    this.departmentFromStorage.setDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_6, true);
                    ((Button)findViewById(R.id.button6)).setText(deptName);
                    break;
            }
        }
        else
            Toast.makeText(getBaseContext(), "Error: Unable to save department name. Code: 01", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.button1) displayDepartmentNameDialog(0);
        if(v.getId() == R.id.button2) displayDepartmentNameDialog(1);
        if(v.getId() == R.id.button3) displayDepartmentNameDialog(2);
        if(v.getId() == R.id.button4) displayDepartmentNameDialog(3);
        if(v.getId() == R.id.button5) displayDepartmentNameDialog(4);
        if(v.getId() == R.id.button6) displayDepartmentNameDialog(5);
    }
}
