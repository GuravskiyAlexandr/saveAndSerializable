/*
       Написать  класс  TextContainer,  который  содержит  в  себе  строку.  С  помощью  механизма  аннотаций  указать
        1)  в  какой  файл  должен  сохраниться  текст
        2)  метод,который  выполнит  сохранение.
        Написать  класс  Saver,  который  сохранит  поле  класса  TextContainer в  указанный  файл.

        Написать  код,  который  сериализируети  десериализируетв/из  файла  все  значения  полей  класса,
         которые  отмечены  аннотацией  @Save.
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Saver {
}
