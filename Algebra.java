public class Algebra {

    // Helper function: Calculates absolute value using only ++ and -- via minus(0, a)
    private static int internalAbs(int a) {
        if (a == 0) return 0;
        if (a > 0) return a; 
        
        // If a is negative, return 0 - a (relies on correct minus implementation)
        return minus(0, a);
    }

    // Implementation of a + b
    public static int plus(int x1, int x2) {
        // Iterate abs(x2) times, either incrementing or decrementing x1
        int absX2 = internalAbs(x2);
        
        if (x2 >= 0) {
            for(int i = 0; i < absX2; i++) {
                x1++;
            }
        } else {
            for(int i = 0; i < absX2; i++) {
                x1--;
            }
        }
        return x1;
    }

    // Implementation of a - b
    public static int minus(int x1, int x2) {
        // The simplest way to define a - b is a + (-b).
        // We use the same logic as plus, but flip the operation based on x2's sign.
        
        int absX2 = internalAbs(x2);
        
        if (x2 >= 0) { // If x2 is positive, we subtract
            for(int i = 0; i < absX2; i++) {
                x1--;
            }
        } else { // If x2 is negative, we add (minus a minus)
            for(int i = 0; i < absX2; i++) {
                x1++;
            }
        }
        return x1;
    }

    // Implementation of a * b
    public static int times(int x1, int x2) {
        if (x1 == 0 || x2 == 0) return 0;
        
        int result = 0;
        int absX1 = internalAbs(x1);
        int absX2 = internalAbs(x2);
        
        // Determine the sign of the final result
        boolean isNegativeResult = (x1 < 0 && x2 >= 0) || (x1 >= 0 && x2 < 0);
        
        // Perform multiplication using repeated addition of absX1 (abs(a) * abs(b))
        for(int i = 0; i < absX2; i++) { 
            result = plus(result, absX1);
        }
        
        // Fix the final sign using minus(0, result)
        if (isNegativeResult) {
            return minus(0, result);
        } else {
            return result;
        }
    }
    
    // Implementation of a ^ b
    public static int pow(int x, int n) {
        if (n < 0) return 0; 
        if (n == 0) return 1; 

        int result = 1; 
        
        for(int i = 0; i < n; i++) {
            result = times(result, x); 
        }
        return result;
    }
    
    // Implementation of integer part of a / b
    public static int div(int x1, int x2) {
        if (x2 == 0) return 0; // Division by zero
        
        int result = 0;
        
        int absX1 = internalAbs(x1);
        int absX2 = internalAbs(x2);

        // Determine the sign of the final result
        boolean isNegativeResult = (x1 < 0 && x2 >= 0) || (x1 >= 0 && x2 < 0);
        
        // Repeated subtraction: count how many times absX2 fits into absX1
        int currentX1 = absX1;
        while (currentX1 >= absX2) {
            currentX1 = minus(currentX1, absX2); // currentX1 = currentX1 - absX2
            result = plus(result, 1);           // result++
        }
        
        // Fix the final sign
        if (isNegativeResult) {
            // Note: Java integer division truncates toward zero, which is achieved by simply negating the result of the absolute values.
            return minus(0, result);
        } else {
            return result;
        }
    }

    // Implementation of a % b
    public static int mod(int x1, int x2) {
        if(x2 == 0) return 0;
        
        // a % b = a - (a / b) * b
        int quotient = div(x1, x2);
        int product = times(quotient, x2);
        int remainder = minus(x1, product);
        
        return remainder;
    }
    
    // Implementation of integer part of sqrt(a)
    public static int sqrt(int x) {
        if (x < 0) return 0;
        if (x == 0) return 0;

        int g = 1;
        
        // Search for g such that g^2 <= x but (g+1)^2 > x
        while (times(g, g) <= x) { 
            g = plus(g, 1); 
        }

        // The answer is g - 1
        return minus(g, 1); 
    }
    
    public static void main(String args[]) {
        // Tests some of the operations
        System.out.println(plus(2,3));  // 5
        System.out.println(minus(7,2));  // 5
        System.out.println(minus(2,7));  // -5
        System.out.println(times(3,4));  // 12
        System.out.println(plus(2,times(4,2))); // 10
        System.out.println(pow(5,3));    // 125
        System.out.println(pow(3,5));    // 243
        System.out.println(div(12,3));   // 4    
        System.out.println(div(5,5));    // 1  
        System.out.println(div(25,7));   // 3
        System.out.println(mod(25,7));   // 4
        System.out.println(mod(120,6));  // 0  
        System.out.println(sqrt(36));   // 6
        System.out.println(sqrt(263169)); // 513
        System.out.println(sqrt(76123)); // 275
        
        // Additional tests for negative numbers
        System.out.println(plus(5, minus(0, 8))); // -3
        System.out.println(times(-3, 4)); // -12
        System.out.println(div(-25, 7)); // -3
        System.out.println(mod(-25, 7)); // -4
        System.out.println(div(10, minus(0, 3))); // -3
    }  
}
