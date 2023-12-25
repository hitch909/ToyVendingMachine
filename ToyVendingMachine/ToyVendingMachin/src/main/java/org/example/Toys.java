package org.example;

import lombok.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Toys extends FileService {

    private String nameToy;
    private Integer weightToy;

    public Toys(String nameToy, Integer weightToy) {
        this.nameToy = nameToy;
        this.weightToy = weightToy;
    }


    public Toys addToy(Toys toys) throws IOException {
        //создание игрушки и запись в файл
        Scanner scanner = new Scanner(System.in);
        System.out.print("введите название игрушки:  ");
        toys.setNameToy(scanner.nextLine());

        System.out.print("введите массу игрушки: ");
        toys.setWeightToy(scanner.nextInt());

        writerListToy(new Toys(toys.getNameToy(), toys.getWeightToy()));
        return new Toys(toys.getNameToy(), toys.getWeightToy());

    }

    public void addListToys(Toys toys, ArrayList<Toys> toysArrayList) throws IOException {
        toysArrayList.add(addToy(toys));
    }


    public void removeToy(Toys toys, ArrayList<Toys> toysArrayList) {
        //удаление игрушки из списка
        toysArrayList.remove(toys);
    }

    public void showListToys(ArrayList<Toys> toysArrayList) {
        //показать список игрушек
        toysArrayList.forEach(System.out::println);
    }
}
