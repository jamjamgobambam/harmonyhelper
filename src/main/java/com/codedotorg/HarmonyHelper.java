package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HarmonyHelper {

    /** The list of instruments */
    private ArrayList<Instrument> instruments;

    /** The ListView containing the names of instruments */
    private ListView<String> listView;

    /**
     * Constructor for the HarmonyHelper class.
     * Initializes an ArrayList of Instrument objects, and a ListView for displaying the instruments.
     */
    public HarmonyHelper() {
        instruments = new ArrayList<Instrument>();
        listView = new ListView<String>();
    }
    
    /**
     * Starts the application.
     * It sets the title of the primary stage, and shows the main scene on the primary stage.
     *
     * @param primaryStage The primary stage of the application.
     */
    public void startApp(Stage primaryStage) {
        primaryStage.setTitle("Harmony Helper");
        showMainScene(primaryStage);    
    }

    /**
     * Displayss the main scene of the application.
     * It sets up the layout, scene, and stage, then shows the stage.
     *
     * @param primaryStage The primary stage on which the scene is set and shown.
     */
    public void showMainScene(Stage primaryStage) {
        TextField inputField = new TextField();
        Button addButton = new Button("Add Instrument");
        addButton.setOnAction(event -> addInstrument(inputField));

        VBox layout = new VBox(10, inputField, addButton, listView);
        Scene mainScene = new Scene(layout, 300, 400);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Adds a new instrument to the list of instruments.
     * It first retrieves the text from the input field, checks if it's not empty,
     * then creates a new Instrument object with the input text and adds it to the instruments list.
     * After adding the new instrument, it sorts the instruments list, refreshes the list view,
     * and finally clears the input field.
     *
     * @param inputField TextField object that contains the name of the new instrument to be added.
     */
    public void addInstrument(TextField inputField) {
        String newInstrument = inputField.getText();

        if (!newInstrument.isEmpty()) {
            instruments.add(new Instrument(newInstrument));
            refreshList();
            inputField.clear();
        }
    }

    /**
     * Sorts the instruments in the 'instruments' list based on their names.
     */
    public void sortInstruments() {
        

    }

    /**
     * Refreshes the list of instruments displayed in the listView.
     * It first clears the listView, then iterates over the 'instruments' list,
     * adding each instrument's name to the listView.
     */
    public void refreshList() {
        listView.getItems().clear();

        for (Instrument instrument : instruments) {
            listView.getItems().add(instrument.getName());
        }
    }

}
