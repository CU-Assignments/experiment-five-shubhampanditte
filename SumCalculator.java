import java.util.ArrayList;
import java.util.List;

public class SumCalculator {
    
    // Method to convert a list of strings to a list of Integers
    public static List<Integer> parseStringToIntegerList(String[] stringNumbers) {
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringNumbers) {
            integerList.add(Integer.parseInt(str)); // Autoboxing
        }
        return integerList;
    }
    
    // Method to calculate the sum of a list of Integers
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing
        }
        return sum;
    }
    
    public static void main(String[] args) {
        // Example input
        String[] inputNumbers = {"10", "20", "30", "40", "50"};
        
        // Convert strings to Integer list
        List<Integer> numbers = parseStringToIntegerList(inputNumbers);
        
        // Calculate and print the sum
        int sum = calculateSum(numbers);
        System.out.println("The sum of the numbers is: " + sum);
    }
}
