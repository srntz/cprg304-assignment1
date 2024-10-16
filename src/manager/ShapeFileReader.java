package manager;

import shapes.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import exceptions.CorruptedClassGenerationException;
import exceptions.InvalidFileFormatException;

/**
 * This class is used for reading a shape data file
 * and constructing an array of Shape objects
 */
public class ShapeFileReader {
    private Scanner scanner;
    private Shape[] array;

    /**
     * Constructs a new ShapeFileReader object and prepares it for file reading.
     *
     * @param filepath A path to a shape data file
     * @throws FileNotFoundException If the path doesn't point to an existing file
     */
    public ShapeFileReader(String filepath) throws FileNotFoundException{
        scanner = new Scanner(new File(filepath));
    }

    /**
     * Reads a file based on the path provided to the constructor.
     *
     * @return Array of Shape objects created from a data file.
     * @throws CorruptedClassGenerationException If dynamic class generation failed.
     * @throws InvalidFileFormatException If the file format does not match the requirements
     */
    public Shape[] ReadFile() throws CorruptedClassGenerationException, InvalidFileFormatException {
        boolean isFirstIteration = true;
        int curIndex = 0;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            if (isFirstIteration) {
                try {
                    array = new Shape[Integer.parseInt(line)];
                } catch (NumberFormatException e) {
                    throw new InvalidFileFormatException(e.getMessage());
                }

                isFirstIteration = false;
                continue;
            }

            Shape shape = GenerateClass(line);
            array[curIndex] = shape;
            curIndex++;
        }

        return array;
    }

    /**
     * Takes a line from a file, creates, and returns a respective object
     *
     * @param filestring A line from a file
     * @return A class extending Shape
     * @throws CorruptedClassGenerationException If package/class name or constructor in the method does not match the actual ones
     * @throws InvalidFileFormatException If the line does not have one of the required params (classname, height, side/radius)
     */
    private Shape GenerateClass(String filestring) throws CorruptedClassGenerationException, InvalidFileFormatException {
        String[] arr = filestring.split(" ");

        try {
            Class<?> cls = Class.forName("shapes" + "." + arr[0]);

            Object shape = cls.getDeclaredConstructor(double.class, double.class).newInstance(Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));

            return (Shape)shape;
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFileFormatException(e.getMessage());

        } catch (Exception e) {
            throw new CorruptedClassGenerationException(e.getMessage());
        }
    }
}
