package NL.MIW.SE2.Remco.YeOldeGunShoppe.states;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */

public class StateKeeper {
    public static boolean addMode;
    public static boolean editMode;
    public static boolean deleteMode;

    public static void switchAllOff(){
        addMode = false;
        editMode = false;
        deleteMode = false;
    }
}
