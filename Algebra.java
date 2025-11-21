public class Algebra {
public static void main(String args[]) {
// Tests some of the operations
System.out.println(plus(2,3)); // 2 + 3
System.out.println(minus(7,2)); // 7 - 2
System.out.println(minus(2,7)); // 2 - 7
System.out.println(times(3,4)); // 3 * 4
System.out.println(plus(2,times(4,2))); // 2 + 4 * 2
System.out.println(pow(5,3)); // 5^3
System.out.println(pow(3,5)); // 3^5
System.out.println(div(12,3)); // 12 / 3
System.out.println(div(5,5)); // 5 / 5
System.out.println(div(25,7)); // 25 / 7
System.out.println(mod(25,7)); // 25 % 7
System.out.println(mod(120,6)); // 120 % 6
System.out.println(sqrt(36));
System.out.println(sqrt(263169));
System.out.println(sqrt(76123));
}

// Returns x1 + x2
public static int plus(int x1, int x2) {
// Replace the following statement with your code
int result = 0;
result = x1;

for(int i = 0; i<x2; i++){
result++;
}

return result;
}

// Returns x1 - x2
public static int minus(int x1, int x2) {
// Replace the following statement with your code
int result = 0;
result = x1;

for(int i = 0; i<x2; i++){
result--;
}

return result;
}

// Returns x1 * x2
public static int times(int x1, int x2) {
// Replace the following statement with your code
int result = 0;
result = x1;

for(int i = 0; i<x2; i++){
result = plus(result,x1);
}

return result;
}

// Returns x^n (for n >= 0)
public static int pow(int x, int n) {
// Replace the following statement with your code
int result = 0;
result = x;

for(int i = 0; i<n; i++){
result = times(result,x);
}

return result;
}

// Returns the integer part of x1 / x2
public static int div(int x1, int x2) {
// Replace the following statement with your code
int result = 0;
result = x1;

for(int i = 0; i<x2; i++){
result = minus(result,x1);
}

return result;
}

// Returns x1 % x2
public static int mod(int x1, int x2) {
// Replace the following statement with your code
int counter = 0;

while(counter <= x1){
counter = plus(counter,x2);
}

counter = minus(counter,x2);

int mod = minus(x1,counter);

return mod;
}

// Returns the integer part of sqrt(x)
public static int sqrt(int x) {
// Replace the following statement with your code
for(int i = 1; i<=x; i++){
if (x/i == i){return i;}
}
return 0;
}
}
