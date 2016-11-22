package KevinBaconGame;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created on 5/9/2016.
 * The program returns a number of connections to kevin bacon from
 * a list of actors.
 * @author Kevin Smith
 * @version 1.0
 */
public class KevinBaconDriver
{
    private static BaconNumber game = new BaconNumber();
    private static Scanner scanner = new Scanner(System.in);
    private static String usrActorName;

    /**
     * This driver class, utilizes the BaconNumber class.
     * @param args Accepts string arguments.
     */
    public static void main(String[] args)
    {
        game.BaconNumber();
        welcomeMessage();
        game.printActors();
        processUsrInput();
    }
    private static void welcomeMessage()
    {
        System.out.println("Welcome to the Kevin Bacon game!");
        System.out.println();
        System.out.println("Please enter a person below:");
    }

    private static void processUsrInput()
    {
        try
        {
            usrActorName = scanner.nextLine();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Input mismatch exception: " + e.getMessage());
        }

        //get bacon number
        System.out.println("The bacon number for " + usrActorName + " is " + game.getBaconNumber(usrActorName, 0));
        continueCheck();
    }

    private static void continueCheck()
    {
        System.out.println("Enter \"yes\" to continue the game!");

        try
        {
            String continueBool = scanner.nextLine().toLowerCase();

            if (continueBool.equals("yes"))
            {
                welcomeMessage();
                game.printActors();
                processUsrInput();
            }
            else
            {
                System.exit(0);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Input mismatch exception: " + e.getMessage());
        }
    }
}
