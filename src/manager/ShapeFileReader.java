package manager;

import shapes.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import exceptions.CorruptedClassGeneration;
import exceptions.InvalidFileFormat;

public class ShapeFileReader {
    private Scanner scanner;
    private Shape[] array;

    public ShapeFileReader(String filepath) throws FileNotFoundException{
        scanner = new Scanner(new File(filepath));
    }

    public Shape[] ReadFile() throws CorruptedClassGeneration, InvalidFileFormat {
        boolean isFirstIteration = true;
        int curIndex = 0;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            if (isFirstIteration) {
                try {
                    array = new Shape[Integer.parseInt(line)];
                } catch (NumberFormatException e) {
                    throw new InvalidFileFormat(e.getMessage());
                }

                isFirstIteration = false;
            } else {
                Shape shape = GenerateClass(line);
                array[curIndex] = shape;
                curIndex++;
            }
        }

        return array;
    }

    private Shape GenerateClass(String filestring) throws CorruptedClassGeneration {
        String[] arr = filestring.split(" ");

        try {
            Class<?> cls = Class.forName("shapes" + "." + arr[0]);

            Object shape = cls.getDeclaredConstructor(double.class, double.class).newInstance(Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));

            return (Shape)shape;
        } catch (Exception e) {
            throw new CorruptedClassGeneration(e.getMessage());
        }
    }
}
