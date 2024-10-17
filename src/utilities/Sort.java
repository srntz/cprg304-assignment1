package utilities;

import java.util.Comparator;
import java.util.Random;

import shapes.Shape;

public class Sort {
	
	public static void bubblesort(Comparable[] array) {
		//TODO later based on height
	}
	
	public static <T> void bubblesort(Object[] array, Comparator<Shape> c) {
		//TODO later
	}
	
	public static void insertionsort(Comparable[] array) {
		//TODO later
	}
	
	public static <T> void insertionsort(T[] array, Comparator<? super T> c) {
		//TODO later
	}
	
	public static void selectionsort(Comparable[] array) {
		//TODO later
	}
	
	public static <T> void selectionsort(T[] array, Comparator<? super T> c) {
		//TODO later
	}
	
	public static void mergesort(Comparable[] array) {
		//TODO later
	}
	
	public static <T> void mergesort(T[] array, Comparator<? super T> c) {
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
	public static <T> void quicksort(T[] array, Comparator<? super T> comparator) {
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
	public static <T> void quicksort(T[] array, Comparator<? super T> comparator,  int low, int high) {
		if (low >= high) {
			return;
		}

		int pivotIndex = new Random().nextInt(high - low) + low;
		T pivot = array[pivotIndex];
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


	public static <T> void mysort(T[] array, Comparator<? super T> c) {
		//TODO later
	}
}
