package BuilderPatternExample;

public class builderTest {

    public static void main(String[] args) {

        computer gamingPC = new computer.Builder("Intel i9")
                .setRam(32)
                .setStorage(1000)
                .setGraphicsCard("NVIDIA RTX 4080")
                .setBluetooth(true)
                .build();

        computer officePC = new computer.Builder("Intel i5")
                .setRam(16)
                .setStorage(512)
                .build();

        gamingPC.display();
        officePC.display();
    }
}