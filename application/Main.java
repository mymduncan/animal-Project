package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
import javafx.scene.control.ListView;

public class Main extends Application {
	//put the variables here for the labels and controls
	private final Label introduction1 = new Label("Hello and welcome to the zoo animal tracker.");
	private final Label introduction2 = new Label("Do you have a file to upload?");
	private final Label lineSpacer = new Label("");
	private final Label upload1 = new Label("Indicate the file to be uploaded");
	private final Label upload2 = new Label("WARNING: File must be in src directory");
	private final Label upload2error = new Label("ERROR: File not Found");
	private final Label maintext = new Label("What would you like to do today?");
	private final Label addAnimalname = new Label("Name:");
	private final Label addAnimalfood = new Label("Food:");
	private final Label addAnimalTerrain = new Label("Terrain");
	private final Label editAnimalfind = new Label("Animal Name");
	private final Label editAnimalname = new Label("Name:");
	private final Label editAnimalterrain = new Label("Terrain");
	private final Label terrainHolder1 = new Label("");
	private final Label terrainHolder2 = new Label("");
	private final Label terrainHolder3 = new Label("");
	private final Label terrainHolder4 = new Label("");
	private final Label terrainHolder5 = new Label("");
	
	private final TextField uploadText = new TextField ("file name goes here");
	private final TextField addName = new TextField ("Name");
	private final TextField addFood = new TextField ("Food");
	private final TextField editAnimalName = new TextField("");
	private final TextField foodChange = new TextField("");
	
	private final Button buttonIntroYes = new Button("Yes");
	private final Button buttonIntroNo = new Button("No");
	private final Button buttonUpload = new Button("Upload");
	private final Button addAnimal = new Button("Add an Animal");
	private final Button editAnimal = new Button("Edit an Animal");
	private final Button saveButton = new Button("Save");
	private final Button buttonAdd = new Button("Add Animal");
	private final Button AnimalFind = new Button("Find Animal");
	private final Button editSend = new Button("Submit");
	private final Button backHome = new Button("Home");
	
	private final HBox yesorno = new HBox(10);
	private final HBox mainButtons = new HBox(10);
	
