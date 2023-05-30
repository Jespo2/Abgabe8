public class NormalizedSeries implements DataSeries{


    NormalizedSeries (DataSeries source, double limit) {
      double mittelwert = Statistics.average(source);
      int anzahlElemente =  source.getItemCount();
      double scale = limit/Statistics.max(source);
      double [] array = new double[anzahlElemente];
        for(int i = 0 ; i < source.getItemCount();i++){
                array[i]=source.getItem(i);
                array[i]=(array[i]-mittelwert)*scale;
        }
        System.out.println("Example normalized to a limit of "+limit);
        System.out.println(array[source.getItemCount()/2]);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public double getItem(int idx) {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
