
public class CustomerData
{	
	String name;
	double count;
	double min;
	double median;
	double max;
	double mean;
	public CustomerData(String nm, double c, double mi, double ma, double me, double m)
	{
		name = nm;
		count = c;
		min = mi;
		median = m;
		max = ma;
		mean = me;
		
	}
	
	public double getCount()
	{
		return count;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public double getMin()
	{
		return min;
	}
	
	public double getMax()
	{
		return max;
	}
	
	public double getMean()
	{
		return mean;
	}
	
	public double getMedian()
	{
		return median;
	}
	
	public String toString()
	{
		return "Name: " + name + " Count: " + count + " Min: " + min + " Max: " + max + " Mean: " + mean + " Median: " + median;
	}
	

}
