package com.yrhacks.apps.yrschool;

import java.io.IOException;

import javafx.fxml.FXML;

public class UnitController {
	private String path;

	@FXML
	private void initialize() {
		Object[] obj = App.getParams();
		path = obj[0].toString();
	}
	
	@FXML
	public void moveToCourse() throws IOException {
		App.setRoot("CourseView");
	}
}