import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) { //нельзя менять код в данном методе
        compare(1);
        compare(2);
        compare(5);
        compare(15);
    }

    public static void compare(int day) {//нельзя менять код в данном методе, кроме параметра int[] memory chooseHobbyRecursive()
        System.out.println("=== Day " + day + " ===");
        int[] startNumbers = {21, 1, 20, 23};
        int iterative = chooseHobbyIterative(startNumbers, day);
        int recursive = chooseHobbyRecursive(startNumbers, day, new int[day]);
        System.out.println("Iterative = " + iterative + " | Recursive = " + recursive);
        System.out.println();
    }

    public static int chooseHobbyRecursive(int[] startNumbers, int day, int[] memory) {
        if (day >= 1 && day <= memory.length && memory[day - 1] != 0) {
            return memory[day - 1];
        }

        if (day <= 0 && day > -1 * startNumbers.length) {
            return startNumbers[day + startNumbers.length - 1];
        }

        int prev = chooseHobbyRecursive(startNumbers, day - 1, memory);
        int prePrePrev = chooseHobbyRecursive(startNumbers, day - 3, memory); // пре-пре-предыдущее значение
        memory[day - 1] = prev * prePrePrev % 10 + 1;
        return memory[day - 1];
    }

    public static int chooseHobbyIterative(int[] startNumbers, int day) {//нельзя менять код в данном методе
        List<Integer> numbers = new ArrayList<>();

        numbers.add(startNumbers[0]);
        numbers.add(startNumbers[1]);
        numbers.add(startNumbers[2]);
        numbers.add(startNumbers[3]);

        for (int d = 0; d < day; d++) {
            int index = d + 4; // индексы дней в массиве сдвинуты на 4
            int prev = numbers.get(index - 1); // предыдущее значение
            int prePrePrev = numbers.get(index - 3); // пре-пре-предыдущее значение
            numbers.add((prev * prePrePrev) % 10 + 1);
        }

        return numbers.get(numbers.size() - 1);
    }
}