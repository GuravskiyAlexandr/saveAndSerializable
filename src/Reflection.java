/*
       Написать  класс  TextContainer,  который  содержит  в  себе  строку.  С  помощью  механизма  аннотаций  указать
        1)  в  какой  файл  должен  сохраниться  текст
        2)  метод,который  выполнит  сохранение.
        Написать  класс  Saver,  который  сохранит  поле  класса  TextContainer в  указанный  файл.

        Написать  код,  который  сериализирует и  десериализирует в/из  файла  все  значения  полей  класса,
         которые  отмечены  аннотацией  @Save.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class<?> tClass = TextContainer.class;
        if (tClass.isAnnotationPresent(SaveTo.class)) {
            System.out.println("Class Annotation");
            SaveTo saveTo = tClass.getAnnotation(SaveTo.class);
            TextContainer container = new TextContainer();
            container.seve(saveTo.path());

            Field[] fields = tClass.getDeclaredFields(); // получить все поля!!!
            List<String> list = new ArrayList<>();
            for ( Field f : fields) {
                if(f.isAnnotationPresent(Save.class)) {
                    list.add((String) f.get(tClass.newInstance()));
                }
                container.serializable(saveTo.pathSer(), list); // сериализуем
            }
            container.deserialization(saveTo.pathSer()); //     de сериализуем

        }

    }
}
