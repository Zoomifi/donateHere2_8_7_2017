package zoomifi.donatehere;

import android.accounts.Account;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.clover.sdk.util.CloverAccount;
import com.clover.sdk.util.CustomerMode;
import com.clover.sdk.util.Platform;
import com.clover.sdk.v1.BindingException;
import com.clover.sdk.v1.ClientException;
import com.clover.sdk.v1.Intents;
import com.clover.sdk.v1.ResultStatus;
import com.clover.sdk.v1.ServiceConnector;
import com.clover.sdk.v1.ServiceException;
import com.clover.sdk.v1.customer.Customer;
import com.clover.sdk.v1.customer.CustomerConnector;
import com.clover.sdk.v1.merchant.Merchant;
import com.clover.sdk.v1.merchant.MerchantConnector;
import com.clover.sdk.v3.employees.Employee;
import com.clover.sdk.v3.employees.EmployeeConnector;
import com.clover.sdk.v3.order.LineItem;
import com.clover.sdk.v3.order.Order;
import com.clover.sdk.v3.order.OrderConnector;
import com.clover.sdk.v3.payments.Payment;
import com.clover.sdk.v3.payments.Refund;
import com.firebase.client.AuthData;
import com.firebase.client.FirebaseError;
import com.parse.ParseAnalytics;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.firebase.client.Firebase;

import zoomifi.donatehere.DepartmentClasses.DepartmentFromStorage;
import zoomifi.donatehere.DepartmentClasses.DepartmentIDs;
import zoomifi.donatehere.FieldClasses.FieldFromStorage;
import zoomifi.donatehere.FieldClasses.FieldIDs;
import zoomifi.donatehere.Utilities.Conversions;

public class CustomerActivity extends AppCompatActivity implements View.OnClickListener, CustomPriceEnteredListener
{
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edt;
    private MerchantConnector merchantConnector;
    private EmployeeConnector mEmployeeConnector;
    private OrderConnector orderConnector;
    private CustomerConnector customerConnector;
    private Context mContext;
    private Account account;
    private Order mOrder;
    private Handler handler = new Handler();
    private Runnable runnable;

    private LinearLayout buttonLayout;
    private LinearLayout customerLayout;
    private LinearLayout departmentLayout;
    private TextView titleText;
    private EditText firstNameText;
    private EditText lastNameText;
    private EditText phoneText;
    private EditText emailText;

    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    private String customText1;
    private String customText2;
    private String customText3;
    private String customText4;

    private String department;

    private String PRICE_STRING = "";

    private ProgressDialog progressDialog;
    private long donationAmount = 0;
    private int TRIGGER = 0;
    private static final int SECURE_PAY_REQUEST_CODE = 1;
    private Boolean LOCKED = false;
    private Boolean TOUCH_ACTIVE = false;

    private PowerManager.WakeLock mWakeLock;

    private SharedPreferences               prefs;
    private Boolean                         active;

    private boolean isOpened = false;
    private static final NumberFormat mCurrencyFormat = DecimalFormat.getCurrencyInstance(Locale.US);

    private Firebase myFirebaseRef;

    private String          merchantID = "";

    OrderConnector.OnOrderUpdateListener onOrderUpdateListener = new OrderConnector.OnOrderUpdateListener() {
        @Override
        public void onOrderUpdated(String orderId, boolean selfChange)
        {
            new CheckStatusOfOrder(orderId).execute();
        }
    };

    public void showOrHideKeyboard(View view)
    {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        System.out.println("OnCreate Called Again");

        prefs = this.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        active = prefs.getBoolean("active", false);

        Button exitButton = (Button) findViewById(R.id.exitButton);

        if(active == true) {
            exitButton.setEnabled(true);
            exitButton.setVisibility(View.VISIBLE);
        } else {
            exitButton.setEnabled(false);
            exitButton.setVisibility(View.INVISIBLE);
        }

        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://donatehere.firebaseio.com/");

        AuthData authData = myFirebaseRef.getAuth();
        if (authData != null)
        {
            // user authenticated
            System.out.println("User is authenticated to use Firebase.");
        }
        else
        {
            // no user authenticated
            System.out.println("User is not authenticated to use Firebase. Authenticating now...");

            authenticateUserForFirebase();
        }

        mContext = this;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE,"");
        mWakeLock.acquire();
        edt = this.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
        TRIGGER = 0;
        LOCKED = true;

