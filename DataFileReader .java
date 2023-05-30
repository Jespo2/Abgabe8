class DataFileReader implements LabeledDataSeries {
    final static int DEFAULT_CAPACITY = 100;

    String title;
    int entryCount;
    double[] values;
    String[] labels;

    DataFileReader (String fileName, int capacity) {
        title = "?";
        entryCount = 0;
        values = new double[capacity];
        labels = new String[capacity];
        In.open(fileName);
        if (In.done()) {
            entryCount = 0;
            title = In.readString();
            while (In.done()) {
                String label = In.readString();
                double value = In.readDouble();
                if (In.done()) {
                    values[entryCount] = value;
                    labels[entryCount] = label;
                    entryCount += 1;
                }
            }
            In.close();
        }
        else
            Out.println("Could not open file '" + fileName + "' for reading!");
    }

    DataFileReader (String fileName) {
      this(fileName, DEFAULT_CAPACITY);
    }
    
    // implement all methods required by interface LabeledDataSeries,
    // including the methods in the super-interface DataSeries
    public String getLabel (int idx) {
        assert 0 <= idx && idx < entryCount : "index out of range";
        return labels[idx];
    }

    public int getItemCount () {
        return entryCount;
    }

    public double getItem (int idx) {
        assert 0 <= idx && idx < entryCount : "index out of range";
        return values[idx];
    }

    public String getTitle () {
        return title;
    }
}
