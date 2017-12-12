package zoomifi.donatehere;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Switch;
import android.widget.CompoundButton;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import zoomifi.donatehere.DepartmentClasses.DepartmentActivity;
import zoomifi.donatehere.FieldClasses.FieldEntity;
import zoomifi.donatehere.FieldClasses.FieldFromStorage;
import zoomifi.donatehere.FieldClasses.FieldIDs;
import zoomifi.donatehere.FieldClasses.FieldInterface;
import zoomifi.donatehere.FieldClasses.FieldsListAdapter;

public class SettingsActivity extends Activity implements View.OnClickListener, CustomPriceEnteredListener, FieldInterface
{
    private static final NumberFormat mCurrencyFormat = DecimalFormat.getCurrencyInstance(Locale.US);
    private FieldsListAdapter fieldsListAdapter;
    private SharedPreferences               prefs;
    private SharedPreferences.Editor        edt;
    private Boolean                         active;
    private Switch                          mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.donationButton1).setOnClickListener(this);
        findViewById(R.id.donationButton2).setOnClickListener(this);
        findViewById(R.id.donationButton3).setOnClickListener(this);
        findViewById(R.id.donationButton4).setOnClickListener(this);
        findViewById(R.id.donationButton5).setOnClickListener(this);
        findViewById(R.id.submitButton)   .setOnClickListener(this);

        setUpButtonPrices();
        setUpOrganizationEditText();

        updateOrganizationName("");

        ListView listView = (ListView) findViewById(R.id.displaySelectionListViewSettings);

        this.fieldsListAdapter = new FieldsListAdapter(this, R.layout.field_panel, initializeFieldStates(), this);
        listView.setAdapter(fieldsListAdapter);

        prefs = this.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        edt = this.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
        mSwitch = (Switch) findViewById(R.id.mySwitch);
        active = prefs.getBoolean("active", false);
        System.out.println("ONSTART ACTIVE =" + active);
        mSwitch.setChecked(active);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    active = true;
                    edt.putBoolean("active", true);
                    edt.commit();



                } else {
                    active = false;
                    edt.putBoolean("active", false);
                    edt.commit();
                }
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        int buttonIndex = 0;

        switch(v.getId())
        {
            case R.id.donationButton1:
                buttonIndex = 1;
                break;
            case R.id.donationButton2:
                buttonIndex = 2;
                break;
            case R.id.donationButton3:
                buttonIndex = 3;
                break;
            case R.id.donationButton4:
                buttonIndex = 4;
                break;
            case R.id.donationButton5:
                buttonIndex = 5;
                break;
            case R.id.submitButton:

                String name = ((EditText)findViewById(R.id.organizationNameEditText)).getText().toString();
                if(name != null && name.length() > 0)
                    saveOrganizationName(name);
                break;
        }

        showCustomLineItemPriceCreator(buttonIndex);
    }

    private void showCustomLineItemPriceCreator(int buttonIndex)
    {
        if(buttonIndex == 0)
            return;

        LineItemPriceSetter lineItemPriceSetter = new LineItemPriceSetter(this);
        lineItemPriceSetter.setCustomPriceEnteredListener(this);
        lineItemPriceSetter.setButtonIndex(buttonIndex);
        lineItemPriceSetter.setHeader("Set Amount");
        lineItemPriceSetter.show();
    }

    @Override
    public void setPrice(String orderID, long price)
    {

    }

    @Override
    public void changeButton(int buttonID, String PRICE_STRING)
    {
        switch(buttonID)
        {
            case 1:
                ((TextView)findViewById(R.id.donationButton1)).setText(formatPrice(PRICE_STRING));
                break;
            case 2:
                ((TextView)findViewById(R.id.donationButton2)).setText(formatPrice(PRICE_STRING));
                break;
            case 3:
                ((TextView)findViewById(R.id.donationButton3)).setText(formatPrice(PRICE_STRING));
                break;
            case 4:
                ((TextView)findViewById(R.id.donationButton4)).setText(formatPrice(PRICE_STRING));
                break;
            case 5:
                ((TextView)findViewById(R.id.donationButton5)).setText(formatPrice(PRICE_STRING));
                break;
        }
    }

    @NonNull
    private String formatPrice(String PRICE_STRING)
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.donation_here_file), Context.MODE_PRIVATE);
        //default USD from prefs
        String currency = sharedPreferences.getString("currencyCode", "USD");
        mCurrencyFormat.setCurrency(Currency.getInstance(currency));// "GBP"));

        if(PRICE_STRING.isEmpty())
            PRICE_STRING = "0";

        long value = Long.valueOf(PRICE_STRING);
        return mCurrencyFormat.format(value / 100.0);

        /*StringBuilder builder = new StringBuilder(PRICE_STRING);

        if(builder.length() == 0)
            builder = new StringBuilder("$0.00");
        else if(builder.length() == 1)
            builder.insert(0, "$0.0");
        else if(builder.length() == 2)
            builder.insert(0, "$0.");
        else if(builder.length() > 5)
        {
            builder.insert(0, "$");
            builder.insert(builder.length() - 5, ",");
            builder.insert(builder.length() - 2, ".");
        } else {
            builder.insert(0, "$");
            builder.insert(builder.length() - 2, ".");
        }

        return builder.toString();*/
    }


    private void setUpButtonPrices()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.donation_here_file), Context.MODE_PRIVATE);

        long [] donationValues = new long[5];

        donationValues[0] = sharedPreferences.getLong(getString(R.string.donation_button1_price), 0L);
        donationValues[1] = sharedPreferences.getLong(getString(R.string.donation_button2_price), 0L);
        donationValues[2] = sharedPreferences.getLong(getString(R.string.donation_button3_price), 0L);
        donationValues[3] = sharedPreferences.getLong(getString(R.string.donation_button4_price), 0L);
        donationValues[4] = sharedPreferences.getLong(getString(R.string.donation_button5_price), 0L);

        String [] donationValuesStrings = new String[5];

        for(int x = 0; x < 5; x++)
            donationValuesStrings[x] = formatPrice(String.valueOf(donationValues[x]));

        ((Button)findViewById(R.id.donationButton1)).setText(donationValuesStrings[0]);
        ((Button)findViewById(R.id.donationButton2)).setText(donationValuesStrings[1]);
        ((Button)findViewById(R.id.donationButton3)).setText(donationValuesStrings[2]);
        ((Button)findViewById(R.id.donationButton4)).setText(donationValuesStrings[3]);
        ((Button)findViewById(R.id.donationButton5)).setText(donationValuesStrings[4]);
    }

    private void saveOrganizationName(String name)
    {
        ((EditText)findViewById(R.id.organizationNameEditText)).setText("");

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.donation_here_file), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(getString(R.string.ORGANIZATION_OR_COMPANY_NAME), name);
        editor.commit();

        updateOrganizationName(name);
    }

    private String getOrganizationName()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.donation_here_file), Context.MODE_PRIVATE);

        return sharedPreferences.getString(getString(R.string.ORGANIZATION_OR_COMPANY_NAME), "");
    }

    private void updateOrganizationName(String name)
    {
        if(name.length() > 0)
            ((TextView)findViewById(R.id.organizationNameTextView)).setText(name);
        else
            ((TextView)findViewById(R.id.organizationNameTextView)).setText(getOrganizationName());
    }

    private void setUpOrganizationEditText()
    {
        ((EditText)findViewById(R.id.organizationNameEditText)).setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if (actionId == EditorInfo.IME_ACTION_DONE)
                {
                    saveOrganizationName(v.getText().toString());

                    return true;
                }

                return false;
            }
        });
    }

    public void backPress(View view)
    {
        onBackPressed();
    }
    public void additionalPress(View view)
    {
        Intent intent = new Intent(this, SettingsActivity2.class);
        startActivity(intent);
    }

    public void openAddDepartmentsActivity(View view)
    {
        Intent intent = new Intent(this, DepartmentActivity.class);
        startActivity(intent);
    }

    @Override
    public void saveDISPLAYCheckState(int ID, boolean isChecked)
    {
        FieldFromStorage fieldFromStorage = new FieldFromStorage(this);
        fieldFromStorage.saveDISPLAYState(ID, isChecked);
    }

    @Override
    public void saveREQUIREDCheckState(int ID, boolean isChecked, boolean isDISPLAYchecked)
    {
        if(isDISPLAYchecked)
        {
            FieldFromStorage fieldFromStorage = new FieldFromStorage(this);
            fieldFromStorage.saveREQUIREDState(ID, isChecked);
        }
        else
            Toast.makeText(this, "Error: You cannot check this box unless this field\'s \'Display\' checkbox is also checked.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void renameCustomName(int ID)
    {
        switch(ID)
        {
            case FieldIDs.CHECK_DISPLAY_CUSTOM_1:
                displayRenameFieldDialog(FieldIDs.CUSTOM_FIELD_1_NAME);
                break;
            case FieldIDs.CHECK_DISPLAY_CUSTOM_2:
                displayRenameFieldDialog(FieldIDs.CUSTOM_FIELD_2_NAME);
                break;
            case FieldIDs.CHECK_DISPLAY_CUSTOM_3:
                displayRenameFieldDialog(FieldIDs.CUSTOM_FIELD_3_NAME);
                break;
            case FieldIDs.CHECK_DISPLAY_CUSTOM_4:
                displayRenameFieldDialog(FieldIDs.CUSTOM_FIELD_4_NAME);
                break;
        }
    }

    private void displayRenameFieldDialog(final int ID)
    {
        final Dialog dialog = new Dialog(this);
        final FieldFromStorage fieldFromStorage = new FieldFromStorage(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_rename_custom_field);

        final EditText editText = (EditText)dialog.findViewById(R.id.enterCustomFieldName);

        String fieldName = fieldFromStorage.retrieveCustomFieldName(ID);

        if(fieldName.equals(getString(R.string.CustomText)))
            editText.setHint(fieldName);
        else
        {
            editText.setText(fieldName);
            editText.setSelection(fieldName.length());
        }

        Button button = (Button) dialog.findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(editText.getText() != null && !editText.getText().toString().isEmpty())
                {
                    fieldFromStorage.saveCustomFieldName(ID, editText.getText().toString());
                    fieldsListAdapter.clear();
                    fieldsListAdapter.addAll(initializeFieldStates());
                    fieldsListAdapter.notifyDataSetChanged();
                }

                dialog.dismiss();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if (actionId == EditorInfo.IME_ACTION_DONE)
                {
                    if(editText.getText() != null && !editText.getText().toString().isEmpty())
                    {
                        fieldFromStorage.saveCustomFieldName(ID, editText.getText().toString());
                        fieldsListAdapter.clear();
                        fieldsListAdapter.addAll(initializeFieldStates());
                        fieldsListAdapter.notifyDataSetChanged();
                    }

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

    private List<FieldEntity> initializeFieldStates()
    {
        List<FieldEntity> fieldEntities = new ArrayList<>();

        FieldFromStorage fieldFromStorage = new FieldFromStorage(this);

        fieldEntities.add(new FieldEntity(getString(R.string.FirstName),

                fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME),
                fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_FIRST_NAME),

                FieldIDs.CHECK_DISPLAY_FIRST_NAME,
                FieldIDs.CHECK_REQUIRED_FIRST_NAME));

        fieldEntities.add(new FieldEntity(getString(R.string.LastName),

                fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME),
                fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_LAST_NAME),

                FieldIDs.CHECK_DISPLAY_LAST_NAME,
                FieldIDs.CHECK_REQUIRED_LAST_NAME));

        fieldEntities.add(new FieldEntity(getString(R.string.PhoneNumber),

                fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER),
                fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_PHONE_NUMBER),

                FieldIDs.CHECK_DISPLAY_PHONE_NUMBER,
                FieldIDs.CHECK_REQUIRED_PHONE_NUMBER));

        fieldEntities.add(new FieldEntity(getString(R.string.Email),

                fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_EMAIL),
                fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_EMAIL),

                FieldIDs.CHECK_DISPLAY_EMAIL,
                FieldIDs.CHECK_REQUIRED_EMAIL));

        fieldEntities.add(new FieldEntity(getString(R.string.CustomText),
                fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_1),
                fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_1),

                FieldIDs.CHECK_DISPLAY_CUSTOM_1,
                FieldIDs.CHECK_REQUIRED_CUSTOM_1));

        fieldEntities.add(new FieldEntity(getString(R.string.CustomText),

                fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_2),
                fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_2),

                FieldIDs.CHECK_DISPLAY_CUSTOM_2,
                FieldIDs.CHECK_REQUIRED_CUSTOM_2));

        fieldEntities.add(new FieldEntity(getString(R.string.CustomText),

                fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_3),
                fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_3),

                FieldIDs.CHECK_DISPLAY_CUSTOM_3,
                FieldIDs.CHECK_REQUIRED_CUSTOM_3));

        fieldEntities.add(new FieldEntity(getString(R.string.CustomText),

                fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_4),
                fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_4),

                FieldIDs.CHECK_DISPLAY_CUSTOM_4,
                FieldIDs.CHECK_REQUIRED_CUSTOM_4));

        fieldEntities.get(4).setFieldName(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_1_NAME));
        fieldEntities.get(5).setFieldName(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_2_NAME));
        fieldEntities.get(6).setFieldName(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_3_NAME));
        fieldEntities.get(7).setFieldName(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_4_NAME));

        return fieldEntities;
    }
}
