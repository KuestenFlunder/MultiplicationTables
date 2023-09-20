package com.tjelvargames.mathlogic;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MathLogicController implements Initializable {
    @FXML
    TextField myResult;
    @FXML
    private Label taskLabel, result, counter, level;
    private MultiplicationTablesTask task;



    @FXML
    protected void onCheckResultClick(){
        try {
            int enteredResult = Integer.parseInt(myResult.getText());
            if (enteredResult == task.getResult()) {
                result.setText("Richtig");
                result.setTextFill(Color.GREEN);
                counter.setText(task.returnCounterAsString());

            } else {
                result.setText("Hmm versuchs nochmal...");
                result.setTextFill(Color.RED);
            }
            task.updateCounterAndLevel(enteredResult);
            counter.setText(task.returnCounterAsString());
            level.setText(task.returnLevelAsString());
            // Create a new PauseTransition object with a duration of 1 seconds
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            // Set the action to be executed after the duration
            pause.setOnFinished(event -> nextTask());
            // Start the pause transition
            pause.play();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    protected void nextTask() {
        myResult.setText("");
        result.setText("");
        task = task.newTask();
        taskLabel.setText(task.returnTaskAsString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task = new MultiplicationTablesTask().newTask();
        taskLabel.setText(String.format("%d x %d = ", task.getFactor1(), task.getFactor2()));
        counter.setText(task.returnCounterAsString());
        level.setText(task.returnLevelAsString());

    }

}