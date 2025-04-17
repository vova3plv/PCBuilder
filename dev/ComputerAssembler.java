// ComputerAssembler class
class ComputerAssembler {
    private java.util.Scanner scanner = new java.util.Scanner(System.in);
    private CPUDAO cpuDAO = new CPUDAO();
    private MotherboardDAO motherboardDAO = new MotherboardDAO();
    private RAMDAO ramDAO = new RAMDAO();
    private StorageDAO storageDAO = new StorageDAO();
    private GPUDAO gpuDAO = new GPUDAO();
    private PSUDAO psuDAO = new PSUDAO();
    private CaseDAO caseDAO = new CaseDAO();

    public CPU selectCPU() {
        List<CPU> cpus = cpuDAO.getAllCPUs();
        if (cpus.isEmpty()) {
            System.out.println("No CPUs available, defaulting to Intel i5.");
            return new CPU("Intel i5", 200.0);
        }
        System.out.println("Select CPU:");
        for (int i = 0; i < cpus.size(); i++) {
            System.out.println((i + 1) + ". " + cpus.get(i).getName() + " - $" + cpus.get(i).getPrice());
        }
        System.out.print("Enter your choice (1-" + cpus.size() + "): ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > cpus.size()) {
            System.out.println("Invalid choice, defaulting to first option.");
            return cpus.get(0);
        }
        return cpus.get(choice - 1);
    }

    public Motherboard selectMotherboard() {
        List<Motherboard> motherboards = motherboardDAO.getAllMotherboards();
        if (motherboards.isEmpty()) {
            System.out.println("No Motherboards available, defaulting to ASUS ROG.");
            return new Motherboard("ASUS ROG", 200.0);
        }
        System.out.println("Select Motherboard:");
        for (int i = 0; i < motherboards.size(); i++) {
            System.out.println((i + 1) + ". " + motherboards.get(i).getName() + " - $" + motherboards.get(i).getPrice());
        }
        System.out.print("Enter your choice (1-" + motherboards.size() + "): ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > motherboards.size()) {
            System.out.println("Invalid choice, defaulting to first option.");
            return motherboards.get(0);
        }
        return motherboards.get(choice - 1);
    }

    public RAM selectRAM() {
        List<RAM> rams = ramDAO.getAllRAMs();
        if (rams.isEmpty()) {
            System.out.println("No RAM available, defaulting to 8GB DDR4.");
            return new RAM("8GB DDR4", 50.0);
        }
        System.out.println("Select RAM:");
        for (int i = 0; i < rams.size(); i++) {
            System.out.println((i + 1) + ". " + rams.get(i).getName() + " - $" + rams.get(i).getPrice());
        }
        System.out.print("Enter your choice (1-" + rams.size() + "): ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > rams.size()) {
            System.out.println("Invalid choice, defaulting to first option.");
            return rams.get(0);
        }
        return rams.get(choice - 1);
    }

    public Storage selectStorage() {
        List<Storage> storages = storageDAO.getAllStorages();
        if (storages.isEmpty()) {
            System.out.println("No Storage available, defaulting to 512GB SSD.");
            return new Storage("512GB SSD", 80.0);
        }
        System.out.println("Select Storage:");
        for (int i = 0; i < storages.size(); i++) {
            System.out.println((i + 1) + ". " + storages.get(i).getName() + " - $" + storages.get(i).getPrice());
        }
        System.out.print("Enter your choice (1-" + storages.size() + "): ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > storages.size()) {
            System.out.println("Invalid choice, defaulting to first option.");
            return storages.get(0);
        }
        return storages.get(choice - 1);
    }

    public GPU selectGPU() {
        List<GPU> gpus = gpuDAO.getAllGPUs();
        if (gpus.isEmpty()) {
            System.out.println("No GPUs available, defaulting to NVIDIA GTX 1660.");
            return new GPU("NVIDIA GTX 1660", 250.0);
        }
        System.out.println("Select GPU:");
        for (int i = 0; i < gpus.size(); i++) {
            System.out.println((i + 1) + ". " + gpus.get(i).getName() + " - $" + gpus.get(i).getPrice());
        }
        System.out.print("Enter your choice (1-" + gpus.size() + "): ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > gpus.size()) {
            System.out.println("Invalid choice, defaulting to first option.");
            return gpus.get(0);
        }
        return gpus.get(choice - 1);
    }

    public PSU selectPSU() {
        List<PSU> psus = psuDAO.getAllPSUs();
        if (psus.isEmpty()) {
            System.out.println("No PSUs available, defaulting to 650W Bronze.");
            return new PSU("650W Bronze", 80.0);
        }
        System.out.println("Select PSU:");
        for (int i = 0; i < psus.size(); i++) {
            System.out.println((i + 1) + ". " + psus.get(i).getName() + " - $" + psus.get(i).getPrice());
        }
        System.out.print("Enter your choice (1-" + psus.size() + "): ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > psus.size()) {
            System.out.println("Invalid choice, defaulting to first option.");
            return psus.get(0);
        }
        return psus.get(choice - 1);
    }

    public Case selectCase() {
        List<Case> cases = caseDAO.getAllCases();
        if (cases.isEmpty()) {
            System.out.println("No Cases available, defaulting to Cooler Master Q300L.");
            return new Case("Cooler Master Q300L", 60.0);
        }
        System.out.println("Select Case:");
        for (int i = 0; i < cases.size(); i++) {
            System.out.println((i + 1) + ". " + cases.get(i).getName() + " - $" + cases.get(i).getPrice());
        }
        System.out.print("Enter your choice (1-" + cases.size() + "): ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > cases.size()) {
            System.out.println("Invalid choice, defaulting to first option.");
            return cases.get(0);
        }
        return cases.get(choice - 1);
    }

    public Computer buildComputer() {
        CPU cpu = selectCPU();
        Motherboard motherboard = selectMotherboard();
        RAM ram = selectRAM();
        Storage storage = selectStorage();
        GPU gpu = selectGPU();
        PSU psu = selectPSU();
        Case pcCase = selectCase();
        return new Computer(cpu, motherboard, ram, storage, gpu, psu, pcCase);
    }
}
