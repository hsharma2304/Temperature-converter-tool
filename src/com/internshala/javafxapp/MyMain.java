package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class MyMain extends Application {

	public static void main( String[] args){
		System.out.println("main");
		launch(args);
		}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

	    MenuBar menuBar	= createMenu();
	    rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature converter tool");
		primaryStage.show();

	}
   //fileMenu
	private MenuBar createMenu() {
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> { System.out.println("New Menu Item Clicked"); });

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);

		});


		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		//HelpMenu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		helpMenu.getItems().addAll(aboutApp);

		//MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;
		}

	//aboutApp
	public static void aboutApp(){
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner");
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);
		Optional<ButtonType> clickedBtn =alertDialog.showAndWait();

		if (clickedBtn.isPresent() &&  clickedBtn.get() ==yesBtn){
			System.out.println("Yes Button");

		}else {
			System.out.println("No Button");

		}

		}
	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
