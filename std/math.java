public class math {

    public static void main(String[] args) {
        // Test cases
        System.out.println(abs(-5));           // 5
        System.out.println(sqrt(16));          // 4.0
        System.out.println(gcd(24, 18));       // 6
        System.out.println(isPrime(13));       // true
    }

    // Tier 1: Core Arithmetic
    public static int abs(int x) {
        return Math.abs(x);
    }

    public static double abs(double x) {
        return Math.abs(x);
    }

    public static double sqrt(int x) {
        return Math.sqrt(x);
    }

    public static double sqrt(double x) {
        return Math.sqrt(x);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

