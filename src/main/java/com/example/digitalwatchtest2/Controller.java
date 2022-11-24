package com.example.digitalwatchtest2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {

    class StopThread extends Thread{
        public void run() {
            timeline.stop();
        }
    }

    class ResumeThread extends Thread{
        @Override
        public void run() {
            timeline.play();
        }
    }

    class SetThread extends Thread{
        @Override
        public void run() {
            time = new Time(setField.getText());
            timer.setText(setField.getText());

        }
    }

    Time time = new Time(new CurrentTime().currentTime());


    @FXML
    private Text timer;

    @FXML
    private TextField setField;

    @FXML
    private Button stopButton;

    @FXML
    private Button resumeButton;

    @FXML
    private Button setButton;

    ResumeThread resumeThread;
    StopThread stopThread;


    @FXML
    void stopMethod(ActionEvent event){

        stopThread = new StopThread();
        stopThread.start();
    }

    @FXML
    void resumeMethod(ActionEvent event){

        resumeThread = new ResumeThread();
        resumeThread.start();
    }

    @FXML
    void setMethod(ActionEvent event){

        SetThread setThread = new SetThread();
        setThread.start();
    }

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {
                        time.oneSecondPassed();
                        timer.setText(time.getCurrentTime());
                    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.setText(time.getCurrentTime());

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}


