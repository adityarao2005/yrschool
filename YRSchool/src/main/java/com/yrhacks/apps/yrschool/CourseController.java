package com.yrhacks.apps.yrschool;

import java.io.IOException;

import javafx.fxml.FXML;

public class CourseController {

	@FXML
	public void moveToMain() throws IOException {
		App.setRoot("MainView");
	}
}