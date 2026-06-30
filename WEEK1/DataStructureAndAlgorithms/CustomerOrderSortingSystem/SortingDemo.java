package CustomerOrderSortingSystem;

public class SortingDemo {

    public static void arrangeUsingBubble(Order[] list) {

        boolean swapped;

        for (int i = 0; i < list.length - 1; i++) {

            swapped = false;

            for (int j = 0; j < list.length - i - 1; j++) {

                if (list[j].getTotalPrice() > list[j + 1].getTotalPrice()) {

                    Order temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    public static void arrangeUsingQuick(Order[] list, int start, int end) {

        if (start < end) {

            int pivotIndex = divide(list, start, end);

            arrangeUsingQuick(list, start, pivotIndex - 1);
            arrangeUsingQuick(list, pivotIndex + 1, end);
        }
    }

    private static int divide(Order[] list, int start, int end) {

        double pivotValue = list[end].getTotalPrice();

        int smaller = start - 1;

        for (int current = start; current < end; current++) {

            if (list[current].getTotalPrice() <= pivotValue) {

                smaller++;

                Order temp = list[smaller];
                list[smaller] = list[current];
                list[current] = temp;
            }
        }

        Order temp = list[smaller + 1];
        list[smaller + 1] = list[end];
        list[end] = temp;

        return smaller + 1;
    }

    public static void printOrders(Order[] list) {

        for (Order order : list) {

            System.out.println(order);
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {

        Order[] bubbleData = {
                new Order(501, "Amit", 2750),
                new Order(505, "Karan", 3500)
        };

        System.out.println("Orders After Bubble Sort\n");

        arrangeUsingBubble(bubbleData);

        printOrders(bubbleData);

        Order[] quickData = {
                new Order(501, "Amit", 2750),
                new Order(505, "Karan", 3500)
        };

        System.out.println("\nOrders After Quick Sort\n");

        arrangeUsingQuick(quickData, 0, quickData.length - 1);

        printOrders(quickData);
    }
}
