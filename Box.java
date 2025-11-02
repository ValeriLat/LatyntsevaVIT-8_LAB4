//задание 1.1
public class Box<T> {
    private T content;

    public Box() {
        this.content = null;
    }

    public Box(T content) {
        this.content = content;
    }

    public void put(T item) {
        if (content != null) {
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.content = item;
    }

    public T get() {
        T item = content;
        content = null;
        return item;
    }

    public boolean isFull() {
        return content != null;
    }

    @Override
    public String toString() {
        if (content == null) {
            return "Box{пусто}";
        } else {
            return "Box{" + content + "}";
        }
    }
}
