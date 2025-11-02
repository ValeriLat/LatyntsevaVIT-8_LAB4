import java.util.ArrayList;
import java.util.List;

public final class FilterUt {
    private FilterUt() {}

    public static <T> List<T> filter(List<T> list, Test<T> tester) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (tester.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}