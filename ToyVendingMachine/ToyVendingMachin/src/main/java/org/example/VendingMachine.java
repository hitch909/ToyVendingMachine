package org.example;

import lombok.*;

import java.io.IOException;
import java.util.*;

@NoArgsConstructor
@ToString
@Setter
@Getter
@AllArgsConstructor
public class VendingMachine extends Toys {

    Toys toys = new Toys();
    ArrayList<Toys> toysArrayList = new ArrayList<>();
    @Getter
    ArrayList<Toys> lotteryList = new ArrayList<>();

    public ArrayList<Toys> createLotteryList(ArrayList<Toys> toysArrayList) throws IOException {
        Random random = new Random();
        while (lotteryList.size() < 3) {
            int randomIndex = random.nextInt(toysArrayList.size());
            lotteryList.add(toysArrayList.get(randomIndex));
        }
        return lotteryList;
    }

    public void showLotteryList() {
        //показать список игрушек
        lotteryList.stream().forEach(System.out::println);
    }

    public void removLotteryList(ArrayList<Toys> lotteryList, Toys toys) {
        lotteryList.remove(toys);
    }

    public void raffleLotteryList() throws IOException {
        // розыгрыш, запись в файл,  удаление из списка выйгрыша, вывод оставшихся игрушек
        ArrayList<Toys> tempArray = new ArrayList<Toys>(createLotteryList(toysArrayList));
        Random random = new Random();
        int randomIndex = 0;
        for (int i = 0; i < tempArray.size(); i++) {
            randomIndex = random.nextInt(tempArray.size());
        }
        System.out.println("\033[35m ваш выигрыш \033[0m" + tempArray.get(randomIndex));

        //запись в файл выйгрыша
        writerLotteryList(tempArray.get(randomIndex));

        // удаление игрушки из списка розыгрыша
        createLotteryList(toysArrayList).remove(tempArray.get(randomIndex));

        //вывод списка розыгрыша
        System.out.println("список разыгрываемых игрушек: ");
        lotteryList.stream().forEach(System.out::println);
    }
}
