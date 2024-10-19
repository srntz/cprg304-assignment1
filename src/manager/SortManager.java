package manager;

import exceptions.CorruptedClassGenerationException;
import exceptions.InvalidFileFormatException;
import shapes.Shape;
import utilities.BaseAreaComparator;
import utilities.Sort;
import utilities.VolumeComparator;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class SortManager {
	private String FilePath;
	private char comparisonType;
	private Comparator<Shape> comparator;
	private char sortType;

	private Shape[] shapeArr;

	private double benchmarkResult;

	/**
	 * Prepares SortManager for sorting and evaluates presence and validity of all required arguments.
	 *
	 * @param args Command line arguments
	 */
	public SortManager(String[] args) {
		final Character[] possibleSortTypes = {'b', 's', 'i', 'm', 'q', 'z'};

		for(String i : args) {
			String[] argArray = i.toLowerCase().split("");

			// Skips the checking for all non-flag arguments
			if(argArray.length < 2) {
				continue;
			}

			// -f flag evaluation
			if(Objects.equals(argArray[0], "-") && Objects.equals(argArray[1], "f")) {
				if (i.substring(2).isEmpty()) {
					System.out.println("Error. File path can not be empty.");
					System.exit(1);
				}

				FilePath = i.substring(2);
			}

			// -t flag evaluation
			if(Objects.equals(argArray[0], "-") && Objects.equals(argArray[1], "t")) {

				try {
					comparisonType = argArray[2].charAt(0);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Error. Comparison type can not be empty.");
					System.exit(1);
				}

				if (comparisonType == 'v') {
					comparator = new VolumeComparator();
				} else if (comparisonType == 'a') {
					comparator = new BaseAreaComparator();
				} else if (comparisonType == 'h') {
					comparator = null;
				} else {
					System.out.println("Invalid comparison type. Please enter one of: v, h, a");
				}
			}

			// -s flag evaluation
			if(Objects.equals(argArray[0], "-") && Objects.equals(argArray[1], "s")) {
				try {
					sortType = argArray[2].charAt(0);

                    if (!Arrays.asList(possibleSortTypes).contains(sortType)) {
						System.out.println("Invalid sorting type. Please enter one of: b, s, i, m, q, z");
						System.exit(1);
					};
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Error. Sort type can not be empty.");
					System.exit(1);
				}
			}
		}

		// Checks if all required flags are present
		if(FilePath == null || comparisonType == '\u0000' || sortType == '\u0000' ) {
			System.out.println("Argument Error. Please enter all required arguments.");
			System.exit(1);
		}
	}

	/**
	 * Performs sorting and displays results and run time.
	 */
	public void RunSorting() {
		shapeArr = getShapeArray();
		Sort();
		DisplayResults();
	}

	/**
	 * Passes relevant sorting methods to SortAndBenchmark depending on sorting type
	 */
	private void Sort() {
		switch(sortType) {
			case 'b':
				if(comparator == null) {
					benchmarkResult = SortAndBenchmark(() -> Sort.bubblesort(shapeArr));
				} else {
					benchmarkResult = SortAndBenchmark(() -> Sort.bubblesort(shapeArr, comparator));
				}
				break;
			case 's':
				if(comparator == null) {
					benchmarkResult = SortAndBenchmark(() -> Sort.selectionsort(shapeArr));
				} else {
					benchmarkResult = SortAndBenchmark(() -> Sort.selectionsort(shapeArr, comparator));
				}
				break;
			case 'i':
				if(comparator == null) {
					benchmarkResult = SortAndBenchmark(() -> Sort.insertionsort(shapeArr));
				} else {
					benchmarkResult = SortAndBenchmark(() -> Sort.insertionsort(shapeArr, comparator));
				}
				break;
			case 'm':
				if(comparator == null) {
					benchmarkResult = SortAndBenchmark(() -> Sort.mergesort(shapeArr));
				} else {
					benchmarkResult = SortAndBenchmark(() -> Sort.mergesort(shapeArr, comparator));
				}
				break;
			case 'q':
				if(comparator == null) {
					benchmarkResult = SortAndBenchmark(() -> Sort.quicksort(shapeArr));
				} else {
					benchmarkResult = SortAndBenchmark(() -> Sort.quicksort(shapeArr, comparator));
				}
				break;
			case 'z':
				if(comparator == null) {
					benchmarkResult = SortAndBenchmark(() -> Sort.mysort(shapeArr));
				} else {
					benchmarkResult = SortAndBenchmark(() -> Sort.mysort(shapeArr, comparator));
				}
				break;
		}
	}

	/**
	 * Displays results in the required format
	 */
	private void DisplayResults() {
		if(comparisonType == 'v') {
			for(int i = 0; i < shapeArr.length - 1; i += 1000) {
				if (i == 0) {
					System.out.println("First Element is: The " + shapeArr[i].getClass().getName() + " has a volume of: " + shapeArr[i].calcVolume());
				} else {
					System.out.println(i + "-th is: The " + shapeArr[i - 1].getClass().getName() + " has a volume of: " + shapeArr[i - 1].calcVolume());
				}
			}
			System.out.println("Last Element is: The " + shapeArr[shapeArr.length - 1].getClass().getName() + " has a volume of: " + shapeArr[shapeArr.length - 1].calcVolume());
		} else if (comparisonType == 'a') {
			for(int i = 0; i < shapeArr.length - 1; i += 1000) {
				if (i == 0) {
					System.out.println("First Element is: The " + shapeArr[i].getClass().getName() + " has a base area of: " + shapeArr[i].calcBaseArea());
				} else {
					System.out.println(i + "-th is: The " + shapeArr[i - 1].getClass().getName() + " has a base area of: " + shapeArr[i - 1].calcBaseArea());
				}
			}
			System.out.println("Last Element is: The " + shapeArr[shapeArr.length - 1].getClass().getName() + " has a base area of: " + shapeArr[shapeArr.length - 1].calcBaseArea());
		} else {
			for(int i = 0; i < shapeArr.length - 1; i += 1000) {
				if (i == 0) {
					System.out.println("First Element is: The " + shapeArr[i].getClass().getName() + " has a height of: " + shapeArr[i].getHeight());
				} else {
					System.out.println(i + "-th is: The " + shapeArr[i - 1].getClass().getName() + " has a height of: " + shapeArr[i - 1].getHeight());
				}
			}
			System.out.println("Last Element is: The " + shapeArr[shapeArr.length - 1].getClass().getName() + " has a height of: " + shapeArr[shapeArr.length - 1].getHeight());
		}

		System.out.println("Run time: " + benchmarkResult + "ms");
	}

	/**
	 * Performs benchmarking and calls a callback function
	 *
	 * @param callback A function to be benchmarked
	 * @return Callback run time
	 */
	private double SortAndBenchmark(Runnable callback) {
		long start = System.nanoTime();
		callback.run();
		return (double)(System.nanoTime() - start) / 1000000;
	}

	/**
	 * Handles ShapeFileReader exceptions and returns a Shape[] instantiated from a provided file
	 *
	 * @return Array with Shape objects
	 */
	private Shape[] getShapeArray() {
		try {
			ShapeFileReader fileReader = new ShapeFileReader(FilePath);
			Shape[] arr = fileReader.ReadFile();
			return arr;
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please enter path to a valid file.");
			System.exit(1);
		} catch (CorruptedClassGenerationException e) {
			System.out.println("Class generation failed. Please ensure the provided file has valid class names");
			System.exit(1);
		} catch (InvalidFileFormatException e) {
			System.out.println(
					"Invalid file format. Please ensure the provided file aligns with the required format");
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Unexpected error has occurred");
			System.exit(1);
		}
		return null;
	}

}
