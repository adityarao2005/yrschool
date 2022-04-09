package com.yrhacks.apps.yrschool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Collections;

import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;

public class CourseController {
	@FXML
	private TilePane tiles;

	@FXML
	private void initialize() throws IOException, URISyntaxException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new File(new File(App.appDir.toURI()), "Courses").toURI().toURL().openStream()));

		reader.lines().forEach((e) -> {
			Tile tile = new Tile();
			tile.setText(e);
			tiles.getChildren().add(tile);
		});
	}

	@FXML
	public void moveToMain() throws IOException {
		App.setRoot("MainView");
	}
}