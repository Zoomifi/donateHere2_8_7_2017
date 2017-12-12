package zoomifi.donatehere;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;

import zoomifi.donatehere.MyApplication;
import zoomifi.donatehere.R;

/**
 * Created by Andrew on 11/30/2015.
 * Created for Zoomifi Inc.
 */

public class OrderEntity
{
    /**
     * This class is a container for holding pertinent data that is kept as part of the list.
     */

    private long   Date                 = 0;
    private long   Amount               = 0;
    private String OrderID              = "";
    private String CustomerFirstName    = "—";
    private String CustomerLastName     = "—";
    private String Email                = "—";
    private String PhoneNumber          = "—";

    private String parsedDate;
    private String parsedAmount         = "—";

    private String CustomText1          = "—";
    private String CustomText2          = "—";
    private String CustomText3          = "—";
    private String CustomText4          = "—";
    private String Department           = "—";

    //private String CurrencyCode;

    private long   RefundAmount = 0;

    public OrderEntity() { }

    // SETTER Methods

    public void setDate(long Date)
    {
        this.Date = Date;

        try
        {
            this.parsedDate = parseDate();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public void setAmount(long Amount)
    {
        this.Amount = Amount;
        this.parsedAmount = parseMoney(this.Amount);
    }

    public void setCustomerFirstName(String CustomerFirstName)  { this.CustomerFirstName = CustomerFirstName; }
    public void setCustomerLastName(String CustomerLastName)    { this.CustomerLastName = CustomerLastName; }
    public void setEmail(String Email)                          { this.Email = Email; }
    public void setPhoneNumber(String PhoneNumber)              { this.PhoneNumber = PhoneNumber; }
    public void setRefundAmount(long refundAmount)              { this.RefundAmount = refundAmount; }
    public void setOrderID(String OrderID)                      { this.OrderID = OrderID; }
    public void setCustomText1(String customText)               { this.CustomText1 = customText; }
    public void setCustomText2(String customText)               { this.CustomText2 = customText; }
    public void setCustomText3(String customText)               { this.CustomText3 = customText; }
    public void setCustomText4(String customText)               { this.CustomText4 = customText; }
    public void setDepartment(String department)                { this.Department = department; }

    // GETTER Methods

    public long   getDate()                                     { return this.Date; }
    public String getParsedDate()                               { return this.parsedDate; }
    public long   getAmount()                                   { return this.Amount; }
    public String getParsedAmount()                             { return this.parsedAmount; }
    public String getCustomerFirstName()                        { return this.CustomerFirstName; }
    public String getCustomerLastName()                         { return this.CustomerLastName; }
    public String getEmail()                                    { return this.Email; }
    public String getPhoneNumber()                              { return this.PhoneNumber; }
    public long   getRefundAmount()                             { return this.RefundAmount; }
    public String getRefundParsed()                             { return "(" + parseMoney(this.RefundAmount) + ")"; }
    public String getOrderID()                                  { return OrderID; }

    public String getCustomText1()                              { return this.CustomText1; }
    public String getCustomText2()                              { return this.CustomText2; }
    public String getCustomText3()                              { return this.CustomText3; }
    public String getCustomText4()                              { return this.CustomText4; }
    public String getDepartment()                               { return this.Department;  }

    /**
     * This method converts the long representation of money in the Clover system to a currency
     * representation.
     * @param amount : The amount of currency to parse (in terms of cents, for USD at least).
     * @return : A String presentations of the currency.
     */

    private String parseMoney(long amount)
    {
        SharedPreferences sharedPreferences = MyApplication.getAppContext().getSharedPreferences(MyApplication.getAppContext().getString(R.string.donation_here_file), Context.MODE_PRIVATE);
        Locale english = new Locale("en");

        Currency currency = Currency.getInstance(Locale.getDefault());// english /*this.CurrencyCode = this.CurrencyCode == null ? */);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setCurrency(currency);

        String cur = sharedPreferences.getString("currencyCode", "USD");
        numberFormat.setCurrency(Currency.getInstance(cur)); //"GBP"));

        return numberFormat.format(amount / 100.0);
    }

    private void parseLongs()
    {
        try
        {
            this.parsedDate = parseDate();
            this.parsedAmount = parseMoney(this.Amount);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    private String parseDate() throws ParseException
    {
        return new SimpleDateFormat("d-MMM yyyy, HH:mm:ss a").format(this.Date);
    }
}
