import java.io.*;
import java.util.Scanner;


public class DisplayImage {
    public static void main(String[] args) {
        String currentData = "";
        String squirtle = "https://pixabay.com/photos/small-cute-toy-figurine-painted-4021854/";
        String pikachu = "https://pixabay.com/photos/miniature-pikachu-pokemon-character-3720485/";
        String cubone = "https://pixabay.com/photos/pop-funko-pokemon-toy-karakara-5475389/";
        String mewtwo = "https://pixabay.com/photos/toys-pokemon-volcano-lightning-5354012/";
        String vulpix = "https://pixabay.com/photos/pop-funko-pokemon-toy-vulpix-5475336/";
        String pokemonChoice = "";

        //System.out.println("number is " + n);
        try {
            File myObj = new File("C:\\\\CS-361\\\\image-service.txt\\"); //creates object to read from file
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("number in file is " + data);
                currentData = data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("data in file is: " + currentData);
        int pokemon;
        try {
            pokemon = Integer.parseInt(currentData);
        }
        catch (NumberFormatException e) {
            pokemon = 0;
        }
        String fileName = "C:\\\\CS-361\\\\image-service.txt\\";
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();                                     //PrintWriter clears file data
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (pokemon) {
            case 1: pokemonChoice = squirtle;
            break;
            case 2: pokemonChoice = pikachu;
            break;
            case 3: pokemonChoice = cubone;
            break;
            case 4: pokemonChoice = mewtwo;
            break;
            case 5: pokemonChoice = vulpix;
            break;
            default: pokemonChoice = "invalid choice";
        }
        //System.out.println("The pokemon you caught is: " + pokemonChoice); //gives output of pokemon caught

        try {
            FileWriter myWriter = new FileWriter("C:\\\\CS-361\\\\image-service.txt\\");
            myWriter.write(pokemonChoice);
            myWriter.close();
            Thread.sleep(2000);
            System.out.println("Successfully wrote image path to image.txt file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}