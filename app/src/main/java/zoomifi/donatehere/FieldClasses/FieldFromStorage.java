package zoomifi.donatehere.FieldClasses;

import android.content.Context;
import android.content.SharedPreferences;

import zoomifi.donatehere.R;

/**
 * Created by Andrew on 4/27/2016.
 * Created for Zoomifi Inc.
 */
public class FieldFromStorage
{
    private Context                     context;
    private SharedPreferences           sharedPreferences;
    private SharedPreferences.Editor    editor;

    public FieldFromStorage(Context context)
    {
        this.context = context;

        this.sharedPreferences = this.context.getSharedPreferences(this.context.getString(R.string._FIELDS_FILE), Context.MODE_PRIVATE);
        this.editor = this.sharedPreferences.edit();
    }

    public void saveDISPLAYState(int ID, boolean flag)
    {
        String value = "";

        switch(ID)
        {
            case FieldIDs.CHECK_DISPLAY_FIRST_NAME:
                value = this.context.getString(R.string._CHECK_DISPLAY_FIRST_NAME);
                break;
            case FieldIDs.CHECK_DISPLAY_LAST_NAME:
                value = this.context.getString(R.string._CHECK_DISPLAY_LAST_NAME);
                break;
            case FieldIDs.CHECK_DISPLAY_PHONE_NUMBER:
                value = this.context.getString(R.string._CHECK_DISPLAY_PHONE_NUMBER);
                break;
            case FieldIDs.CHECK_DISPLAY_EMAIL:
                value = this.context.getString(R.string._CHECK_DISPLAY_EMAIL);
                break;
            case FieldIDs.CHECK_DISPLAY_CUSTOM_1:
                value = this.context.getString(R.string._CHECK_DISPLAY_CUSTOM_FIELD_1);
                break;
            case FieldIDs.CHECK_DISPLAY_CUSTOM_2:
                value = this.context.getString(R.string._CHECK_DISPLAY_CUSTOM_FIELD_2);
                break;
            case FieldIDs.CHECK_DISPLAY_CUSTOM_3:
                value = this.context.getString(R.string._CHECK_DISPLAY_CUSTOM_FIELD_3);
                break;
            case FieldIDs.CHECK_DISPLAY_CUSTOM_4:
                value = this.context.getString(R.string._CHECK_DISPLAY_CUSTOM_FIELD_4);
                break;
        }

        if(!value.isEmpty())
        {
            this.editor.putBoolean(value, flag);
            this.editor.commit();
        }
    }

    public void saveREQUIREDState(int ID, boolean flag)
    {
        String value = "";

        switch(ID)
        {
            case FieldIDs.CHECK_REQUIRED_FIRST_NAME:
                value = this.context.getString(R.string._CHECK_REQUIRED_FIRST_NAME);
                break;
            case FieldIDs.CHECK_REQUIRED_LAST_NAME:
                value = this.context.getString(R.string._CHECK_REQUIRED_LAST_NAME);
                break;
            case FieldIDs.CHECK_REQUIRED_PHONE_NUMBER:
                value = this.context.getString(R.string._CHECK_REQUIRED_PHONE_NUMBER);
                break;
            case FieldIDs.CHECK_REQUIRED_EMAIL:
                value = this.context.getString(R.string._CHECK_REQUIRED_EMAIL);
                break;
            case FieldIDs.CHECK_REQUIRED_CUSTOM_1:
                value = this.context.getString(R.string._CHECK_REQUIRED_CUSTOM_FIELD_1);
                break;
            case FieldIDs.CHECK_REQUIRED_CUSTOM_2:
                value = this.context.getString(R.string._CHECK_REQUIRED_CUSTOM_FIELD_2);
                break;
            case FieldIDs.CHECK_REQUIRED_CUSTOM_3:
                value = this.context.getString(R.string._CHECK_REQUIRED_CUSTOM_FIELD_3);
                break;
            case FieldIDs.CHECK_REQUIRED_CUSTOM_4:
                value = this.context.getString(R.string._CHECK_REQUIRED_CUSTOM_FIELD_4);
                break;
        }

        if(!value.isEmpty())
        {
            this.editor.putBoolean(value, flag);
            this.editor.commit();
        }
    }

