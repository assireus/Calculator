

import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> romanNumber = new TreeMap<>(); //Класс TreeMap позволит дать значение каждой арабской цифре
    TreeMap<Integer, String> arabianNumber = new TreeMap<>();

    public Converter() {
        romanNumber.put('I', 1); //Сопостовляем римские цифры с арабским аналогом
        romanNumber.put('V', 5);
        romanNumber.put('X', 10);
        romanNumber.put('L', 50);
        romanNumber.put('C', 100);
        romanNumber.put('D', 500);
        romanNumber.put('M', 1000);
        arabianNumber.put(1000, "M"); //Обратно из римских в арабские
        arabianNumber.put(900, "CM");
        arabianNumber.put(500, "D");
        arabianNumber.put(400, "CD");
        arabianNumber.put(100, "C");
        arabianNumber.put(90, "XC");
        arabianNumber.put(50, "L");
        arabianNumber.put(40, "XL");
        arabianNumber.put(10, "X");
        arabianNumber.put(9, "IX");
        arabianNumber.put(5, "V");
        arabianNumber.put(4, "IV");
        arabianNumber.put(1, "I");

    }

    public boolean isRoman(String number) {
        return romanNumber.containsKey(number.charAt(0));//Возвращение римской цифры
    }

    public String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianNumber.floorKey(number);//Подбираем ближайший ключ
            roman += arabianNumber.get(arabianKey);//Конвертируем ключ в римское число
            number -= arabianKey;//Вычитаем из числа ближайший ключ
        } while (number != 0);//Если цикл закончился - число сконвертированно
        return roman;//Возвращаем римское число
    }
    public int romanToInt(String s) {
        int m = s.length() - 1;//Последний символ римского числа
        char[] arr = s.toCharArray(); //Создаем масив символов римского числа
        int arabian;
        int result = romanNumber.get(arr[m]);//Конвертируем последний символ в арабское число
        for (int i = m - 1; i >= 0; i--) {//Запуск цикла начиная со второго символа с обратной стороны
            arabian = romanNumber.get(arr[i]);//Конвертируем символ в арабское число

            if (arabian < romanNumber.get(arr[i + 1])) {//Сравниваем текущее ччисло с предыдущим
                result -= arabian;//Если символ левее меньше того что павее мы вычитаем
            } else {
                result += arabian;//Если символ левее больше того что павее мы складываем
            }
        }
        return result;//Возвращаем арабское число
    }
}