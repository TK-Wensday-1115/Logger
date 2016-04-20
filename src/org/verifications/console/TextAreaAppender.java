package org.verifications.console;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import java.util.Date;


public class TextAreaAppender {

    private static volatile TextArea textArea = null;

    public static void setTextArea(final TextArea textArea) {
        TextAreaAppender.textArea = textArea;
    }

    public void append(final Date date, final int colour, final String content) {
        final String message = content;

        // Append formatted message to text area using the Thread.
        try {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (textArea != null) {
                            if (textArea.getText().length() == 0) {
                                textArea.setText(message);
                            } else {
                                textArea.selectEnd();
                                textArea.insertText(textArea.getText().length(),
                                        message);
                            }
                        }
                    } catch (final Throwable t) {
                        System.out.println("Unable to append log to text area: "
                                + t.getMessage());
                    }
                }
            });
        } catch (final IllegalStateException e) {
            // ignore case when the platform hasn't yet been iniitialized
        }
    }
}