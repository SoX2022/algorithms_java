package Homework.Exeptions.Homework_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
        Фамилия Имя Отчество датарождения номертелефона пол

        Форматы данных:
        фамилия, имя, отчество - строки
        датарождения - строка формата dd.mm.yyyy
        номертелефона - строка в виде семизначного числа
        пол - символ латиницей f или m.

        Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

        Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

        Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

        <Фамилия><Имя><Отчество><датарождения><номертелефона><пол>

        Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

        Не забудьте закрыть соединение с файлом.

        При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
        */
        boolean dataIsNotOK = true;
        String userInput;
        Path path;
        Boolean notStop = true;

        while (notStop) {
            do {
                userInput = getUserInput("Enter values splited with ' '.\nLastname, Firstname, Surname, Birthday, Phone number, Gender");
        
                switch (userInputChecker(userInput)) {
                    case 1: // User entered to much data
                        System.out.println("To much data. Error code '1'");
                        break;
                    case -1: // User entered not innough data
                        System.out.println("Not innough data. Error code '-1'");
                        break;
                    default:
                        dataIsNotOK = dataFormatChecker(userInput);
                        break;
                }
        
                if (dataIsNotOK) {
                    System.out.println("Please, try again.");;
                }
            } while (dataIsNotOK);
    
            path = Paths.get(System.getProperty("user.dir") + "\\Homework\\Exeptions\\Homework_03\\" + getName(userInput) + ".txt");

            saveInFile(path, userInput + "\n");
            userInput = getUserInput("Do you want to add new data?\nEnter \"NO\" to stop or \"ENTER\" to continue: ");

            if (userInput.toLowerCase().equals("no")) {
                notStop = false;
            }
        }
    }


    public static String getUserInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int userInputChecker(String userInput) {
        int dataLenght = userInput.split(" ").length;
        if (dataLenght == 6) {
            return 0;
        } else if (dataLenght > 6) {
            return 1;
        }
        return -1;
    }

    public static boolean dataFormatChecker (String userInput) {
        String[] array = userInput.split(" ");
        try {
            dateFormatChecker(array[3]);
            phoneNumberFormatChecker(array[4]);
            genderFormatChecker(array[5]);
            return false;
        } catch (DateFormatExeption e) {
            System.out.println(e.getMessage());
        } catch (PhoneNumberFormatExeption e) {
            System.out.println(e.getMessage());
        } catch (GenderFormatExeption e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private static void dateFormatChecker (String date) throws DateFormatExeption {
        if (!date.matches("^(\\d{2}).(\\d{2}).(\\d{4})$")) {
            throw new DateFormatExeption("Invalid date format");
        }
    }

    private static void phoneNumberFormatChecker (String phoneNumber) throws PhoneNumberFormatExeption {
        if (phoneNumber.length() != 7) {
            throw new PhoneNumberFormatExeption("Invalid phone number format");
        }
    }

    private static void genderFormatChecker (String gender) throws GenderFormatExeption {
        if (gender.length() == 1 && !gender.equals("m") && !gender.equals("f")) {
            throw new GenderFormatExeption("Invalid gender");
        }
    }

    public static void saveInFile(Path path, String string) {
        try {
            Files.writeString(path, string, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                Files.writeString(path, string);
                System.out.println("\nNew file created successfully.");
            } catch (IOException e1) {
                System.out.println(e.getMessage());
                e1.printStackTrace();
            }
        }
    }

    public static String getName(String userInput) {
        String[] array = userInput.split(" ");
        return array[0];
    }

}
