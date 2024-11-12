package katas.kata2.session1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

class LettersList {

    public String listLetters(String input) {
        List<String> words = Arrays.asList(input.split(",")).stream()
                .map(String::trim).toList();

        Map<String, Set<String>> map = new TreeMap<>();

        words.stream().forEach(word -> addWordToMap(map, word));

        return formatOutput(map);

    }

    private String formatOutput(Map<String, Set<String>> map) {
        return map.entrySet().stream()
                .map(this::entryToString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String entryToString(Entry<String, Set<String>> entry) {
        StringBuilder sb = new StringBuilder();
        sb.append(entry.getKey())
                .append(": [")
                .append(String.join(", ", entry.getValue()))
                .append("]");

        return sb.toString();
    }

    private void addWordToMap(Map<String, Set<String>> map, String word) {
        String letters = getLetters(word);
        map.computeIfAbsent(letters, l -> new TreeSet<>());
        map.get(letters).add(word);
    }

    private String getLetters(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
