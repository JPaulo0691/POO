package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number of products: ");
		int n = input.nextInt();
		
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			
			System.out.print("Common, used or imported(c/u/i)?");
			char choose = input.next().charAt(0);
			
			System.out.println("Name: ");
			input.nextLine();
			String name = input.nextLine();			
			
			System.out.println("Price: ");
			double price = input.nextDouble();
			
			if (choose == 'c') {
				list.add(new Product(name, price));
			}
			
			else if(choose == 'i') {
				System.out.println("Customs fee: ");
				double customsFee = input.nextDouble();
				
				list.add(new ImportedProduct(name, price, customsFee)); 
			}
			
			else{				
				
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(input.next());
				
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			
			
		}
		
		System.out.println();
		
		System.out.println("PRICE TAGS");
		
		for(Product listas: list) {
			System.out.println(listas.priceTag());
		}
		
		input.close();

	}

}
