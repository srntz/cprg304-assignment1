package utilities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import shapes.Shape;

public class Sort {
	
	/**
	 * Sorts an array using a bubblesort algorithm
	 *
	 * @param iterate through the array
	 * @param compare each pair of adjacent elements
	 * @param swap elements if they're in the wrong order
	 * @param repeat until there's no swaps needed
	 */
	
	public static void bubblesort(Comparable[] array) {
		boolean swapped;
		int al = array.length;
		do {
			swapped = false;
			for (int i = 0; i < al - 1; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					swap(array, i, i + 1);
					swapped = true;
				}
			}
			al--; // to reduce the range of comparison after each pass
		} while (swapped);
	}
	
	
	public static void bubblesort(Object[] array, Comparator<Shape> c) {
		boolean swapped;
		int al = array.length;
		do {
			swapped = false;
			for (int i = 0; i < al - 1; i++) {
				if (c.compare((Shape) array[i], (Shape) array[i + 1]) > 0) {
					swap(array, i, i + 1);
					swapped = true;
				}
			}
			al--;
		} while (swapped);
	}
	
	public static void insertionsort(Comparable[] array) {
		//TODO later
	}
	
	public static void insertionsort(Object[] array, Comparator<Shape> c) {
		//TODO later
	}
	
	public static void selectionsort(Comparable[] array) {
		//TODO later
	}
	
	public static void selectionsort(Object[] array, Comparator<Shape> c) {
		//TODO later
	}
	
	/**
	 * Sorts an array using a mergesort algorithm
	 *
	 * @param divide array to two halves
	 * @param sort each half
	 * @param merge the sorted half
	 */
	
	public static void mergesort(Comparable[] array) {
		if (array.length < 2) return;
		int mid = array.length / 2;
		Comparable[] left = Arrays.copyOfRange(array, 0, mid);
		Comparable[] right = Arrays.copyOfRange(array, mid, array.length);
		
		mergesort(left);
		mergesort(right);
		merge(array, left, right);
	}
	
	// method to merge two sorted arrays into one array
	private static void merge(Comparable[] array, Comparable[] left, Comparable[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i].compareTo(right[j]) <= 0) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}
		while (i < left.length) {
			array[k++] = right[j++];
		}
		while (j < right.length) {
			array[k++] = right[j++];
		}
		
	}

	public static void mergesort(Object[] array, Comparator<Shape> c) {
		if (array.length < 2) return;
		int mid = array.length / 2;
		Object[] left = Arrays.copyOfRange(array, 0, mid);
		Object[] right = Arrays.copyOfRange(array, mid, array.length);
		
		mergesort(left, c);
		mergesort(right, c);
		merge(array, left, right, c);
	}
	
	// merge two sorted arrays into one using custom comparator
	public static void merge(Object[] array, Object[] left, Object[] right, Comparator<Shape> c) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (c.compare((Shape) left[i], (Shape) right[j]) <= 0) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[i++];
			}
		}
		while (i < left.length) {
			array[k++] = left[i++];
		}
		while (j < right.length) {
			array[k++] = right[j++];
		}
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