        buttonLayout = (LinearLayout) findViewById(R.id.buttonView);
        departmentLayout = (LinearLayout) findViewById(R.id.buttonView_Departments);
        customerLayout = (LinearLayout) findViewById(R.id.customerView);
        departmentLayout.setVisibility(View.GONE);
        customerLayout.setVisibility(View.GONE);
        ImageButton ib1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton ib3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton ib4 = (ImageButton) findViewById(R.id.imageButton4);
        titleText = (TextView) findViewById(R.id.text1);
        firstNameText = (EditText) findViewById(R.id.fname);
        lastNameText = (EditText) findViewById(R.id.lname);
        phoneText = (EditText) findViewById(R.id.phone);
        emailText = (EditText) findViewById(R.id.email);
        Button payButton = (Button) findViewById(R.id.payButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO CREATE ORDER AND CUSTOMER FIRST TO ASSOCIATE WITH PAYMENT

                if (donationAmount <= 0L)
                    return;

                //startProgressDialog();
                String errorMessage = "";
                Boolean inputError = false;
                //firstname = firstNameText.getText().toString();
                //lastname = lastNameText.getText().toString();
                //phone = phoneText.getText().toString();
                //email = emailText.getText().toString();

                FieldFromStorage fieldFromStorage = new FieldFromStorage(getBaseContext());

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME))
                    firstname    = hash.get(FieldIDs.CHECK_DISPLAY_FIRST_NAME)  .getText().toString();
                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME))
                    lastname     = hash.get(FieldIDs.CHECK_DISPLAY_LAST_NAME)   .getText().toString();
                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER))
                    phone        = hash.get(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER).getText().toString();
                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_EMAIL))
                    email        = hash.get(FieldIDs.CHECK_DISPLAY_EMAIL)       .getText().toString();
                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_1))
                    customText1  = hash.get(FieldIDs.CHECK_DISPLAY_CUSTOM_1)    .getText().toString();
                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_2))
                    customText2  = hash.get(FieldIDs.CHECK_DISPLAY_CUSTOM_2)    .getText().toString();
                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_3))
                    customText3  = hash.get(FieldIDs.CHECK_DISPLAY_CUSTOM_3)    .getText().toString();
                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_4))
                    customText4  = hash.get(FieldIDs.CHECK_DISPLAY_CUSTOM_4)    .getText().toString();

                boolean emailValid = false;

                if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_FIRST_NAME))
                {
                    if (firstname.equals("")) {
                        inputError = true;
                        errorMessage = errorMessage + "Please Enter a First Name\n";
                    }
                }

                if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_LAST_NAME))
                {
                    if (lastname.equals("")) {
                        inputError = true;
                        errorMessage = errorMessage + "Please Enter a Last Name\n";

                    }
                }

                if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_PHONE_NUMBER))
                {
                    if (phone.equals("") ){ // && email.equals("")) {
                        inputError = true;
                        errorMessage = errorMessage + "Please enter a Phone Number\n"; // or Email Address\n";
                    }
                }

                if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_EMAIL))
                {
                    if(!email.equals("") && !isEmailValid(email))
                    {
                        inputError = true;
                        errorMessage = errorMessage + "Invalid Email Address Format\n";
                    }
                    else if(email.equals(""))
                    { // && email.equals("")) {
                        inputError = true;
                        errorMessage = errorMessage + "Please enter an Email Address\n";
                    }
                }

                if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_1))
                {
                    if (customText1.equals("") ){ // && email.equals("")) {
                        inputError = true;
                        errorMessage = errorMessage + "\'" + fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_1_NAME) + "\' is empty.\n";
                    }
                }

                if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_2))
                {
                    if (customText2.equals("") ){ // && email.equals("")) {
                        inputError = true;
                        errorMessage = errorMessage + "\'" + fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_2_NAME) + "' is empty.\n";
                    }
                }

                if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_3))
                {
                    if (customText3.equals("") ){ // && email.equals("")) {
                        inputError = true;
                        errorMessage = errorMessage + "\'" + fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_3_NAME) + "' is empty.\n";
                    }
                }

                if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_4))
                {
                    if (customText4.equals("") ){ // && email.equals("")) {
                        inputError = true;
                        errorMessage = errorMessage + "\'" + fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_4_NAME) + "' is empty.\n";
                    }
                }

                if (inputError) {
                    //cancelProgressDialog();

                    CustomDialog customDialog = new CustomDialog(mContext);
                    customDialog.setHeaderText("Input Error");
                    customDialog.setBodyText(errorMessage);
                    customDialog.setDialogFrom(CustomDialog.CUSTOMER_FACING_SIDE_INVALID_INPUT);
                    customDialog.setCancelable(false);
                    customDialog.show();

                    /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
                    alertDialogBuilder.setTitle("Input Error");
                    alertDialogBuilder
                            .setMessage(errorMessage)
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();*/
                    return;
                }
                else
                    populatePaymentProcessInstructions();
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LOCKED = false;
                finish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO CREATE ORDER AND CUSTOMER FIRST TO ASSOCIATE WITH PAYMENT

                System.out.println("CANCELLED CALLED");

                clearAllEditTexts();
                timerRemove();

                DepartmentFromStorage departmentFromStorage = new DepartmentFromStorage(mContext);

                if(departmentFromStorage.getDisplayDepartmentScreen())
                {
                    customerLayout.setVisibility(View.GONE);
                    departmentLayout.setVisibility(View.VISIBLE);

                    changeText1(2);
                }
                else
                {
                    customerLayout.setVisibility(View.GONE);
                    buttonLayout.setVisibility(View.VISIBLE);
                    changeText1(0);
                    PRICE_STRING = "";
                    resetDonationAmount();
                }
                mOrder = null;
            }
        });

        if(prefs.getBoolean("checked"+0, true) == false){
            findViewById(R.id.button1).setVisibility(View.GONE);
        }
        if(prefs.getBoolean("checked"+1, true) == false){
            findViewById(R.id.button2).setVisibility(View.GONE);
        }if(prefs.getBoolean("checked"+2, true) == false){
            findViewById(R.id.button3).setVisibility(View.GONE);
        }if(prefs.getBoolean("checked"+3, true) == false){
            findViewById(R.id.button4).setVisibility(View.GONE);
        }if(prefs.getBoolean("checked"+4, true) == false){
            findViewById(R.id.button5).setVisibility(View.GONE);
        }if(prefs.getBoolean("checked"+5, true) == false){
            findViewById(R.id.button6).setVisibility(View.GONE);
        }
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);


        findViewById(R.id.button1_Departments).setOnClickListener(this);
        findViewById(R.id.button2_Departments).setOnClickListener(this);
        findViewById(R.id.button3_Departments).setOnClickListener(this);
        findViewById(R.id.button4_Departments).setOnClickListener(this);
        findViewById(R.id.button5_Departments).setOnClickListener(this);
        findViewById(R.id.button6_Departments).setOnClickListener(this);

        View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    TRIGGER = TRIGGER + 1;
                    System.out.println("OnTouch: " + TRIGGER);
                    // CHANGE BACK TO TRIGGER AT 4
                    if (TRIGGER == 4){ //1) {
                        LOCKED = false;
                        logout();
                    }
                    return true;
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    TRIGGER = TRIGGER - 1;

                    return true;
                }
                return false;
            }
        };
        ib1.setOnTouchListener(mOnTouchListener);
        ib2.setOnTouchListener(mOnTouchListener);
        ib3.setOnTouchListener(mOnTouchListener);
        ib4.setOnTouchListener(mOnTouchListener);

        setUpButtonPrices();

        this.PRICE_STRING = "";

        updateOrganizationName();
        setUpLayout();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.donate_here_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        hasOnOrderUpdateListener = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.customer_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_hide_keyboard:
                showOrHideKeyboard(null);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    private void authenticateUserForFirebase()
    {
        myFirebaseRef.authAnonymously(new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                // we've authenticated this session with your Firebase app
                String userID = authData.getUid();
                System.out.println("User is authenticated (onAuthenticated called). UserID: " + userID);

            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                System.out.println("Auth error: " + firebaseError);

            }
        })
        ;
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    private void logout() {
        finishAffinity();
        mEmployeeConnector.logout(new EmployeeConnector.EmployeeCallback<Void>() {
            @Override
            public void onServiceSuccess(Void result, ResultStatus status) {
                super.onServiceSuccess(result, status);
                System.out.println("logged out");
                disconnect();
            }

            @Override
            public void onServiceFailure(ResultStatus status) {
                super.onServiceFailure(status);
                System.out.println("logout failure");
                disconnect();
            }

            @Override
            public void onServiceConnectionFailure() {
                super.onServiceConnectionFailure();
                System.out.println("connection failure");
                disconnect();
            }
        });
        //disconnect();

        setupFullscreenMode();
    }

    private void setUpButtonPrices() {
        sharedPreferences = getSharedPreferences(getString(R.string.donation_here_file), Context.MODE_PRIVATE);

        long[] donationValues = new long[5];

        donationValues[0] = sharedPreferences.getLong(getString(R.string.donation_button1_price), 0L);
        donationValues[1] = sharedPreferences.getLong(getString(R.string.donation_button2_price), 0L);
        donationValues[2] = sharedPreferences.getLong(getString(R.string.donation_button3_price), 0L);
        donationValues[3] = sharedPreferences.getLong(getString(R.string.donation_button4_price), 0L);
        donationValues[4] = sharedPreferences.getLong(getString(R.string.donation_button5_price), 0L);

        String[] donationValuesStrings = new String[5];

        for (int x = 0; x < 5; x++)
            donationValuesStrings[x] = formatPrice(String.valueOf(donationValues[x]));

        ((Button) findViewById(R.id.button1)).setText(donationValuesStrings[0]);
        ((Button) findViewById(R.id.button2)).setText(donationValuesStrings[1]);
        ((Button) findViewById(R.id.button3)).setText(donationValuesStrings[2]);
        ((Button) findViewById(R.id.button4)).setText(donationValuesStrings[3]);
        ((Button) findViewById(R.id.button5)).setText(donationValuesStrings[4]);
    }

    @NonNull
    private String formatPrice(String PRICE_STRING)
    {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getString(R.string.donation_here_file), Context.MODE_PRIVATE);
        //default USD from prefs
        String currency = sharedPreferences.getString("currencyCode", "USD");

        mCurrencyFormat.setCurrency(Currency.getInstance(currency)); //"GBP"));
        long value = Long.valueOf(PRICE_STRING);
        String price = mCurrencyFormat.format(value / 100.0);
        return price;

        //old format code
        /*StringBuilder builder = new StringBuilder(PRICE_STRING);

        if (builder.length() == 0)
            builder = new StringBuilder("$0.00");
        else if (builder.length() == 1)
            builder.insert(0, "$0.0");
        else if (builder.length() == 2)
            builder.insert(0, "$0.");
        else if (builder.length() > 5) {
            builder.insert(0, "$");
            builder.insert(builder.length() - 5, ",");
            builder.insert(builder.length() - 2, ".");
        } else {
            builder.insert(0, "$");
            builder.insert(builder.length() - 2, ".");
        }

        return builder.toString();*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(Platform.isCloverMobile() || Platform.isCloverMini())
            CustomerMode.enable(this);

        System.out.println("OnResume Called, locked: " + LOCKED);

        LOCKED = true;
        timerRemove();

        // hideSystemUI();
        // UiChangerListener();
        setupFullscreenMode();

        // Retrieve the Clover account
        if (account == null) {
            account = CloverAccount.getAccount(this);

            if (account == null) {
                Toast.makeText(this, getString(R.string.no_account), Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
        }

        // Create and Connect
        connect();
        //getEmployee();
        //new getMerchantAsyncTask().execute();

    }

    private class getMerchantAsyncTask extends AsyncTask<Void, Void, Merchant>
    {
        @Override
        protected Merchant doInBackground(Void... params)
        {
            Merchant merchant = null;

            try
            {
                if(merchantConnector.isConnected())
                    System.out.println("Merchant Account connected.");
                else
                    System.out.println("Merchant Account not connected.");

                merchant = merchantConnector.getMerchant();

                System.out.println("Merchant ID: " + merchant.getId());
            }
            catch (ServiceException e)
            {
                Log.e("ERROR: ServiceException", e.getMessage());
            }
            catch (RemoteException e)
            {
                Log.e("ERROR: RemoteException", e.getMessage());
            }
            catch (BindingException e)
            {
                Log.e("ERROR: BindingException", e.getMessage());
            }
            catch (ClientException e)
            {
                Log.e("ERROR: ClientException", e.getMessage());
            }

            return merchant;
        }

        @Override
        protected void onPostExecute(Merchant merchant)
        {
            if(merchant != null)
                merchantID = merchant.getId();
            else
                Toast.makeText(mContext, "ERROR: Problem retrieving Merchant ID.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Connect the Merchant Connector.
     */

    private void connectMerchantConnector()
    {
        disconnectMerchantConnector();
        if(this.account != null)
        {
            this.merchantConnector = new MerchantConnector(this, this.account, null);
            this.merchantConnector.connect();
        }
    }

    /**
     * Disconnect the Merchant Connector.
     */

    private void disconnectMerchantConnector()
    {
        if(this.merchantConnector != null)
        {
            this.merchantConnector.disconnect();
            this.merchantConnector = null;
        }
    }


    private void getEmployee() {
        System.out.println("GETEMPLOYEE CALLED");

        new AsyncTask<Void, Void, List<Employee>>() {

            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
            }

            @Override
            protected List<Employee> doInBackground(Void... params) {
                List<Employee> employees = null;

                try
                {
                    employees = mEmployeeConnector.getEmployees();
                } catch (RemoteException e) {
                    Map<String, String> dimensions = new HashMap<String, String>();
                    dimensions.put("code", e.getMessage());
                    ParseAnalytics.trackEventInBackground("error", dimensions);
                } catch (ClientException e) {
                    Map<String, String> dimensions = new HashMap<String, String>();
                    dimensions.put("code", e.getMessage());
                    ParseAnalytics.trackEventInBackground("error", dimensions);
                } catch (ServiceException e) {
                    Map<String, String> dimensions = new HashMap<String, String>();
                    dimensions.put("code", e.getMessage());
                    ParseAnalytics.trackEventInBackground("error", dimensions);
                } catch (BindingException e) {
                    Map<String, String> dimensions = new HashMap<String, String>();
                    dimensions.put("code", e.getMessage());
                    ParseAnalytics.trackEventInBackground("error", dimensions);
                }
                return employees;
            }

            @Override
            protected void onPostExecute(List<Employee> employees) {
                super.onPostExecute(employees);

                if (!isFinishing()) {

                }
            }
        }.execute();
    }

    @Override
    protected void onPause()
    {
        if(Platform.isCloverMobile() || Platform.isCloverMini())
            CustomerMode.disable(this);

        //disconnect();
        System.out.println("OnPause Called" + LOCKED);
        if (LOCKED) {
            Intent i = new Intent(this, CustomerActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(i);
        }

        super.onPause();
    }

    @Override
    protected void onDestroy()
    {
        System.out.println("onDestroy called");
        disconnect();
        timerRemove();
        mWakeLock.release();
        super.onDestroy();
    }

    private void connect() {
        disconnect();

        System.out.println("Connect Called");

        if (account != null) {
            merchantConnector = new MerchantConnector(this, account, new ServiceConnector.OnServiceConnectedListener()
            {

                @Override
                public void onServiceConnected(ServiceConnector<? extends IInterface> connector)
                {
                    new getMerchantAsyncTask().execute();
                }

                @Override
                public void onServiceDisconnected(ServiceConnector<? extends IInterface> connector) {

                }
            });
            merchantConnector.connect();

            mEmployeeConnector = new EmployeeConnector(this, account, new ServiceConnector.OnServiceConnectedListener()
            {

                @Override
                public void onServiceConnected(ServiceConnector<? extends IInterface> connector)
                {
                    getEmployee();
                }

                @Override
                public void onServiceDisconnected(ServiceConnector<? extends IInterface> connector) {

                }
            });
            mEmployeeConnector.connect();

            customerConnector = new CustomerConnector(this, account, null);
            customerConnector.connect();

            orderConnector = new OrderConnector(this, account, new OrderConnector.OnServiceConnectedListener()
            {

                @Override
                public void onServiceConnected(ServiceConnector<? extends IInterface> connector)
                {
                    //orderConnector.addOnOrderChangedListener(onOrderUpdateListener);
                }

                @Override
                public void onServiceDisconnected(ServiceConnector<? extends IInterface> connector) {

                }
            });
            orderConnector.connect();
        }
        else
            System.out.println("Account not connected.");
    }

    private void disconnect() {

        if (mEmployeeConnector != null) {
            mEmployeeConnector.disconnect();
            mEmployeeConnector = null;
        }
        if (merchantConnector != null) {
            merchantConnector.disconnect();
            merchantConnector = null;
        }
        if (customerConnector != null) {
            customerConnector.disconnect();
            customerConnector = null;
        }
        if (orderConnector != null) {
            orderConnector.disconnect();
            orderConnector = null;
        }
    }

    @Override
    public void onClick(View v)
    {
        DepartmentFromStorage departmentFromStorage = new DepartmentFromStorage(this);

        System.out.println(getResources().getResourceEntryName(v.getId()));

        switch(v.getId())
        {
            case R.id.button1:
                donationAmount = sharedPreferences.getLong(getString(R.string.donation_button1_price), 0L);
                //bringCustomerLayoutToFront();
                bringDepartmentLayoutToFront();
                break;
            case R.id.button2:
                donationAmount = sharedPreferences.getLong(getString(R.string.donation_button2_price), 0L);
                //bringCustomerLayoutToFront();
                bringDepartmentLayoutToFront();
                break;
            case R.id.button3:
                donationAmount = sharedPreferences.getLong(getString(R.string.donation_button3_price), 0L);
                //bringCustomerLayoutToFront();
                bringDepartmentLayoutToFront();
                break;
            case R.id.button4:
                donationAmount = sharedPreferences.getLong(getString(R.string.donation_button4_price), 0L);
                //bringCustomerLayoutToFront();
                bringDepartmentLayoutToFront();
                break;
            case R.id.button5:
                donationAmount = sharedPreferences.getLong(getString(R.string.donation_button5_price), 0L);
                //bringCustomerLayoutToFront();
                bringDepartmentLayoutToFront();
                break;
            case R.id.button6:
                LineItemPriceSetter lineItemPriceSetter = new LineItemPriceSetter(this);
                lineItemPriceSetter.setCustomPriceEnteredListener(this);
                lineItemPriceSetter.setButtonIndex(6);
                lineItemPriceSetter.setFromCustomer(true);
                lineItemPriceSetter.show();
                break;
            case R.id.button1_Departments:

                if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_1))
                {
                    this.department = departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_1);
                    bringCustomerLayoutToFront();
                }

                break;
            case R.id.button2_Departments:

                if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_2))
                {
                    this.department = departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_2);
                    bringCustomerLayoutToFront();
                }

                break;
            case R.id.button3_Departments:

                if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_3))
                {
                    this.department = departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_3);
                    bringCustomerLayoutToFront();
                }

                break;
            case R.id.button4_Departments:

                if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_4))
                {
                    this.department = departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_4);
                    bringCustomerLayoutToFront();
                }

                break;
            case R.id.button5_Departments:

                System.out.print("sasds");

                if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_5))
                {
                    System.out.print("sasdsswwqfsad");
                    this.department = departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_5);
                    bringCustomerLayoutToFront();
                }

                break;
            case R.id.button6_Departments:

                if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_6))
                {
                    this.department = departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_6);
                    bringCustomerLayoutToFront();
                }

                break;
        }
    }

    @Override
    public void setPrice(String orderID, long price)
    {
        donationAmount = price;
        this.PRICE_STRING = String.valueOf(donationAmount);
        //bringCustomerLayoutToFront();
        bringDepartmentLayoutToFront();
    }

    @Override
    public void changeButton(int buttonID, String PRICE_STRING)
    {
        if(buttonID == 6){
            System.out.println("test listener" + PRICE_STRING);
            donationAmount = Long.parseLong(PRICE_STRING);
            titleText.setText(formatPrice(PRICE_STRING)+" Donation: Please enter your contact details.");
        }
    }

    private class SaveCustomerAsyncTask extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... params)
        {
            Customer customer = null;
            String customerId = null;
            try
            {
                // Create a customer based on the name from the EditTexts.
                customer = customerConnector.createCustomer(firstname, lastname, false);
                // Add phone number
                customerConnector.addPhoneNumber(customer.getId(), phone);
                // Add email address
                customerConnector.addEmailAddress(customer.getId(), email);
                customerId = customer.getId();

            }
            catch (ServiceException e)
            {
                Log.e("ERROR: ServiceException", e.getMessage());
            }
            catch (RemoteException e)
            {
                Log.e("ERROR: RemoteException", e.getMessage());
            }
            catch (BindingException e)
            {
                Log.e("ERROR: BindingException", e.getMessage());
            }
            catch (ClientException e)
            {
                Log.e("ERROR: ClientException", e.getMessage());
            }
            return customerId;
        }

        @Override
        public void onPostExecute(String customId)
        {
            //cancelProgressDialog();
            if(customId == null)
                Toast.makeText(getApplicationContext(), "Customer Not Created", Toast.LENGTH_LONG).show();
        }
    }

    private class CreateDonationAsync extends AsyncTask<String, Void, Order>
    {
        @Override
        protected Order doInBackground(String... params)
        {
            System.out.println("createdonationn");
            String Id = params[0];
            String orderId = null;
            Order order = null;
            //Customer customer_v1;
            final com.clover.sdk.v3.customers.Customer customer_v3 = new com.clover.sdk.v3.customers.Customer();

            try
            {
                //customer_v1 = customerConnector.getCustomer(Id);
                //System.out.println("Customer1: " + customer_v1);
                customer_v3.setId(Id); //customer_v1.getId());
                System.out.println("Customer2: " + customer_v3);

                //OrderType orderType = new OrderType();
                //orderType.setId("Donation");
                LineItem myLineItem = new LineItem();
                myLineItem.setPrice(donationAmount);
                order = orderConnector.createOrder(new Order());
                orderId = order.getId();
                order.setTitle("Donation");

                FieldFromStorage fieldFromStorage = new FieldFromStorage(getApplicationContext());//this);
                DepartmentFromStorage departmentFromStorage = new DepartmentFromStorage(getApplicationContext());//this);

                String notes = firstname + " & " + lastname + " & " + email + " & " + phone + " & " + customText1 + " & " + customText2 + " & " + customText3 + " & " + customText4 + " & " + department;
                order.setNote(notes);

                //order.setOrderType(orderType);
                order = orderConnector.updateOrder(order);
                order.setCustomers(Collections.singletonList(customer_v3));
                order = orderConnector.updateOrder(order);
                orderConnector.addCustomLineItem(orderId, myLineItem, false);
                order = orderConnector.updateOrder(order);
                System.out.println("Customer3: " + order.getCustomers());
                System.out.println("orderid: " + orderId);

            }
            catch (ServiceException e)
            {
                Log.e("ERROR: ServiceException", e.getMessage());
            }
            catch (RemoteException e)
            {
                Log.e("ERROR: RemoteException", e.getMessage());
            }
            catch (BindingException e)
            {
                Log.e("ERROR: BindingException", e.getMessage());
            }
            catch (ClientException e)
            {
                Log.e("ERROR: ClientException", e.getMessage());
            }

            return order;
        }

        @Override
        public void onPostExecute(Order order)
        {
            System.out.println("ORDER CREATED");

            if(order == null)
                Toast.makeText(getApplicationContext(), "Order Not Created", Toast.LENGTH_LONG).show();
        }
    }


    /**
     * UI animation (ProgressBar) for End User to recognize that the creation of the Customer is taking place.
     */

    private void startProgressDialog()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving your Customer...");
        progressDialog.show();
    }

    /**
     * Cancel the ProgressBar.
     */

    private void cancelProgressDialog()
    {
        if(progressDialog != null)
        {
            if(progressDialog.isShowing())
                progressDialog.cancel();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SECURE_PAY_REQUEST_CODE){

            //System.out.println("orderresult: " + mOrder.getId() + " resultCode:" + resultCode+" orderstate:"+mOrder.getState());

            if (resultCode == RESULT_OK) {

                System.out.println("result ok");
                try {
                    Thread.sleep(2000);
                    Toast.makeText(this, "Updating your order... This might take a moment.", Toast.LENGTH_LONG).show();
                } catch (InterruptedException ex) {
                    System.out.println("sleep fail");
                    Toast.makeText(this, "There was an error updating your order.", Toast.LENGTH_LONG).show();
                }

                try {
                    Order holdOrder = new updateOrderAsync().execute().get();
                    mOrder = holdOrder;
                    //canUploadToFirebase = true;
                } catch (InterruptedException e) {
                    System.out.println("update fail");
                    Toast.makeText(this, "There was an error updating your order.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    System.out.println("update fail");
                    Toast.makeText(this, "There was an error updating your order.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                Payment payment = data.getParcelableExtra(Intents.EXTRA_PAYMENT);
                String  amountString = String.format("%.2f", ((Double) (0.01 * payment.getAmount())));
                Toast.makeText(getApplicationContext(), getString(R.string.payment_successful, amountString), Toast.LENGTH_SHORT).show();

                Refund refund = data.getParcelableExtra(Intents.EXTRA_REFUND);

                boolean hasRefund = false;

                if(refund != null)
                    hasRefund = true;

                if(hasRefund && refund.getAmount() > 0)
                    sendOrderCredentialsToFirebase(mOrder);
                else if(!hasRefund && payment.getAmount() > 0)
                    sendOrderCredentialsToFirebase(mOrder);
                else if(hasRefund && refund.getAmount() >= 0 && payment.getAmount() > 0)
                    sendOrderCredentialsToFirebase(mOrder);

            clearAllEditTexts();
            bringButtonLayoutToFront();
        }
        mOrder = null;
    }}
    private void receiptDialog(final String orderId)
    {
        LOCKED = false;
        if(prefs.getBoolean("rPopup", true)==true) {
            CustomReceiptDialog customReceiptDialog = new CustomReceiptDialog(mContext, merchantID, orderId, email, phone);
            customReceiptDialog.setHeaderText("How Would You Like Your Receipt?");
            customReceiptDialog.show();
        }
    }

    private class updateOrderAsync extends AsyncTask<String, Void, Order>
    {
        @Override
        protected Order doInBackground(String... params)
        {
            System.out.println("createdonationn");
            Order order = null;
            //Customer customer_v1;
            final com.clover.sdk.v3.customers.Customer customer_v3 = new com.clover.sdk.v3.customers.Customer();

            try
            {
                order = orderConnector.updateOrder(mOrder);
            }
            catch (ServiceException e)
            {
                Log.e("ERROR: ServiceException", e.getMessage());
            }
            catch (RemoteException e)
            {
                Log.e("ERROR: RemoteException", e.getMessage());
            }
            catch (BindingException e)
            {
                Log.e("ERROR: BindingException", e.getMessage());
            }
            catch (ClientException e)
            {
                Log.e("ERROR: ClientException", e.getMessage());
            }

            return order;
        }

        @Override
        public void onPostExecute(Order order)
        {
            System.out.println("ORDER CREATED");

            if(order == null)
                Toast.makeText(getApplicationContext(), "Order Not Created", Toast.LENGTH_LONG).show();
        }
    }

    private void setupFullscreenMode()
    {
        //CustomerMode.enable(this);

        if(Platform.isCloverMobile() || Platform.isCloverMini())
            return;

        View decorView = setFullscreen();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                setFullscreen();
            }
        });
    }

    private View setFullscreen()
    {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(/*View.SYSTEM_UI_FLAG_LAYOUT_STABLE
 +            | */View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        return decorView;
    }

    private void removeFullscreen()
    {
        getWindow().clearFlags(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
        {
            if(Platform.isCloverMobile() || Platform.isCloverMini())
                return;

            setFullscreen();
        }
    }

    @NonNull
    private String formatPrice()
    {
        StringBuilder builder = new StringBuilder(this.PRICE_STRING);

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

        return builder.toString();
    }

    private String getOrganizationName()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.donation_here_file), Context.MODE_PRIVATE);

        return sharedPreferences.getString(getString(R.string.ORGANIZATION_OR_COMPANY_NAME), "Company Name");
    }

    private void updateOrganizationName()
    {
        ((TextView)findViewById(R.id.header)).setText(getOrganizationName());
    }

    private void changeText1(int flag)
    {
        String instructions = "";

        switch(flag)
        {
            case 0:
                instructions = getString(R.string.enterDonationAmount);
                break;
            case 1:
                instructions = "Your donation: " + formatPrice(PRICE_STRING) + ". " + "Thank you!";
                break;
            case 2:
                instructions = "Your donation: " + formatPrice(String.valueOf(donationAmount)) + ". " + getString(R.string.enterDepartmentName);
                break;
            default:
                instructions = getString(R.string.enterDonationAmount);
        }

        TextView textView = (TextView)findViewById(R.id.text1);
        textView.setText(instructions);
    }

    public void bringButtonLayoutToFront()
    {
        PRICE_STRING = "";
        resetDonationAmount();

        DepartmentFromStorage departmentFromStorage = new DepartmentFromStorage(this);
        FieldFromStorage fieldFromStorage = new FieldFromStorage(this);

        if(departmentFromStorage.getDisplayDepartmentScreen() && !fieldFromStorage.doAnyFieldsExist())
            departmentLayout.setVisibility(View.GONE);
        else if(fieldFromStorage.doAnyFieldsExist())
            customerLayout.setVisibility(View.GONE);

        buttonLayout.setVisibility(View.VISIBLE);
        changeText1(0);
    }

    private void bringCustomerLayoutToFront()
    {
        FieldFromStorage fieldFromStorage = new FieldFromStorage(this);

        if(fieldFromStorage.doAnyFieldsExist())
        {
            System.out.println("Donation: " + donationAmount);

            if(donationAmount <= 0L)
                return;
            timerSetup();

            ScrollView scrollView = (ScrollView)findViewById(R.id.scrollViewCustomerActivity);
            scrollView.fullScroll(View.FOCUS_UP);

            firstNameText.setText("");
            lastNameText.setText("");
            phoneText.setText("");
            emailText.setText("");
            PRICE_STRING = String.valueOf(donationAmount);

            DepartmentFromStorage departmentFromStorage = new DepartmentFromStorage(this);

            if(departmentFromStorage.getDisplayDepartmentScreen())
                departmentLayout.setVisibility(View.GONE);
            else
                buttonLayout.setVisibility(View.GONE);

            customerLayout.setVisibility(View.VISIBLE);

            changeText1(1);
        }
        else
            populatePaymentProcessInstructions();
    }

    private void bringDepartmentLayoutToFront()
    {
        if(donationAmount <= 0L)
            return;

        DepartmentFromStorage departmentFromStorage = new DepartmentFromStorage(this);

        if(departmentFromStorage.getDisplayDepartmentScreen())
        {
            buttonLayout.setVisibility(View.GONE);
            departmentLayout.setVisibility(View.VISIBLE);

            changeText1(2);
        }
        else
            bringCustomerLayoutToFront();
    }

    private void timerSetup(){
        startTimeout();
        TOUCH_ACTIVE = true;

        FrameLayout fullLayout = (FrameLayout) findViewById(R.id.full_layout);
        fullLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //show dialog here
                System.out.println("timer setup");

                stopTimeout();
                startTimeout();

                return false;
            }
        });

    }
