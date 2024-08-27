package katas.kata1.session1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

class StringCalculator {
    int add(String numbers) {
        int i = 0;

        try {
            Matcher m = Pattern.compile("^//(.+)\n").matcher(numbers);
            String simpleDelimiter = ",";
            if (m.find()) {
                String customDelimiter = m.group(1);
                numbers = numbers.replace(m.group(), "");
                numbers = numbers.replace(customDelimiter, simpleDelimiter);
            }
            numbers = numbers.replace("\n", simpleDelimiter);
            i = Arrays.asList(numbers.split(simpleDelimiter)).stream()
                    .filter(StringUtils::isNotEmpty)
                    .mapToInt(Integer::valueOf).sum();
        } catch (NumberFormatException nfe) {
            System.out.println(String.format("oops, input %s is not a number", numbers));
        }

        return i;
    }

}
