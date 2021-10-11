// Shabunya Polina lab 2 var 3

public class StrService {
    public static void main(String[] args)
            throws Exception {
        if(args.length != 1)
            throw new Exception("Invalid number of command line arguments.");
        String str = args[0];
        System.out.println(removeZeros(str));
    }

    static String removeZeros(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        boolean isGroup = false;
        int newStringLength = str.length();
        for(int i = 0; i < newStringLength; ++i) {
                if (strBuilder.charAt(i) == 48 && newStringLength != 1) {  // srt[i] = '0'
                    if(isGroup) {
                        strBuilder.deleteCharAt(i--);
                        --newStringLength;
                    }
                    if (!isGroup) {
                        if ((i == 0 ||
                                i != newStringLength - 1 &&
                                        (strBuilder.charAt(i - 1) < 46 || strBuilder.charAt(i - 1) > 57))
                                && strBuilder.charAt(i + 1) > 47 && strBuilder.charAt(i + 1) < 58) {
                            isGroup = true;
                            strBuilder.deleteCharAt(i--);
                            --newStringLength;
                    }
                }
            }
                else {
                    isGroup = false;
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
// str = ".09j.00h_00_h080uh07kk00000jl.00"  newStr = ".09j.00h__h80uh7kkjl.00"
