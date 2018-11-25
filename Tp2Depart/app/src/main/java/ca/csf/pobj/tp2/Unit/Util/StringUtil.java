package ca.csf.pobj.tp2.Unit.Util;

public final class StringUtil {

    private StringUtil(){
        //Private, so it is a static class
    }

    public static boolean isBlank (String string){
        for (int i = 0 ; i < string.length(); i++ ){
            if (!Character.isWhitespace(string.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
