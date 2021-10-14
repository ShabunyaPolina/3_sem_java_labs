// Shabunya Polina lab 2 var 3

import java.util.*;

public class StrService {
    public static void main(String[] args)
            throws Exception {
        String str = args[0];
        System.out.println("Initial string: " + str);
        System.out.println("Final string: " + removeZeros(str));
    }

    static String removeZeros(String str) {
        String[] digits = str.split("\\D+");
        System.out.println("/* Digits: " + Arrays.toString(digits) + " */");
        StringBuilder strBuilder = new StringBuilder(str);
        int index = 0;
        int fromIndex = -1;
        for (String i : digits) {
            if (i.length() != 1) {
                index = strBuilder.indexOf(i, fromIndex + 1);
                fromIndex = index;
                if (index == 0 || strBuilder.codePointBefore(index) != '.') {
                    while (index != strBuilder.length() &&
                            strBuilder.charAt(index) == '0') {
                        strBuilder.deleteCharAt(index);
                    }
                }
            }
        }
        str = strBuilder.toString();
        return str;
    }
}

// str = "0"  newStr = "0"
// str = "00"  newStr = ""
// str = "0078hgj"  newStr = "78hgj"
// str = ".0089y"  newStr = ".0089y"
// str = "100"  newStr = "100"
// str = "ll00"  newStr = "ll"
/* str = ".00.09j.00h_00_00h080u0h07kk00000jl.00jk09k0"
 * newStr = ".00.09j.00h__h80u0h7kkjl.00jk9k0" */
