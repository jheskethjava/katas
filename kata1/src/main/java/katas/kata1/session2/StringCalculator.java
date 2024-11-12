package katas.kata1.session2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public Integer add(String numbers) {

        List<String> splitNumbers = splitNumbers(numbers);

        validateNoNegatives(splitNumbers);

        return splitNumbers
                .stream()
                .map(this::toNumber)
                .reduce((i, j) -> i + j)
                .orElse(0);
    }

    private void validateNoNegatives(List<String> splitNumbers) {
        String negatives = splitNumbers.stream()
                .filter(s -> s.startsWith("-"))
                .collect(Collectors.joining(","));

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
    }

    private List<String> splitNumbers(String numbers) {
        Pattern pattern = Pattern.compile("^\\/\\/(.)\n");
        String delimiters = "[,\n]";
        Matcher matcher = pattern.matcher(numbers);
        if (matcher.find()) {
            delimiters = matcher.group(1);
        }
        return Arrays.asList(numbers.split(delimiters)).stream()
                .map(String::trim).toList();
    }

    private Integer toNumber(String s) {
        try {
            Integer i = Integer.valueOf(s.trim());
            if (i > 1000) {
                i = 0;
            }
            return i;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
