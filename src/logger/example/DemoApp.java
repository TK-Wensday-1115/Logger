package logger.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logger.component.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class DemoApp extends Application{

    public static void main(String[] args){
        launch(args);
    }
    Thread thread;
    Logger logger;

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger = new Logger();
        Scene scene = new Scene(logger);
        primaryStage.setScene(scene);
        primaryStage.show();
        logger.setColor(Color.BROWN);
        logger.setHistorySize(1000);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                String line = "";
                while(!line.equals("q")){
                    System.out.println("Enter some text: ");
                    try {
                        line = buffer.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    logger.append(new Date(), line);
                }
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public void stop() throws Exception {
        thread.interrupt();
    }
}
