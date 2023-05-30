import java.io.File;

public class Main {
    public static void main(String[] args) {
         new LimitedSeries(2,6,(new DataFileReader("C:\\Users\\Jespo\\IdeaProjects\\Abgabe 8\\src\\months.txt",100)));
         new NormalizedSeries(new RangeSeries(-250000, 500000), 10000);
    }
}
