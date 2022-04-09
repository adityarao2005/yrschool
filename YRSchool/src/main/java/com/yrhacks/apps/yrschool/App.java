package com.yrhacks.apps.yrschool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("MainView"), 640, 480);
		stage.setScene(scene);
		stage.show();
	}

	private static Deque<Object> params = new LinkedList<Object>();

	static void setRoot(String fxml, Object... params) throws IOException {
		List.of(params).forEach(App.params::offer);
		scene.setRoot(loadFXML(fxml));
	}

	public static Object[] getParams() {
		Object[] params = new Object[App.params.size()];

		int i = 0;
		App.params.forEach((e) -> {
			params[i] = App.params.poll();
		});
		return params;
	}

	private static Parent loadFXML(String fxml) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}
	
	public static final URL appDir = App.class.getProtectionDomain().getCodeSource().getLocation();

	public static void main(String[] args) {
		launch();
	}

}