package des;


public class ShiftChar {

    public static String shiftChars(String string, byte shift) {
        return string.substring(shift, string.length()) + string.substring(0, shift);
    }
}
