import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;

    public ToyShop(){
        toys = new ArrayList<>();
    }
    public void addToy(Toy toy){
        toys.add(toy);
    }

    public void setToyWeight(int id, double weight) {
        for(Toy toy : toys){
            if(toy.getId() == id){
                toy.setWeight(weight);
                break;
            }
        }
    }
    public void drawToys(){
        if(toys.isEmpty()){
            System.out.println("В магазине нет игрушек");
            return;
        }
        double totalWeight = 0;
        for(Toy toy : toys){
            totalWeight += toy.getWeight();
        }
        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;

        double currentWeight = 0;
        Toy chosenToy = null;

        for(Toy toy : toys){
            currentWeight += toy.getWeight();
            if (randomNumber <= currentWeight){
                chosenToy = toy;
                break;
            }
        }
        if (chosenToy != null){
            System.out.println("Вы выиграли игрушку: " + chosenToy.getName());
            if(chosenToy.getQuantity() > 0){
                chosenToy.setQuantity(chosenToy.getQuantity() - 1);
            } else {
                System.out.println("Данная игрушка закончилась.");
            } else {
                System.out.println("Ничего не выиграли.");
            }

        }

    }
    public void saveToysToFile(String filename){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(toys);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Список игрушек успешно сохранен в файл " + filename);
        } catch (IOException){
            System.out.println("Ошибка при сохранении списка игуршек в файл " + filename);
            e.printStackTrace();
        }
    }
    public void loadToysFromFile(String filename){
        try {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        toys = (List <Toy>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("Список игрушек успешно загружен из файла " + filename);
    } catch (IOException | ClassNotFoundException e){
            System.out.println("Ошибка при загрузке списка игрушек из файла " + filename);
            e.printStackTrace();
        }

}
