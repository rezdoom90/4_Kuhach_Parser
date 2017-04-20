package by.epam.parsing.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

import static org.apache.logging.log4j.Level.INFO;

public class TextData implements TextComponent {
    private static Logger logger = LogManager.getLogger();
    private TextDataType type;
    private LinkedList<TextData> textComponents;
    private String text;

    public TextData(TextDataType type, String text) {
        this.setType(type);
        this.setText(text);
    }

    public TextDataType getType() {
        return type;
    }

    public void setType(TextDataType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextComponents(LinkedList<TextData> textComponents) {
        this.textComponents = textComponents;
    }

    public LinkedList<TextData> getTextComponents() {
        return textComponents;
    }

    public void removeComponent(int index){
        this.textComponents.remove(index);
        logger.log(INFO, "Component has been removed successfully.");
    }

    @Override
    public void setComponent(int index, TextData textComponent) {
        this.textComponents.set(index, textComponent);
    }

    @Override
    public TextData getComponent(int index) {
        return this.textComponents.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        if(this.getTextComponents() != null){
            for(TextData tc : this.textComponents){
                sb.append(tc.toString());
            }
        } else {
            sb.append(this.getText());
        }

        return sb.toString();
    }
}
