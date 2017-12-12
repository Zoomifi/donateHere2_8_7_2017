package zoomifi.donatehere;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.clover.sdk.util.Platform;

/**
 * Created by Andrew on 3/4/2016.
 */
public class CustomDialog extends Dialog
{
    private String  headerText;
    private String  bodyText;
    private Context context;
    private String  orderId = "";

    public static final int MAIN_ACTIVITY_INSTRUCTIONS          = 1001;
    public static final int CUSTOMER_FACING_SIDE_INVALID_INPUT  = 1002;
    public static final int RECEIPT_ACTIVITY                    = 1003;
    public static final int PAYMENT_PROCESS_INSTRUCTIONS        = 1004;

    private int dialogFrom = 1001;
    private int clicker = 0;

    public CustomDialog(Context context)
    {
        super(context);

        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);

        ((TextView)findViewById(R.id.customDialogHeader)).setText(this.headerText);
        ((TextView)findViewById(R.id.customeDialogBody )).setText(this.bodyText);

        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        switch(this.dialogFrom)
        {
            case MAIN_ACTIVITY_INSTRUCTIONS:

                findViewById(R.id.customDialogCancelButton).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        dismiss();
                    }
                });

                findViewById(R.id.customDialogSubmitButton).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        dismiss();

                        Intent intent = new Intent(context, CustomerActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });

                DisplayMetrics metrics = this.context.getResources().getDisplayMetrics();
                int width = metrics.widthPixels;
                int height = metrics.heightPixels;

                getWindow().setLayout((5 * width) / 7, (5 * height) / 7);

                findViewById(R.id.instructionsImageView).setVisibility(View.VISIBLE);

                instantiateCheckBoxDoNotShowAgain();

                break;
            case CUSTOMER_FACING_SIDE_INVALID_INPUT:

                setupFullscreenMode();

                Button button = (Button) findViewById(R.id.customDialogCancelButton);
                button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        dismiss();
                    }
                });
                button.setText("OK");

                findViewById(R.id.customDialogSubmitButton).setVisibility(View.GONE);

                DisplayMetrics metrics2 = this.context.getResources().getDisplayMetrics();
                int width2 = metrics2.widthPixels;
                int height2 = metrics2.heightPixels;

                getWindow().setLayout((3 * width2) / 7, (3 * height2) / 7);

                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility());
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

                break;
            case RECEIPT_ACTIVITY:

                initializeReceiptDialog();

                break;

            case PAYMENT_PROCESS_INSTRUCTIONS:

                findViewById(R.id.relativeLayoutFour).setVisibility(View.GONE);
                findViewById(R.id.relativeLayoutOne).setVisibility(View.VISIBLE);

                SpannableString spannablecontent = new SpannableString("1.) There are 3 screens in total. On the first screen, sign your name and click Done.");
                spannablecontent.setSpan(new StyleSpan(Typeface.BOLD), 14, 15, 0);
                spannablecontent.setSpan(new StyleSpan(Typeface.BOLD), spannablecontent.length() - 5, spannablecontent.length() - 1, 0);

                ((TextView)findViewById(R.id.stepOneTextView)).setText(spannablecontent);

                spannablecontent = new SpannableString("2.) Once the second page is shown, click anywhere on the screen to proceed.");
                spannablecontent.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 41, 49, 0);

                ((TextView)findViewById(R.id.stepTwoTextView)).setText(spannablecontent);

                spannablecontent = new SpannableString("3.) Finally, click the Verify button on the third screen (ignore everything else) and the process will be complete!");
                spannablecontent.setSpan(new StyleSpan(Typeface.BOLD), 23, 29, 0);
                spannablecontent.setSpan(new StyleSpan(Typeface.BOLD), 58, 80, 0);

                ((TextView)findViewById(R.id.stepThreeTextView)).setText(spannablecontent);

                findViewById(R.id.customDialogCancelButton).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        switch(clicker)
                        {
                            case 0:
                                dismiss();
                                break;
                            case 1:
                                ((Button)findViewById(R.id.customDialogCancelButton)).setText("Cancel");
                                ((TextView)findViewById(R.id.customDialogHeader)).setText("Payment Process Instructions: Screen 1 of 3");
                                findViewById(R.id.relativeLayoutOne).setVisibility(View.VISIBLE);
                                findViewById(R.id.relativeLayoutTwo).setVisibility(View.GONE);
                                break;
                            case 2:
                                ((Button)findViewById(R.id.customDialogSubmitButton)).setText("Continue");
                                ((TextView)findViewById(R.id.customDialogHeader)).setText("Payment Process Instructions: Screen 2 of 3");
                                findViewById(R.id.relativeLayoutTwo).setVisibility(View.VISIBLE);
                                findViewById(R.id.relativeLayoutThree).setVisibility(View.GONE);
                                break;
                        }

                        clicker--;
                    }
                });

                findViewById(R.id.customDialogSubmitButton).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        switch(clicker)
                        {
                            case 0:
                                ((Button)findViewById(R.id.customDialogCancelButton)).setText("Back");
                                ((TextView)findViewById(R.id.customDialogHeader)).setText("Payment Process Instructions: Screen 2 of 3");
                                findViewById(R.id.relativeLayoutOne).setVisibility(View.GONE);
                                findViewById(R.id.relativeLayoutTwo).setVisibility(View.VISIBLE);
                                break;
                            case 1:

                                ((Button)findViewById(R.id.customDialogSubmitButton)).setText("Start Payment Process");
                                ((TextView)findViewById(R.id.customDialogHeader)).setText("Payment Process Instructions: Screen 3 of 3");

                                findViewById(R.id.relativeLayoutTwo).setVisibility(View.GONE);
                                findViewById(R.id.relativeLayoutThree).setVisibility(View.VISIBLE);
                                break;
                            case 2:
                                dismiss();
                                ((CustomerActivity)context).startPaymentProcess();
                                break;
                        }

                        clicker++;

                    }
                });

                DisplayMetrics metrics3 = this.context.getResources().getDisplayMetrics();
                int width3 = metrics3.widthPixels;
                int height3 = metrics3.heightPixels;

                setupFullscreenMode();

                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility());
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                getWindow().setLayout((6 * width3) / 7, (6 * height3) / 7);

                break;
        }
    }

    public void initializeReceiptDialog()
    {
        DisplayMetrics metrics = this.context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility());
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        getWindow().setLayout((4 * width) / 7, (4 * height) / 7);

        setupFullscreenMode();

        Button button = (Button) findViewById(R.id.customDialogCancelButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        button.setText("Decline");

        button = (Button) findViewById(R.id.customDialogSubmitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                ((CustomerActivity) context).launchReceipts(orderId);

                //System.out.println("receipt test: " + LOCKED + " " + mOrder);

                //Intent intent1 = new Intent(Intents.ACTION_START_PRINT_RECEIPTS);
                //intent1.putExtra(Intents.EXTRA_ORDER_ID, orderId);
                //context.startActivity(intent1);
            }
        });
        button.setText("Print or Email Receipt");

        TextView body = (TextView)findViewById(R.id.customeDialogBody);
        body.setTextSize(30);
        body.setGravity(Gravity.CENTER);

    }

    public void setHeaderText(String headerText)
    {
        this.headerText = headerText;
    }

    public void setBodyText(String bodyText)
    {
        this.bodyText = bodyText;
    }

    public void setDialogFrom(int dialogFrom)
    {
        this.dialogFrom = dialogFrom;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void instantiateCheckBoxDoNotShowAgain()
    {
        CheckBox checkBox = (CheckBox)findViewById(R.id.doNotShowMessageAgainCheckBox);
        checkBox.setVisibility(View.VISIBLE);

        final SharedPreferences sharedPreferences = this.context.getSharedPreferences(this.context.getString(R.string.donation_here_file), Context.MODE_PRIVATE);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(context.getString(R.string.doNotShowDialogAgain), !isChecked);

                editor.commit();
            }
        });
    }

    private void setupFullscreenMode()
    {
        //CustomerMode.enable(this.context);

        if(Platform.isCloverMobile() || Platform.isCloverMini())
            return;
        else
        {
            View decorView = setFullscreen();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
            {
                @Override
                public void onSystemUiVisibilityChange(int visibility)
                {
                    setFullscreen();
                }
            });
        }
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
