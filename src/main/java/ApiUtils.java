import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import pojo.CandleStickResponsePojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ApiUtils {

    public static final String BASE_URL = "https://api.crypto.com/v2/";
    public static final String GET_CANDLE_STICK_ENDPOINT = "public/get-candlestick";

    private static ExtractableResponse<Response> getAPiResponse(String endpoint, Map<String, Object> queryParam) {
        return given()
                .queryParams(queryParam)
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("code",equalTo(0))
                .extract();
    }

    public static CandleStickResponsePojo getCandleStick(String instrumentName, int timeFrame)  {

        Map<String, Object> params = new HashMap<>();
        params.put("instrument_name", instrumentName);
        params.put("timeframe", timeFrame + "m");

       return getAPiResponse(GET_CANDLE_STICK_ENDPOINT,params).as(CandleStickResponsePojo.class);

    }
}
