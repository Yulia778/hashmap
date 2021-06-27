package com.metanit;

import static java.lang.String.format;

public enum AvailableCommands {
    EXIT_COMMAND(0),
    ADD_COMMANDS(1),
    GET_BY_KEY_COMMAND(2),
    GET_ALL_COMMAND(3);

    private final int number;

    AvailableCommands(Integer number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    public static AvailableCommands findCommandByNumber(int number) throws CommandException {
        for (AvailableCommands command : values()) {
            if (number == command.getNumber()) {
                return command;
            }
        }
        throw new CommandException(String.format("Not found menu action with code: %s.", number));


    }public static String getValues(){
        String number = AvailableCommands.ADD_COMMANDS.getNumber()+"";
        return number;

    }
}
