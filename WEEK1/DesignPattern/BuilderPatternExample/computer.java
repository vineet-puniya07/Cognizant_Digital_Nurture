package BuilderPatternExample;

public class computer {

    private String cpu;

    private int ram;
    private int storage;
    private String graphicsCard;
    private boolean bluetooth;

    private computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetooth = builder.bluetooth;
    }

    public void display() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Storage: " + storage + " GB");
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("Bluetooth: " + bluetooth);
        System.out.println("----------------------------");
    }

    public static class Builder {

        private String cpu;

        private int ram;
        private int storage;
        private String graphicsCard;
        private boolean bluetooth;

        public Builder(String cpu) {
            this.cpu = cpu;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public computer build() {
            return new computer(this);
        }
    }
}