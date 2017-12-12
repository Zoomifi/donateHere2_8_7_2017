package zoomifi.donatehere.FieldClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import zoomifi.donatehere.R;

/**
 * Created by Andrew on 4/20/2016.
 */

public class FieldsListAdapter extends ArrayAdapter<FieldEntity>
{
    private List<FieldEntity>   fields;
    private Context             context;
    private FieldInterface      fieldInterface;

    public FieldsListAdapter(Context context, int resource, List<FieldEntity> fields, FieldInterface fieldInterface)
    {
        super(context, R.layout.order_panel, fields);

        this.context = context;
        this.fields = fields;
        this.fieldInterface = fieldInterface;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup root)
    {
        final FieldEntity fieldEntity = this.fields.get(position);

        TextView fieldName;
        CheckBox display;
        CheckBox required;

        if(convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.field_panel, null);

            fieldName       = (TextView) convertView.findViewById(R.id.fieldTextView);
            display         = (CheckBox) convertView.findViewById(R.id.fieldCheckBoxDisplay);
            required        = (CheckBox) convertView.findViewById(R.id.fieldCheckBoxRequired);

            fieldName.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    FieldEntity fieldEntity1 = (FieldEntity)v.getTag();
                    fieldInterface.renameCustomName(fieldEntity1.getDisplayID());
                }
            });

            display.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    CheckBox checkBox = (CheckBox)v;
                    FieldEntity fieldEntity1 = ((FieldEntity) checkBox.getTag());
                    fieldInterface.saveDISPLAYCheckState(fieldEntity1.getDisplayID(), checkBox.isChecked());
                    fieldEntity1.setDisplay(checkBox.isChecked());

                    if(!checkBox.isChecked())
                    {
                        //fieldEntity1.setRequired(false);
                        fieldInterface.saveREQUIREDCheckState(fieldEntity1.getRequiredID(), false, true);
                        ViewGroup viewGroup = (ViewGroup)checkBox.getParent();

                        CheckBox checkBox1 = (CheckBox) viewGroup.getChildAt(5);
                        checkBox1.setChecked(false);
                    }
                }
            });

            required.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox checkBox = (CheckBox) v;
                    FieldEntity fieldEntity1 = ((FieldEntity) checkBox.getTag());
                    fieldInterface.saveREQUIREDCheckState(fieldEntity1.getRequiredID(), checkBox.isChecked(), fieldEntity1.getDisplay());

                    if(fieldEntity1.getDisplay())
                        fieldEntity1.setRequired(checkBox.isChecked());
                    else
                    {
                        fieldEntity1.setRequired(false);
                        checkBox.setChecked(false);
                    }
                }
            });

            convertView.setTag(new FieldEntityContainer(fieldName, display, required));
        }
        else
        {
            FieldEntityContainer fieldEntityContainer = (FieldEntityContainer)convertView.getTag();

            fieldName       = fieldEntityContainer.getField();
            display         = fieldEntityContainer.getDisplay();
            required        = fieldEntityContainer.getRequired();
        }

        fieldName.setText(fieldEntity.getField());
        display.setChecked(fieldEntity.getDisplay());
        required.setChecked(fieldEntity.getRequired());

        fieldName.setTag(fieldEntity);
        display.setTag(fieldEntity);
        required.setTag(fieldEntity);

        return convertView;
    }

    private static class FieldEntityContainer
    {
        private TextView field;
        private CheckBox display;
        private CheckBox required;

        private FieldEntityContainer(TextView field, CheckBox display, CheckBox required)
        {
            this.field      = field;
            this.display    = display;
            this.required   = required;
        }

        private TextView getField()     { return this.field; }
        private CheckBox getDisplay()   { return this.display; }
        private CheckBox getRequired()  { return this.required; }
    }
}
