package ca.csf.pobj.tp2.Unit.Unit;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UnitConverter {

    private static final Map<Integer, String> ROMAN_REFERENCE ;
    static {
        ROMAN_REFERENCE = new TreeMap<Integer,String>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2)*-1 ;
            }
        });
            ;
        ROMAN_REFERENCE.put(4000,"MMMM");
        ROMAN_REFERENCE.put(1000,"M");
        ROMAN_REFERENCE.put(900,"CM");
        ROMAN_REFERENCE.put(500,"D");
        ROMAN_REFERENCE.put(400,"CD");
        ROMAN_REFERENCE.put(100,"C");
        ROMAN_REFERENCE.put(90,"XC");
        ROMAN_REFERENCE.put(50,"L");
        ROMAN_REFERENCE.put(40,"XL");
        ROMAN_REFERENCE.put(10,"X");
        ROMAN_REFERENCE.put(9,"IX");
        ROMAN_REFERENCE.put(5,"V");
        ROMAN_REFERENCE.put(4,"IV");
        ROMAN_REFERENCE.put(1,"I");
    }


    public String convertIntToRomanString (Integer value){

        int valueLenght = 4;
        StringBuilder romanStringConverter = new StringBuilder();
        int[] valueDivided = valueToArray(value);

        for (Integer i =0 ; i < 4 ; i++) {
            if (valueDivided[i] >= 1 && valueDivided[i] <= 3){
               romanStringConverter.append(romanLowerNumberTransformation(valueDivided[i],valueLenght));
            }
            else if (valueDivided[i] >= 5 && valueDivided[i] <= 8){
                romanStringConverter.append(romanUpperNumberTransformation(valueDivided[i],valueLenght));
            }
            else if (valueDivided[i] == 4){
                romanStringConverter.append(romanExceptionNumberFOURTransformation(valueLenght));
            }
            else if (valueDivided[i] == 9){
                romanStringConverter.append(romanExceptionNumberNINETransformation(valueLenght));
            }
            valueLenght --;
        }
        return romanStringConverter.toString();
    }

    private int[] valueToArray(int value){
        int temporaryValue = value;
        int count = 4;
        int[] divededNumber = new int[] {0,0,0,0};
        String valueSepareted = Integer.toString(value);


        for (int i = 0; i < 4 ; i++){
            if((valueSepareted.length()-1-i) >= 0) {
                divededNumber[3 - i] = Character.getNumericValue(valueSepareted.charAt(valueSepareted.length() - 1 - i));
            }
        }
        return divededNumber;
    }

    private String romanExceptionNumberFOURTransformation (int index){
        StringBuilder romanValue = new StringBuilder();
        if ( index == 4){
            romanValue.append(ROMAN_REFERENCE.get(4000));
        }
        if ( index == 3){
            romanValue.append(ROMAN_REFERENCE.get(400));
        }
        if ( index == 2){
            romanValue.append(ROMAN_REFERENCE.get(40));
        }
        if ( index == 1){
            romanValue.append(ROMAN_REFERENCE.get(4));
        }
        return romanValue.toString();
    }

    private String romanExceptionNumberNINETransformation (int index){
        StringBuilder romanValue = new StringBuilder();
        if ( index == 3){
            romanValue.append(ROMAN_REFERENCE.get(900));
        }
        else if ( index == 2){
            romanValue.append(ROMAN_REFERENCE.get(90));
        }
        else if ( index == 1){
            romanValue.append(ROMAN_REFERENCE.get(9));
        }
        return romanValue.toString();
    }

    private String romanLowerNumberTransformation (int value, int index) {
        StringBuilder romanValue = new StringBuilder();
        for (int i = 0; i < value; i++){
            if (index == 4) {
                romanValue.append(ROMAN_REFERENCE.get(1000));
            } else if (index == 3) {
                romanValue.append(ROMAN_REFERENCE.get(100));
            } else if (index == 2) {
                romanValue.append(ROMAN_REFERENCE.get(10));
            } else if (index == 1) {
                romanValue.append(ROMAN_REFERENCE.get(1));
            }
        }
        return romanValue.toString();
    }
    private String romanUpperNumberTransformation (int value , int index){
        StringBuilder romanValue = new StringBuilder();
        int temporaryValue = value ;

            if ( index == 3){
                romanValue.append(ROMAN_REFERENCE.get(500));
                if(temporaryValue - 5 > 0) {
                    for (int i = 0; i < temporaryValue - 5; i++) {
                        romanValue.append(ROMAN_REFERENCE.get(100));
                    }
                }
            }
            else if ( index == 2){
                romanValue.append(ROMAN_REFERENCE.get(50));
                if(temporaryValue - 5 > 0) {
                    for (int i = 0; i < temporaryValue - 5; i++) {
                        romanValue.append(ROMAN_REFERENCE.get(10));
                    }
                }
            }
            else if ( index == 1){
                romanValue.append(ROMAN_REFERENCE.get(5));
                if(temporaryValue - 5 > 0) {
                    for (int i = 0; i < temporaryValue - 5; i++) {
                        romanValue.append(ROMAN_REFERENCE.get(1));
                    }
                }
            }
        return romanValue.toString();
    }

}
