package zoomifi.donatehere.FieldClasses;

/**
 * Created by Andrew on 4/20/2016.
 * Created for Zoomifi Inc.
 */
public class FieldEntity
{
    private String  field;
    private boolean display;
    private boolean required;
    private int     displayID;
    private int     requiredID;

    public FieldEntity(String field, boolean display, boolean required, int displayID, int requiredID)
    {
        this.field      = field;
        this.display    = display;
        this.required   = required;
        this.displayID  = displayID;
        this.requiredID = requiredID;
    }

    public String   getField()      { return this.field; }
    public boolean  getDisplay()    { return this.display; }
    public boolean  getRequired()   { return this.required; }
    public int      getDisplayID()  { return this.displayID; }
    public int      getRequiredID() { return this.requiredID; }

    public void     setFieldName(String name) { this.field = name; }
    public void     setDisplay(boolean flag)    { this.display = flag; }
    public void     setRequired(boolean flag)   { this.required = flag; }
}
