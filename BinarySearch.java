public class BinarySearch {

	public static void main(String[] args) {

		 int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for(int i=0;i<15;i++){
		 System.out.println(binarySearchWithRecursion(array, i, 0, array.length-1));
		
		}
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

	/**
	 * Rekurzivno sabiranje brojeva izmedju 1 i broja kojeg proslijedimo kao parametar.
	 * @param number do kojeg broja se treba sabirati
	 * @return zbir svih projeva 1-number
	 */
	public static int sumRecursion(int number){
						
		if(number > 0)														// Uslov rekurzije, ponavljat ce se sve dok je nas broj veci od 0.
			return number +sumRecursion(number-1);							//vraca broj + "ovu funkciju" broja umanjenog za 1	
						
		return 0;															
	}

	/**
	 * Binary search with recursion.
	 * @param array our array
	 * @param number number we search
	 * @param startIndex	start index of array
	 * @param endIndex		end index of array
	 * @return index of number in array we search
	 */
	public static int binarySearchWithRecursion(int [] array, int number, int startIndex, int endIndex){
		
		if(startIndex > endIndex)							// Uslov kada rekurzija vraca -1, tj kada broj kojeg trazimo nije u nasem nizu
			return -1;
		
		
		int middleIndex = (startIndex + endIndex) / 2;		// Racunanje srednjeg indexa
		
		if (number == array[middleIndex])					// Ako je nas broj jednak broju pod 'middle' indexom
			return middleIndex;

		else if (number < array[middleIndex])				// Ako je nas broj manji od broja pod middle indexom
			return binarySearchWithRecursion(array, number, startIndex, endIndex-1);
			

		else												// Ako je nas broj veci od broja pod middle indexom		
			return binarySearchWithRecursion(array, number, startIndex+1, endIndex);
		
		
	}



}
