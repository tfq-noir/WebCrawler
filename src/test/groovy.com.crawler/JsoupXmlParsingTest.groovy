package com.sportradar.crawler

import com.crawler.JsoupParsing
import com.crawler.common.Utils
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import spock.lang.Specification

class JsoupXmlParsingTest extends Specification {

    Document document = Utils.getJsoupDocument("src/test/resources/Test.xml")

    def "Test get number of matches"() {
        given:
        document != null

        when:
        Elements matches = JsoupParsing.getElements(document, "match")

        then:
        matches.size() == 3
    }

    def "Test first match in xml has scores"() {

        given:
        document != null
        Elements matches = JsoupParsing.getElements(document, "matches")

        when:
        Element match = JsoupParsing.getFirstElement(matches)

        then:
        match.selectFirst("score") != null
    }

    def "Test last match in xml has no scores"() {

        given:
        document != null
        Elements matches = document.select("match")

        when:
        Element match = matches[matches.size() - 1]

        then:
        match.selectFirst("score") == null
    }

    def "Test buildCategory from match with id 456 equals 'Programming.International.Newbie League'"() {

        given:
        document != null
        Element match = document.selectFirst("sport")

        when:
        String category = JsoupParsing.buildCategory(match)

        then:
        category == "Programming.International.Newbie League"
    }
}
