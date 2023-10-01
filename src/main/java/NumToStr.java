public class NumToStr {

    public static final  String[] ones = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", 
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",};
    
    public static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public static final  String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public static void main(String[] args) {

        System.out.println(integerToString(1234567891));

    }

    public static String helper(int n){
        if (n < 20) 
            return ones[n];
        if (n < 100)
            return tens[n/10] + " " + helper(n % 10);
        if (n < 1000)
            return helper(n/100) + " Hundred " + helper(n % 100);
        for (int i = 3; i >= 0; i--) {
            if (n >= Math.pow(1000, i))
                return helper((int)(n / Math.pow(1000, i))) + " "
                + thousands[i] + " " + helper((int)(n % Math.pow(1000, i)));
        }
        return "";
    }
    
    public static String integerToString(int number){
        if (number == 0)
            return "Zero";
        return helper(number);
    }
}