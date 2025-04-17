import java.util.Objects;

/**
 * Клас Computer представляє конфігурацію персонального комп'ютера, що складається з різних компонентів:
 * процесора, материнської плати, оперативної пам'яті, накопичувача, відеокарти, блока живлення та корпусу.
 * 
 * Клас підтримує копіювання, перевірку еквівалентності, розрахунок загальної вартості та виведення конфігурації.
 */
public class Computer {
    private CPU cpu;
    private Motherboard motherboard;
    private RAM ram;
    private Storage storage;
    private GPU gpu;
    private PSU psu;
    private Case pcCase;

    /**
     * Основний конструктор. Створює новий об'єкт  з усіма необхідними компонентами.
     *
     * @param cpu          процесор
     * @param motherboard  материнська плата
     * @param ram          оперативна пам'ять
     * @param storage      накопичувач
     * @param gpu          відеокарта
     * @param psu          блок живлення
     * @param pcCase       корпус
     * @throws IllegalArgumentException якщо будь-який з параметрів дорівнює {@code null}
     */
    public Computer(CPU cpu, Motherboard motherboard, RAM ram, Storage storage,
                    GPU gpu, PSU psu, Case pcCase) {
        setCpu(cpu);
        setMotherboard(motherboard);
        setRam(ram);
        setStorage(storage);
        setGpu(gpu);
        setPsu(psu);
        setPcCase(pcCase);
    }

    /**
     * Конструктор копіювання. Створює глибоку копію іншого об'єкта {@code Computer}.
     *
     * @param other інший комп'ютер для копіювання
     */
    public Computer(Computer other) {
        this.cpu = new CPU(other.cpu);
        this.motherboard = new Motherboard(other.motherboard);
        this.ram = new RAM(other.ram);
        this.storage = new Storage(other.storage);
        this.gpu = new GPU(other.gpu);
        this.psu = new PSU(other.psu);
        this.pcCase = new Case(other.pcCase);
    }

    // Сетери з перевіркою на null

    /**
     * Встановлює процесор.
     *
     * @param cpu процесор
     * @throws IllegalArgumentException якщо {@code cpu} дорівнює {@code null}
     */
    public void setCpu(CPU cpu) {
        if (cpu == null) throw new IllegalArgumentException("CPU не може бути null");
        this.cpu = cpu;
    }

    /**
     * Встановлює материнську плату.
     *
     * @param motherboard материнська плата
     * @throws IllegalArgumentException якщо {@code motherboard} дорівнює {@code null}
     */
    public void setMotherboard(Motherboard motherboard) {
        if (motherboard == null) throw new IllegalArgumentException("Motherboard не може бути null");
        this.motherboard = motherboard;
    }

    /**
     * Встановлює оперативну пам'ять.
     *
     * @param ram оперативна пам'ять
     * @throws IllegalArgumentException якщо {@code ram} дорівнює {@code null}
     */
    public void setRam(RAM ram) {
        if (ram == null) throw new IllegalArgumentException("RAM не може бути null");
        this.ram = ram;
    }

    /**
     * Встановлює накопичувач.
     *
     * @param storage накопичувач
     * @throws IllegalArgumentException якщо {@code storage} дорівнює {@code null}
     */
    public void setStorage(Storage storage) {
        if (storage == null) throw new IllegalArgumentException("Storage не може бути null");
        this.storage = storage;
    }

    /**
     * Встановлює відеокарту.
     *
     * @param gpu відеокарта
     * @throws IllegalArgumentException якщо {@code gpu} дорівнює {@code null}
     */
    public void setGpu(GPU gpu) {
        if (gpu == null) throw new IllegalArgumentException("GPU не може бути null");
        this.gpu = gpu;
    }

    /**
     * Встановлює блок живлення.
     *
     * @param psu блок живлення
     * @throws IllegalArgumentException якщо {@code psu} дорівнює {@code null}
     */
    public void setPsu(PSU psu) {
        if (psu == null) throw new IllegalArgumentException("PSU не може бути null");
        this.psu = psu;
    }

    /**
     * Встановлює корпус.
     *
     * @param pcCase корпус
     * @throws IllegalArgumentException якщо {@code pcCase} дорівнює {@code null}
     */
    public void setPcCase(Case pcCase) {
        if (pcCase == null) throw new IllegalArgumentException("Case не може бути null");
        this.pcCase = pcCase;
    }

    //  ГЕТЕРИ

    /**
     * @return процесор
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * @return материнська плата
     */
    public Motherboard getMotherboard() {
        return motherboard;
    }

    /**
     * @return оперативна пам'ять
     */
    public RAM getRam() {
        return ram;
    }

    /**
     * @return накопичувач
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * @return відеокарта
     */
    public GPU getGpu() {
        return gpu;
    }

    /**
     * @return блок живлення
     */
    public PSU getPsu() {
        return psu;
    }

    /**
     * @return корпус
     */
    public Case getPcCase() {
        return pcCase;
    }

    /**
     * Розраховує загальну вартість усіх компонентів комп'ютера.
     *
     * @return загальна вартість
     */
    public double getTotalPrice() {
        return cpu.getPrice() + motherboard.getPrice() + ram.getPrice()
             + storage.getPrice() + gpu.getPrice() + psu.getPrice() + pcCase.getPrice();
    }

    /**
     * Виводить конфігурацію комп'ютера у консоль, включаючи всі компоненти та їхню вартість.
     */
    public void printConfiguration() {
        System.out.println("=== Комп'ютерна конфігурація ===");
        System.out.println("CPU: " + cpu.getName() + " - $" + cpu.getPrice());
        System.out.println("Motherboard: " + motherboard.getName() + " - $" + motherboard.getPrice());
        System.out.println("RAM: " + ram.getName() + " - $" + ram.getPrice());
        System.out.println("Storage: " + storage.getName() + " - $" + storage.getPrice());
        System.out.println("GPU: " + gpu.getName() + " - $" + gpu.getPrice());
        System.out.println("PSU: " + psu.getName() + " - $" + psu.getPrice());
        System.out.println("Case: " + pcCase.getName() + " - $" + pcCase.getPrice());
        System.out.println("Загальна вартість: $" + getTotalPrice());
    }

    /**
     * Повертає рядкове представлення комп'ютера.
     *
     * @return рядкове представлення
     */
    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", motherboard=" + motherboard +
                ", ram=" + ram +
                ", storage=" + storage +
                ", gpu=" + gpu +
                ", psu=" + psu +
                ", pcCase=" + pcCase +
                '}';
    }

    /**
     * Перевіряє еквівалентність цього об'єкта з іншим.
     *
     * @param o інший об'єкт
     * @return {@code true}, якщо об'єкти однакові
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;

        Computer that = (Computer) o;

        return cpu.equals(that.cpu) &&
                motherboard.equals(that.motherboard) &&
                ram.equals(that.ram) &&
                storage.equals(that.storage) &&
                gpu.equals(that.gpu) &&
                psu.equals(that.psu) &&
                pcCase.equals(that.pcCase);
    }

}
