import java.util.Objects;

/**
 * Клас, що представляє корпус комп'ютера.
 * Зберігає інформацію про модель корпусу та його вартість.
 * Надає методи для безпечного доступу до характеристик корпусу.
 */
public class Case {
    private final String name;
    private final double price;

    /**
     * Основний конструктор для створення об'єкта корпусу комп'ютера.
     *
     * @param name назва моделі корпусу (не може бути null або пустою)
     * @param price вартість корпусу (має бути не менше 0)
     * @throws IllegalArgumentException якщо ціна від'ємна або назва пуста
     * @throws NullPointerException якщо назва є null
     */
    public Case(String name, double price) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        this.price = price;
        this.name = name;
    }

    /**
     * Конструктор копіювання для створення нового корпусу на основі існуючого.
     *
     * @param other об'єкт корпусу для копіювання (не може бути null)
     * @throws NullPointerException якщо переданий об'єкт є null
     */
    public Case(Case other) {
        if (other == null) throw new NullPointerException("Об'єкт для копіювання не може бути null");
        this.name = other.name;
        this.price = other.price;
    }

    /**
     * Отримує поточну вартість корпусу.
     *
     * @return вартість корпусу типу double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримує модель корпусу.
     *
     * @return назва моделі корпусу типу String
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає рядкове представлення об'єкта Case.
     */
    @Override
    public String toString() {
        return "Case{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Порівнює об'єкт Case з іншим об'єктом на рівність.
     *
     * @param o об'єкт для порівняння
     * @return true якщо об'єкти рівні, false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return Double.compare(price, aCase.price) == 0 && Objects.equals(name, aCase.name);
    }

    /**
     * Повертає хеш-код об'єкта.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}