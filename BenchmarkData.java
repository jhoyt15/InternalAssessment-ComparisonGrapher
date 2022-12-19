
public class BenchmarkData 
{
	String name;
	double oneMedian;
	double median;
	double twoMedian;
	public BenchmarkData(String nm, double om, double m, double tm)
	{
		name = nm;
		oneMedian = om;
		median = m;
		twoMedian = tm;
	}
	
	public double getLowerMedian()
	{
		return oneMedian;
	}
	
	public double getMedian()
	{
		return median;
	}
	
	public double getUpperMedian()
	{
		return twoMedian;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return "Name: " + name + " 25th Percentile: " + oneMedian + " Median: " + median + " 75th Percentile: " + twoMedian;
	}
	
}
