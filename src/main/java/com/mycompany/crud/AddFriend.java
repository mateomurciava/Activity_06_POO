/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

/**
 *
 * @author 1
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AddFriend {

    public static String addFriend(String newName, long newNumber) {
        try {
            String nameNumberString;
            String name;
            long number;
            String result;

            File file = new File("contactosAmigos.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit = nameNumberString.split("!");
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                if (name.equals(newName) || number == newNumber) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                nameNumberString = newName + "!" + String.valueOf(newNumber);
                raf.writeBytes(nameNumberString);
                raf.writeBytes(System.lineSeparator());
                result = "Friend added!";
                raf.close();
            } else {
                raf.close();
                result = "Name or number already exists.";
            }
            return result;
        } catch (IOException ioe) {
            return "Error: " + ioe.getMessage();
        }
    }
}
