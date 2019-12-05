package application;
//this is the terrain manager.  This is where we get the basic functionality and backend tying up the multiple terrains together.
//using this we can use terrain in the main as it's own variable and with various different functionalities programmed in.
import java.util.ArrayList;

public class TerrainManager {

	private ArrayList<Terrain> Tmanager = new ArrayList<Terrain>();
	
	public TerrainManager()
	{
		Tmanager.add(new Forest());
		Tmanager.get(0).createTerrain("Forest", "Temperate", "Many Trees", 5);
		Tmanager.add(new Mountain());
		Tmanager.get(1).createTerrain("Mountain", "Temperate", "Hilly but empty", 4);
		Tmanager.add(new RegionalForest("Brazilian"));
		Tmanager.get(2).createTerrain("Forest", "Hot", "Many Trees", 7);
		Tmanager.add(new Sea());
		Tmanager.get(3).createTerrain("Sea", "Cool", "Underwater", 3);
		Tmanager.add(new RainForest());
		Tmanager.get(4).createTerrain("Rainforest", "Hot", "Many Trees", 8);
	}
	
	public Terrain terrainSearch(String a)
	{
		if (a == "Regional Forest")
		{
			return Tmanager.get(2);
		}
		for(int i=0;i<Tmanager.size();i++)
		{
			if (Tmanager.get(i).getName() == a)
			{
				return Tmanager.get(i);
			}
		}
		return null;
	}
	
	public String TerrainPrint1(String x)
	{
		String a = "This is the terrain you have chosen.";
		return a;	
	}
	public String TerrainPrint2(String x)
	{
		Terrain temp = terrainSearch(x);
		String b = "The name of this terrrain is: ";
		return (b + temp.getName());	
	}
	public String TerrainPrint3(String x)
	{
		Terrain temp = terrainSearch(x);
		String c = "The Climate of this terrain is: ";
		return (c + temp.getClimate());	
	}
	public String TerrainPrint4(String x)
	{
		Terrain temp = terrainSearch(x);
		String d = "The Topography of this terrain is: ";
		return (d + temp.getTopography());	
	}
	public String TerrainPrint5(String x)
	{
		Terrain temp = terrainSearch(x);
		String e = "The Heat Index of this terrain is: ";
		return (e + temp.getHindex());	
	}
}
