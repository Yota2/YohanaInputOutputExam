package be.intechbrussel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Files.createFile;

public class MainApp  implements Serializable{
    public static void main(String[] args) throws IOException {
        // creating a Path
        Path messagePath = Path.of("../../FromYohanaToPearl/message.txt");
        Path animalPath = Path.of("../../FromYohanaToPearl/message.txt");

        try {
            if (!Files.exists(messagePath.getParent()))
                Files.createDirectory(messagePath.getParent());
            if (Files.notExists(messagePath))
                Files.createFile(messagePath);
            if (Files.notExists(animalPath))
                Files.createFile(animalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fileWriter = new FileWriter(String.valueOf(messagePath));
            fileWriter.write("The  purpose of our life is to be happy!!!");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(messagePath)))){
            String line=null;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       Dog dog = new Dog("Buchiy",true);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(animalPath.toString()))) {
            objectOutputStream.writeObject(dog);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(animalPath.toString()))) {
            String text = inputStream.readObject().toString();
            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}