package com.crawler.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// DON'T TOUCH
public class Utils {

  private static final ObjectMapper mapper = new ObjectMapper();

  private Utils(){}
  /**
   * load content from file
   *
   * @param fileName path to file
   * @return String of file content
   * @throws FileNotFoundException exception when file couldn't be loaded
   */
  private static String loadFile(String fileName) throws FileNotFoundException {
    try (Scanner scanner = new Scanner(new File(fileName))) {
      StringBuilder content = new StringBuilder();
      while (scanner.hasNextLine()) {
        content.append(scanner.nextLine());
      }
      return content.toString();
    }
  }

  /**
   * Jsoup.parse (file)
   *
   * @return Document
   * @throws IOException exception when file couldn't be loaded
   */
  public static Document getJsoupDocument(String fileName) throws IOException {
    return Jsoup.parse(Utils.loadFile(fileName));
  }

  /**
   * ObjectMapper.readTree (file)
   *
   * @return JsonNode
   * @throws IOException exception when file couldn't be loaded
   */
  public static JsonNode getJsonRootNode(String fileName) throws IOException {
    return mapper.readTree(Utils.loadFile(fileName));
  }
}