    public boolean retrieveDISPLAYState(int ID)
    {
        switch(ID)
        {
            case FieldIDs.CHECK_DISPLAY_FIRST_NAME:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_DISPLAY_FIRST_NAME), true);
            case FieldIDs.CHECK_DISPLAY_LAST_NAME:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_DISPLAY_LAST_NAME), true);
            case FieldIDs.CHECK_DISPLAY_PHONE_NUMBER:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_DISPLAY_PHONE_NUMBER), true);
            case FieldIDs.CHECK_DISPLAY_EMAIL:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_DISPLAY_EMAIL), true);
            case FieldIDs.CHECK_DISPLAY_CUSTOM_1:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_DISPLAY_CUSTOM_FIELD_1), false);
            case FieldIDs.CHECK_DISPLAY_CUSTOM_2:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_DISPLAY_CUSTOM_FIELD_2), false);
            case FieldIDs.CHECK_DISPLAY_CUSTOM_3:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_DISPLAY_CUSTOM_FIELD_3), false);
            case FieldIDs.CHECK_DISPLAY_CUSTOM_4:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_DISPLAY_CUSTOM_FIELD_4), false);
        }

        return false;
    }

    public boolean retrieveREQUIREDState(int ID)
    {
        switch(ID)
        {
            case FieldIDs.CHECK_REQUIRED_FIRST_NAME:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_REQUIRED_FIRST_NAME), false);
            case FieldIDs.CHECK_REQUIRED_LAST_NAME:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_REQUIRED_LAST_NAME), false);
            case FieldIDs.CHECK_REQUIRED_PHONE_NUMBER:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_REQUIRED_PHONE_NUMBER), false);
            case FieldIDs.CHECK_REQUIRED_EMAIL:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_REQUIRED_EMAIL), false);
            case FieldIDs.CHECK_REQUIRED_CUSTOM_1:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_REQUIRED_CUSTOM_FIELD_1), false);
            case FieldIDs.CHECK_REQUIRED_CUSTOM_2:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_REQUIRED_CUSTOM_FIELD_2), false);
            case FieldIDs.CHECK_REQUIRED_CUSTOM_3:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_REQUIRED_CUSTOM_FIELD_3), false);
            case FieldIDs.CHECK_REQUIRED_CUSTOM_4:
                return this.sharedPreferences.getBoolean(this.context.getString(R.string._CHECK_REQUIRED_CUSTOM_FIELD_4), false);
        }

        return false;
    }

    public void saveCustomFieldName(int ID, String name)
    {
        String value = "";

        switch(ID)
        {
            case FieldIDs.CUSTOM_FIELD_1_NAME:
                value = this.context.getString(R.string._CUSTOM_FIELD_1_NAME);
                break;
            case FieldIDs.CUSTOM_FIELD_2_NAME:
                value = this.context.getString(R.string._CUSTOM_FIELD_2_NAME);
                break;
            case FieldIDs.CUSTOM_FIELD_3_NAME:
                value = this.context.getString(R.string._CUSTOM_FIELD_3_NAME);
                break;
            case FieldIDs.CUSTOM_FIELD_4_NAME:
                value = this.context.getString(R.string._CUSTOM_FIELD_4_NAME);
                break;
        }

        if(!value.isEmpty())
        {
            this.editor.putString(value, name);
            this.editor.commit();
        }
    }

    public String retrieveCustomFieldName(int ID)
    {
        switch(ID)
        {
            case FieldIDs.CUSTOM_FIELD_1_NAME:
                return this.sharedPreferences.getString(this.context.getString
                        (R.string._CUSTOM_FIELD_1_NAME), this.context.getString(R.string.CustomText));
            case FieldIDs.CUSTOM_FIELD_2_NAME:
                return this.sharedPreferences.getString(this.context.getString
                        (R.string._CUSTOM_FIELD_2_NAME), this.context.getString(R.string.CustomText));
            case FieldIDs.CUSTOM_FIELD_3_NAME:
                return this.sharedPreferences.getString(this.context.getString
                        (R.string._CUSTOM_FIELD_3_NAME), this.context.getString(R.string.CustomText));
            case FieldIDs.CUSTOM_FIELD_4_NAME:
                return this.sharedPreferences.getString(this.context.getString
                        (R.string._CUSTOM_FIELD_4_NAME), this.context.getString(R.string.CustomText));
        }

        return "";
    }

    public boolean doAnyFieldsExist()
    {
        Integer [] fieldIDs =
                {
                        FieldIDs.CHECK_DISPLAY_FIRST_NAME,
                        FieldIDs.CHECK_DISPLAY_LAST_NAME,
                        FieldIDs.CHECK_DISPLAY_PHONE_NUMBER,
                        FieldIDs.CHECK_DISPLAY_EMAIL,
                        FieldIDs.CHECK_DISPLAY_CUSTOM_1,
                        FieldIDs.CHECK_DISPLAY_CUSTOM_2,
                        FieldIDs.CHECK_DISPLAY_CUSTOM_3,
                        FieldIDs.CHECK_DISPLAY_CUSTOM_4
                };

        for(int x = 0; x < 8; x++)
            if(retrieveDISPLAYState(fieldIDs[x]))
                return true;

        return false;
    }
}
