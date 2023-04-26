package _13_09_10_Is_Primo;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main03 {
    public static void main(String[] args) {

        Integer [] nums = new Integer[100];
        for (int i = 0; i < 100; i++) {
            nums [i] = ((int) (Math.random() * 1000));
        }

        Stream<Integer> nums02 = Arrays.stream(nums)
                .filter(Even::isEven)
                .sorted();
        System.out.println("These are the numbers in natural order: " +Arrays.toString(nums02.toArray()));

        Stream<Integer> nums03 = Arrays.stream(nums)
                .filter(Even::isEven)
                .sorted((a,b) -> b -a);
        System.out.println("These are the numbers in reversed order: " +Arrays.toString(nums03.toArray()));

        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] >= 200 && nums[i] <= 800)
            {
                count++;
            }
        }

        Integer [] nums04 = new Integer[count];
        int index = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] >= 200 && nums[i] <= 800)
            {
                nums04[index++] = nums[i];
            }
        }
        Stream<Integer> stream = Arrays.stream(nums04)
                .filter(Even::isEven)
                .sorted((a,b) -> b -a);
        System.out.print("These are the numbers higher than 200 and lower than 800 in reversed order: ");
        stream.forEach(num -> System.out.print(num + " "));
    }
}
