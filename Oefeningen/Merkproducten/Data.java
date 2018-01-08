package be.oak3.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
	private static Product[] artikels = {
			new Parfum(0, "Dolce & Gabbana", "Light Blue", 100, 66.72),
			new Parfum(0, "BVLGARI", "BLV", 75, 61.52),
			new Deodorant(0, "DKNY", "Be Delicious Women", 100, 33.65,
					Deodorant.DeoType.STICK),
			new Parfum(0, "Georgio Armani", "Code Donna", 50, 59.32),
			new AfterShave(0, "Yves Saint Laurent", "Jazz", 50, 39.84,
					AfterShave.Soort.VAPO),
			new Parfum(0, "Givency", "Absolutely Irresistible", 75, 75.42),
			new AfterShave(0, "Yves Saint Laurent", "Jazz", 100, 57.76,
					AfterShave.Soort.VAPO),
			new Parfum(0, "Ted Lapidus", "Pour Elle", 50, 44.48),
			new Parfum(0, "Georgio Armani", "Code Donna", 30, 39.84),
			new Parfum(0, "Georgio Armani", "Code Donna", 75, 76.00),
			new Deodorant(0, "Cacharel", "Anais", 50, 24.50, Deodorant.DeoType.VAPO),

	};

	// Geeft de lijst als een ArrayList terug
	public static List<Product> getData() {
		return new ArrayList<Product>(Arrays.asList(artikels));
	}
}
