import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
       Написать  класс  TextContainer,  который  содержит  в  себе  строку.  С  помощью  механизма  аннотаций  указать
        1)  в  какой  файл  должен  сохраниться  текст
        2)  метод,который  выполнит  сохранение.
        Написать  класс  Saver,  который  сохранит  поле  класса  TextContainer в  указанный  файл.

        Написать  код,  который  сериализирует и  десериализируетв/из  файла  все  значения  полей  класса,
         которые  отмечены  аннотацией  @Save.

*/
@SaveTo(path = "text.txt", pathSer = "text2.txt")
public class TextContainer {
    @Save
    String textSerializable1 = "hi i sun";
    @Save
    String textSerializable2 = "hi i rain";
    String textSerializable3 = "hi i rain";

    @Saver
    public void seve(String path){
        String text = "To be or not to be here is the question";
        try (FileWriter writer = new FileWriter(path)) {

            writer.write(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void serializable(String path, List list){
        List<TextSerializable> textList = new ArrayList<>();
        for (Object  o: list){
            textList.add(new TextSerializable(o.toString()));
        }
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(textList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deserialization(String path){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            List<TextSerializable> list = (List<TextSerializable>) inputStream.readObject();
          for (TextSerializable t : list){
              System.out.println(t.text);
          }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
