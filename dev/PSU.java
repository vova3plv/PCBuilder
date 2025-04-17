import java.util.Objects;

/**
 * Клас, що представляє блок живлення (Power Supply Unit) комп'ютера.
 * Відповідає за зберігання інформації про модель блоку живлення та його вартість.
 * Забезпечує незмінність даних після створення об'єкта.
 */
public class PSU {
    private final String name;
    private final double price;

    /**
     * Конструктор, що створює новий блок живлення з вказаними параметрами.
     *
     * @param name назва моделі блоку живлення (наприклад, "Corsair RM850x")
     * @param price вартість блоку живлення (має бути не менше 0)
     * @throws IllegalArgumentException якщо ціна від'ємна або назва пуста
     * @throws NullPointerException якщо назва є null
     */
    public PSU(String name, double price) {
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною");
        if (name == null) throw new NullPointerException("Ім'я не може бути null");
        if (name.isBlank()) throw new IllegalArgumentException("Ім'я не може бути пустим");
        this.name = name;
        this.price = price;
    }

    /**
     * Конструктор копіювання, що створює новий блок живлення на основі існуючого.
     *
     * @param other об'єкт для копіювання (не може бути null)
     * @throws NullPointerException якщо переданий об'єкт є null
     */
    public PSU(PSU other) {
        if (other == null) throw new NullPointerException("Об'єкт для копіювання не може бути null");
        this.name = other.name;
        this.price = other.price;
    }

    /**
     * Повертає вартість блоку живлення.
     *
     * @return вартість типу double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає назву моделі блоку живлення.
     *
     * @return назва моделі типу String
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає рядкове представлення об'єкта блоку живлення.
     */
    @Override
    public String toString() {
        return "PSU{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Перевіряє рівність об'єктів PSU на основі їх характеристик.
     *
     * @param o об'єкт для порівняння
     * @return true якщо об'єкти ідентичні, false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PSU psu = (PSU) o;
        return Double.compare(price, psu.price) == 0 && Objects.equals(name, psu.name);
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