package ca.csf.pobj.tp2.Unit.Test;

import org.junit.Assert;
import org.junit.Test;

import ca.csf.pobj.tp2.Unit.Unit.UnitConverter;

import static org.junit.Assert.*;

public class UnitConverterTest {

    private static UnitConverter unitConverter = new UnitConverter();



    @Test
    public void convertToIII(){
        assertEquals("III" , unitConverter.convertIntToRomanString(3));
    }

    @Test
    public void convertToIV(){
        assertEquals("IV" , unitConverter.convertIntToRomanString(4));
    }

    @Test
    public void convertToV(){
        assertEquals("V" , unitConverter.convertIntToRomanString(5));
    }

    @Test
    public void convertToIX(){
        assertEquals("IX" , unitConverter.convertIntToRomanString(9));
    }

    @Test
    public void convertToX(){
        assertEquals("X" , unitConverter.convertIntToRomanString(10));
    }

    @Test
    public void convertToXL(){
        assertEquals("XL" , unitConverter.convertIntToRomanString(40));
    }

    @Test
    public void convertToL(){
        assertEquals("L" , unitConverter.convertIntToRomanString(50));
    }

    @Test
    public void convertToXCV(){
        assertEquals("XCV" , unitConverter.convertIntToRomanString(95)); }

    @Test
    public void convertToC(){
        assertEquals("C" , unitConverter.convertIntToRomanString(100));
    }

    @Test
    public void convertToCD(){
        assertEquals("CD" , unitConverter.convertIntToRomanString(400));
    }

    @Test
    public void convertToD(){
        assertEquals("D" , unitConverter.convertIntToRomanString(500));
    }

    @Test
    public void convertToCM(){
        assertEquals("CM" , unitConverter.convertIntToRomanString(900));
    }

    @Test
    public void convertToM(){
        assertEquals("M" , unitConverter.convertIntToRomanString(1000));
    }

    @Test
    public void convertToMCCXXXIV(){
        assertEquals("MCCXXXIV" , unitConverter.convertIntToRomanString(1234));
    }

    @Test
    public void convertToMI(){
        assertEquals("MI" , unitConverter.convertIntToRomanString(1001));
    }

    @Test
    public void convertToMMMMC(){
        assertEquals("MMMM" , unitConverter.convertIntToRomanString(4000));
    }

    @Test
    public void convertToMMMMCMXCIX(){
        assertEquals("MMMMCMXCIX" , unitConverter.convertIntToRomanString(4999));
    }

    @Test
    public void convertToMMMMCMX(){
        assertEquals("MMMMDLXVIII" , unitConverter.convertIntToRomanString(4568));
    }

    @Test
    public void convertToCCCXCVI(){
        assertEquals("CCCXCVI" , unitConverter.convertIntToRomanString(396));
    }

    @Test
    public void convertToCCCXXXIII(){
        assertEquals("CCCXXXIII" , unitConverter.convertIntToRomanString(333));
    }

    @Test
    public void convertToMMMCCCXXXIII(){
        assertEquals("MMMCCCXXXIII" , unitConverter.convertIntToRomanString(3333));
    }

}
