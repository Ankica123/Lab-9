import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Lab9shoppingList {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Map<String, Double> items = new HashMap<>();
		List<String> orderName = new ArrayList<>();
		List<Double> orderCost = new ArrayList<>();


		items.put("apple", 0.99);
		items.put("banana", 0.59);
		items.put("califlower", 1.59);
		items.put("dragonfruit", 2.35);
		items.put("elderberry", 1.79);
		items.put("figs", 2.09);
		items.put("grapefruit", 1.99);
		items.put("honeydew", 3.49);
		Set<Map.Entry<String, Double>> s = items.entrySet();

		System.out.println("Welcome to Our Market");
		System.out.println("Item                 Price");
		System.out.println("==========================");
		// for loop to display Array list
		for (Map.Entry<String, Double> it : s) {
			System.out.println(String.format("%-20s %s", it.getKey(), it.getValue()));
		}

		String userChoice = "";
		do {
			// Printing the menu

			// User input (item name)

			System.out.println("Enter an item name: ");
			String nameItem = scan.nextLine();

			// Is this a valid item?
			if (items.containsKey(nameItem)) { // Check hash map for key (“apple”)
				double value = items.get(nameItem);
				System.out.println("Contains : " + nameItem + " " + "$" + value);
				// orderName.get(0) = “test” (List)
				// orderName[0] = “test” (array)
				// List, HashMap, ArrayList (List)
				// [“apple”: 0.99, “banana”: 0.59] hash map operator: .size(), put(“string”, 0),
				// get(“string”), containsKey(“string”)
				// [“apple”, “banana”, “figs”] list operator: .size(), .add(“string”),
				// remove(0), get(0)

				orderName.add(nameItem);
				// double value = items.get(nameItem);
				orderCost.add(value); // hashmap.get(“apples”) -> 0.99 // list.add(0.99)
			} else {
				System.out.println("Sorry we don’t have that item, please try again.");

			}

			// printResults(orderName, orderCost);
			System.out.println();
			System.out.print("Would you like to continue? (Y/n): ");
			userChoice = scan.nextLine();

		} while (userChoice.equalsIgnoreCase("Y"));
		printResults(orderName, orderCost);

	}

	public static void printResults(List<String> names, List<Double> costs) {
		// Average cost
		int sum = 0;
		for (int i = 0; i < costs.size(); i++) {
			sum += costs.get(i);
	}
		int average = sum / costs.size();
		System.out.println("Average cost: " + average);
		// Index of highest and lowest cost items
		double high = 0.0;
		double low = Double.MAX_VALUE;
		for (int I = 0; I < costs.size(); I++) {
			double value = costs.get(I);
			if (value < low) {
				low = value;
		}
			if (value > high) {
				high = value;
		}
	}
		System.out.println("Low: " + low + ", High: " + high);
	}
}
