package org.example;

/**
 * Hello world!
 *
 */
public class Sum {

    public long sumNumbers(short[] arr) {
        long sumValue = 0;
        for (int i = 0; i < arr.length; i++) {
            sumValue += arr[i];
        }
        return sumValue;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
