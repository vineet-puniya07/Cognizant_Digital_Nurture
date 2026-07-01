package financialForecasting;

import java.util.Scanner;

public class FinancialForecasting {

    static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }

        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter present value: ");
        double presentValue = sc.nextDouble();

        System.out.print("Enter annual growth rate: ");
        double growthPercent = sc.nextDouble();
        double growthRate = growthPercent / 100.0;

        System.out.print("Enter number of years to forecast: ");
        int years = sc.nextInt();

        double futureValue = calculateFutureValue(presentValue, growthRate, years);

        System.out.println("\nPresent Value: " + presentValue);
        System.out.println("Growth Rate: " + growthPercent + "%");
        System.out.println("Years: " + years);
        System.out.printf("Predicted Future Value after %d years: %.2f%n", years, futureValue);

    }
}
