import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        initToys(lottery);

        boolean continueLoop = true;

        while (lottery.getToysListSize() != 0 && continueLoop){
            System.out.println("""
                    1 - Учавствовать в розыгрыше
                    2 - Посмотреть вероятность выпадения игрушек
                    3 - Добавить игрушку
                    4 - Выйти
                    """);
            try {
                Scanner sc = new Scanner(System.in);
                switch (sc.nextLine()) {
                    case "1" -> start(lottery);
                    case "2" -> chancePrinter(lottery);
                    case "3" -> addToy(lottery);
                    case "4" -> {
                        System.out.println("Программа завершила работу.");
                        continueLoop = false;
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("Некорректная команда.");
            } catch (NoSuchElementException ex) {
                System.out.println("Вы ничего не ввели!");
            }
        }
    }

    private static void chancePrinter(Lottery lottery) {
        System.out.println("Вероятность выпадения игрушек: ");
        lottery.updateOverallRate().forEach(System.out::println);
    }

    private static void initToys(Lottery lottery) {
        lottery.addToy(new Toy(1, "Water pistol", 1));
        lottery.addToy(new Toy(2, "Car", 3));
        lottery.addToy(new Toy(3, "Sword", 2));
    }

    private static void addToy(Lottery lottery) {
        try  {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите id: ");
            int id = scanner.nextInt();
            System.out.print("Введите название игрушки: ");
            String name = scanner.next();
            System.out.print("Введите количество игрушек: ");
            double rate = scanner.nextDouble();
            lottery.addToy(new Toy(id, name, rate));
            System.out.println("Игрушка добавлена!");

        } catch (InputMismatchException e) {
            System.out.println("Некорректная команда.");
        } catch (NoSuchElementException ex) {
            System.out.println("Вы ничего не ввели!");
        }
    }

    private static void start(Lottery lottery) {
        if (lottery.getToysListSize() == 0){
            System.out.println("Упс! Игрушки закончились.");
        }else System.out.println("Вы выиграли: " + lottery.getToy());
    }

}
