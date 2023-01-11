/*
 * File:     Calculator
 * Package:  org.dromakin
 * Project:  lambda-calc
 *
 * Created by dromakin as 09.01.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.01.09
 */

package org.dromakin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.*;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = Integer::sum;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
        try {
            /*
             Возникает деление на 0, поэтому имеет смысл обернуть деление в try/catch блок
             */
            return x / y;
        } catch (ArithmeticException e) {
            logger.error(e.getMessage(), e);
            return x;
        }
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = logger::info;
}
