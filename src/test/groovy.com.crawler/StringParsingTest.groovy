package com.crawler

import com.crawler.StringParsing
import spock.lang.Specification

class StringParsingTest extends Specification {

    String testTxt1 = "....         Gera        ..    ."
    String testTxt2 = "hello world! where are though?"
    String testTxt3 = "Test 10- and 6 other of 2a equals -10 but not +55"
    String testTxt4 = "HomeHcp +2.5 / AwayHcp -2.5 / Total 21.5 / HomeAHC -0.75 / AwayAHC +0.75"

    def "Test makeNice"() {
        expect:
        StringParsing.makeNice(testTxt1) == "Gera"
    }

    def "Test explode"() {
        expect:
        StringParsing.explode(testTxt2, " ").size() == 5
    }

    def "Test uppercaseFirst"() {
        expect:
        StringParsing.uppercaseFirst(testTxt2) == "Hello world! where are though?"
    }

    def "Test uppercaseWords"() {
        expect:
        StringParsing.uppercaseWords(testTxt2) == "Hello World! Where Are Though?"
    }

    def "Test extractIntegers"() {

        given:
        List<Integer> integers = StringParsing.extractIntegers(testTxt3)

        expect:
        integers.size() == 5
        integers.contains(10)
        integers.contains(6)
        integers.contains(2)
        integers.contains(-10)
        integers.contains(55)
    }

    def "Test extractDoubles"() {

        given:
        List<Double> doubles = StringParsing.extractDoubles(testTxt4)

        expect:
        doubles.size() == 5
        doubles.get(0) == 2.5
        doubles.get(1) == -2.5
        doubles.get(2) == 21.5
        doubles.get(3) == -0.75
        doubles.get(4) == 0.75
    }
}
