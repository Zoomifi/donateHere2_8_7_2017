package zoomifi.donatehere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Andrew on 2/26/2016.
 */
public class CustomListAdapter extends ArrayAdapter<OrderEntity>
{
    private List<OrderEntity> orderEntities;
    private Context context;
    private static final NumberFormat mCurrencyFormat = DecimalFormat.getCurrencyInstance(Locale.US);

    public CustomListAdapter(Context context, int resource, List<OrderEntity> orderEntities)
    {
        super(context, R.layout.order_panel, orderEntities);

        this.context = context;
        this.orderEntities = orderEntities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup root)
    {
        OrderEntity orderEntity = this.orderEntities.get(position);

        TextView [] panelTextViews = new TextView[11];

        if(convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.order_panel, null);

            panelTextViews[0] = (TextView)convertView.findViewById(R.id.date);
            panelTextViews[1] = (TextView)convertView.findViewById(R.id.amount);
            panelTextViews[2] = (TextView)convertView.findViewById(R.id.first_name);
            panelTextViews[3] = (TextView)convertView.findViewById(R.id.last_name);
            panelTextViews[4] = (TextView)convertView.findViewById(R.id.email);
            panelTextViews[5] = (TextView)convertView.findViewById(R.id.phoneNumber);
            panelTextViews[6] = (TextView)convertView.findViewById(R.id.customText1);
            panelTextViews[7] = (TextView)convertView.findViewById(R.id.customText2);
            panelTextViews[8] = (TextView)convertView.findViewById(R.id.customText3);
            panelTextViews[9] = (TextView)convertView.findViewById(R.id.customText4);
            panelTextViews[10] = (TextView)convertView.findViewById(R.id.department);

            convertView.setTag(new OrderEntityContainer
            (
                    panelTextViews[0],
                    panelTextViews[1],
                    panelTextViews[2],
                    panelTextViews[3],
                    panelTextViews[4],
                    panelTextViews[5],
                    panelTextViews[6],
                    panelTextViews[7],
                    panelTextViews[8],
                    panelTextViews[9],
                    panelTextViews[10])
            );
        }
        else
        {
            OrderEntityContainer orderEntityContainer = (OrderEntityContainer)convertView.getTag();

            panelTextViews[0]  = orderEntityContainer.getDate();
            panelTextViews[1]  = orderEntityContainer.getAmount();
            panelTextViews[2]  = orderEntityContainer.getCustomerFirstName();
            panelTextViews[3]  = orderEntityContainer.getCustomerLastName();
            panelTextViews[4]  = orderEntityContainer.getEmail();
            panelTextViews[5]  = orderEntityContainer.getPhoneNumber();
            panelTextViews[6]  = orderEntityContainer.getCustomText1();
            panelTextViews[7]  = orderEntityContainer.getCustomText2();
            panelTextViews[8]  = orderEntityContainer.getCustomText3();
            panelTextViews[9]  = orderEntityContainer.getCustomText4();
            panelTextViews[10] = orderEntityContainer.getDepartment();
        }

        String parsedDate           = orderEntity.getParsedDate();
        String parsedAmount         = orderEntity.getParsedAmount();
        String customerFirstName    = orderEntity.getCustomerFirstName();
        String customerLastName     = orderEntity.getCustomerLastName();
        String email                = orderEntity.getEmail();
        String phoneNumber          = orderEntity.getPhoneNumber();
        String customText1          = orderEntity.getCustomText1();
        String customText2          = orderEntity.getCustomText2();
        String customText3          = orderEntity.getCustomText3();
        String customText4          = orderEntity.getCustomText4();
        String department           = orderEntity.getDepartment();

        parsedAmount        = parsedAmount      == null || parsedAmount.isEmpty()       ? "—" : parsedAmount;
        customerFirstName   = customerFirstName  == null || customerFirstName.isEmpty()  ? "—" : customerFirstName;
        customerLastName    = customerLastName  == null || customerLastName.isEmpty()   ? "—" : customerLastName;
        email               = email             == null || email.isEmpty()              ? "—" : email;
        phoneNumber         = phoneNumber       == null || phoneNumber.isEmpty()        ? "—" : phoneNumber;
        customText1         = customText1       == null || customText1.isEmpty()        ? "—" : customText1;
        customText2         = customText2       == null || customText2.isEmpty()        ? "—" : customText2;
        customText3         = customText3       == null || customText3.isEmpty()        ? "—" : customText3;
        customText4         = customText4       == null || customText4.isEmpty()        ? "—" : customText4;
        department          = department        == null || department.isEmpty()         ? "—" : department;

