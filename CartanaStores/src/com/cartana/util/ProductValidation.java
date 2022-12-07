package com.cartana.util;

import java.text.ParseException;
import java.util.List;

import com.cartana.exception.ProductCustomException;
import com.cartana.model.Category;
import com.cartana.model.Product;

public class ProductValidation {

	// method to check for duplicate product code
	public static void checkDuplicateProductCode(String itemCode,
			List<Product> productList) throws ProductCustomException {
		Product checkProduct = new Product(itemCode);
		for (Product product : productList) {
			if (product.equals(checkProduct)) {
				throw new ProductCustomException("Duplicate product found!!!");
			}
		}
	}

	// method to validate buying price
	public static void validateBuyingPrice(double buyingPrice)
			throws ProductCustomException {
		if (buyingPrice <= 0) {
			throw new ProductCustomException(
					"Buying price has to be greater than 0!!!");
		}
	}
	
	// method to validate buying price
		public static void validateSellingPrice(double sellingPrice, double buyingPrice)
				throws ProductCustomException {
			if (sellingPrice < buyingPrice) {
				throw new ProductCustomException(
						"Selling price can't be less than buying price!!!");
			}
		}
		
		// method to validate product category
		public static Category validateCategory(String category) throws ParseException {
			Category checkCategory = Category.valueOf(category);
			return checkCategory;
		}
		
}
