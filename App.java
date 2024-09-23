package com.teacuptechsystems.challenge;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        CeilingFan fan = new CeilingFan();
        try (
            Scanner scanner = new Scanner(System.in)
        ) {
            String input = null;
            System.out.println("Welcome!");
            System.out.println();
            System.out.println("To pull the speed cord, enter 'S' (no quotes).");
            System.out.println("To pull the direction cord, enter 'D' (no quotes).");
            System.out.println("To check the current settings, without any changes, enter 'I' (no quotes).");
            System.out.println("To exit, enter 'exit', 'quit', 'E', or 'Q' (no quotes).");
            System.out.println();
            System.out.println("Initial setting is as follows:");
            printCurrentState(fan);
            do {
                System.out.println("Input: ");
                input = scanner.nextLine();
                switch (input.toLowerCase()) {
                    case "s":
                        fan.pullSpeedCord();
                        printCurrentState(fan);
                        break;
                    case "d":
                        fan.pullDirectionCord();
                        printCurrentState(fan);
                        break;
                    case "i":
                        printCurrentState(fan);
                        break;
                    case "e":
                    case "q":
                    case "exit":
                    case "quit":
                        input = "q";
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            } while (!"q".equalsIgnoreCase(input));
        } catch (NoSuchElementException|IllegalStateException ex) {
            System.out.println("Quitting... There was some error reading input.");
        }
    }

    public static void printCurrentState(CeilingFan fan) {
        System.out.println();
        System.out.println("On/Off: " + (fan.isOn() ? "ON" : "OFF"));
        System.out.println("Speed: " + fan.getSpeed());
        System.out.println("Direction: " + fan.getDirection());
        System.out.println();
    }
}

