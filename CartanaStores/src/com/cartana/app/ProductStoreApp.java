package com.cartana.app;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import static com.cartana.util.ProductUtil.*;
import static com.cartana.util.ProductValidation.*;

import com.cartana.model.Category;
import com.cartana.model.Product;

public class ProductStoreApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
				BufferedReader brRead = new BufferedReader(new InputStreamReader(System.in));
				try{
			
			// loading the pre-loaded list
			List<Product> productList = loadExistingProductList();
			
			System.out.println("WELCOME TO CARTANA STORE!!!");
			
			boolean loop = true;
			
			while(true) {
				System.out.println("Press 1 to add a new product");
				System.out.println("Press 2 to list products by category");
				System.out.println("Press 3 to search a product by item code or its name");
				System.out.println("Press 4 to list all the products");
				System.out.println("Press 10 to exit");
				System.out.println("Enter your choice: ");
				int choice = scan.nextInt();
				
				switch (choice) {
				case 1:
					System.out.println("Enter the product code: ");
					String productCode = brRead.readLine();
					checkDuplicateProductCode(productCode, productList);
					System.out.println("Enter product name: ");
					String productName = brRead.readLine();
					System.out.println("Enter the buing price: ");
					double buyingPrice = scan.nextDouble();
					System.out.println("Enter the selling price: ");
					double sellingPrice = scan.nextDouble();
					System.out.println("Enter product category: ");
					String category = brRead.readLine().toUpperCase();
					System.out.println("Enter tax input");
					double tax = scan.nextDouble();
					System.out.println("Enter quantity: ");
					int quantity = scan.nextInt();
					
					addNewProduct(productCode, productName, buyingPrice, sellingPrice, category, tax, quantity);
					break;

				case 2:
					System.out.println("Enter the category you need to search for: ");
					String searchCategory = brRead.readLine().toUpperCase();
					
					for (Product product : productList) {
						if(product.getCategory() == Category.valueOf(searchCategory)) {
							System.out.println(product);
						} 
					}
					break;
					
				case 3:
					System.out.println("Enter product name or product code that you want to search: ");
					String search = brRead.readLine().toUpperCase();
					
					for (Product product : productList) {
						if(product.getItemCode().equals(search) || product.getItemName().toUpperCase().equals(search)) {
							System.out.println("Product found!!!");
							System.out.println("Here are the product details: ");
							System.out.println(product);
						}
					}
					break;
					
				case 4:
					for (Product product : productList) {
						System.out.println(product);
					}
					break;
					
				case 10:
					loop = false;
					break;
					
				default:
					System.out.println("Not a valid choice");
					break;
				}
			}
		
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
