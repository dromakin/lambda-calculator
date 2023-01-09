package org.dromakin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = 0;
        try {
            /*
             Возникает деление на 0, поэтому имеет смысл обернуть деление в try/catch блок
             */
            c = calc.devide.apply(a, b);
        } catch (ArithmeticException e) {
            logger.error(e.getMessage(), e);
        } finally {
            // можно исправить так, но это зависит от бизнес задачи
            c = calc.devide.apply(a, b == 0 ? b + 1 : b);
        }

        calc.println.accept(c);
    }
}