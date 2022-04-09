package com.yrhacks.apps.yrschool;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class UnitController {
	private String path;

	@FXML
	private WebView webView;
	private WebEngine engine;
	@FXML
	private TreeView<File> treeView;

	@FXML
	private void initialize() throws URISyntaxException, MalformedURLException {
		Object[] obj = App.getParams();
		path = obj[0].toString();

		File file = new File(App.getResource("Courses/" + path).toURI());

		TreeItem<File> root = loadTree(file);

		treeView.setRoot(root);
		treeView.setCellFactory(this::treeCellFactory);

		engine = webView.getEngine();
	}

	public TreeItem<File> loadTree(File file) {
		TreeItem<File> root = new TreeItem<File>();
		root.setValue(file);

		if (file.isDirectory()) {
			File[] files = file.listFiles();

			for (File f : files) {
				root.getChildren().add(loadTree(f));
			}
		}

		return root;
	}

	public TreeCell<File> treeCellFactory(TreeView<File> view) {
		return new TreeCell<File>() {

			@Override
			protected void updateItem(File item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null || empty) {
					setGraphic(null);
					setText(null);
					return;
				}
				if (item.getName().endsWith(".html")) {
					setText(item.getName().substring(0, item.getName().lastIndexOf(".")));

					setOnMouseClicked(e -> {
						try {
							engine.load(item.toURI().toURL().toExternalForm());
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						}
					});
				} else
					setText(item.getName());
			}
		};
	}

	@FXML
	public void moveToCourse() throws IOException {
		App.setRoot("CourseView");
	}
}