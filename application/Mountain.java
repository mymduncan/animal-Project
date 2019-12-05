package application;
//simple terrain extension for mountain
public class Mountain extends Terrain{
	
	public Mountain()
	{
		super();
	}
	
	public void createTerrain(String a, String b, String c, int d)
	{
		setName(a);
		setClimate(b);
		setTopography(c);
		setHindex(d);
	}
	
	public void changeTerrain(String a, String b, String c, int d)
	{
		setName(a);
		setClimate(b);
		setTopography(c);
		setHindex(d);
	}
	
	
}
