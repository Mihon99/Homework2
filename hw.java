import java.io.File; // импортируем класс для работы с файлами
import java.io.FileNotFoundException; // импортируем класс обработки ошибки отсутствия файла
import java.util.Scanner; // импортируем класс для чтения информации из консоли, файла и т.п.
import java.io.PrintWriter; // Импортируем класс записи в файл

    public class hw {
    public static void main(String[] args) throws FileNotFoundException { 
        int[] array = readFile();
        int a = array[0];
        int b = array[1];
        if(a == 0 && b == 0) writeFile("Не определено"); // записать в файл "Не определено"
        else if(b < 0) writeFile(negativPow(a, b)); // Вычисляем и записываем в случае отрицательной степени
        else writeFile(positivPow(a, b)); // Вычисляем и записываем в случае положительной степени
    }

    // Метод считывания файла:
    public static int[] readFile() throws FileNotFoundException {// FileNotFoundException Выдаст ошибку при отсутствии файла
        File file = new File("input.txt"); // создаем класс файл - присвоим файл некой сущности)
        Scanner scanner = new Scanner(file); // На вход классу сканер подаем файл
        String line = scanner.nextLine(); // присвоить строковой переменной следующую строку
        int[] intArray = new int[2];
        String[] stringArray = line.split(" "); // Создали массив из строки разбив по пробелам
        if(stringArray[0] == "a"){
            intArray[0] = Integer.parseInt(stringArray[1]); // Преобразуем в число второй элемент строкового массива и ставим его в числовой массив
            stringArray = scanner.nextLine().split(" "); // Создали массив из прочтенной следующей строки разбив по пробелам минуя переменную line
            intArray[1] = Integer.parseInt(stringArray[1]); // Преобразуем в число второй элемент строкового массива и ставим его в числовой массив
        }
        else {
            intArray[1] = Integer.parseInt(stringArray[1]);
            stringArray = scanner.nextLine().split(" ");
            intArray[0] = Integer.parseInt(stringArray[1]);
        }
        // scanner.hasNextLine() - проверяет, есть ли несчитанные строки
        scanner.close(); // Закрыли сканер
        return intArray;
    }

    // ВЫчисление положительной степени
    public static String positivPow(int a, int b) {
        int temp = 1;
        String result = "";
        for(int i = 0; i < b; i++){
            temp *= a;
        }
        result = String.valueOf(temp);
        return result;
    }

    // Вычисление отрицательной степени
    public static String negativPow(int a, int b) {
        double temp = 1;
        String result = "";
        for(int i = 0; i < b * -1; i++){
            temp *= a; 
        }
        result = String.valueOf(1/temp);
        return result;
    }

    // Метод записи в файл:
    public static void writeFile(String string) throws FileNotFoundException {
        File file = new File("output.txt"); // Создаем объект класса "файл"
        PrintWriter pw = new PrintWriter(file); // Создаем объект класса записи в файл "PrintWriter"
        pw.println(string); // Метод (команда) записи в файл
        pw.close(); // закрываем объект класса "PrintWriter" (файл) 
    }
}