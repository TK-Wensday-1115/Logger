package logger.component;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger extends ScrollPane{
    private final TextArea loggingView = new TextArea();
    private DateFormat dateFormat = new SimpleDateFormat("[dd.MM.yyyy HH:mm:ss]");
    private int historySize;

    public Logger(){
        setupLoggingView();
        this.setContent(loggingView);
        this.setFitToWidth(true);
        this.setFitToHeight(true);
        this.setPrefWidth(400);
        this.setPrefHeight(180);
        this.historySize = 0;
        setColor(Color.BLACK);
    }

    private void setupLoggingView() {
        loggingView.setPrefWidth(1000);
        loggingView.setPrefHeight(500);
        loggingView.setWrapText(true);
        loggingView.setEditable(false);
    }

    public void append(final Date date, final String content) {
        final String message = dateFormat.format(date) + " " + content + "\n";
        int spaceNeeded = message.length();
        try {
            try {
                if (loggingView != null) {
                    if (loggingView.getText().length() == 0) {
                        loggingView.setText(message);
                    } else if(loggingView.getText().length() + spaceNeeded <= historySize){
                        loggingView.selectEnd();
                        loggingView.insertText(loggingView.getText().length(),
                                message);
                    }else{
                        String text = loggingView.getText();
                        text = text.substring(spaceNeeded);
                        while(!text.startsWith("\n")){
                            text = text.substring(1);
                        }
                        text = text.substring(1);
                        loggingView.setText(text);
                        loggingView.selectEnd();
                        loggingView.insertText(loggingView.getText().length(),
                                message);
                    }
                }
            } catch (final Throwable t) {
                System.out.println("Unable to append log to text area: "
                        + t.getMessage());
            }
        } catch (final IllegalStateException e) {
            // ignore case when the platform hasn't yet been iniitialized
        }
    }

    public void setColor(Color color){
        loggingView.setStyle("-fx-text-fill: " + toRgbString(color) + ";");
    }

    private String toRgbString(Color c) {
        return "rgb("
                + to255Int(c.getRed())
                + "," + to255Int(c.getGreen())
                + "," + to255Int(c.getBlue())
                + ")";
    }

    private int to255Int(double d) {
        return (int) (d * 255);
    }

    public int getHistorySize() {
        return historySize;
    }

    public void setHistorySize(int historySize) {
        this.historySize = historySize;
    }

}
