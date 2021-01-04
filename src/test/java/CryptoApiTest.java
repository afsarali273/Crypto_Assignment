
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

public class CryptoApiTest {

//    3. At minimum, we would like your solution to verify the consistency of the candlesticks in
//    terms of its attributes: O, H, L, C. Be careful on number handling. You can add additional
//    checks with a reasoning.

//   4. To get started, you can start verifying the consistency of a 1-minute candlestick of
//    BTC_USDT, think about what the required data are to verify the consistency of the
//    candlestick, and how to obtain the data. To save time, you can verify the most recent
//    verifiable few bars from the candlestick.

//    5. You can think about how to generalize the test case to handle different instruments /
//    time-periods, e.g. (5-minute chart, 15-minute chart, etc).

    @Test
    public void validate_consistency_of_candle_stick() {

       final String  INSTRUMENT = "BTC_USDT";
       final int TIME_FRAME = 1;

        ApiUtils
                .getCandleStick(INSTRUMENT, TIME_FRAME)
                .getResult()
                .getData()
                .stream()
                .forEach(x -> {

                    // Logic for consistency of candles
                    System.out.println("==== Value  ======= ");
                    System.out.println("O "+x.getO());
                    System.out.println("H "+x.getH());
                    System.out.println("L "+x.getL());
                    System.out.println("C "+x.getC());
                    System.out.println();
                    System.out.println("T "+x.getT());
                    System.out.println("V "+x.getV());

                });

    }
}
