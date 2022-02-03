package com.crawler

import com.crawler.JsoupParsing
import com.crawler.common.Utils
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import spock.lang.Specification

class JsoupHtmlParsingTest extends Specification {

    Document document = Utils.getJsoupDocument("src/test/resources/Test.html")

    /**
     * Test jsoup css selectors usage
     *
     * do NOT touch the test method names but use them as test description
     *
     * you need to replace <SELECTOR> with proper values
     * you may need to adjust some given value to meet the test description (method name)
     *
     * START CODING BELOW - try to get all test successfully working
     */

    def "Test amount of meta elements in documents head equals 19"() {

        expect:
        document != null

        when:
        Elements headMetas = JsoupParsing.getElements(document, "meta")

        then:
        headMetas != null
        headMetas.size() == 19
    }

    def "Test amount of link elements in documents head equals 17"() {
        expect:
        document != null

        when:
        Elements links = JsoupParsing.getElements(document, "link")

        then:
        links != null
        links.size() == 17
    }

    def "Test amount of script elements in document equals 12"() {
        expect:
        document != null

        when:
        Elements scripts = JsoupParsing.getElements(document, "script")

        then:
        scripts != null
        scripts.size() == 12
    }

    def "Test amount of a elements with attribute target=\"_blank\" in document equals 18"() {
        expect:
        document != null

        when:
        Elements links = JsoupParsing.getElements(document, "[target=_blank]")

        then:
        links != null;
        links.size() == 18
    }

    def "Test amount of div elements with class=\"grid\" in given document equals 6"() {
        expect:
        document != null

        when:
        Elements divs = JsoupParsing.getElements(document, "div.grid")

        then:
        divs != null
        divs.size() == 6
    }

    def "Test amount of extracted tables equals 1"() {
        expect:
        document != null

        when:
        Elements tables = JsoupParsing.getElements(document, "table")

        then:
        tables != null
        tables.size() == 1
    }

    def "Test charset attribute of first meta element in document head equals 'utf-8'"() {

        given:
        document != null
        Elements metas = JsoupParsing.getElements(document, "meta")

        when:
        metas != null
        Element firstMeta = JsoupParsing.getFirstElement(metas)

        then:
        firstMeta != null
        JsoupParsing.getAttribute(firstMeta, "charset") == "utf-8"
    }

    def "Test document title equals 'OBOS-ligaen 2021 - Terminliste - Norges Fotballforbund'"() {
        expect:
        document != null

        when:
        Element title = JsoupParsing.getElements(document, "title").get(0)

        then:
        title != null
        title.text() == "OBOS-ligaen 2021 - Terminliste - Norges Fotballforbund"
    }

    def "Test number of all table rows in tbody elements equals 240"() {
        expect:
        document != null

        when:
        Elements matchRows = JsoupParsing.getElements(document, "table tbody tr")

        then:
        matchRows != null
        matchRows.size() == 240
    }

    def "Test get date, time, homeTeam and awayTeam from match at index 42 and expect 18.06.2021, 18.00, Raufoss and Jerv"() {

        given:
        document != null
        int index = 42
        Elements matchRows = JsoupParsing.getElements(document, "table tbody tr")

        expect:
        matchRows.size() >= index

        when:
        Element match = JsoupParsing.getElementAtIndex(matchRows, index)
        String date = match.select("td[class=table--mobile__date]").text()
        String time = match.select("td[class=table--mobile__time]").text()
        String homeTeam = match.select("td[class=table--mobile__home]").text()
        String awayTeam = match.select("td[class=table--mobile__away]").text()

        then:
        date == "18.06.2021"
        time == "18.00"
        homeTeam == "Raufoss"
        awayTeam == "Jerv"
    }
}
