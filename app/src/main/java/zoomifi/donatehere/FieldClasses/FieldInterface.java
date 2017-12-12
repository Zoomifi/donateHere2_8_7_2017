package zoomifi.donatehere.FieldClasses;

/**
 * Created by Andrew on 4/27/2016.
 */
public interface FieldInterface
{
    void saveDISPLAYCheckState  (int ID, boolean isChecked);
    void saveREQUIREDCheckState (int ID, boolean isChecked, boolean isDISPLAYchecked);
    void renameCustomName       (int ID);
}
