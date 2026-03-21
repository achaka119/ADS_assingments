import java.util.Scanner;

public class Main {

    // task 1
    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    // task 2
    public static void readArray(int[] arr, int index, Scanner sc) {
        if (index == arr.length) {
            return;
        }
        arr[index] = sc.nextInt();
        readArray(arr, index + 1, sc);
    }

    public static int sumArray(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }

        return arr[index] + sumArray(arr, index + 1);
    }

    // task 3
    public static boolean isPrime(int n, int d) {
        if (n <= 1) {
            return false;
        }
        if (d == n) {
            return true;
        }
        if (n % d == 0) {
            return false;
        }
        return isPrime(n, d + 1);
    }

    // task 4
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // task 5
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // task 6
    public static long powerFunction(long a, int n) {
        if (n == 0) {
            return 1;
        }

        return a * powerFunction(a, n - 1);
    }

    // task 7
    public static void reversePrint(int n, Scanner sc) {
        if (n == 0) {
            return;
        }

        int x = sc.nextInt();
        reversePrint(n - 1, sc);
        System.out.print(x + " ");
    }

    // task 8
    public static boolean isDigits(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        if (!Character.isDigit(s.charAt(index))) {
            return false;
        }

        return isDigits(s, index + 1);
    }

    // task 9
    public static int countChars(String s) {
        if (s.equals("")) {
            return 0;
        }

        return 1 + countChars(s.substring(1));
    }

    // task 10
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // task 1
//        System.out.print("Enter a number: ");
//        int n = sc.nextInt();
//        if (n < 0) {
//            n = -n;
//        }
//        printDigits(n);

        // task 2
//         int n2 = sc.nextInt();
//         int[] arr = new int[n2];
//         readArray(arr, 0, sc);
//         int sum = sumArray(arr, 0);
//         double average = (double) sum / n2;
//         System.out.println(average);

        // task 3
//         int n3 = sc.nextInt();
//         if (isPrime(n3, 2)) {
//             System.out.println("Prime");
//         } else {
//             System.out.println("Composite");
//         }

        // task 4
//         int n4 = sc.nextInt();
//         System.out.println(factorial(n4));

        // task 5
//         int n5 = sc.nextInt();
//         System.out.println(fibonacci(n5));

        // task 6
//         long a = sc.nextLong();
//         int n = sc.nextInt();
//         System.out.println(powerFunction(a, n));

        // task 7
//         int n7 = sc.nextInt();
//         reversePrint(n7, sc);

        // task 8
//         String s8 = sc.next();
//         if (isDigits(s8, 0)) {
//             System.out.println("Yes");
//         } else {
//             System.out.println("No");
//         }

        // task 9
        // String s9 = sc.next();
        // System.out.println(countChars(s9));

        // task 10
//         int a10 = sc.nextInt();
//         int b10 = sc.nextInt();
//         System.out.println(gcd(a10, b10));

        sc.close();
    }
}