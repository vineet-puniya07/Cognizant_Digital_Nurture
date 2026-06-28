package DependencyInjectionExample;

public class DependencyInjectionDemo {

    public static void main(String[] args) {

        // Create Repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject Repository into Service
        CustomerService service = new CustomerService(repository);

        // Find Customer
        service.getCustomerDetails(101);

        System.out.println();

        service.getCustomerDetails(102);

        System.out.println();

        service.getCustomerDetails(103);
    }
}