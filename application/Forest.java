package application;
//simple terrain extension for forest
public class Forest extends Terrain {
	
	public Forest()
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