/*    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if(TOUCH_ACTIVE) {
            stopTimeout();
            startTimeout();
        }
        return super.onTouchEvent(event);
    }*/
    private void timerRemove() {
        System.out.println("timer removed");
        FrameLayout fullLayout = (FrameLayout) findViewById(R.id.full_layout);
        fullLayout.setOnTouchListener(null);
        TOUCH_ACTIVE = false;
        handler.removeCallbacks(runnable);
    }
    private void startTimeout(){
        System.out.println("timer started");
        runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("times up");
                //finish();
                Intent intent = new Intent(MyApplication.getAppContext(), CustomerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                TOUCH_ACTIVE = false;

            }
        };

        handler.postDelayed(runnable, 60000);
    }
    private void stopTimeout(){
        System.out.println("timer stopped");
        handler.removeCallbacks(runnable);
    }

    public void launchReceipts(String orderId)
    {
        LOCKED = false;
        System.out.println("receipt intent called, locked: " + LOCKED);
        Intent intent1 = new Intent(Intents.ACTION_START_PRINT_RECEIPTS);
        intent1.putExtra(Intents.EXTRA_ORDER_ID, orderId);

        if(intent1.resolveActivity(getPackageManager()) != null)
            mContext.startActivity(intent1);
        else
            Toast.makeText(this, "Error: Cannot print receipt; no application found. Please install an application that can print receipts on your device.", Toast.LENGTH_LONG).show();
    }

    public void startPaymentProcess()
    {
        String myId = null;
        String orderId = null;

        try {
            myId = new SaveCustomerAsyncTask().execute().get();
        } catch (InterruptedException e) {
            Log.e("ERROR: Interrupted", e.getMessage());
            e.printStackTrace();
        } catch (ExecutionException e) {
            Log.e("ERROR: Execution", e.getMessage());
            e.printStackTrace();
        }

        try {
            mOrder = new CreateDonationAsync().execute(myId).get();
            //if(hasOnOrderUpdateListener)
                //orderConnector.removeOnOrderChangedListener(onOrderUpdateListener);
            //orderConnector.addOnOrderChangedListener(onOrderUpdateListener);
            //hasOnOrderUpdateListener = true;
            orderId = mOrder.getId();
        } catch (InterruptedException e) {
            Log.e("ERROR: Interrupted", e.getMessage());
            e.printStackTrace();
        } catch (ExecutionException e) {
            Log.e("ERROR: Execution", e.getMessage());
            e.printStackTrace();
        }

        //cancelProgressDialog();
        LOCKED = false;
        System.out.println("ToPayment OrderId " + orderId);
        Intent intent = new Intent(Intents.ACTION_SECURE_PAY);
        intent.putExtra(Intents.EXTRA_AMOUNT, donationAmount);
        intent.putExtra(Intents.EXTRA_ORDER_ID, orderId);

        if(intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent, SECURE_PAY_REQUEST_CODE);
        else
        {
            Toast.makeText(this, "ERROR! Please contact support. Secure Payments app needs to be installed to proceed.", Toast.LENGTH_LONG).show();
        }
    }

    private void populatePaymentProcessInstructions()
    {
        if(prefs.getBoolean("iPopup", true)==true) {
            CustomDialog paymentInstructionsDialog = new CustomDialog(this);
            paymentInstructionsDialog.setHeaderText("Payment Process Instructions: Screen 1 of 3");
            paymentInstructionsDialog.setDialogFrom(CustomDialog.PAYMENT_PROCESS_INSTRUCTIONS);

            paymentInstructionsDialog.show();
        }else{
            startPaymentProcess();
        }
    }

    private EditText generateEditText(String hint, final int indicator, int linearLayoutPosition)
    {
        final EditText editText = new EditText(this);
        editText.setBackgroundResource(R.drawable.search_background);
        editText.setSingleLine(true);
        editText.setHint(hint);
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                switch(indicator)
                {
                    case FieldIDs.CHECK_DISPLAY_FIRST_NAME:
                        firstname = editText.getText().toString();
                        break;
                    case FieldIDs.CHECK_DISPLAY_LAST_NAME:
                        lastname = editText.getText().toString();
                        break;
                    case FieldIDs.CHECK_DISPLAY_PHONE_NUMBER:
                        phone = editText.getText().toString();
                        break;
                    case FieldIDs.CHECK_DISPLAY_EMAIL:
                        email = editText.getText().toString();
                        break;
                    case FieldIDs.CHECK_DISPLAY_CUSTOM_1:
                        customText1 = editText.getText().toString();
                        break;
                    case FieldIDs.CHECK_DISPLAY_CUSTOM_2:
                        customText2 = editText.getText().toString();
                        break;
                    case FieldIDs.CHECK_DISPLAY_CUSTOM_3:
                        customText3 = editText.getText().toString();
                        break;
                    case FieldIDs.CHECK_DISPLAY_CUSTOM_4:
                        customText4 = editText.getText().toString();
                        break;
                }

                return false;
            }
        });

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int)Conversions.convertDpToPixel(250, this), LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins
        (
            (int)Conversions.convertDpToPixel(10, this),
            (int)Conversions.convertDpToPixel(10, this),
            (int)Conversions.convertDpToPixel(10, this),
            (int)Conversions.convertDpToPixel(10, this)
        );

        LinearLayout linearLayout = null;

        switch(linearLayoutPosition)
        {
            case 1:
                linearLayout = (LinearLayout)findViewById(R.id.LinearLayout1);
                break;
            case 2:
                linearLayout = (LinearLayout)findViewById(R.id.LinearLayout2);
                break;
            case 3:
                linearLayout = (LinearLayout)findViewById(R.id.LinearLayout3);
                break;
            case 4:
                linearLayout = (LinearLayout)findViewById(R.id.LinearLayout4);
                break;
        }

        if(linearLayout != null)
            linearLayout.addView(editText, layoutParams);

        return editText;
    }

    Map<Integer, EditText> hash;

    private void clearAllEditTexts()
    {
        FieldFromStorage fieldFromStorage = new FieldFromStorage(this);

        for (Map.Entry<Integer, EditText> entry : hash.entrySet())
        {
            System.out.println(entry.getValue().getText().toString() + " " + entry.getKey() + " " + FieldIDs.CUSTOM_FIELD_1_NAME);
            switch(entry.getKey())
            {
                case FieldIDs.CHECK_DISPLAY_FIRST_NAME:
                    entry.getValue().setText("");
                    entry.getValue().setHint(getString(R.string.FirstName));
                    break;
                case FieldIDs.CHECK_DISPLAY_LAST_NAME:
                    entry.getValue().setText("");
                    entry.getValue().setHint(getString(R.string.LastName));
                    break;
                case FieldIDs.CHECK_DISPLAY_PHONE_NUMBER:
                    entry.getValue().setText("");
                    entry.getValue().setHint(getString(R.string.PhoneNumber));
                    break;
                case FieldIDs.CHECK_DISPLAY_EMAIL:
                    entry.getValue().setText("");
                    entry.getValue().setHint(getString(R.string.Email));
                    break;
                case FieldIDs.CHECK_DISPLAY_CUSTOM_1: //CUSTOM_FIELD_1_NAME:
                    entry.getValue().setText("");
                    entry.getValue().setHint(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_1_NAME));
                    break;
                case FieldIDs.CHECK_DISPLAY_CUSTOM_2:
                    entry.getValue().setText("");
                    entry.getValue().setHint(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_2_NAME));
                    break;
                case FieldIDs.CHECK_DISPLAY_CUSTOM_3:
                    entry.getValue().setText("");
                    entry.getValue().setHint(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_3_NAME));
                    break;
                case FieldIDs.CHECK_DISPLAY_CUSTOM_4:
                    entry.getValue().setText("");
                    entry.getValue().setHint(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_4_NAME));
                    break;
            }
        }

        this.department = "";
    }

    private void setUpLayout()
    {
        hash = new HashMap<>();

        FieldFromStorage fieldFromStorage = new FieldFromStorage(this);

        int layoutPos = 1;
        int counter = 0;

        if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME))
        {
            hash.put(FieldIDs.CHECK_DISPLAY_FIRST_NAME, generateEditText(getString(R.string.FirstName), FieldIDs.CHECK_DISPLAY_FIRST_NAME, layoutPos));
            counter++;
        }

        if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME))
        {
            hash.put(FieldIDs.CHECK_DISPLAY_LAST_NAME, generateEditText(getString(R.string.LastName), FieldIDs.CHECK_DISPLAY_LAST_NAME, layoutPos));
            counter++;
        }
        if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER))
        {
            if(counter != 0 && counter % 2 == 0)
            {
                layoutPos++;
                if(layoutPos == 2)
                    adjustGravity();
            }
            hash.put(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER, generateEditText(getString(R.string.PhoneNumber), FieldIDs.CHECK_DISPLAY_PHONE_NUMBER, layoutPos));
            counter++;
        }
        if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_EMAIL))
        {
            if(counter != 0 && counter % 2 == 0)
            {
                layoutPos++;
                if(layoutPos == 2)
                    adjustGravity();
            };
            hash.put(FieldIDs.CHECK_DISPLAY_EMAIL, generateEditText(getString(R.string.Email), FieldIDs.CHECK_DISPLAY_EMAIL, layoutPos));
            counter++;
        }
        if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_1))
        {
            if(counter != 0 && counter % 2 == 0)
            {
                layoutPos++;
                if(layoutPos == 2)
                    adjustGravity();
            }
            hash.put(FieldIDs.CHECK_DISPLAY_CUSTOM_1, generateEditText(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_1_NAME), FieldIDs.CHECK_DISPLAY_CUSTOM_1, layoutPos));
            counter++;
        }
        if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_2))
        {
            if(counter != 0 && counter % 2 == 0)
            {
                layoutPos++;
                if(layoutPos == 2)
                    adjustGravity();
            }
            hash.put(FieldIDs.CHECK_DISPLAY_CUSTOM_2, generateEditText(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_2_NAME), FieldIDs.CHECK_DISPLAY_CUSTOM_2, layoutPos));
            counter++;
        }
        if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_3))
        {
            if(counter != 0 && counter % 2 == 0)
            {
                layoutPos++;
                if(layoutPos == 2)
                    adjustGravity();
            }
            hash.put(FieldIDs.CHECK_DISPLAY_CUSTOM_3, generateEditText(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_3_NAME), FieldIDs.CHECK_DISPLAY_CUSTOM_3, layoutPos));
            counter++;
        }
        if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_4))
        {
            if(counter != 0 && counter % 2 == 0)
            {
                layoutPos++;
                if(layoutPos == 2)
                    adjustGravity();
            }
            hash.put(FieldIDs.CHECK_DISPLAY_CUSTOM_4, generateEditText(fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_4_NAME), FieldIDs.CHECK_DISPLAY_CUSTOM_4, layoutPos));
            counter++;
        }

        if(layoutPos == 1)
            adjustGravity();

        if(layoutPos != 1 && counter % 2 != 0)
            addInvisibleView(layoutPos);

        TextView textView = (TextView)findViewById(R.id.text2);

        // Please provide your first name, last name, and either your Phone number or Email.

        String credentials = "Required: ";

        boolean atLeastOneField = false;

        if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_FIRST_NAME))
        {
            credentials += getString(R.string.FirstName) + "; ";
            atLeastOneField = true;
        }
        if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_LAST_NAME))
        {
            credentials += getString(R.string.LastName) + "; ";
            atLeastOneField = true;
        }
        if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_PHONE_NUMBER))
        {
            credentials += getString(R.string.PhoneNumber) + "; ";
            atLeastOneField = true;
        }
        if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_EMAIL))
        {
            credentials += getString(R.string.Email) + "; ";
            atLeastOneField = true;
        }
        if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_1))
        {
            credentials += fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_1_NAME) + "; ";
            atLeastOneField = true;
        }
        if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_2))
        {
            credentials += fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_2_NAME) + "; ";
            atLeastOneField = true;
        }
        if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_3))
        {
            credentials += fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_3_NAME) + "; ";
            atLeastOneField = true;
        }
        if(fieldFromStorage.retrieveREQUIREDState(FieldIDs.CHECK_REQUIRED_CUSTOM_4))
        {
            credentials += fieldFromStorage.retrieveCustomFieldName(FieldIDs.CUSTOM_FIELD_4_NAME) + "; ";
            atLeastOneField = true;
        }

        credentials = credentials.substring(0, credentials.length() - 2);
        credentials += ".";

        if(atLeastOneField)
            textView.setText(credentials);
        else
            textView.setText("");

        DepartmentFromStorage departmentFromStorage = new DepartmentFromStorage(this);

        if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_1))
            ((Button)findViewById(R.id.button1_Departments)).setText(departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_1));
        else
            ((Button)findViewById(R.id.button1_Departments)).setText("");
        if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_2))
            ((Button)findViewById(R.id.button2_Departments)).setText(departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_2));
        else
            ((Button)findViewById(R.id.button2_Departments)).setText("");
        if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_3))
            ((Button)findViewById(R.id.button3_Departments)).setText(departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_3));
        else
            ((Button)findViewById(R.id.button3_Departments)).setText("");
        if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_4))
            ((Button)findViewById(R.id.button4_Departments)).setText(departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_4));
        else
            ((Button)findViewById(R.id.button4_Departments)).setText("");
        if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_5))
            ((Button)findViewById(R.id.button5_Departments)).setText(departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_5));
        else
            ((Button)findViewById(R.id.button5_Departments)).setText("");
        if(departmentFromStorage.getDepartmentNameExists(DepartmentIDs.DEPARTMENT_ID_6))
            ((Button)findViewById(R.id.button6_Departments)).setText(departmentFromStorage.getDepartmentName(DepartmentIDs.DEPARTMENT_ID_6));
        else
            ((Button)findViewById(R.id.button6_Departments)).setText("");
    }

    private void adjustGravity()
    {
        TextView textView = new TextView(this);
        textView.setText("Click Here");
        textView.setPadding(0, 0, (int) Conversions.convertDpToPixel(10, this), 0);
        textView.setTextSize(18);
        textView.setVisibility(View.INVISIBLE);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.LinearLayout1);
        linearLayout.addView(textView, layoutParams);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.right_pointing_arrow);
        imageView.setVisibility(View.INVISIBLE);

        layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.addView(imageView, layoutParams);
    }

    private void addInvisibleView(Integer linearLayoutPosition)
    {
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int)Conversions.convertDpToPixel(250, this), 2);
        layoutParams.setMargins
                (
                        (int)Conversions.convertDpToPixel(10, this),
                        (int)Conversions.convertDpToPixel(10, this),
                        (int)Conversions.convertDpToPixel(10, this),
                        (int)Conversions.convertDpToPixel(10, this)
                );

        LinearLayout linearLayout = null;

        switch(linearLayoutPosition)
        {
            case 1:
                linearLayout = (LinearLayout)findViewById(R.id.LinearLayout1);
                break;
            case 2:
                linearLayout = (LinearLayout)findViewById(R.id.LinearLayout2);
                break;
            case 3:
                linearLayout = (LinearLayout)findViewById(R.id.LinearLayout3);
                break;
            case 4:
                linearLayout = (LinearLayout)findViewById(R.id.LinearLayout4);
                break;
        }

        if(linearLayout != null)
            linearLayout.addView(view, layoutParams);
    }

    /*private void test()
    {
        FieldFromStorage        fieldFromStorage        = new FieldFromStorage(this);
        DepartmentFromStorage   departmentFromStorage   = new DepartmentFromStorage(this);

        if(fieldFromStorage.doAnyFieldsExist() && departmentFromStorage.getDisplayDepartmentScreen()) // add department here too
        {
            if(merchantID != null && merchantID.length() > 0)
            {
                Firebase customerRef = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
                Firebase newCustomerRef = customerRef.push();

                if     ( (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME)  && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(firstname + " "+ lastname);
                else if( (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        !(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME)  && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(firstname);
                else if(!(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME)  && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(lastname);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_EMAIL) && !email.isEmpty())
                    newCustomerRef.child("email").setValue(email);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER) && !phone.isEmpty())
                    newCustomerRef.child("phone").setValue(phone);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_1) && !customText1.isEmpty())
                    newCustomerRef.child("customText1").setValue(customText1);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_2) && !customText2.isEmpty())
                    newCustomerRef.child("customText2").setValue(customText2);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_3) && !customText3.isEmpty())
                    newCustomerRef.child("customText3").setValue(customText3);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_4) && !customText4.isEmpty())
                    newCustomerRef.child("customText4").setValue(customText4);

                if(departmentFromStorage.getDisplayDepartmentScreen() && !department.isEmpty())
                    newCustomerRef.child("department").setValue(department);

                //newCustomerRef
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                newCustomerRef.child("date").setValue(mMonth+"-"+mDay+"-"+mYear);
                newCustomerRef.child("amount").setValue(donationAmount);

                newCustomerRef.child("orderid").setValue(mOrder.getId());

            }
            else
            {
                // data was not saved to Firebase

                Toast.makeText(getApplicationContext(), "ERROR: This donation's data was not saved properly.", Toast.LENGTH_SHORT).show();
            }
        }
        else if(fieldFromStorage.doAnyFieldsExist() && !departmentFromStorage.getDisplayDepartmentScreen())
        {
            if(merchantID != null && merchantID.length() > 0)
            {
                Firebase customerRef = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
                Firebase newCustomerRef = customerRef.push();

                if     ( (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME)  && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(firstname + " "+ lastname);
                else if( (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        !(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME)  && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(firstname);
                else if(!(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME)  && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(lastname);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_EMAIL) && !email.isEmpty())
                    newCustomerRef.child("email").setValue(email);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER) && !phone.isEmpty())
                    newCustomerRef.child("phone").setValue(phone);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_1) && !customText1.isEmpty())
                    newCustomerRef.child("customText1").setValue(customText1);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_2) && !customText2.isEmpty())
                    newCustomerRef.child("customText2").setValue(customText2);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_3) && !customText3.isEmpty())
                    newCustomerRef.child("customText3").setValue(customText3);

                if(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_4) && !customText4.isEmpty())
                    newCustomerRef.child("customText4").setValue(customText4);

                //newCustomerRef
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                newCustomerRef.child("date").setValue(mMonth+"-"+mDay+"-"+mYear);
                newCustomerRef.child("amount").setValue(donationAmount);

                newCustomerRef.child("orderid").setValue(mOrder.getId());
            }
        }
        else if(!fieldFromStorage.doAnyFieldsExist() && departmentFromStorage.getDisplayDepartmentScreen())
        {
            if(merchantID != null && merchantID.length() > 0)
            {
                Firebase customerRef = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
                Firebase newCustomerRef = customerRef.push();
                //newCustomerRef.child("department").setValue(department);

                if(departmentFromStorage.getDisplayDepartmentScreen() && !department.isEmpty())
                    newCustomerRef.child("department").setValue(department);

                newCustomerRef.child("orderid").setValue(mOrder.getId());
            }
        }
        clearAllEditTexts();
        bringButtonLayoutToFront();
    }*/

    public void returnFromDepartmentScreen(View view)
    {
        PRICE_STRING = "";

        departmentLayout.setVisibility(View.GONE);
        buttonLayout.setVisibility(View.VISIBLE);
        changeText1(0);
    }

    public void resetDonationAmount()
    {
        donationAmount = 0;
    }

    private class CheckStatusOfOrder extends AsyncTask<Void, Void, Integer>
    {
        private String orderId;

        private static final int ERROR_ORDER_CONNECTOR_NULL = 0x01;
        private static final int ERROR_ORDER_NOT_LOCKED     = 0x02;
        private static final int ERROR_ORDER_NULL           = 0x03;
        private static final int ERROR_ORDER_ID_MISMATCH    = 0x04;
        private static final int ERROR_GENERAL              = 0x05;
        private static final int SUCCESS_PAYMENT            = 0x06;

        public CheckStatusOfOrder(String orderId)
        {
            this.orderId = orderId;
        }

        @Override
        protected Integer doInBackground(Void... params)
        {
            if(orderConnector == null)
            {
                Toast.makeText(getApplicationContext(), getString(R.string.payment_failed) + " Code: 0x00.", Toast.LENGTH_SHORT).show();
                return ERROR_ORDER_CONNECTOR_NULL;
            }

            try
            {
                Order order = orderConnector.getOrder(this.orderId);

                if(order != null)
                    System.out.println(" order: " + order.getId() + " ORDER STATE: " + order.getState());
                if(mOrder != null)
                    System.out.println("mOrder: " + mOrder.getId());

                //if(mOrder != null && order.getId().equals(mOrder.getId()))
                {
                    if(order != null)
                    {
                        if( order.getState().equals("locked"))// && canUploadToFirebase)
                            sendOrderCredentialsToFirebase(order);
                        else
                            return ERROR_ORDER_NOT_LOCKED;
                    }
                    else
                        return ERROR_ORDER_NULL;
                }
                //else
                //    return ERROR_ORDER_ID_MISMATCH;

                return SUCCESS_PAYMENT;

            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            } catch (ServiceException e) {
                e.printStackTrace();
            } catch (BindingException e) {
                e.printStackTrace();
            }
            return ERROR_GENERAL;
        }

        @Override
        protected void onPostExecute(Integer result)
        {
            switch(result)
            {
                case ERROR_ORDER_CONNECTOR_NULL:
                    //Toast.makeText(getApplicationContext(), getString(R.string.payment_failed) + " Error Code: 1.", Toast.LENGTH_SHORT).show();
                    System.out.println("ERROR_ORDER_CONNECTOR_NULL");
                    break;
                case ERROR_ORDER_NOT_LOCKED:
                    //Toast.makeText(getApplicationContext(), getString(R.string.payment_failed) + " Error Code: 2.", Toast.LENGTH_SHORT).show();
                    System.out.println("ERROR_ORDER_NOT_LOCKED");
                    break;
                case ERROR_ORDER_NULL:
                    //Toast.makeText(getApplicationContext(), getString(R.string.payment_failed) + " Error Code: 3.", Toast.LENGTH_SHORT).show();
                    System.out.println("ERROR_ORDER_NULL");
                    break;
                case ERROR_ORDER_ID_MISMATCH:
                    //Toast.makeText(getApplicationContext(), getString(R.string.payment_failed) + " Error Code: 4.", Toast.LENGTH_SHORT).show();
                    System.out.println("ERROR_ORDER_ID_MISMATCH");
                    break;
                case ERROR_GENERAL:
                    //Toast.makeText(getApplicationContext(), getString(R.string.payment_failed) + " Error Code: 5.", Toast.LENGTH_SHORT).show();
                    System.out.println("ERROR_GENERAL");
                    break;
                case SUCCESS_PAYMENT:
                    //Toast.makeText(getApplicationContext(), getString(R.string.payment_successful), Toast.LENGTH_SHORT).show();
                    System.out.println("SUCCESS_PAYMENT");
                    break;
            }
        }
    }

    private void sendOrderCredentialsToFirebase(Order order)
    {
        System.out.println("on Order updated triggered");

        //Payment payment = data.getParcelableExtra(Intents.EXTRA_PAYMENT);
        //String amountString = String.format("%.2f", ((Double) (0.01 * payment.getAmount())));
        Toast.makeText(getApplicationContext(), getString(R.string.payment_successful) /*amountString)*/, Toast.LENGTH_SHORT).show();

        //String order = payment.getOrder().getId();
        System.out.println("orderresult:" + order.getId());

        receiptDialog(order.getId());

        FieldFromStorage fieldFromStorage = new FieldFromStorage(getApplicationContext());//this);
        DepartmentFromStorage departmentFromStorage = new DepartmentFromStorage(getApplicationContext());//this);

        if (fieldFromStorage.doAnyFieldsExist() && departmentFromStorage.getDisplayDepartmentScreen()) // add department here too
        {
            if (merchantID != null && merchantID.length() > 0) {
                Firebase customerRef = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
                Firebase newCustomerRef = customerRef.push();

                if ((fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME) && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(firstname + " " + lastname);
                else if ((fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        !(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME) && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(firstname);
                else if (!(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME) && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(lastname);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_EMAIL) && !email.isEmpty())
                    newCustomerRef.child("email").setValue(email);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER) && !phone.isEmpty())
                    newCustomerRef.child("phone").setValue(phone);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_1) && !customText1.isEmpty())
                    newCustomerRef.child("customText1").setValue(customText1);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_2) && !customText2.isEmpty())
                    newCustomerRef.child("customText2").setValue(customText2);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_3) && !customText3.isEmpty())
                    newCustomerRef.child("customText3").setValue(customText3);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_4) && !customText4.isEmpty())
                    newCustomerRef.child("customText4").setValue(customText4);

                if (departmentFromStorage.getDisplayDepartmentScreen() && !department.isEmpty())
                    newCustomerRef.child("department").setValue(department);

                //newCustomerRef
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                newCustomerRef.child("date").setValue(mMonth + "-" + mDay + "-" + mYear);
                newCustomerRef.child("amount").setValue(donationAmount);

                newCustomerRef.child("orderid").setValue(order.getId());
                Toast.makeText(getApplicationContext(), "Order Update successful.", Toast.LENGTH_LONG).show();
            } else {
                // data was not saved to Firebase

                Toast.makeText(getApplicationContext(), "ERROR: This donation's data was not saved properly.", Toast.LENGTH_SHORT).show();
            }
        } else if (fieldFromStorage.doAnyFieldsExist() && !departmentFromStorage.getDisplayDepartmentScreen()) {
            if (merchantID != null && merchantID.length() > 0) {
                Firebase customerRef = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
                Firebase newCustomerRef = customerRef.push();

                if ((fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME) && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(firstname + " " + lastname);
                else if ((fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        !(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME) && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(firstname);
                else if (!(fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_FIRST_NAME) && !firstname.isEmpty()) &&
                        (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_LAST_NAME) && !lastname.isEmpty()))
                    newCustomerRef.child("name").setValue(lastname);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_EMAIL) && !email.isEmpty())
                    newCustomerRef.child("email").setValue(email);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_PHONE_NUMBER) && !phone.isEmpty())
                    newCustomerRef.child("phone").setValue(phone);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_1) && !customText1.isEmpty())
                    newCustomerRef.child("customText1").setValue(customText1);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_2) && !customText2.isEmpty())
                    newCustomerRef.child("customText2").setValue(customText2);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_3) && !customText3.isEmpty())
                    newCustomerRef.child("customText3").setValue(customText3);

                if (fieldFromStorage.retrieveDISPLAYState(FieldIDs.CHECK_DISPLAY_CUSTOM_4) && !customText4.isEmpty())
                    newCustomerRef.child("customText4").setValue(customText4);

                //newCustomerRef
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                newCustomerRef.child("date").setValue(mMonth + "-" + mDay + "-" + mYear);
                newCustomerRef.child("amount").setValue(donationAmount);

                newCustomerRef.child("orderid").setValue(order.getId());
                Toast.makeText(getApplicationContext(), "Order Update successful.", Toast.LENGTH_LONG).show();
            }
        } else if (!fieldFromStorage.doAnyFieldsExist() && departmentFromStorage.getDisplayDepartmentScreen()) {
            if (merchantID != null && merchantID.length() > 0) {
                Firebase customerRef = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
                Firebase newCustomerRef = customerRef.push();
                //newCustomerRef.child("department").setValue(department);

                if (departmentFromStorage.getDisplayDepartmentScreen() && !department.isEmpty())
                    newCustomerRef.child("department").setValue(department);

                newCustomerRef.child("orderid").setValue(order.getId());
                Toast.makeText(getApplicationContext(), "Order Update successful.", Toast.LENGTH_LONG).show();
            }
        }
        //canUploadToFirebase = false;
        //orderConnector.removeOnOrderChangedListener(onOrderUpdateListener);
        //hasOnOrderUpdateListener = false;
    }

    //private boolean canUploadToFirebase = false;

    private boolean hasOnOrderUpdateListener = false;
}