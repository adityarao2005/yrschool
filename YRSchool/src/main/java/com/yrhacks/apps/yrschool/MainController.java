package com.yrhacks.apps.yrschool;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainController {

	@FXML
	private void moveToCourses() throws IOException {
		App.setRoot("CourseView");
	}
}
