package com.crawler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParsing {

  /**
   * TEST 1: Remove all spaces and dots (.) surrounding the text (' ... Test    .    ' => 'Test')
   */
  public static String makeNice(String text) {

    // add code here
    text = text.replaceAll("\\s+", "");
    text = text.replaceAll("\\.+", "");

    return text;
  }

  /**
   * TEST 2: Explode a string into a list of substrings which in the original string is separated by
   * the given separator
   */
  public static List<String> explode(String text, String separator) {
    List<String> parts = new ArrayList<>();


    String  str [] = text.split(separator);
    parts = Arrays.asList(str);
    return parts;
  }

  /**
   * TEST 3: Make a string's first character uppercase
   */
  public static String uppercaseFirst(String text) {

    String firstLetter = text.substring(0, 1);
    String remLetters = text.substring(1);
    firstLetter = firstLetter.toUpperCase();

    String allLetters = firstLetter + remLetters;

    return allLetters;
  }

  /**
   * TEST 4: Uppercase the first character of each word in a string
   */
  public static String uppercaseWords(String text) {

    String regex = "\\b(.)(.*?)\\b";
    String result = Pattern.compile(regex).matcher(text).replaceAll(
            matcher -> matcher.group(1).toUpperCase() + matcher.group(2)
    );
    return result;
  }

  /**
   * TEST 5: Extract all integers from a string Hint: Regex
   */
  public static List<Integer> extractIntegers(String text) {
    List<Integer> integers = new ArrayList<>();

    List<String> string = new ArrayList<>();
    Pattern p = Pattern.compile("[+-]?\\d+");
    Matcher m = p.matcher(text);
    while(m.find()) { string.add(m.group());
    }
    integers = string.stream().map(Integer::parseInt).collect(Collectors.toList());
    return integers;
  }

  /**
   * TEST 5: Extract all doubles from a string Hint: Regex
   */
  public static List<Double> extractDoubles(String text) {
    List<Double> doubles = new ArrayList<>();


    List<String> string = new ArrayList<>();
    Pattern p = Pattern.compile("[+-]?\\d*\\.?\\d+([eE][+-]?\\d+)?");
    Matcher m = p.matcher(text);
    while(m.find()) { string.add(m.group());
    }

    doubles = string.stream().map(Double::parseDouble).collect(Collectors.toList());
    return doubles;
  }

}
