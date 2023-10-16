


import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение типа a + b");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        Converter converter =  new Converter();
        int result;
        int a, b;
        String[] operations = {"+", "-", "*", "/"};//Массив со знаками дейсвий
        String[] arabian = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};//Доступные арабские числа
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};//Доступные римские числа
        String[] words = input.split("[+\\-*/]");//Разделяем полученную строку
        if(words.length != 2){//Проверка на корректность выражения
            throw new Exception("Должны быть 2 операнда и один оператор типа +, -, *, /.");
        }

        int operationIndex=-1;
        for (int i = 0; i < operations.length; i++) {//Проверка знака выражения
            if(input.contains(operations[i])){
                operationIndex = i;
                break;
            }
        }
        if(converter.isRoman(words[0]) == converter.isRoman(words[1])) {//Проверка на формат чисел
            boolean isRoman = converter.isRoman(words[0]);
            if (isRoman) {
                a = converter.romanToInt(words[0]);//Конвертируем числа в int для выполнения операции
                b = converter.romanToInt(words[1]);
                boolean l = Arrays.asList(roman).contains(words[0]);//Проверяем диапазон введенных римских чисел
                boolean m = Arrays.asList(roman).contains(words[1]);
                if (l == false) {
                    throw new Exception("Первое значение в неправильном диапазоне.");
                }
                if (m == false) {
                    throw new Exception("Второе значение в неправильном диапазоне.");
                }
                switch (operations[operationIndex]) {//Определяем знак операции и выполняем ее
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default:
                        result = a / b;
                        break;
                }
                if (result > 0) {//Проверка на знак римского числа
                    input = converter.intToRoman(result);//Конвертируем полученный результат в римское число
                    return input;
                }
                else {
                    throw new Exception("Результат работы с римскими числами может быть только положительный.");
                }
            }
            else {
                a = Integer.parseInt(words[0]);//Конвертируем числа в int для выполнения операции
                b = Integer.parseInt(words[1]);
                boolean l = Arrays.asList(arabian).contains(words[0]);//Проверяем диапазон введенных арабских чисел
                boolean m = Arrays.asList(arabian).contains(words[1]);
                if (l == false) {
                    throw new Exception("Первое значение в неправильном диапазоне.");
                }
                if (m == false) {
                    throw new Exception("Второе значение в неправильном диапазоне.");
                }
                switch (operations[operationIndex]) {//Определяем знак операции и выполняем ее
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default:
                        result = a / b;
                        break;
                }
                input = String.valueOf(result);//Конвертируем результат в STRING
                return input;
            }
        }
        else
        {
            throw new Exception("Числа должны быть в одном формате");
        }
    }
}