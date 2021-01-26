package Programming;

import java.util.HashMap;

public class driver {


    public static int fibonacci(int n) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Item is negative"
            );
        } else if (n == 0 || n == 1) {
            // (1)
            return n;
        } else {
            //What this does is uses a hashmap as a look up table reducing the runtime complexity to O(n)
            //Non_Engineering people would not use this 2^(N)
            //Space complexity in both cases is (O(n) the reason for this is because not all of the items
            //that is, calculations are on the callstack at the same time
            if (hm.containsKey(n)) {
                return hm.get(n);
            }
            //perform a result and added it to the table
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            hm.put(n, result);
            return result;
        }
    }
        public static int fib1(int n){
            if(n < 0){
                throw new IllegalArgumentException("Positivity check");
            }else if(n == 0 || n == 1){
                return n;
            }

            int result = fib1(n-1)+ fib1(n-2);
            return result;
        }

        public static String reverseString(String s){
            StringBuilder sb = new StringBuilder(s);
            String s2 = sb.reverse().toString();
        return s2;
    }
        public static String reverseString2(String s){

            String result = "";
            for(int i =s.length()-1; i >=0; i--){
                result = result + s.charAt(i);
            }

            return result;
        }

    public static void main(String[] args){
        System.out.println("Test");
        System.out.println(fibonacci(10));

        System.out.println(fib1(10));

        String s = "This is another lesson in wasting other peoples time";
        System.out.println(reverseString(s));


        System.out.println(reverseString2(s));
    }
}
