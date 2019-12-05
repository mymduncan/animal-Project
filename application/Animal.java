package application;

import java.util.ArrayList;
//this is the animal class I am using.  Mostly just setting variables and getter / setter methods
public class Animal {
	private String name;
	private Terrain terrain;
	private ArrayList<String> food = new ArrayList<String>();

	Animal() {
		name = "none";
		terrain = null;
		food = null;
	}
	
	public void setName(String a)
	{
		name = a;
	}
	
	public void setTerrain(Terrain t) 
	{
		terrain = t;
	}
	
	public void setFood(String a)
	{
		try {
			food.add(a);
		}
		catch (NullPointerException e) {
			return;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public Terrain getTerrain()
	{
		return terrain;
	}
	
	public ArrayList<String> getFood()
	{
		return food;
	}
	
	public int getfoodlength()
	{
		return food.size();
	}
}
