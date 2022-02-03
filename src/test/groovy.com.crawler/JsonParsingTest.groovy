import com.fasterxml.jackson.databind.JsonNode
import com.crawler.JsonParsing
import com.crawler.common.Utils
import spock.lang.Specification

class JsonParsingTest extends Specification {

    JsonNode rootNode = Utils.getJsonRootNode("src/test/resources/Test.json")

    /**
     * test working with JsonNodes
     *
     * do NOT touch the test method names but use them as test description
     *
     * you need to replace <FIELD NAME> with proper values
     * you may need to adjust some given value to meet the test description (method name)
     *
     * START CODING BELOW - try to get all test successfully working
     */

    def "Test amount of root field elements equals 2 and they contain matches and calls"() {
        given:
        rootNode != null
        JsonParsing.getElementsSize(rootNode) == 2

        when:
        Set<String> fieldNames = JsonParsing.getElementsFieldNames(rootNode)

        then:
        fieldNames.size() == 2
        fieldNames.contains("call")
        fieldNames.contains("matches")
    }

    def "Test number of elements in 'matches' node equals 132"() {
        expect:
        rootNode != null

        when:
        JsonNode matches = JsonParsing.getElementsByFieldName(rootNode, "matches")

        then:
        matches != null
        matches.size() == 132
    }

    def "Test get match at position 42 from matches and expect matchid to be '1943926'"() {

        given:
        rootNode != null
        int index = 42
        JsonNode matches = JsonParsing.getElementsByFieldName(rootNode, "matches")

        when:
        JsonNode match = JsonParsing.getElementByIndex(matches, index)
        int matchId = JsonParsing.getAsInt(match.get("match_id"))

        then:
        match != null
        matchId == 1943926
    }

    def "Test get element at index 42 from elements list and extract date, time, homeTeam and awayTeam"() {

        given:
        rootNode != null
        int index = 42
        JsonNode match = JsonParsing.getElementByIndex(JsonParsing.getElementsByFieldName(rootNode, "matches"), index);

        when:
        match != null
        String date = JsonParsing.getAsText(JsonParsing.getElementsByFieldName(match, "date"))
        String time = JsonParsing.getAsText(JsonParsing.getElementsByFieldName(match, "time"))
        String homeTeam = JsonParsing.getAsText(JsonParsing.getElementsByFieldName(match, "club_A_name"))
        String awayTeam = JsonParsing.getAsText(JsonParsing.getElementsByFieldName(match, "club_B_name"))

        then:
        index == 42
        date == "2021-06-20"
        time == "16:00:00"
        homeTeam == "Fotbollsföreningen JARO Jalkapalloseura"
        awayTeam == "Pallokerho-35"

    }
}
