package edu.wit.comp1050;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application{
    @FXML public Button go,red,orange,green,blue,purple,yellow,strtBtn;
    @FXML public HBox hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8,hb9,hb10;
    @FXML public MenuItem start;
    @FXML public Circle c1,c2,c3,c4;
    @FXML public Text wls;

    Board sushi = new Board(0,0);
    private String guessString;
    VBox root;
    Controller test;
    int rowNum;
    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("mastermind.fxml"));
        primaryStage.setTitle("MasterMind");
        test = new Controller();
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void startGame(){
        sushi = new Board(10,4);
        guessString = "";
        rowNum = 0;
    }
    public void handleButtonAction(ActionEvent actionEvent){
        if(actionEvent.getSource()==start){
            startGame();
        }
        if(actionEvent.getSource()==go && rowNum == sushi.size){
            String correction;
            correction = sushi.guessCode(guessString);
            displayCorrect(correction,c1,0);
            displayCorrect(correction,c2,1);
            displayCorrect(correction,c3,2);
            displayCorrect(correction,c4,3);
            if(sushi.win){
                wls.setText("You Won!");
            }else{
                rowNum = 0;
                guessString = "";
            }

        }
        if(sushi.guessCount < sushi.numRows && rowNum < sushi.size){
            Circle circle = new Circle(30);
            if(actionEvent.getSource()==orange){
                guessString+="O";
                circle.setFill(Color.ORANGE);
                setCircle(circle);
            }
            if(actionEvent.getSource()==red){
                guessString+="R";
                circle.setFill(Color.RED);
                setCircle(circle);
            }
            if(actionEvent.getSource()==blue){
                guessString+="B";
                circle.setFill(Color.BLUE);
                setCircle(circle);
            }
            if(actionEvent.getSource()==green){
                guessString+="G";
                circle.setFill(Color.GREEN);
                setCircle(circle);
            }
            if(actionEvent.getSource()==purple){
                guessString+="P";
                circle.setFill(Color.PURPLE);
                setCircle(circle);
            }
            if(actionEvent.getSource()==yellow){
                guessString+="Y";
                circle.setFill(Color.YELLOW);
                setCircle(circle);
            }
        }
    }

    private void displayCorrect(String correction,Circle c, int i) {
            String temp =correction.substring(i,i+1);
            System.out.println(temp);
            if(temp.equals("G")){
                c.setFill(Color.GREEN);
            }
            else if(temp.equals("C")){
                c.setFill(Color.YELLOW);
            }
            else{
                c.setFill(Color.RED);
            }
    }

    void setCircle(Circle c){
        Circle circle = c;
        switch(sushi.guessCount){
            case 0:
                hb1.getChildren().add(circle);
                break;
            case 1:
                hb2.getChildren().add(circle);
                break;
            case 2:
                hb3.getChildren().add(circle);
                break;
            case 3:
                hb4.getChildren().add(circle);
                break;
            case 4:
                hb5.getChildren().add(circle);
                break;
            case 5:
                hb6.getChildren().add(circle);
                break;
            case 6:
                hb7.getChildren().add(circle);
                break;
            case 7:
                hb8.getChildren().add(circle);
                break;
            case 8:
                hb9.getChildren().add(circle);
                break;
            case 9:
                hb10.getChildren().add(circle);
                break;

        }
        rowNum++;
    }
}
