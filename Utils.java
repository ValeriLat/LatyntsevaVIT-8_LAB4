import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private Utils() {}

    public static <T, P> List<P> map(List<T> list, Mapper<T, P> mapper) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }
}