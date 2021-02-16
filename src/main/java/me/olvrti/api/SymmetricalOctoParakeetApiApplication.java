package me.olvrti.api;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.olvrti.api.domain.Address;
import me.olvrti.api.domain.BillingDocument;
import me.olvrti.api.domain.Category;
import me.olvrti.api.domain.City;
import me.olvrti.api.domain.CreditCard;
import me.olvrti.api.domain.Customer;
import me.olvrti.api.domain.Payment;
import me.olvrti.api.domain.Product;
import me.olvrti.api.domain.PurchaseOrder;
import me.olvrti.api.domain.PurchaseOrderProduct;
import me.olvrti.api.domain.State;
import me.olvrti.api.domain.enums.CustomerType;
import me.olvrti.api.domain.enums.PaymentState;
import me.olvrti.api.repositories.AddressRepository;
import me.olvrti.api.repositories.CategoryRepository;
import me.olvrti.api.repositories.CityRepository;
import me.olvrti.api.repositories.CustomerRepository;
import me.olvrti.api.repositories.PaymentRepository;
import me.olvrti.api.repositories.ProductRepository;
import me.olvrti.api.repositories.PurchaseOrderProductRepository;
import me.olvrti.api.repositories.PurchaseOrderRepository;
import me.olvrti.api.repositories.StateRepository;

@SpringBootApplication
public class SymmetricalOctoParakeetApiApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PurchaseOrderProductRepository purchaseOrderProductRepository;

	public static void main(String[] args) {
		SpringApplication.run(SymmetricalOctoParakeetApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Sorvete");
		Category cat2 = new Category(null, "Açaí");

		Product prod1 = new Product(null, "Sorvete Expresso", 5.00);
		Product prod2 = new Product(null, "Sorvete Bola", 6.00);
		Product prod3 = new Product(null, "Açaí", 10.00);

		cat1.getProducts().addAll(Arrays.asList(prod1, prod2));
		cat2.getProducts().addAll(Arrays.asList(prod3));

		prod1.getCategories().addAll(Arrays.asList(cat1));
		prod2.getCategories().addAll(Arrays.asList(cat1));
		prod3.getCategories().addAll(Arrays.asList(cat2));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

		State st1 = new State(null, "Paraná");
		State st2 = new State(null, "Rio de Janeiro");

		City ct1 = new City(null, "Rio Azul", st1);
		City ct2 = new City(null, "Irati", st1);
		City ct3 = new City(null, "Rio de Janeiro", st2);

		st1.getCities().addAll(Arrays.asList(ct1, ct2));
		st2.getCities().addAll(Arrays.asList(ct3));

		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(ct1, ct2));

		Customer cust1 = new Customer(null, "Maria", "12394850293", "maria@mail.com", CustomerType.NATURALPERSON);
		Customer cust2 = new Customer(null, "Mercearia Maria LTDA", "12445763000134", "mariamercearia@mail.com",
				CustomerType.JURIDICALPERSON);

		Address ad1 = new Address(null, "Rua Getúlio Vargas", 882, "Vila Diva", 84560000, ct1, cust1);
		Address ad2 = new Address(null, "Avenida Getúlio Vargas", 4651, "Fósforo", 84500000, ct2, cust2);

		cust1.getAddresses().addAll(Arrays.asList(ad1));
		cust2.getAddresses().addAll(Arrays.asList(ad2));

		cust1.getPhones().addAll(Arrays.asList("42 64564745", "42 35647455"));

		customerRepository.saveAll(Arrays.asList(cust1, cust2));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		PurchaseOrder or1 = new PurchaseOrder(null, sdf.parse("10/02/2021 19:57"), ad1, cust1);
		PurchaseOrder or2 = new PurchaseOrder(null, sdf.parse("15/02/2021 19:07"), ad2, cust2);

		Payment pay1 = new CreditCard(null, 1351.48, or1, PaymentState.PAID, "3246983135463587",
				sdf.parse("31/12/2022 23:59"));
		or1.setPayment(pay1);
		cust1.getPurchaseOrders().addAll(Arrays.asList(or1));

		Payment pay2 = new BillingDocument(null, 351.98, or2, PaymentState.SHIPPED, sdf.parse("28/02/2021 23:59"),
				sdf.parse("15/02/2021 19:11"));
		or2.setPayment(pay2);
		cust2.getPurchaseOrders().addAll(Arrays.asList(or2));

		purchaseOrderRepository.saveAll(Arrays.asList(or1, or2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		PurchaseOrderProduct pop1 = new PurchaseOrderProduct(or1, prod1, 0.50, 2);
		PurchaseOrderProduct pop2 = new PurchaseOrderProduct(or2, prod2, 0.00, 4);
		PurchaseOrderProduct pop3 = new PurchaseOrderProduct(or2, prod3, 0.00, 10);

		or1.getProducts().addAll(Arrays.asList(pop1));
		or2.getProducts().addAll(Arrays.asList(pop2, pop3));

		prod1.getPurchaseOrders().addAll(Arrays.asList(pop1));
		prod2.getPurchaseOrders().addAll(Arrays.asList(pop2));
		prod3.getPurchaseOrders().addAll(Arrays.asList(pop3));

		purchaseOrderProductRepository.saveAll(Arrays.asList(pop1, pop2, pop3));

	}

}
