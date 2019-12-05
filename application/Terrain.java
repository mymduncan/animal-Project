package application;
//this is the terrain class.  This abstract class allows all of the properties of its subclasses while also retaining the info and comparable

public abstract class Terrain implements Comparable<Terrain> {
	private String Tname;
	private String Tclimate;
	private String Ttopography;
	private int Hindex;
	
	public Terrain()
	{
		Tname = "none";
		Tclimate = "none";
		Ttopography = "none";
		Hindex = 0;
	}
	
	public abstract void createTerrain(String a, String b, String c, int d);
	
	public void setName(String a)
	{
		Tname = a;
	}
	public void setClimate(String a)
	{
		Tclimate = a;
	}
	public void setTopography(String a)
	{
		Ttopography = a;
	}
	public void setHindex(int a)
	{
		Hindex = a;
	}
	public String getName()
	{
		return Tname;
	}
	public String getClimate()
	{
		return Tclimate;
	}
	public String getTopography()
	{
		return Ttopography;
	}
	public int getHindex()
	{
		return Hindex;
	}
	public int compareTo(Terrain obj)
	{
		if (Hindex > obj.Hindex)
			return 1;
		else if (Hindex == obj.Hindex)
			return 0;
		else 
			return -1;
	}
}