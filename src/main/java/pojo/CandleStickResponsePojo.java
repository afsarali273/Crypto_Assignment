package pojo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CandleStickResponsePojo {

    public int code;
    public String method;
    public Result result;

    @Getter
    public static class Result{
        public String instrument_name;
        public String interval;
        public List<Datum> data;
    }

    @Getter
    public static class Datum{
        public long t;
        public double o;
        public double h;
        public double l;
        public double c;
        public double v;
    }
}
