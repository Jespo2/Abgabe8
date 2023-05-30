import java.util.ArrayList;
public class LimitedSeries implements DataSeries {
    double min;
    double max;
    DataSeries source;

    public LimitedSeries(double min, double max, DataSeries source) {
        double [] array = new double[source.getItemCount()];
        for(int i = 0 ; i < source.getItemCount();i++){
            if(source.getItem(i)>max||source.getItem(i)<min){
                System.out.println(source.getTitle() + " limited to ["+min+", "+max+"]");
                i=source.getItemCount();
            }else
            array[i] = source.getItem(i);
        }

    }

    @Override
    public int getItemCount() {
        return source.getItemCount();
    }

    @Override
    public double getItem(int idx) {
        return source.getItem(idx);
    }

    @Override
    public String getTitle() {
        return source.getTitle();
    }
}
