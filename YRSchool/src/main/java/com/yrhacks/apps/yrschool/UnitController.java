package com.yrhacks.apps.yrschool;

import java.io.IOException;

import javafx.fxml.FXML;

public class UnitController {

	@FXML
	public void moveToCourse() throws IOException {
		App.setRoot("CourseView");
	}
}