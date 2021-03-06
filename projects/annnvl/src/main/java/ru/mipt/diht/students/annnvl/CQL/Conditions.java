package ru.mipt.diht.students.annnvl.CQL;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Where clause conditions.
 */
public class Conditions<T> {

    /**
     * Matches string result of expression against regexp pattern.
     *
     * @param expression expression result to match
     * @param regexp     pattern to match to
     * @param <T>        source object type
     * @return
     */
    public static <T> Predicate<T> rlike(Function<T, String> expression, String regexp) {
        return element -> expression.apply(element).matches(regexp);
    }

    /**
     * Matches string result of expression against SQL like pattern.
     *
     * @param expression expression result to match
     * @param pattern    pattern to match to
     * @param <T>        source object type
     * @return
     */
    public static <T> Predicate<T> like(Function<T, String> expression, String pattern) {
        String newpattern = pattern.toLowerCase();
        newpattern = newpattern.replace(".", "\\.").replace("?", ".").replace("%", ".*");
        return rlike(expression, newpattern);
    }

}
