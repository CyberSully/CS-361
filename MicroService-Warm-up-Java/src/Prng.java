import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Prng {
    public static void main(String[] args) {
        String currentData = "";
        //System.out.println("number is " + n);
        try {
            File myObj = new File("C:\\\\CS-361\\\\prng-service.txt\\"); //creates object to read from file
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                currentData = data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("data in file is: " + currentData);

        if (currentData.equals("run")) {
            String fileName = "C:\\\\CS-361\\\\prng-service.txt\\";

            try {
                PrintWriter pw = new PrintWriter(fileName);
                pw.close();                                     //printwriter clears file data
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                FileWriter myWriter = new FileWriter("C:\\\\CS-361\\\\prng-service.txt\\");
                int n = randomizer(); //calls method to generate random number
                myWriter.write(String.valueOf(n)); //converts to string to write number to prng.txt file
                myWriter.close();
                System.out.println("Successfully wrote random number " + n + " to file after removing run command");
                Thread.sleep(2000);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        else {
            System.out.println("no run command from UI microservice"); //if no run command in prng.text then this is displayed
        }

        //write random number to file here
    }

    public static int randomizer() { //generates 1-5 number
        Random random = new Random();
        int num = random.nextInt(5);
        if (num == 0) {
            num += 1;
        }
        return num;
    }
}
