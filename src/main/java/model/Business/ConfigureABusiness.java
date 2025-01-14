/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import model.Business.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonDirectory;
import model.MarketingManagement.MarketingPersonProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.EmployeeDirectory;
import model.Personnel.EmployeeProfile;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

    public static Business initialize() {
        Business business = new Business("Jayanagar Automobiles");

        // Create 5 suppliers with 10 products each using nested loops
        String[] supplierNames = {"Toyota", "Ford", "BMW", "Tesla", "Hyundai"};
        String[][] productNames = {
            {"Corolla", "Camry", "RAV4", "Highlander", "Prius", "Land Cruiser", "Tacoma", "Tundra", "Yaris", "4Runner"},
            {"F-150", "Mustang", "Explorer", "Ranger", "Bronco", "Escape", "Edge", "Expedition", "Maverick", "Super Duty"},
            {"3 Series", "5 Series", "7 Series", "X1", "X3", "X5", "X7", "i4", "iX", "Z4"},
            {"Model S", "Model 3", "Model X", "Model Y", "Cybertruck", "Roadster", "Semi", "Solar Roof", "Powerwall", "Tesla Battery"},
            {"Elantra", "Sonata", "Tucson", "Santa Fe", "Kona Electric", "Venue", "Ioniq 5", "Palisade", "Creta", "Verna"}
        };

        // Create suppliers and their products
        for (int i = 0; i < supplierNames.length; i++) {
            Supplier supplier = business.getSupplierDirectory().newSupplier(supplierNames[i]);
            ProductCatalog productCatalog = supplier.getProductCatalog();

            for (int j = 0; j < 10; j++) {
                // Base price increases with each supplier and product
                int basePrice = 20000 + (i * 100) + (j * 50);
                productCatalog.newProduct(
                        productNames[i][j],
                        basePrice, // Floor Price
                        basePrice * 2, // Ceiling Price
                        (int) (basePrice * 1.5) // Target Price
                );
            }
        }

        // Create 10 customers
        String[] customerNames = {"Ashish", "Venugopal", "Gautam", "Kenish", "Namratha",
            "Dinesh", "Anil Kumar", "Suchitha", "Chinmay", "Rachana"};
        CustomerProfile[] customers = new CustomerProfile[10];

        for (int i = 0; i < customerNames.length; i++) {
            Person person = new Person(customerNames[i]);
            customers[i] = business.getCustomerDirectory().newCustomerProfile(person);
        }

        // Create 3 sales persons
        String[] salesPersonNames = {"Abhay", "Raghav", "Dennis"};
        SalesPersonProfile[] salesPersons = new SalesPersonProfile[3];

        for (int i = 0; i < salesPersonNames.length; i++) {
            Person person = new Person(salesPersonNames[i]);
            salesPersons[i] = business.getSalesPersonDirectory().newSalesPersonProfile(person);
            // Create user accounts for sales persons
            business.getUserAccountDirectory().newUserAccount(
                    salesPersons[i],
                    salesPersonNames[i].toLowerCase(),
                    salesPersonNames[i].toLowerCase() + "@1234"
            );
        }
        //MarketingPerson 1 - Mike
        Person person14 = new Person("Vemana");
        MarketingPersonProfile marketingPerson1 = business.getMarketingPersonDirectory().newMarketingPersonProfile(person14);
        UserAccount userAccount4 = business.getUserAccountDirectory().newUserAccount(marketingPerson1, "vemana", "vemana@1234");

        //MarketingPerson 2 - Mary
        Person person15 = new Person("Suhas");
        MarketingPersonProfile marketingPerson2 = business.getMarketingPersonDirectory().newMarketingPersonProfile(person15);
        UserAccount userAccount5 = business.getUserAccountDirectory().newUserAccount(marketingPerson2, "suhas", "suhas@1234");

        // Create 500 orders (10 orders per product for 50 products)
        for (int productId = 1; productId <= 50; productId++) {
            // Get the supplier index and product index
            int supplierIndex = (productId - 1) / 10;
            int productIndex = (productId - 1) % 10;

            // Get the product from the correct supplier
            Supplier supplier = business.getSupplierDirectory().getSupplierList().get(supplierIndex);
            Product product = supplier.getProductCatalog().getProductList().get(productIndex);

            // Create 10 orders for this product
            for (int orderNum = 0; orderNum < 10; orderNum++) {
                // Cycle through customers and sales persons
                CustomerProfile customer = customers[orderNum];
                SalesPersonProfile salesPerson = salesPersons[orderNum % 3];

                // Create new order
                Order order = business.getMasterOrderList().newOrder(customer, salesPerson);

                // Add three items to each order
                // First item is the current product
                OrderItem item1 = order.newOrderItem(
                        product,
                        calculatePrice(product.getTargetPrice(), 0.9, 1.1),
                        1
                );

                // Second item from different supplier
                Product product2 = getProductFromDifferentSupplier(business, productId, 1);
                OrderItem item2 = order.newOrderItem(
                        product2,
                        calculatePrice(product2.getTargetPrice(), 0.9, 1.1),
                        1
                );

                // Third item from another different supplier
                Product product3 = getProductFromDifferentSupplier(business, productId, 2);
                OrderItem item3 = order.newOrderItem(
                        product3,
                        calculatePrice(product3.getTargetPrice(), 0.9, 1.1),
                        1
                );
            }
        }

        return business;
    }

// Helper methods
    private static int calculatePrice(int targetPrice, double minFactor, double maxFactor) {
        double randomFactor = minFactor + Math.random() * (maxFactor - minFactor);
        return (int) (targetPrice * randomFactor);
    }

    private static Product getProductFromDifferentSupplier(Business business, int currentProductId, int offset) {
        int newProductId = ((currentProductId + (offset * 10) - 1) % 50) + 1;
        int supplierIndex = (newProductId - 1) / 10;
        int productIndex = (newProductId - 1) % 10;

        Supplier supplier = business.getSupplierDirectory().getSupplierList().get(supplierIndex);
        return supplier.getProductCatalog().getProductList().get(productIndex);
    }

}
