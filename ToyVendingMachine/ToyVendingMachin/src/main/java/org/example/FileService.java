package org.example;

import java.io.*;
import java.util.*;

public class FileService {
    public void writerListToy(Toys toys) throws IOException {
        //запись в файл игрушки
        try (FileWriter fw = new FileWriter("file.txt", true)) {
            fw.write(" \n" + toys.toString());
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readerListToy() throws IOException {
        //вывод записанных в файл игрушек
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader("file.txt"));
        String line = bf.readLine();
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();
        String[] array = listOfStrings.toArray(new String[0]);
        for (String str : array) {
            System.out.println(str);
        }
    }


    public void writerLotteryList(Toys toys) throws IOException {
        //запись в файл разыгрываемых игрушек
        try (FileWriter fw = new FileWriter("lotteryList.txt", true)) {
            fw.write(" \n" + toys.toString());
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readerLotteryList() throws IOException {
        //вывод записанных в файл разыгрываемых игрушек
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader("lotteryList.txt"));
        String line = bf.readLine();
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();
        String[] array = listOfStrings.toArray(new String[0]);
        for (String str : array) {
            System.out.println(str);
        }
    }

}
