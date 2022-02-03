package com.crawler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class JsoupParsing {

  /**
   * return a collection of elements from a jsoup document for a given css selector
   *
   * @param document    JSoup document
   * @param cssSelector the css selector
   * @return JSoup Elements
   */
  public static Elements getElements(Document document, String cssSelector) throws IOException {
    Elements elements = document.select(cssSelector);
    return elements;
  }


  /**
   * return the first element of elements collection
   *
   * @param elements JSoup Elements
   * @return JSoup Element
   */
  public static Element getFirstElement(Elements elements) {
    Element element = elements.get(0);
    return element;
  }

  /**
   * return element at a specific index
   *
   * @param elements JSoup elements
   * @param index    int index
   * @return JSoup Elements
   */
  public static Element getElementAtIndex(Elements elements, int index) {
    Element element = elements.get(index);
    return element;
  }

  /**
   * return the attribute value from a given element for a given attribute
   *
   * @param element   the JSoup element
   * @param attribute the attribute to read
   * @return attribute value as string
   */
  public static String getAttribute(Element element, String attribute) {
    String attrElement = element.attr(attribute);
    return attrElement;
  }

  /**
   * returns a category string of all parent nodes 'name' attributes separated by DOT
   *
   * @param match the JSoup match element
   * @return String of all parent nodes name attributes with DOT separator
   */

  public static String buildCategory(Element match) {
    StringBuilder category = new StringBuilder();
    category.append(match.attr("name"));
    Elements children = match.children();
    while(children.size() > 0){
     String text = children.get(0).attr("name");
     if (text != ""){
       category.append("." + text);
     }
     children = children.get(0).children();
    }
    return category.toString();
  }
}
