import java.util.List;
import java.util.function.BinaryOperator;

public final class ReduceUt {
    private ReduceUt() {}

    public static <T> T reduce(List<T> list, BinaryOperator<T> combiner, T identity) {
        T result = identity;
        for (T item : list) {
            result = combiner.apply(result, item);
        }
        return result;
    }
}
