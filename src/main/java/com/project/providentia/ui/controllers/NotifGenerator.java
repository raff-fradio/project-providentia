package com.project.providentia.ui.controllers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NotifGenerator {
	
	private Font defaultFont;
	
	public NotifGenerator() {
		defaultFont = Font.font("System", 14);
	}

	public void append(VBox notifBox, String text) {
		LocalTime time = LocalTime.now();
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");
		String formattedTime = time.format(timeFormat);
		
		HBox newEntry = new HBox(16);
		newEntry.setAlignment(Pos.CENTER_LEFT);
		
		Text timestamp = new Text(formattedTime);
		timestamp.setFill(Color.WHITE);
		timestamp.setFont(defaultFont);
		
		Text message = new Text(text);
		message.setFill(Color.WHITE);
		message.setFont(defaultFont);
		
		newEntry.getChildren().addAll(timestamp, message);
		
		List<Node> tempList = new ArrayList<Node>();
		
		tempList.add(newEntry);
		tempList.addAll(notifBox.getChildren());
		
//		if (tempList.size() == 10) {
//			tempList.remove(9);
//			System.out.println("Notification max reached.");
//		}
		
		notifBox.getChildren().setAll(tempList);
	}
}
