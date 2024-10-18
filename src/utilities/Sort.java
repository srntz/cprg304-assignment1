package utilities;

import java.util.Comparator;
import java.util.Random;

import shapes.Shape;

public class Sort {
	
	public static void bubblesort(Comparable[] array) {
		//TODO later based on height
	}
	
	public static void bubblesort(Object[] array, Comparator<Shape> c) {
		//TODO later
	}
	
	/**
	 * Sorts an array in descending order using insertion sort algorithm.
	 * Sorts an array of objects that implement the Comparable interface.
	 * @param array The array to be sorted, containing objects the implement Comparable.
	 * @see "Insertion Sort Algorithm." Geeksforgeeks. Accessed: Oct. 8, 2024. [Online]. Available: https://www.geeksforgeeks.org/insertion-sort-algorithm/
	 */
	public static void insertionsort(Comparable[] array) {
		for (int i = 1; i < array.length; i++) {
	        Comparable key = array[i];
	        int j = i - 1;
	        
	        while (j >= 0 && array[j].compareTo(key) < 0) {
	        	array[j + 1] = array[j];
	            j = j - 1;
	        }
	        array[j + 1] = key;
	    }
	}
	
	/**
	 * Sorts an array in descending order using insertion sort algorithm.
	 * Uses a Comparator to compare Shape objects.
	 * @param array The array of Shape Objects to be sorted.
	 * @param c The comparator used to compare between Two Shape objects.
	 * @see "Insertion Sort Algorithm." Geeksforgeeks. Accessed: Oct. 8, 2024. [Online]. Available: https://www.geeksforgeeks.org/insertion-sort-algorithm/
	 */
	public static void insertionsort(Object[] array, Comparator<Shape> c) {
		for (int i = 1; i < array.length; i++) {
	        Object key = array[i];
	        int j = i - 1;
	        
	        while (j >= 0 && c.compare((Shape)array[j], (Shape) key) <  0) {
	        	array[j + 1] = array[j];
	            j = j - 1;
	        }
	        array[j + 1] = key;
	    }
	}
	
	public static void selectionsort(Comparable[] array) {
		//TODO later
	}
	
	public static void selectionsort(Object[] array, Comparator<Shape> c) {
		//TODO later
	}
	
	public static void mergesort(Comparable[] array) {
		//TODO later
	}
	
	public static void mergesort(Object[] array, Comparator<Shape> c) {
		//TODO later
	}

	/**
	 * Infers high and low index from an array and passes that to a sorting method
	 *
	 * @param array Array to sort
	 */
	public static void quicksort(Comparable[] array) {
		quicksort(array, 0, array.length - 1);
	}

	/**
	 * Infers high and low index from an array and passes that to a sorting method
	 *
	 * @param array Array to sort
	 * @param comparator An object defining comparison logic
	 */
	public static void quicksort(Shape[] array, Comparator<Shape> comparator) {
		quicksort(array, comparator, 0, array.length - 1);
	}
	/**
	 * Sorts an array using a quicksort algorithm
	 *
	 * @param array Array to sort
	 * @param comparator An object defining comparison logic
	 * @param low First index of a slice of the array that would get sorted
	 * @param high Last index of a slice of the array that would get sorted
	 */
	public static void quicksort(Shape[] array, Comparator<Shape> comparator,  int low, int high) {
		if (low >= high) {
			return;
		}

		int pivotIndex = new Random().nextInt(high - low) + low;
		Shape pivot = array[pivotIndex];
		swap(array, pivotIndex, high);

		int lp = low;
		int hp = high;

		while (lp < hp) {
			while (comparator.compare(array[lp], pivot) != 1 && lp < hp) {
				lp++;
			}

			while (comparator.compare(array[hp], pivot) != -1 && lp < hp) {
				hp--;
			}

			swap(array, lp, hp);
		}

		swap(array, lp, high);
		quicksort(array, comparator, low, lp - 1);
		quicksort(array, comparator, lp + 1, high);
	}

	/**
	 * Sorts an array using a quicksort algorithm
	 *
	 * @param array Array to sort
	 * @param low First index of a slice of the array that would get sorted
	 * @param high Last index of a slice of the array that would get sorted
	 */
	public static void quicksort(Comparable[] array, int low, int high) {
		if(low >= high) {
			return;
		}

		int pivotIndex = new Random().nextInt(high - low) + low;
		Comparable pivot = array[pivotIndex];
		swap(array, pivotIndex, high);

		int lp = low;
		int hp = high;

		while (lp < hp) {
			while (array[lp].compareTo(pivot) != 1 && lp < hp) {
				lp++;
			}

			while (array[hp].compareTo(pivot) != -1 && lp < hp) {
				hp--;
			}

			swap(array, lp, hp);
		}

		swap(array, lp, high);
		quicksort(array, low, lp - 1);
		quicksort(array, lp + 1, high);

	}

	/**
	 * Swaps two array elements
	 *
	 * @param array Array with the elements
	 * @param i Index of the first element
	 * @param j Index of the second element
	 */
	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void mysort(Comparable[] array) {
		//TODO later
	}
	
	public static void mysort(Object[] array, Comparator<Shape> c) {
		//TODO later
	}
}
