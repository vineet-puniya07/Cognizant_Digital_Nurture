package CommandPatternExample;

public class CommandPatternDemo {

    public static void main(String[] args) {

        // Receiver
        Light light = new Light();

        // Commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn ON the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn OFF the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}