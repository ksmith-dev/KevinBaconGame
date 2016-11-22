package KevinBaconGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kevinsmith on 5/9/16.
 * This program, offers a game to input a name of an actor on the available list to find out how many
 * connections it takes to get back to kevin bacon.
 */
public class BaconNumber
{
    private HashMap<String, String> relationships = new HashMap();

    private int baconNumber;

    /**
     * Constructor, populates a hash map from a file called relationships.txt
     * @author Kevin Smith
     * @version 1.0
     */
    public void BaconNumber()
    {
        try (Scanner scanner = new Scanner(new FileInputStream("relationships.txt")))
        {
            while (scanner.hasNextLine())
            {
                String[] scannerNextLineArray = scanner.nextLine().split(" \\| ");

                this.relationships.put(scannerNextLineArray[0], scannerNextLineArray[1]);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found exception: " + e.getMessage());
        }
    }

    /**
     *
     * @param actor Accepts a string, representing the name of the actor you wish to start your connections from.
     * @param baconNumber Accepts and int, representing the base point for starting connections at.
     * @return Returns an int, representing the number of connections it took to get back to kevin bacon.
     */
    public int getBaconNumber(String actor, int baconNumber)
    {
        this.baconNumber = baconNumber;

        //recursive method
        if (actor.equals("Kevin Bacon"))
        {
            return  this.baconNumber;
        }
        else
        {
            if (relationships.containsKey(actor))
            {
                this.baconNumber++;

                String[] splitString = relationships.get(actor).split(" : ");

                System.out.println(actor + " starred in \"" + splitString[1] + "\" with " + splitString[0] + ".");

                getBaconNumber(splitString[0], this.baconNumber);
            }
        }
        return this.baconNumber;
    }

    /**
     * This method, prints out a list of available actor names, for the user to check connections to kevin bacon too.
     */
    public void printActors()
    {
        try (Scanner scanner = new Scanner(new FileInputStream("actors.txt")))
        {
            while (scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found exception: " + e.getMessage());
        }
    }
}