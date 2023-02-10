package calculator;


import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Converter converter =  new Converter();
        Scanner scan = new Scanner(System.in);
        int a, b;
        System.out.println("Введите выражение типа a + b");

        String n = scan.nextLine();
        String[] operations = {"+", "-", "*", "/"};//Массив со знаками дейсвий
        String[] arabian = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};//Доступные арабские числа
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};//Доступные римские числа
        String[] words = n.split(" ");//Разделаем выражение на части
        if(words.length != 3){//Проверка на корректность выражения
            System.out.println("Должно быть два операнда и 1 знак");
            return;
        }

        int operationIndex=-1;
        for (int i = 0; i < operations.length; i++) {//Проверка знака выражения
            if(n.contains(operations[i])){
                operationIndex = i;
                break;
            }
        }
        if(operationIndex==-1){
            System.out.println("Неправильный знак");
            return;
        }
        if(converter.isRoman(words[0]) == converter.isRoman(words[2])) {//Проверка на формат чисел
            boolean isRoman = converter.isRoman(words[0]);
            if (isRoman) {
                a = converter.romanToInt(words[0]);//Конвертируем числа в int для выполнения операции
                b = converter.romanToInt(words[2]);
                boolean l = Arrays.asList(roman).contains(words[0]);//Проверяем диапазон введенных римских чисел
                boolean m = Arrays.asList(roman).contains(words[2]);
                if (l == false) {
                    System.out.println("Первое значение в неправильном диапазоне");
                    return;
                }
                if (m == false) {
                    System.out.println("Второе значение в неправильном диапазоне");
                    return;
                }
                int result;
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
                    System.out.println(converter.intToRoman(result));//Конвертируем полученный результат в римское число и выводим его
                }
                else {
                    System.out.println("Результат работы с римскими числами может быть только положительный");
                }
            }
            else {
                a = Integer.parseInt(words[0]);//Конвертируем числа в int для выполнения операции
                b = Integer.parseInt(words[2]);
                boolean l = Arrays.asList(arabian).contains(words[0]);//Проверяем диапазон введенных арабских чисел
                boolean m = Arrays.asList(arabian).contains(words[2]);
                if (l == false) {
                    System.out.println("Первое значение в неправильном диапазоне");
                    return;
                }
                if (m == false) {
                    System.out.println("Второе значение в неправильном диапазоне");
                    return;
                }
                int result;
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
                System.out.println(result);//Выводим результат операции с арабскими числами
            }
        }
        else
        {
            System.out.println("Числа должны быть в одном формате");
        }
    }
}