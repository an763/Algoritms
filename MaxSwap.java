public class MaxSwap {

    public static int maximumSwap(int num) {
        // Convert the number to a character array for easy manipulation.
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;

        // Create an array to store the last index of each digit (0-9).
        int[] lastIndex = new int[10];
        for (int i = 0; i < n; i++) {
            lastIndex[digits[i] - '0'] = i;
        }


    StringBuilder sb = new StringBuilder();

        // Iterate from left to right to find the first digit that can be swapped
        // for a larger one to its right.
        for (int i = 0; i < n; i++) {
            int currentDigit = digits[i] - '0';

            // Look for the largest possible digit (from 9 down to currentDigit + 1)
            // that can be swapped.
            for (int d = 9; d > currentDigit; d--) {
                // Check if this larger digit 'd' exists later in the number.
                if (lastIndex[d] > i) {
                    // If it does, we've found our optimal swap.
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;

                    // After one swap, we are done. Convert back to an integer and return.
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // If the loop completes without any swaps, the number is already in its
        // largest form.
        return num;
    }

    public static  void main(String args[]){
        maximumSwap(2736);
    }
}

