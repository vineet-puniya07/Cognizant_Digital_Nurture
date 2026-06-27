package DecoratorPatternExample;

public class DecoratorPatternDemo {

    public static void main(String[] args) {

        System.out.println("Email Notification:");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello User!");

        System.out.println("\nEmail + SMS Notification:");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Your OTP is 123456");

        System.out.println("\nEmail + SMS + Slack Notification:");
        Notifier allNotifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()));

        allNotifier.send("Project submitted successfully!");
    }
}
