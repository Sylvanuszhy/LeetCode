import java.util.HashMap;

class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        long integer = (long)numerator/denominator;
        String intp = String.valueOf(integer);
        if (integer == 0 && (long)numerator*denominator < 0)
            intp = "-"+intp;
        numerator = numerator%denominator;

        StringBuilder fracp = new StringBuilder();
        HashMap<Integer, Integer> cycle = new HashMap<Integer, Integer>();
        int i = 0;
        cycle.put(numerator, i);
        while (numerator != 0) {
            i++;
            fracp.append(Math.abs((long)numerator*10/denominator));
            numerator = (int)((long)numerator*10%denominator);
            if (cycle.containsKey(numerator))
                break;
            else
                cycle.put(numerator, i);
        }
        if (numerator == 0) {
            if (fracp.length() == 0)
                return intp;
            else
                return intp+"."+fracp;
        } else {
            int k = cycle.get(numerator);
            return intp+"."+fracp.substring(0, k)+"("+fracp.substring(k)+")";
        }
    }

    public static void main(String[] args) {
        String res = fractionToDecimal(-2147483648, -1);
        System.out.println(res);
    }
}
