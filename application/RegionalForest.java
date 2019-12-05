package application;
//second super subclass extension for forest and terrain
public class RegionalForest extends Forest {
	
	private String area;
	
	public RegionalForest(String a)
	{
		area = a;
	}
	public String getArea()
	{
		return area;
	}
}