	@Override
	public void start(Stage primaryStage) {
		//variables and arrays
		ArrayList<Animal> animal = new ArrayList<Animal>();
		TerrainManager Tmanager = new TerrainManager();
		Animal tempAnimal = new Animal();
		ListView<String> Terrainlistview = new ListView<>();
		Terrainlistview.getItems().addAll("Forest","Regional Forest","Mountain","Sea","Rainforest");
		Label eventhandler = new Label("");
		ComboBox<String> foodList = new ComboBox<>(); 
		foodList.getItems().add("new");
		ComboBox<String> animalList = new ComboBox<>();
		
		try {
			//scene declarations
			//startup
			VBox root = new VBox();
			root.getChildren().addAll(introduction1,introduction2,lineSpacer,yesorno);
			yesorno.getChildren().addAll(buttonIntroYes,buttonIntroNo);
			Scene opening = new Scene(root, 600, 600);
			opening.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//upload
			VBox uploadbox = new VBox();
			uploadbox.getChildren().addAll(upload1,upload2,uploadText,buttonUpload);
			Scene upload = new Scene(uploadbox, 600, 600);
			upload.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//upload error
			VBox uploadboxerror = new VBox();
			uploadboxerror.getChildren().addAll(upload1,upload2error,uploadText,buttonUpload);
			Scene uploaderror = new Scene(uploadboxerror, 600, 600);
			uploadboxerror.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//main menu
			VBox main = new VBox();
			main.getChildren().addAll(maintext,eventhandler,mainButtons);
			mainButtons.getChildren().addAll(addAnimal,editAnimal,saveButton);
			Scene mainMenu = new Scene(main, 600, 600);
			mainMenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//had to move the add an animal screen to the end of the declarations so that I could import the terrainreviewer
			//and make it so that you could add animals AND get the terrain details listed
			
			//animal editor p1
			VBox editanimalsp1 = new VBox();
			editanimalsp1.getChildren().addAll(editAnimalfind,animalList,AnimalFind);
			Scene editAnimalp1 = new Scene(editanimalsp1, 600, 600);
			editAnimalp1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//animal editor p2
			HBox editAnimals = new HBox();
			VBox editFields = new VBox();
			VBox editBoxes = new VBox();
			VBox editTInfo = new VBox();
			editAnimals.getChildren().addAll(editFields,editBoxes,editTInfo,editSend);
			editFields.getChildren().addAll(editAnimalname,foodList,editAnimalterrain);
			editBoxes.getChildren().addAll(editAnimalName,foodChange,Terrainlistview);
			editTInfo.getChildren().addAll(terrainHolder1,terrainHolder2,terrainHolder3,terrainHolder4,terrainHolder5);
			Scene editAnimalp2 = new Scene(editAnimals, 600, 600);
			editAnimalp2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//terrain reviewer
			HBox terrainReviewer = new HBox();
			VBox terrainInfo = new VBox();
			terrainInfo.getChildren().addAll(terrainHolder1,terrainHolder2,terrainHolder3,terrainHolder4,terrainHolder5);
			terrainReviewer.getChildren().addAll(Terrainlistview,terrainInfo);
			
			//animal adder
			VBox tFixer = new VBox();
			HBox addAnimals = new HBox();
			VBox addFields = new VBox();
			VBox addBoxes = new VBox();
			VBox addTFields = new VBox();
			addAnimals.getChildren().addAll(Terrainlistview, addFields, addBoxes, addTFields, buttonAdd);
			addFields.getChildren().addAll(addAnimalname,addAnimalfood,addAnimalTerrain);
			addBoxes.getChildren().addAll(addName,addFood, Terrainlistview);
			addTFields.getChildren().addAll(terrainHolder1,terrainHolder2,terrainHolder3,terrainHolder4,terrainHolder5);
			tFixer.getChildren().addAll(addAnimals,terrainReviewer);
			Scene addAnimalScreen = new Scene(tFixer, 600, 600);
			addAnimalScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			//program initialization
			primaryStage.setTitle("Startup");
			primaryStage.setScene(opening);
			primaryStage.show();
			//this is so that you can upload a save state.  The only issue is if you have multiple save states but the file
			//would not save properly even when the file is named properly as a save state, so instead it had to be automatic
			//thus the issue.
			buttonIntroYes.setOnAction(click->{
				try {
					File fileName = new File("SaveState.txt");
					Scanner inFile = new Scanner(fileName);
					while (inFile.hasNext())
					{
						int foodcount = inFile.nextInt();
						String tempName = inFile.next();
						for (int i=0;i<foodcount;i++)
						{
							tempAnimal.setFood(inFile.next());
						}
						tempAnimal.setTerrain(Tmanager.terrainSearch(inFile.next()));
						tempAnimal.setName(tempName);
						animal.add(tempAnimal);
					}
					inFile.close();
					primaryStage.setTitle("Main Menu");
					primaryStage.setScene(mainMenu);
					primaryStage.show();
				} catch (FileNotFoundException e) {
					primaryStage.setTitle("ERROR");
					primaryStage.setScene(uploaderror);
					primaryStage.show();
				}
			});
			//menu loader
			buttonIntroNo.setOnAction(click->{
				primaryStage.setTitle("Main Menu");
				primaryStage.setScene(mainMenu);
				primaryStage.show();
			});
			//menu loader
			addAnimal.setOnAction(click->{
				primaryStage.setTitle("Add Animal");
				primaryStage.setScene(addAnimalScreen);
				primaryStage.show();
				
			});
			//this is to add an animal to the animal list
			buttonAdd.setOnAction(click->{
				eventhandler.setText("Successfully added an animal to the database");
				tempAnimal.setName(addName.getText());
				tempAnimal.setFood(addFood.getText());
				tempAnimal.setTerrain(Tmanager.terrainSearch(Terrainlistview.getSelectionModel().getSelectedItem()));
				animal.add(tempAnimal);
				primaryStage.setTitle("Main Menu");
				primaryStage.setScene(mainMenu);
				primaryStage.show();
			});
			//menu loader
			editAnimal.setOnAction(click->{
				for(int i=0;i<animal.size();i++)
				{
					animalList.getItems().add(animal.get(i).getName());
				}
				primaryStage.setTitle("Find Animals to Edit");
				primaryStage.setScene(editAnimalp1);
				primaryStage.show();
			});
			//this is so you can find the animal when you want to edit, and populate the following screen with the appropriate info
			AnimalFind.setOnAction(click->{
				int animalnumbholder = animalList.getSelectionModel().getSelectedIndex();
				Animal tempfindanimal = animal.get(animalnumbholder);
				ArrayList<String> foodHolder = tempfindanimal.getFood();
				try {
					for (int i=0;i<foodHolder.size();i++)
					{
						foodList.getItems().add(foodHolder.get(i));
					}
				}
				catch (NoSuchElementException e) {
					return;
				}
				catch (NullPointerException e) {
					return;
				}
				
				for (int i=0;i<5;i++)
				{
					if (Terrainlistview.getItems().get(i) == tempfindanimal.getTerrain().getName())
					{
						Terrainlistview.getSelectionModel().clearAndSelect(i);
					}
				}
				primaryStage.setTitle("AnimalEditor");
				primaryStage.setScene(editAnimalp2);
				primaryStage.show();
			});
			
			//menu loader
			backHome.setOnAction(click->{
				primaryStage.setTitle("Main Menu");
				primaryStage.setScene(mainMenu);
				primaryStage.show();
			});
			//to save the file for later use
			saveButton.setOnAction(click->{
				try {
					PrintWriter outFile = new PrintWriter(new File("SaveState.txt"));
					Animal tempAnimalSave = new Animal();
					for (int i=0;i<animal.size();i++)
					{
						tempAnimalSave = animal.get(i);
						outFile.println(tempAnimalSave.getFood().size());
						outFile.println(tempAnimalSave.getName());
						for (int j=0;j<tempAnimalSave.getFood().size();j++)
						{
							outFile.println(tempAnimalSave.getFood().get(j));
						}
						outFile.println(tempAnimalSave.getTerrain().getName());
					}
					eventhandler.setText("Data Saved");
					primaryStage.setTitle("Main Menu");
					primaryStage.setScene(mainMenu);
					primaryStage.show();
					outFile.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					eventhandler.setText("Need a name for the save state");
					primaryStage.setTitle("Main Menu");
					primaryStage.setScene(mainMenu);
					primaryStage.show();
				}
				catch (NullPointerException e) {
					eventhandler.setText("Data Saved");
					primaryStage.setTitle("Main Menu");
					primaryStage.setScene(mainMenu);
					primaryStage.show();
				}
			});
			
			Terrainlistview.getSelectionModel().selectedItemProperty().addListener(click->{
				terrainHolder1.setText(Tmanager.TerrainPrint1(Terrainlistview.getSelectionModel().getSelectedItem()));
				terrainHolder2.setText(Tmanager.TerrainPrint2(Terrainlistview.getSelectionModel().getSelectedItem()));
				terrainHolder3.setText(Tmanager.TerrainPrint3(Terrainlistview.getSelectionModel().getSelectedItem()));
				terrainHolder4.setText(Tmanager.TerrainPrint4(Terrainlistview.getSelectionModel().getSelectedItem()));
				terrainHolder5.setText(Tmanager.TerrainPrint5(Terrainlistview.getSelectionModel().getSelectedItem()));
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
