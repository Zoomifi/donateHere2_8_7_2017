package zoomifi.donatehere;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class SettingsActivity2 extends Activity implements View.OnClickListener
{
    private static final NumberFormat mCurrencyFormat = DecimalFormat.getCurrencyInstance(Locale.US);
    private SharedPreferences               prefs;
    private SharedPreferences.Editor        edt;
    private Switch                          mSwitch1;
    private Switch                          mSwitch2;
    private Boolean                         iPopups;
    private Boolean                         rPopups;
    CheckBox myCheckBoxes[] = new CheckBox[6];


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);

        for(int i=0; i<6; i++) {
            int resID = getResources().getIdentifier("check"+i, "id", "zoomifi.donatehere");
            myCheckBoxes[i] = ((CheckBox) findViewById(resID));
            myCheckBoxes[i].setOnClickListener(this);
        }


        prefs = this.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        edt = this.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
        setUpButtonPrices();
        setUpCheckBoxes();

        mSwitch1 = (Switch) findViewById(R.id.switch1);
        mSwitch2 = (Switch) findViewById(R.id.switch2);

        iPopups = prefs.getBoolean("iPopup", false);
        System.out.println("Display Instruction Popups?" + iPopups);
        mSwitch1.setChecked(iPopups);
        mSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    edt.putBoolean("iPopup", true);
                    edt.commit();

                } else {
                    edt.putBoolean("iPopup", false);
                    edt.commit();
                }
            }
        });

        rPopups = prefs.getBoolean("rPopup", false);
        System.out.println("Display Instruction Popups?" + rPopups);
        mSwitch2.setChecked(rPopups);
        mSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    edt.putBoolean("rPopup", true);
                    edt.commit();
                } else {
                    edt.putBoolean("rPopup", false);
                    edt.commit();
                }
            }
        });

    }

    @Override
    public void onClick(View v)
    {
        for(int i=0; i<6; i++){
            if(v.getId() == myCheckBoxes[i].getId()){
                System.out.println(myCheckBoxes[i].isChecked());
                if(myCheckBoxes[i].isChecked()){
                    myCheckBoxes[i].setChecked(true);
                    edt.putBoolean("checked"+i, true);
                    edt.commit();
                }else if(!myCheckBoxes[i].isChecked()){
                    myCheckBoxes[i].setChecked(false);
                        edt.putBoolean("checked"+i, false);
                        edt.commit();
                }
            }
        }
    }

    private void setUpCheckBoxes() {
        for(int i=0; i<6; i++){
            if(prefs.getBoolean("checked"+i, true) == true){
                    myCheckBoxes[i].setChecked(true);
            }
            else if(prefs.getBoolean("checked"+i, true) == false){
                myCheckBoxes[i].setChecked(false);
            }
        }
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

    }

    public void backPress(View view)
    {
        onBackPressed();
    }

}
