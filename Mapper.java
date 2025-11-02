@FunctionalInterface
public interface Mapper<T, P> {
    P apply(T t);
}