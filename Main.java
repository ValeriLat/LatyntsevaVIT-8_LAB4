import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        demonstrateBox(scanner);

        demonstrateMap();

        demonstrateFilter();

        demonstrateReduce();

        demonstrateCollect();

        scanner.close();
    }

    private static void demonstrateBox(Scanner scanner) {
        System.out.println("=== Задание 1.1 ===");
        Box<Integer> integerBox = new Box<>();
        System.out.print("Введите целое число для помещения в коробку: ");
        int number = getIntegerInput(scanner);

        try {
            integerBox.put(number);
            System.out.println("Число " + number + " успешно помещено в коробку");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Коробка заполнена: " + integerBox.isFull());

        Integer value = integerBox.get();
        if (value != null) {
            System.out.println("Извлеченное значение: " + value);
        }

        System.out.println("Коробка заполнена после извлечения: " + integerBox.isFull());
        System.out.println();
    }

    private static int getIntegerInput(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите целое число: ");
            }
        }
    }

    private static void demonstrateMap() {
        System.out.println("=== Задание 3.1: ===");

        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<Integer> lengths = Utils.map(strings, String::length);
        System.out.println("Длины строк: " + lengths);

        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> positiveNumbers = Utils.map(numbers, n -> n < 0 ? -n : n);
        System.out.println("Oтрицательные стали положительными, а положительные остались без изменений: " + positiveNumbers);

        List<int[]> arrays = List.of(new int[]{1, 5, 3}, new int[]{7, 2}, new int[]{0, -1, -2});
        List<Integer> maxValues = Utils.map(arrays, arr -> {
            int max = arr[0];
            for (int v : arr) if (v > max) max = v;
            return max;
        });
        System.out.println("Максимумы массивов: " + maxValues);
        System.out.println();
    }

    private static void demonstrateFilter() {
        System.out.println("=== Задание 3.2: ===");

        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<String> filteredStrings = FilterUt.filter(strings, s -> s.length() >= 3);
        System.out.println("Строки менее 3 символов: " + filteredStrings);

        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> negativeNumbers = FilterUt.filter(numbers, n -> n <= 0);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        List<int[]> arrays = List.of(new int[]{-1, -2}, new int[]{0, -1}, new int[]{1, -2});
        List<int[]> nonPositiveArrays = FilterUt.filter(arrays, arr -> {
            for (int v : arr) if (v > 0) return false;
            return true;
        });
        System.out.println("Массивы, в которых нет ни одного положительного элемента: " + nonPositiveArrays.size());
        System.out.println();
    }

    private static void demonstrateReduce() {
        System.out.println("=== Задание 3.3: ===");

        List<String> strings = List.of("qwerty", "asdfg", "zx");
        String concatenated = ReduceUt.reduce(strings, String::concat, "");
        System.out.println("Склейка строк: " + concatenated);

        List<Integer> numbers = List.of(1, -3, 7);
        int sum = ReduceUt.reduce(numbers, Integer::sum, 0);
        System.out.println("Сумма чисел исходного списка: " + sum);

        List<List<Integer>> listOfLists = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());
        int totalCount = ReduceUt.reduce(listOfLists, (a, b) -> {
            a.addAll(b);
            return a;
        }, new ArrayList<>()).size();
        System.out.println("Общее количество элементов во всех списках: " + totalCount);

        System.out.println();
    }
    private static void demonstrateCollect() {
        System.out.println("Задание 3.4:");

        List<Integer> numbers = List.of(1, -3, 7);
        Map<String, List<Integer>> splitNumbers = new HashMap<>();
        splitNumbers.put("Положительные", numbers.stream().filter(n -> n > 0).toList());
        splitNumbers.put("Отрицательные", numbers.stream().filter(n -> n < 0).toList());
        System.out.println("Разделение по знаку: " + splitNumbers);

        List<String> strings = List.of("qwerty", "asdfg", "zx", "qw");
        Map<Integer, List<String>> byLength = strings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Разделение по длине строки: " + byLength);

        List<String> stringsWithDuplicates = List.of("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueStrings = new HashSet<>(stringsWithDuplicates);
        System.out.println("Строки без дубликатов: " + uniqueStrings);

        System.out.println();
    }

}