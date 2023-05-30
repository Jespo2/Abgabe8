class RangeSeries implements DataSeries {

   int start, end;
   
   RangeSeries(int start, int end) {
      // save all characterizing information in object fields
      assert end >= start : "only non-empty increasing ranges are supported";
      this.start = start;
      this.end = end;
   }
   
   // implement the three interface methods as public methods
   public int getItemCount () {
      return end - start + 1;
      // + 1, because end value is inclusive (fence post analogy)
   }
   
   public double getItem (int idx) {
      return start + idx;
      // compute the requested element on demand
   }
   
   public String getTitle () {
      return "Range " + start + " ... " + end;
   }
}
