package opkarol.heroeswars.utils;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class Utils {

    public static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
