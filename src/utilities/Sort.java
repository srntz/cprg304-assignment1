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
	
	public static void quicksort(Comparable[] array) {
		quicksort(array, 0, array.length - 1);
	}
	
	public static <T> void quicksort(T[] array, Comparator<? super T> c) {
		//TODO later
	}

	private static void quicksort(Comparable[] array, int lowIndex, int highIndex) {
		if(lowIndex >= highIndex) {
			return;
		}

		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		Comparable pivot = array[pivotIndex];
		swap(array, pivotIndex, highIndex);

		int lp = lowIndex;
		int hp = highIndex;

		while (lp < hp) {
			while (array[lp].compareTo(pivot) != 1 && lp < hp) {
				lp++;
			}

			while (array[hp].compareTo(pivot) != -1 && lp < hp) {
				hp--;
			}

			swap(array, lp, hp);
		}

		swap(array, lp, highIndex);
		quicksort(array, lowIndex, lp - 1);
		quicksort(array, lp + 1, highIndex);

	}
	
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
