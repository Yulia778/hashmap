package com.metanit;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        readACommandFromConsole();
    }


    Map<String, String> map = new HashMap<>();

    private static AvailableCommands readACommandFromConsole() {
        AvailableCommands.getValues();
        String val= AvailableCommands.getValues();
        System.out.println(val);
        System.out.println("Type please next command.");
        var reader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            //throw new RuntimeException("Cannot read line from console");
            try {
                line = reader.readLine().trim();
                if (line.matches("[0-9]+")) {
                    try {
                        return AvailableCommands.findCommandByNumber(1);
                    } catch (CommandException commandException) {
                        commandException.printStackTrace();
                    }
                } else {
                    System.out.println("Command is invalid!");
                }
            } catch (IOException a) {
                throw new RuntimeException("Failed to read next command from console.", a);
            } catch (IllegalArgumentException Throwable) {
                System.out.println(" Type please either command name in uppercase, or it's numeric code. ");

            }
        }
        return null;
    }

    }





