package ru.gb.group4546_5984;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.gb.group4546_5984.person.Person;

/**
 * Основной класс к домашнему заданию:
 * 1. Создание одного объекта класса Person;
 * 2. Вывод в консоль вновь созданного объекта;
 * 3. Сериализация объекта в формат JSON;
 * 4. Вывод в консоль строки формата JSON;
 * 5. Десериализация объекта класса Person из строки формата JSON;
 * 6. Вывод в консоль десериализованного объекта класса Person
 * 7.Сравнение объектов и их хэшей до и после сериализации;
 * 8. Вывод результатов сравнения в консоль.
 */
public class MavenAppMain {
    public static void main(String[] args) {
        Person person = new Person("Иван", "Иванов", 25);
        System.out.println("\nВновь созданная персона: \n" + person);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String personToGson = gson.toJson(person);
        System.out.println("\nОбект сериализованный в формат GSON:\n" + personToGson);

        Person personFromGson = gson.fromJson(personToGson, Person.class);
        System.out.println("\nДесериализованная персона:\n" + personFromGson);

        boolean isEqual = person.equals(personFromGson);
        System.out.println("\nОбъекты до сериализации и после сериализации равны: " + isEqual);

        isEqual = person.hashCode() == personFromGson.hashCode();
        System.out.println("\nХэшкоды бъектов до сериализации и после сериализации равны: " + isEqual);
    }
}