        panelTextViews[0].setText(parsedDate);
        panelTextViews[1].setText(parsedAmount);
        panelTextViews[2].setText(customerFirstName);
        panelTextViews[3].setText(customerLastName);
        panelTextViews[4].setText(email);
        panelTextViews[5].setText(phoneNumber);
        panelTextViews[6].setText(customText1);
        panelTextViews[7].setText(customText2);
        panelTextViews[8].setText(customText3);
        panelTextViews[9].setText(customText4);
        panelTextViews[10].setText(department);

        if(parsedAmount.equals("—") || parsedAmount.isEmpty())
            panelTextViews[1].setAlpha(0.35f);
        else if(panelTextViews[1].getAlpha() == 0.35f)
            panelTextViews[1].setAlpha(1.0f);

        if(customerFirstName.equals("—") || parsedAmount.isEmpty())
            panelTextViews[2].setAlpha(0.35f);
        else if(panelTextViews[2].getAlpha() == 0.35f)
            panelTextViews[2].setAlpha(1.0f);

        if(customerLastName.equals("—"))
            panelTextViews[3].setAlpha(0.35f);
        else if(panelTextViews[3].getAlpha() == 0.35f)
            panelTextViews[3].setAlpha(1.0f);

        if(email.equals("—"))
            panelTextViews[4].setAlpha(0.35f);
        else if(panelTextViews[4].getAlpha() == 0.35f)
            panelTextViews[4].setAlpha(1.0f);

        if(phoneNumber.equals("—"))
            panelTextViews[5].setAlpha(0.35f);
        else if(panelTextViews[5].getAlpha() == 0.35f)
            panelTextViews[5].setAlpha(1.0f);

        if(customText1.equals("—"))
            panelTextViews[6].setAlpha(0.35f);
        else if(panelTextViews[6].getAlpha() == 0.35f)
            panelTextViews[6].setAlpha(1.0f);

        if(customText2.equals("—"))
            panelTextViews[7].setAlpha(0.35f);
        else if(panelTextViews[7].getAlpha() == 0.35f)
            panelTextViews[7].setAlpha(1.0f);

        if(customText3.equals("—"))
            panelTextViews[8].setAlpha(0.35f);
        else if(panelTextViews[8].getAlpha() == 0.35f)
            panelTextViews[8].setAlpha(1.0f);

        if(customText4.equals("—"))
            panelTextViews[9].setAlpha(0.35f);
        else if(panelTextViews[9].getAlpha() == 0.35f)
            panelTextViews[9].setAlpha(1.0f);

        if(department.equals("—"))
            panelTextViews[10].setAlpha(0.35f);
        else if(panelTextViews[10].getAlpha() == 0.35f)
            panelTextViews[10].setAlpha(1.0f);

        if(position % 2 == 0)
            convertView.findViewById(R.id.panelParent).setBackgroundResource(R.color.AquaGreenLightTinted2);
        else
            convertView.findViewById(R.id.panelParent).setBackgroundResource(R.color.White);

        return convertView;
    }

    private static class OrderEntityContainer
    {
        private TextView Date;
        private TextView Amount;
        private TextView CustomerFirstName;
        private TextView CustomerLastName;
        private TextView Email;
        private TextView PhoneNumber;
        private TextView CustomText1;
        private TextView CustomText2;
        private TextView CustomText3;
        private TextView CustomText4;
        private TextView Department;

        private OrderEntityContainer
        (
            TextView Date,              TextView Amount,        TextView CustomerFirstName,
            TextView CustomerLastName,  TextView Email,         TextView PhoneNumber,
            TextView CustomText1,       TextView CustomText2,   TextView CustomText3,
            TextView CustomText4,       TextView Department
        )
        {
            this.Date               = Date;
            this.Amount             = Amount;
            this.CustomerFirstName  = CustomerFirstName;
            this.CustomerLastName   = CustomerLastName;
            this.Email              = Email;
            this.PhoneNumber        = PhoneNumber;
            this.CustomText1        = CustomText1;
            this.CustomText2        = CustomText2;
            this.CustomText3        = CustomText3;
            this.CustomText4        = CustomText4;
            this.Department         = Department;
        }

        private TextView getDate()                  { return this.Date; }
        private TextView getAmount()                { return this.Amount; }
        private TextView getCustomerFirstName()     { return this.CustomerFirstName; }
        private TextView getCustomerLastName()      { return this.CustomerLastName; }
        private TextView getEmail()                 { return this.Email; }
        private TextView getPhoneNumber()           { return this.PhoneNumber; }
        private TextView getCustomText1()           { return this.CustomText1; }
        private TextView getCustomText2()           { return this.CustomText2; }
        private TextView getCustomText3()           { return this.CustomText3; }
        private TextView getCustomText4()           { return this.CustomText4; }
        private TextView getDepartment()            { return this.Department; }
    }
}
