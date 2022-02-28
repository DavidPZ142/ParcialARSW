package edu.eci.arsw.math;

public class PiDigitsThread  extends Thread {
public int start,end;
public Object pivote;
private static int DigitsPerSum = 8;
private static double Epsilon = 1e-17;
public double sum = 0;
public byte[] digits;




public PiDigitsThread(int start, int end, byte[] digits, Object pivote) {
    this.start = start;
    this.end = end;
    this.digits = digits;
    this.pivote = pivote;


}

public void run(){

    digits = new byte[end];
    long initialTime = System.currentTimeMillis();

    if (start < 0) {
        throw new RuntimeException("Invalid Interval");
    }
    if (end < 0) {
        throw new RuntimeException("Invalid Interval");
    }
    for (int i =0; i< end; i++){
        long currentTime = System.currentTimeMillis();
        long a = currentTime - initialTime;

        if(i % DigitsPerSum == 0) {
            sum = suma(sum, start);
            start += DigitsPerSum;
        }
        sum = 16 * (sum - Math.floor(sum));
        digits[i] = (byte) sum;
    }

    

}

public byte getByte(int a){
    return digits[a] ;
}

public byte[] getByteList(){
    return digits;
}


public double suma(double sum, int start){
    sum= 4 * sum(1, start) - 2 * sum(4, start) - sum(5, start) - sum(6, start);
    return sum;
}
   public int hexExponentModulo(int p, int m) {
        int power = 1;
        while (power * 2 <= p) {
            power *= 2;
        }

        int result = 1;
        while (power > 0) {
            if (p >= power) {
                result *= 16;
                result %= m;
                p -= power;
            }
            power /= 2;
            if (power > 0) {
                result *= result;
                result %= m;
            }
        }
        return result;
    }



    public double sum(int m, int n) {
        double sum = 0;
        int d = m;
        int power = n;
        while (true) {
            double term;
            if (power > 0) {
                term = (double) hexExponentModulo(power, d) / d;
            } else {
                term = Math.pow(16, power) / d;
                if (term < Epsilon) {
                    break;
                }
            }
            sum += term;
            power--;
            d += 8;
        }

        return sum;
    }


}
