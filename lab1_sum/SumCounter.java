// Shabunya Polina lab 1 var 2

public class SumCounter {

    public static void main(String[] args)
            throws Exception {
        if(args.length != 2)
            throw new Exception("Invalid number of command line arguments.");
            double x = Double.parseDouble(args[0]);
            double e = Double.parseDouble(args[1]);
        double first_term = x * x * Math.pow(4 / 3., 6) / 6; // k = 1
        double res = calcSum(e, first_term);
        System.out.println("SUM = " + res);
    }

    static double calcSum(double e, double first_term) {
        int k = 1;
        double sum = first_term;
        while(Math.abs(first_term) >= e) {
            first_term *= -1 * Math.pow(4 / 3., 4) / ((2 * k + 2) * (2 * k + 3));
            sum += first_term;
            k++;
        }
        System.out.println(k);
        return sum;
    }
}

// x = 2; e = 0.0000001; k = 7; SUM = 3.196488293444962
// x = 5; e =  0.0000000001; k = 9; SUM = 19.978051832798595
// x = -3; e =  0.0000001; k = 7; SUM = 7.1920986602511645
// x = 2.8; e = 0.00000000001, k = 9, SUM = 6.265117054765641