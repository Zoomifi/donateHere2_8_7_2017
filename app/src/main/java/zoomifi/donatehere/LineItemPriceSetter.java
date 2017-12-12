package zoomifi.donatehere;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.clover.sdk.util.CustomerMode;
import com.clover.sdk.util.Platform;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Andrew on 1/16/2016.
 * Used for Delivery Fee application for Zoomifi Inc.
 */

public class LineItemPriceSetter extends Dialog implements View.OnClickListener
{
    private Context                     context;
    private int                         buttonIndex = 0;
    private String                      PRICE_STRING = "";
    private long                        PRICE = 0;
    private CustomPriceEnteredListener customPriceEnteredListener;
    private String                      headerString = "Enter Amount";
    private boolean                     fromCustomer = false;

    private static final NumberFormat   mCurrencyFormat = DecimalFormat.getCurrencyInstance(Locale.US);

    /**
     * Constructor.
     * @param context: Parent's context (from MainActivity or LineItemService.)
     */

    public LineItemPriceSetter(Context context)
    {
        super(context);

        this.context = context;
    }

    /**
     * Initialize Dialog buttons and basic setup.
     * @param savedInstanceState : Bundle for
     */

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_set_price);

        // Configure window size.

        DisplayMetrics metrics = this.context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        getWindow().setLayout((3 * width) / 7, (5 * height) / 7);

        if(this.fromCustomer)
            setupFullscreenMode();

        // Initiate Add button.

        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String _KEY = "";

                switch(buttonIndex)
                {
                    case 1:
                        _KEY = context.getString(R.string.donation_button1_price);
                        break;
                    case 2:
                        _KEY = context.getString(R.string.donation_button2_price);
                        break;
                    case 3:
                        _KEY = context.getString(R.string.donation_button3_price);
                        break;
                    case 4:
                        _KEY = context.getString(R.string.donation_button4_price);
                        break;
                    case 5:
                        _KEY = context.getString(R.string.donation_button5_price);
                        break;
                    default:
                        customPriceEnteredListener.setPrice(null, PRICE);
                        dismiss();
                        return;
                }

                if(PRICE > 0 && PRICE_STRING.length() > 0)
                {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.donation_here_file), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putLong(_KEY, PRICE);
                    editor.commit();

                    customPriceEnteredListener.changeButton(buttonIndex, PRICE_STRING);

                    dismiss();
                }
            }
        });

        ((TextView) findViewById(R.id.TOTAL)).setTextColor(ContextCompat.getColor(this.context, R.color.Gray1));
        Button button = (Button)findViewById(R.id.addButton);
        button.setEnabled(false);
        button.setAlpha(0.5f);

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });

        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        // Set ClickListeners

        findViewById(R.id._1)       .setOnClickListener(this);
        findViewById(R.id._2)       .setOnClickListener(this);
        findViewById(R.id._3)       .setOnClickListener(this);
        findViewById(R.id._4)       .setOnClickListener(this);
        findViewById(R.id._5)       .setOnClickListener(this);
        findViewById(R.id._6)       .setOnClickListener(this);
        findViewById(R.id._7)       .setOnClickListener(this);
        findViewById(R.id._8)       .setOnClickListener(this);
        findViewById(R.id._9)       .setOnClickListener(this);
        findViewById(R.id._0)       .setOnClickListener(this);
        findViewById(R.id._00)      .setOnClickListener(this);
        findViewById(R.id._DELETE)  .setOnClickListener(this);

        ((TextView)findViewById(R.id.header)).setText(headerString);
    }

    /**
     * Set the interface for communication between the Dialog and Parent calling class.
     * @param customPriceEnteredListener : Interface for communication.
     */

    public void setCustomPriceEnteredListener(CustomPriceEnteredListener customPriceEnteredListener)
    {
        this.customPriceEnteredListener = customPriceEnteredListener;
    }

    public void setFromCustomer(boolean fromCustomer)
    {
        this.fromCustomer = fromCustomer;
    }

    /**
     * Set the Button ID for use within this class (internal).
     * @param ID : Internal button ID of the selected Button.
     */

    public void setButtonIndex(int ID)
    {
        this.buttonIndex = ID;
    }

    /**
     * Write the new price for whichever default button the user selected.
     * @param buttonID : Internal ID for the button the user clicked.
     * @param price : New price input.
     */

    private void saveDefaultPrice(int buttonID, long price)
    {
        //SharedPreferences sharedPreferences = this.context.getSharedPreferences(this.context.getString(R.string.FILE), Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPreferences.edit();

        /*switch(buttonID)
        {
            case DeliveryFeeContract.BUTTON_ID_1:
                editor.putLong(this.context.getString(R.string.DefaultPriceButton1), price);
                break;
            case DeliveryFeeContract.BUTTON_ID_2:
                editor.putLong(this.context.getString(R.string.DefaultPriceButton2), price);
                break;
        }

        editor.commit();

        this.customPriceEnteredListener.changeButton(this.buttonID, formatPrice());*/
    }

    /**
     * Callback method which handles the user input for the price entered,
     * @param v : View used as reference.
     */

    @Override
    public void onClick(View v)
    {
        // The entered price cannot be greater then $99,999.99 (This is the limit clover imposed).

        if(this.PRICE_STRING.length() > 18) // accounts for unsgined max
        {
            // The EU can click the delete button at this point. No other numbers can be entered
            // though.

            if(v.getId() != R.id._DELETE)
                return;
        }

        // Determine which button was clicked on let control flow from there.

        switch(v.getId())
        {
            case R.id._1:
                this.PRICE_STRING += String.valueOf(1);
                break;
            case R.id._2:
                this.PRICE_STRING += String.valueOf(2);
                break;
            case R.id._3:
                this.PRICE_STRING += String.valueOf(3);
                break;
            case R.id._4:
                this.PRICE_STRING += String.valueOf(4);
                break;
            case R.id._5:
                this.PRICE_STRING += String.valueOf(5);
                break;
            case R.id._6:
                this.PRICE_STRING += String.valueOf(6);
                break;
            case R.id._7:
                this.PRICE_STRING += String.valueOf(7);
                break;
            case R.id._8:
                this.PRICE_STRING += String.valueOf(8);
                break;
            case R.id._9:
                this.PRICE_STRING += String.valueOf(9);
                break;
            case R.id._0:
                if(PRICE != 0 && PRICE_STRING.length() > 0)
                    this.PRICE_STRING += String.valueOf(0);
                break;
            case R.id._00:
                if(PRICE != 0 && PRICE_STRING.length() > 0)
                    this.PRICE_STRING += "00";
                break;
            case R.id._DELETE:
                if(this.PRICE_STRING.length() > 0)
                    this.PRICE_STRING = this.PRICE_STRING.substring(0, this.PRICE_STRING.length() - 1);
                break;
        }

        if(this.PRICE_STRING.length() > 0)
        {
            this.PRICE = Long.parseLong(this.PRICE_STRING);
        }
        else
            this.PRICE = 0;

        ((TextView) findViewById(R.id.TOTAL)).setText(formatPrice());

        if(this.PRICE == 0)
        {
            ((TextView) findViewById(R.id.TOTAL)).setTextColor(ContextCompat.getColor(this.context, R.color.Gray1));
            Button button = (Button)findViewById(R.id.addButton);
            button.setEnabled(false);
            button.setAlpha(0.5f);
        }
        else if(!findViewById(R.id.addButton).isEnabled())
        {
            ((TextView) findViewById(R.id.TOTAL)).setTextColor(ContextCompat.getColor(this.context, R.color.Black));
            Button button = (Button)findViewById(R.id.addButton);
            button.setEnabled(true);
            button.setAlpha(1.0f);
        }
    }

    /**
     * Format the price from the long value to USD display.
     * @return : The formatted price as a String.
     */

    @NonNull
    private String formatPrice()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.donation_here_file), Context.MODE_PRIVATE);
        //default USD from prefs
        String currency = sharedPreferences.getString("currencyCode", "USD");

        mCurrencyFormat.setCurrency(Currency.getInstance(currency));// "GBP"));

        if(PRICE_STRING.isEmpty())
            PRICE_STRING = "0";

        long value = Long.valueOf(PRICE_STRING);
        return mCurrencyFormat.format(value / 100.0);

        /*StringBuilder builder = new StringBuilder(this.PRICE_STRING);

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

    public void setHeader(String headerString)
    {
        this.headerString = headerString;
    }

    private void setupFullscreenMode()
    {
        CustomerMode.enable(this.context);
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
}
