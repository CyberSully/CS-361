import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    public static void main(String[] args) {
        System.out.println("Time to try to catch a Pokemon");
        System.out.println("Type 1 to throw pokeball, type any other number to exit");
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        if (selection == 1) {
            try {
                FileWriter myWriter = new FileWriter("C:\\\\CS-361\\\\prng-service.txt\\");
                myWriter.write("run"); //writes run command to prng.txt file
                myWriter.close();
                Thread.sleep(2000);
                System.out.println("Successfully wrote run command to the prng.txt file.");
                System.out.println("Now check for random number in file...type any number to continue");
                int userChoice = input.nextInt();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);  //end of first file writer
            }
            String numRandom = null;
            try { //writer closed, now reader opens to check prng.txt for number from Prng service
                File myObj = new File("C:\\\\CS-361\\\\prng-service.txt\\"); //creates object to read from file
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    numRandom = data;
                    System.out.println("Number in file is " + numRandom);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("data in file is: " + numRandom);

            try {
                FileWriter myWriter = new FileWriter("C:\\\\CS-361\\\\image-service.txt\\");
                assert numRandom != null;
                myWriter.write(numRandom);
                myWriter.close();
                Thread.sleep(2000);
                System.out.println("Successfully wrote number to image.txt file.");
                System.out.println("Now check to see what pokemon you caught!");
                int userChoice2 = input.nextInt(); //after using types, image.txt is read for image path
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }                                       //number writer end and image path reader starts

            try {
                File myObj = new File("C:\\\\CS-361\\\\image-service.txt\\");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String imagePath = myReader.nextLine();
                    System.out.println("The Pokemon you caught is " + imagePath + " Click link to view!");
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }
        else{
            System.out.println("Thank you for playing...Gotta catch em all!");
        }
    }
}