public class BinarySearch {

	public static void main(String[] args) {

		// int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(sumRecursion(5));

	}

	private static int binarySearchLoop(int[] array, int number) {

		int startPosition = 0;
		int endPosition = array.length - 1;

		while (startPosition <= endPosition) {

			int middleIndex = (startPosition + endPosition) / 2;

			if (number == array[middleIndex])
				return middleIndex;

			else if (number < array[middleIndex])
				endPosition = middleIndex - 1;

			else
				startPosition = middleIndex + 1;

		}

		return -1;
	}

	/**
	 * Metoda kao primjer za rekurziju. Ispis svih brojeva od unesenog broja do
	 * 0;
	 * 
	 * @param number
	 *            broj koji smo unijeli
	 */
	public static void simpleRecursion(int number) {

		if (number < 0) // uslov za rekurziju, tj kada rekurzija treba da stane.
			return;

		System.out.println(number); // Printamo nas broj
		simpleRecursion(number - 1); // Pozivamo funkciju

	}
	
	/**
	 * Rekurzija stepenovanje brojvea. Funkcija prima dva paramentra bazu i exponent.
	 * @param base baza koju cemo stepenovat
	 * @param exponent eksponent na koji cemo stepenovat
	 * @return stepenovan broj
	 */
	public static int recursionPow(int base, int exponent) {
		
		if(exponent == 1)
			return base*1;
		
		return base*recursionPow(base, exponent-1);
		
		
	}

	
	public static int sumRecursion(int number){
				
		
		if(number > 0)
			return number +sumRecursion(number-1);;
		
				
		return 0;
	}
}
