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
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class DisplayFriends {

    public static String[] displayFriends() {
        try {
            String nameNumberString;
            String name;
            long number;
            List<String> friendList = new ArrayList<>();

            File file = new File("contactosAmigos.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit = nameNumberString.split("!");
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
                friendList.add(name + ": " + number);
            }

            raf.close();
            return friendList.toArray(new String[friendList.size()]);
        } catch (Exception e) {
            String[] error = { e.getMessage() };
            return error;
        }
    }
}