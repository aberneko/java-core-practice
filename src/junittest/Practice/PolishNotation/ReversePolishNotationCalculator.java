package junittest.Practice.PolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotationCalculator {

    public int calculatePolishNotation(String str) {
        String[] parts = str.split(" ");  // разбивает строку на отдельные слова/символы по пробелу.
        Deque<Integer> numbers = new ArrayDeque<>(); // деко
        int index = 0;

        while (index != parts.length) { // Перебирает массив parts от элемента 0 до самого конца (index != parts.length).


            if (parts[index].isBlank()) { // : Если попался пустой символ или пробел, .isBlank() говорит true, мы делаем index++ и пропускаем шаг (continue).
                index++;
                continue;
            }

            if (isOperation(parts[index])) {
                int operandOne = numbers.pop();
                int operandTwo = numbers.pop();

                if (parts[index].equals("+")) {
                    numbers.push(operandOne + operandTwo);
                } else if (parts[index].equals("-")) {
                    numbers.push(operandTwo - operandOne);
                } else if (parts[index].equals("*")) {
                    numbers.push(operandOne * operandTwo);
                }

            } else {
                numbers.push(Integer.parseInt(parts[index])); // Если это число (а не оператор), попадаем в else - переводим строку в число через Integer.parseInt() - кладём в деку (numbers.push()).
            }

            index++;
        }

        return numbers.pop();
    }

    private boolean isOperation(String part) {
        return part.equals("+")
                || part.equals("-")
                || part.equals("*");
    }
}