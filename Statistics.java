class Statistics {

	static int count (DataSeries ds) {
		return ds.getItemCount();
	}

	static double sum (DataSeries ds) {
		int n = ds.getItemCount();
		double sum = 0;
		for (int i = 0; i < n; i++)
			sum += ds.getItem(i);
		return sum;
	}

	static double average (DataSeries ds) {
		int n = ds.getItemCount();
		if (n < 1) return Double.NaN;
		return sum(ds) / n;
	}

	static double max (DataSeries ds) {
		int n = ds.getItemCount();
		if (n < 1) return Double.NaN;
		double maxVal = ds.getItem(0);
		for (int i = 1; i < n; i++) {
			double itemVal = ds.getItem(i);
			if (itemVal > maxVal)
				maxVal = itemVal;
		}
		return maxVal;
	}

	static double min (DataSeries ds) {
		int n = ds.getItemCount();
		if (n < 1) return Double.NaN;
		double minVal = ds.getItem(0);
		for (int i = 1; i < n; i++) {
			double itemVal = ds.getItem(i);
			if (itemVal < minVal)
				minVal = itemVal;
		}
		return minVal;
	}

	static double variance (DataSeries ds) {
		int n = ds.getItemCount();
		if (n < 1) return Double.NaN;
		double avg = average(ds);
		double deltaSquareSum = 0;
		for (int i = 0; i < n; i++) {
			double delta = ds.getItem(i) - avg;
			deltaSquareSum += delta * delta;
		}
		return deltaSquareSum / n;
	}

	static double standardDeviation (DataSeries ds) {
		return Math.sqrt(variance(ds));
	}

	static double pQuantile (DataSeries ds, double p) {
		int n = ds.getItemCount();
		if (n < 1) return Double.NaN;
		double[] values = new double[n];
		for (int i = 0; i < n; i++)
			values[i] = ds.getItem(i);
		java.util.Arrays.sort(values);
		int pIndex = (int) (p * n);
		return values[pIndex];
	}

	static double median (DataSeries ds) {
		return pQuantile(ds, 0.5);
	}
	
	static void printAll (DataSeries ds) {
		double q16 = pQuantile(ds, 1.0 / 6);
		double q56 = pQuantile(ds, 5.0 / 6);
		Out.println("Statistik zu " + ds.getTitle());
		Out.println("Anzahl Werte: " + count(ds));
		Out.println("Summe: " + sum(ds));
		Out.println("Minimum: " + min(ds));
		Out.println("Maximum: " + max(ds));
		Out.println("Durchschnitt: " + average(ds));
		Out.println("Std.abweichung: " + standardDeviation(ds));
		Out.println("Streuintervall: " + ((q56 - q16) / 2));
		Out.println(" 1%-Quantil: " + pQuantile(ds, 0.01));
		Out.println(" 5%-Quantil: " + pQuantile(ds, 0.05));
		Out.println("10%-Quantil: " + pQuantile(ds, 0.1));
		Out.println("1/6-Quantil: " + q16);
		Out.println("25%-Quantil: " + pQuantile(ds, 0.25));
		Out.println("     Median: " + median(ds));
		Out.println("75%-Quantil: " + pQuantile(ds, 0.75));
		Out.println("5/6-Quantil: " + q56);
		Out.println("90%-Quantil: " + pQuantile(ds, 0.9));
		Out.println("95%-Quantil: " + pQuantile(ds, 0.95));
		Out.println("99%-Quantil: " + pQuantile(ds, 0.99));
		Out.println("--------");
	}
}