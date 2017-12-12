package zoomifi.donatehere;

import android.accounts.Account;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.clover.sdk.util.CloverAccount;
import com.clover.sdk.v1.BindingException;
import com.clover.sdk.v1.ClientException;
import com.clover.sdk.v1.ServiceConnector;
import com.clover.sdk.v1.ServiceException;
import com.clover.sdk.v1.customer.Customer;
import com.clover.sdk.v1.customer.CustomerConnector;
import com.clover.sdk.v1.merchant.Merchant;
import com.clover.sdk.v1.merchant.MerchantAddress;
import com.clover.sdk.v1.merchant.MerchantConnector;
import com.clover.sdk.v3.employees.Employee;
import com.clover.sdk.v3.employees.EmployeeConnector;
import com.clover.sdk.v3.order.Order;
import com.clover.sdk.v3.order.OrderConnector;
import com.clover.sdk.v3.order.OrderContract;
import com.clover.sdk.v3.order.OrderType;
import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class MainActivity extends Activity implements View.OnClickListener
{
    private static final int    FLAG_FIRST_TIME         = 1001;
    private static final int    FLAG_UPDATE             = 1002;

    private Account             cloverAccount;
    private OrderConnector      orderConnector;
    private MerchantConnector   merchantConnector;
    private EmployeeConnector   employeeConnector;
    private CustomerConnector   customerConnector;
    private List<OrderEntity>   OrdersMasterList;

    private CustomListAdapter customListAdapter;

    private static String       mercID                  = "default";
    private static String       mEmail                  = "do data";
    private static String       mCloverID;
    private static String       mAdd                    = "no data";
    private static String       mCity                   = "no data";
    private static String       mState                  = "no data";
    private static String       mCountry                = "no data";
    private static String       mNumber                 = "no data";
    private static String       mZip                    = "no data";
    private static String       mTimezone               = "no data";
    private static String       mName                   = "no data";

    private Boolean             firstTimeStartingApp    = true;
    private Context             mContext;

    private String              merchantID              = "";

    private boolean             setTextViewVisible      = false;

    private ListView            listView;

    private Firebase            ref;

    @Override
    protected void onSaveInstanceState(Bundle outstate)
    {
        outstate.putBoolean("TEXT_VIEW_VISIBLE", setTextViewVisible);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://donatehere.firebaseio.com/");

        AuthData authData = ref.getAuth();
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

        setTextViewVisible = savedInstanceState == null || savedInstanceState.getBoolean("TEXT_VIEW_VISIBLE", false);
        setAlarm(this);

        //this is the correct project

        findViewById(R.id.settingsButton).setOnClickListener(this);
        findViewById(R.id.customerButton).setOnClickListener(this);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        if(this.cloverAccount == null)
        {
            this.cloverAccount = CloverAccount.getAccount(this);

            if(this.cloverAccount == null)
            {
                Toast.makeText(this, "ERROR: Clover Account not found.", Toast.LENGTH_LONG).show();
                return;
            }
        }

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        updateOrganizationName();

        connectMerchantConnector();
        connectEmployeeConnector();
        connectCustomerConnector();
        connectOrderConnector();
        getEmployee();
        getMerchant();
    }

    public void queryDonations()
    {
        if(firstTimeStartingApp)
        {
            firstTimeStartingApp = false;
            new QueryDonationOrders(this, FLAG_FIRST_TIME).execute();
        }
        else
            callQueryDonationOrders(null);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        disconnectOrderConnect();
        disconnectCustomerConnect();
        disconnectMerchantConnector();
        disconnectEmployeeConnector();
    }

    private void getMerchant() {
        System.out.println("GETMERCHANT CALLED");

        new AsyncTask<Void, Void, Merchant>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Merchant doInBackground(Void... params) {
                Merchant merchant = null;
                try {
                    merchant = merchantConnector.getMerchant();

                    merchantID = merchant.getId();
                    MerchantAddress mAddress = merchant.getAddress();
                    mAdd = mAddress.getAddress1()+" "+mAddress.getAddress2()+" "+mAddress.getAddress3();
                    mCity = mAddress.getCity();
                    mState = mAddress.getState();
                    mZip = mAddress.getZip();
                    mCountry = mAddress.getCountry();
                    TimeZone tz = merchant.getTimeZone();
                    mTimezone = tz.getDisplayName();
                    mName = merchant.getName();
                    mNumber = merchant.getPhoneNumber();
                    mercID = merchant.getId();
                    // either merchant or employee will finish first, check here and send info

                    SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getString(R.string.donation_here_file), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("currencyCode", merchant.getCurrency().getCurrencyCode());
                    //editor.putString("currencyCode", "GBP");
                    editor.commit();

                    infoexecute();
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
            protected void onPostExecute(Merchant merchant) {
                super.onPostExecute(merchant);

                if (!isFinishing()) {
                    System.out.println("GETMERCHANT INFO");

                    // Populate the merchant information
                    /*if (merchant != null) {

                    }*/
                }
            }
        }.execute();
    }

    private void getEmployee() {
        System.out.println("GETEMPLOYEE CALLED");

        new AsyncTask<Void, Void, List<Employee>>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected List<Employee> doInBackground(Void... params) {
                List<Employee> employees = null;

                try {
                    employees = employeeConnector.getEmployees();

                    for (Employee employee : employees) {
                        if (employee.getIsOwner()) {
                            mEmail = employee.getEmail();
                            System.out.println("EMAIL: " + mEmail);
                        }
                    }

                    infoexecute2();

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
                return employees;
            }

            @Override
            protected void onPostExecute(List<Employee> employees) {
                super.onPostExecute(employees);

                /*if (!isFinishing()) {

                }*/
            }
        }.execute();
    }
    public static void infoexecute() {
        Firebase ref = new Firebase("https://zoomifi-app-installs.firebaseio.com/DonateHere/" + mercID);
        ref.child("merchantid").setValue(mercID);
        ref.child("zipcode").setValue(mZip);
        ref.child("timezone").setValue(mTimezone);
        ref.child("phone").setValue(mNumber);
        ref.child("merchantName").setValue(mName);
        ref.child("address").setValue(mAdd);
        ref.child("city").setValue(mCity);
        ref.child("state").setValue(mState);
        ref.child("county").setValue(mCountry);

        Map<String, String> comment = new HashMap<String, String>();
        comment.put("email", mEmail);
        comment.put("merchantID", mercID);
        comment.put("zipcode", mZip);
        comment.put("timezone", mTimezone);
        comment.put("phone", mNumber);
        comment.put("merchantName", mName);
        comment.put("address", mAdd);
        comment.put("city", mCity);
        comment.put("state", mState);
        comment.put("country", mCountry);
        comment.put("cloverID", "Terminal Sale + Tax");
        String json = new GsonBuilder().create().toJson(comment, Map.class);
        makeRequest("https://ops.zoomifi.com/appinstall.php", json);
    }

    public static HttpResponse makeRequest(String uri, String json) {
        try {
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(new StringEntity(json));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            return new DefaultHttpClient().execute(httpPost);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void infoexecute2() {
        Firebase ref = new Firebase("https://zoomifi-app-installs.firebaseio.com/DonateHere/" + mercID);
        ref.child("email").setValue(mEmail);
    }

    /**
     * Connect the Merchant Connector.
     */

    private void connectMerchantConnector() {
        disconnectMerchantConnector();
        //disconnectOrderConnect();
        if(this.cloverAccount != null)
        {
            this.merchantConnector = new MerchantConnector(this, this.cloverAccount, null);
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
    /**
     * Connect the Employee Connector.
     */

    private void connectEmployeeConnector() {
        disconnectEmployeeConnector();
        //disconnectOrderConnect();
        if(this.cloverAccount != null)
        {
            this.employeeConnector = new EmployeeConnector(this, this.cloverAccount, null);
            this.employeeConnector.connect();
        }
    }

    /**
     * Disconnect the Employee Connector.
     */

    private void disconnectEmployeeConnector()
    {
        if(this.employeeConnector != null)
        {
            this.employeeConnector.disconnect();
            this.employeeConnector = null;
        }
    }

    /**
     * Connect the Order Connector.
     */

    private void connectOrderConnector()
    {
        disconnectOrderConnect();
        if(this.cloverAccount != null)
        {
            this.orderConnector = new OrderConnector(this, this.cloverAccount, new ServiceConnector.OnServiceConnectedListener() {
                @Override
                public void onServiceConnected(ServiceConnector<? extends IInterface> serviceConnector) {
                    /*if (orderConnector != null) {
                        //queryDonations();
                    }*/

                    if(setTextViewVisible)
                        setSyncButtonVisibility(View.VISIBLE);
                }

                @Override
                public void onServiceDisconnected(ServiceConnector<? extends IInterface> serviceConnector) {
                }
            });
            this.orderConnector.connect();
        }
    }

    /**
     * Disconnect the Order Connector.
     */

    private void disconnectOrderConnect()
    {
        if(this.orderConnector != null)
        {
            this.orderConnector.disconnect();
            this.orderConnector = null;
        }
    }

    /**
     * Connect the Order Connector.
     */

    private void connectCustomerConnector()
    {
        disconnectCustomerConnect();
        if(this.cloverAccount != null)
        {
            this.customerConnector = new CustomerConnector(this, this.cloverAccount, null);
            this.customerConnector.connect();
        }
    }

    /**
     * Disconnect the Order Connector.
     */

    private void disconnectCustomerConnect()
    {
        if(this.customerConnector != null)
        {
            this.customerConnector.disconnect();
            this.customerConnector = null;
        }
    }

    public void callCreateDonationAsync(View view)
    {
       new CreateDonationAsync().execute();
    }

    public void callQueryDonationOrders(View view)
    {
        new QueryDonationOrders(this, FLAG_UPDATE).execute();
    }

    private class CreateDonationAsync extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... params)
        {
            try
            {
                OrderType orderType = new OrderType();
                orderType.setId("Donation");

                Order order = orderConnector.createOrder(new Order());
                order.setOrderType(orderType);

                orderConnector.updateOrder(order);
            } catch (ServiceException e) {
                Log.e("ERROR: ServiceException", e.getMessage());
            } catch (RemoteException e) {
                Log.e("ERROR: RemoteException", e.getMessage());
            } catch (BindingException e) {
                Log.e("ERROR: BindingException", e.getMessage());
            } catch (ClientException e) {
                Log.e("ERROR: ClientException", e.getMessage());
            }

            return null;
        }
    }

    private class QueryDonationOrders extends AsyncTask<Void, Void, Boolean>
    {
        private Context context;
        private Integer FLAG;

        public QueryDonationOrders(Context _context, Integer _FLAG)
        {
            this.context    = _context;
            this.FLAG       = _FLAG;
        }

        @Override
        protected void onPreExecute()
        {
            if(progressBar != null && progressBar.getVisibility() == View.GONE)
                progressBar.setVisibility(View.VISIBLE);

            findViewById(R.id.syncDonationsTextView).setVisibility(View.GONE);



        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            OrderEntity orderEntity;

            Cursor cursor
                    = MainActivity.this.getContentResolver().query(OrderContract.Summaries.contentUriWithAccount(cloverAccount),
                    new String[]{
                            OrderContract.Summaries.ID,
                            OrderContract.Summaries.TITLE,
                            OrderContract.Summaries.CREATED,
                            OrderContract.Summaries.TOTAL,
                            OrderContract.Summaries.PAYMENT_STATE
                    }, OrderContract.Summaries.TITLE + " LIKE ? AND " + OrderContract.Summaries.PAYMENT_STATE + " LIKE ?", new String[] { "Donation" , "PAID" }, OrderContract.Summaries.CREATED + " DESC");

            //"COALESCE(" + OrderContract.Summaries.ORDER_TYPE + ", '')

            if(cursor != null && cursor.getCount() >= 1)
            {
                OrdersMasterList = new ArrayList<>();

                cursor.moveToFirst();

                do
                {
                    orderEntity = new OrderEntity();

                    orderEntity.setDate(cursor.getLong(2));
                    orderEntity.setAmount(cursor.getLong(3));

                    System.out.println(
                            cursor.getString(0) + " " +
                            cursor.getString(1) + " " +
                            cursor.getString(2) + " " +
                            cursor.getString(3) + " " +
                            cursor.getString(4)
                    );

                    try
                    {
                        Order order = orderConnector.getOrder(cursor.getString(0));
                        orderEntity.setOrderID(order.getId());

                        if (order.isNotEmptyCustomers()) {
                            Customer customer = customerConnector.getCustomer(order.getCustomers().get(0).getId());
                            orderEntity.setCustomerFirstName(customer.getFirstName());
                            orderEntity.setCustomerLastName(customer.getLastName());

                            if (customer.getEmailAddresses() != null && customer.getEmailAddresses().size() > 0)
                            {
                                orderEntity.setEmail(customer.getEmailAddresses().get(0).getEmailAddress());
                                System.out.println("F: " + customer.getFirstName() + " L: " + customer.getLastName() + " E: " + orderEntity.getEmail());
                            }

                            if (customer.getPhoneNumbers() != null && customer.getPhoneNumbers().size() > 0)
                                orderEntity.setPhoneNumber(customer.getPhoneNumbers().get(0).getPhoneNumber());
                        }
                        OrdersMasterList.add(orderEntity);
                    }
                    catch (ServiceException e)
                    {
                        cursor.close();
                        Log.e("ERROR: ServiceException", e.getMessage());
                    }
                    catch (RemoteException e)
                    {
                        cursor.close();
                        Log.e("ERROR: RemoteException", e.getMessage());
                    }
                    catch (BindingException e)
                    {
                        cursor.close();
                        Log.e("ERROR: BindingException", e.getMessage());
                    }
                    catch (ClientException e)
                    {
                        cursor.close();
                        Log.e("ERROR: ClientException", e.getMessage());
                    }
                }

                while(cursor.moveToNext());

                cursor.close();

                return true;
            }
            else
                return false;
        }

        @Override
        protected void onPostExecute(Boolean result)
        {
            if(result)
                populateOrderEntitiesFromFirebase(this.FLAG);
            else
            {
                Toast.makeText(this.context, "No Donations found.", Toast.LENGTH_LONG).show();

                if(progressBar != null && progressBar.getVisibility() == View.VISIBLE)
                    progressBar.setVisibility(View.GONE);
            }

            /*if(result)
            {
                switch(this.FLAG)
                {
                    case FLAG_FIRST_TIME:

                        customListAdapter = new CustomListAdapter(this.context, 0, OrdersMasterList);
                        ListView listView = (ListView)findViewById(R.id.ordersListView);
                        listView.setAdapter(customListAdapter);

                        break;
                    case FLAG_UPDATE:

                        customListAdapter.clear();
                        customListAdapter.addAll(OrdersMasterList);
                        customListAdapter.notifyDataSetChanged();

                        break;
                }
            }
            else
                Toast.makeText(this.context, "No Donations found.", Toast.LENGTH_LONG).show();*/
        }
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.settingsButton)
        {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        if(v.getId() == R.id.customerButton)
        {
            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.donation_here_file), Context.MODE_PRIVATE);
            boolean checkBoxActive = sharedPreferences.getBoolean(getString(R.string.doNotShowDialogAgain), true);

            if(checkBoxActive)
            {
                CustomDialog customDialog = new CustomDialog(this);
                customDialog.setHeaderText("How to Exit the Customer Donation Screen");
                customDialog.setBodyText("Once shown, the Customer Donation Screen can be closed by pressing all four corners of the screen (specified in the diagram) at the same time.");
                customDialog.setDialogFrom(CustomDialog.MAIN_ACTIVITY_INSTRUCTIONS);
                customDialog.show();
            }
            else
            {
                Intent intent = new Intent(this, CustomerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
    }

    private void updateOrganizationName()
    {
        ((TextView)findViewById(R.id.headerMainActivity)).setText(getOrganizationName());
    }

    private String getOrganizationName()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.donation_here_file), Context.MODE_PRIVATE);

        return sharedPreferences.getString(getString(R.string.ORGANIZATION_OR_COMPANY_NAME), "");
    }

    private void populateOrderEntitiesFromFirebase(final Integer flag) //final int index, final String orderId)
    {
        //Firebase ref = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
        ref = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren())
                {
                    boolean c = true;
                    if(child.child("orderid").exists())
                    {
                        for (int x = 0; x < OrdersMasterList.size() && c; x++)
                        {
                            if (OrdersMasterList.get(x).getOrderID().equals(child.child("orderid").getValue().toString()))
                            {
                                System.out.println(child.child("orderid").getValue().toString());
                                if(child.child("customText1").exists())
                                    OrdersMasterList.get(x).setCustomText1(child.child("customText1").getValue().toString());
                                if(child.child("customText2").exists())
                                    OrdersMasterList.get(x).setCustomText2(child.child("customText2").getValue().toString());
                                if(child.child("customText3").exists())
                                    OrdersMasterList.get(x).setCustomText3(child.child("customText3").getValue().toString());
                                if(child.child("customText4").exists())
                                    OrdersMasterList.get(x).setCustomText4(child.child("customText4").getValue().toString());
                                if(child.child("department").exists())
                                    OrdersMasterList.get(x).setDepartment(child.child("department").getValue().toString());
                                c = false;
                            }
                        }
                    }
                }

                parseDonations();

                System.out.println("addFeesToOrderEntities complete, call frefresh OrderList");
                resetList(flag);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void resetList(Integer flag)
    {
        switch(flag)
        {
            case FLAG_FIRST_TIME:

                customListAdapter = new CustomListAdapter(this, 0, OrdersMasterList);
                listView = (ListView)findViewById(R.id.ordersListView);
                listView.setAdapter(customListAdapter);

                break;
            case FLAG_UPDATE:

                customListAdapter.clear();
                customListAdapter.addAll(OrdersMasterList);
                customListAdapter.notifyDataSetChanged();

                break;
        }

        if(progressBar != null && progressBar.getVisibility() == View.VISIBLE)
            progressBar.setVisibility(View.GONE);
    }

    private ProgressBar progressBar;

    public void setSyncButtonVisibility(int visibility)
    {
        findViewById(R.id.syncDonationsTextView).setVisibility(visibility);
        setTextViewVisible = false;
    }

    public void syncDonations(View view)
    {
        if (orderConnector != null) {
            queryDonations();
        }
    }

    public void parseDonations()
    {
        // added this function call to line 694

        //Firebase ref = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
        ref = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");

        for(int x = 0; x < OrdersMasterList.size(); x++)
        {
            Query queryRef = ref.orderByChild("orderid").equalTo(OrdersMasterList.get(x).getOrderID());

            if(queryRef != null)
            {
                Firebase customerRef = new Firebase("https://donatehere.firebaseio.com/merchants/" + merchantID + "/customers");
                Firebase newCustomerRef = customerRef.push();

                String firstName = OrdersMasterList.get(x).getCustomerFirstName();
                String lastName  = OrdersMasterList.get(x).getCustomerLastName();
                String email  = OrdersMasterList.get(x).getEmail();
                String phoneNumber  = OrdersMasterList.get(x).getPhoneNumber();
                String custom1  = OrdersMasterList.get(x).getCustomText1();
                String custom2  = OrdersMasterList.get(x).getCustomText2();
                String custom3  = OrdersMasterList.get(x).getCustomText3();
                String custom4  = OrdersMasterList.get(x).getCustomText4();
                String department  = OrdersMasterList.get(x).getDepartment();

                if(firstName != null && firstName.length() > 0 && firstName != "—")
                {
                    if(lastName != null && lastName.length() > 0 && lastName != "—")
                        newCustomerRef.child("name").setValue(firstName + " " + lastName);
                    else
                        newCustomerRef.child("name").setValue(firstName);
                }
                else if(lastName != null && lastName.length() > 0 && lastName != "—")
                    newCustomerRef.child("name").setValue(lastName);

                if(email != null && email.length() > 0 && email != "—")
                    newCustomerRef.child("email").setValue(firstName + " " + lastName);

                if(phoneNumber != null && phoneNumber.length() > 0 && phoneNumber != "—")
                    newCustomerRef.child("phone").setValue(firstName + " " + lastName);

                if(custom1 != null && custom1.length() > 0 && custom1 != "—")
                    newCustomerRef.child("customText1").setValue(firstName + " " + lastName);

                if(custom2 != null && custom2.length() > 0 && custom2 != "—")
                    newCustomerRef.child("customText2").setValue(firstName + " " + lastName);

                if(custom3 != null && custom3.length() > 0 && custom3 != "—")
                    newCustomerRef.child("customText3").setValue(firstName + " " + lastName);

                if(custom4 != null && custom4.length() > 0 && custom4 != "—")
                    newCustomerRef.child("customText4").setValue(firstName + " " + lastName);

                if(department != null && department.length() > 0 && department != "—")
                    newCustomerRef.child("department").setValue(firstName + " " + lastName);

                newCustomerRef.child("date").setValue(OrdersMasterList.get(x).getParsedDate());
                newCustomerRef.child("amount").setValue(OrdersMasterList.get(x).getParsedAmount());
            }
        }
    }

    private void authenticateUserForFirebase()
    {
        ref.authAnonymously(new Firebase.AuthResultHandler() {
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

    private void setAlarm(Context context) {
        Calendar calendar = Calendar.getInstance();
        long systemTime = calendar.getTimeInMillis();
        long alarmTime = systemTime + (3 * 60 * 1000);
        Intent intent = new Intent(context, AlarmReciever.class);
        intent.setAction("zoomifi.donatehere.AlarmReciever");
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, alarmIntent);

    }
}