package models;

import java.util.ArrayList;

import database.Banco;

public class TesteDrive {
private int id;
private String text;
private int who;

public TesteDrive (int id, String text, int who){
    this.id = id;
    this.text = text;
    this.who = who;
}

public static void create(Banco banco, String text, int who){
    banco.getFeedbacks().add(new Feedback(banco.getLastInsertFeedback() + 1, text,who));
    banco.incLastInsertFeedback();
}

public static ArrayList<Feedback> getAll(Banco banco){
    return banco.getFeedbacks();
}


public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public int getWho() {
	return who;
}

public void setWho(int who) {
	this.who = who;
}

}