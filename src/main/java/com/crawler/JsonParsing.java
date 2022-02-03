package com.crawler;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;


public class JsonParsing {

  /**
   * get count of elements for a given JsonNode
   *
   * @param jsonNode jsonNode object
   * @return int number of objects
   */
  public static int getElementsSize(JsonNode jsonNode) {
    //TODO implement
     int size = jsonNode.size();
     return size;
  }

  /**
   * get Set<String> of elements fieldNames
   *
   * @param jsonNode jsonNode object
   * @return Set<String> with elements fieldNames
   */
  public static Set<String> getElementsFieldNames(JsonNode jsonNode) {
   Set<String> fieldNames = new HashSet<>();
    //TODO add all elements fieldNames(!) to our returning fieldNames set

      Iterator<String> fieldName = jsonNode.fieldNames();
            while(fieldName.hasNext()) {
          String string = fieldName.next();
          fieldNames.add(string);
            }
  return fieldNames;
  }

  /**
   * get element(s) for a given fieldName from a jsonNode
   *
   * @param jsonNode  jsonNode object
   * @param fieldName fieldName value
   * @return JsonNode or null
   */
  public static JsonNode getElementsByFieldName(JsonNode jsonNode, String fieldName) {

    return jsonNode.get(fieldName);
  }

  /**
   * get element at specific index from jsonNode
   *
   * @param jsonNode jsonNode object
   * @param index    int position of the object in collection
   * @return JsonNode or null
   */
  public static JsonNode getElementByIndex(JsonNode jsonNode, int index) {

    return jsonNode.get(index);
  }

  /**
   * get text value for a given fieldName
   *
   * @param jsonNode jsonNode object
   * @return JsonNode or null
   */
  public static String getAsText(JsonNode jsonNode) {

    return jsonNode.asText() ;
  }

  /**
   * get int value for a given fieldName
   *
   * @param jsonNode jsonNode object
   * @return Integer representation of value
   */
  public static int getAsInt(JsonNode jsonNode) {
    //TODO implement

    return jsonNode.asInt() ;
  }
}
