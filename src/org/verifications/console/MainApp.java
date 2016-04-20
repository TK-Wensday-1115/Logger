package org.verifications.console;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

public class MainApp extends Application {

    private final TextArea loggingView = new TextArea();

    public MainApp() {
        TextAreaAppender.setTextArea(loggingView);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        ScrollPane scrollPane = new ScrollPane();
        setupLogginView();
        scrollPane.setContent(loggingView);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(400);
        scrollPane.setPrefHeight(180);

        VBox vBox = VBoxBuilder.create()
                .children(scrollPane)
                .build();
        root.getChildren().add(vBox);
        stage.setScene(new Scene(root, 500, 400));
        stage.show();



    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void setupLogginView() {
//        loggingView.setLayoutX(17);
//        loggingView.setLayoutY(64);
        loggingView.setPrefWidth(1000);
        //loggingView.setPrefHeight(170);
        loggingView.setWrapText(true);
        loggingView.appendText("[22.04.2016 17:26] Free disk space: 678 MB\n");
        loggingView.appendText("[22.04.2016 17:28] Free disk space: 529 MB\n");
        loggingView.setEditable(true);

    }
}
