package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sure on 2017/2/19.
 */

public class FizzBuzz {

    /**
     * Write a program that outputs the string representation of numbers from 1 to n.

     But for multiples of three it should output “Fizz” instead of the number and for the multiples
     of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

     Example:

     n = 15,

     Return:
     [
     "1",
     "2",
     "Fizz",
     "4",
     "Buzz",
     "Fizz",
     "7",
     "8",
     "Fizz",
     "Buzz",
     "11",
     "Fizz",
     "13",
     "14",
     "FizzBuzz"
     ]
     */

    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ret.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ret.add("Fizz");
            } else if (i % 5 == 0) {
                ret.add("Buzz");
            } else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> ret = new FizzBuzz().fizzBuzz(15);
        System.out.println(Arrays.toString(ret.toArray(new String[0])));
    }
}
