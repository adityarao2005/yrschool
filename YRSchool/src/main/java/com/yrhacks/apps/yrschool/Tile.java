package com.yrhacks.apps.yrschool;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Tile extends BorderPane {
	@FXML
	private Label text;

	public Tile() {
		FXMLLoader loader = new FXMLLoader(App.class.getResource("Tile.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setText(String string) {
		text.setText(string);
	}

	@FXML
	private void clicked() throws IOException {
		App.setRoot("UnitView", text.getText());
	}
}
