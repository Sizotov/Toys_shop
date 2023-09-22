import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        toyShop.addToy(new Toy(1, "Мяч", 20, 200));
        toyShop.addToy(new Toy(2, "Кукла", 30, 300));
        toyShop.addToy(new Toy(3,"Машинка", 40, 400));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println("Выберите действие: ");
            System.out.println("1. Розыгрыш игрушки");
            System.out.println("2. Добавление новой игрушки");
            System.out.println("3. Изменение веса (частоты выпадения) игрушки");
            System.out.println("4. Сохранить список игрушек в файл");
            System.out.println("5. Загрузить список игрушек из файла");
            System.out.println("6. Выйти");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    toyShop.drawToys();
                    break;
                case 2:
                    System.out.println("Введите id новой игрушки: ");
                    int id = scanner.nextInt();
                    System.out.println("Введите название новой игрушки: ");
                    String name = scanner.next();
                    System.out.println("Введите количество новой игрушки: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите вес (частоту выпадения) новой игрушки: ");
                    double weight = scanner.nextDouble();
                    toyShop.addToy(new Toy(id, name,quantity, weight));
                    break;
                case 3:
                    System.out.println("Введите id игрушки, у которой необходимо изменить вес: ");
                    int toyId = scanner.nextInt();
                    System.out.println("Введите новый вес (частоту выпадения) игрушки: ");
                    double newWeight = scanner.nextDouble();
                    toyShop.setToyWeight(toyId, newWeight);
                    break;
                case 4:
                    System.out.println("Введите имя файла для сохранения списка игрушек: ");
                    String saveFilename = scanner.next();
                    toyShop.saveToysToFile(saveFilename);
                    break;
                case 5:
                    System.out.println("Введите имя файла для загрузки списка игрушек: ");
                    String loadFilename = scanner.next();
                    toyShop.saveToysToFile(loadFilename);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
        scanner.close();
    }
}
