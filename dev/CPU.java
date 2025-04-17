import java.util.Objects;

/**
 * Клас, що представляє центральний процесор (CPU) комп'ютера.
 * Містить інформацію про назву процесора та його ціну.
 */
public class CPU {
    private final String name;
    private final double price;

    /**
     * Конструктор, що створює новий об'єкт CPU з вказаною назвою та ціною.
     *
     * @param name назва процесора
     * @param price ціна процесора
     * @throws IllegalArgumentException якщо ціна від'ємна або назва пуста
     * @throws NullPointerException якщо назва є null
     */
    public CPU(String name, double price) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        this.name = name;
        this.price = price;
    }

    /**
     * Конструктор копіювання, що створює новий об'єкт CPU на основі існуючого.
     *
     * @param other об'єкт CPU, з якого копіюються дані
     */
    public CPU(CPU other) {
        if (other == null) throw new NullPointerException("Об'єкт для копіювання не може бути null");
        this.name = other.name;
        this.price = other.price;
    }

    /**
     * Повертає ціну процесора.
     *
     * @return ціна процесора
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає назву процесора.
     *
     * @return назва процесора
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає рядкове представлення об'єкта CPU.
     */
    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Порівнює об'єкт CPU з іншим об'єктом на рівність.
     *
     * @param o об'єкт для порівняння
     * @return true якщо об'єкти рівні, false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CPU cpu = (CPU) o;
        return Double.compare(price, cpu.price) == 0 && Objects.equals(name, cpu.name);
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