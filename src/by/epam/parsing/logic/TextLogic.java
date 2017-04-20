package by.epam.parsing.logic;

import by.epam.parsing.entity.TextData;
import by.epam.parsing.exception.IllegalParserException;
import by.epam.parsing.parser.AbstractParser;
import by.epam.parsing.parser.ParagraphParser;
import by.epam.parsing.parser.SentenceParser;
import by.epam.parsing.parser.TokenParser;

import java.util.LinkedList;

public class TextLogic {
    public int getParagraphCount(TextData textData){
        return textData.getTextComponents().size();
    }

    public int getSentenceCount(TextData textData, int index){
        return textData.getComponent(index).getTextComponents().size();
    }

    public int getTokenCount(TextData sentenceData, int index){
        return sentenceData.getTextComponents().size();
    }

    //Task 2
    public String GetSentencesInTokenOrder(TextData textData) throws IllegalParserException {
        StringBuilder sb = new StringBuilder("");
        AbstractParser parser1 = new ParagraphParser();
        AbstractParser parser2 = new SentenceParser();
        AbstractParser parser3 = new TokenParser();
        parser1.setNext(parser2);
        parser2.setNext(parser3);

        textData.setTextComponents(parser1.parseComponents(textData));

        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < getParagraphCount(textData); i++){
            for(int j = 0; j < getSentenceCount(textData, i); j++){
                int a = textData.getComponent(i).getComponent(j).getTextComponents().size();
                String s = textData.getComponent(i).getComponent(j).getText();
                if(!list.isEmpty()){
                    int e = 0;
                    while(e < list.size()){
                        if(a < list.get(e).length()){
                            list.add(e, s);
                        }
                    }
                } else {
                    list.add(s);
                }
            }
        }
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }

        return sb.toString();
    }

    //Task 6
    public TextData deleteTokens(TextData textData, int l, char c) throws IllegalParserException {
        StringBuilder sb = new StringBuilder("");
        AbstractParser parser1 = new ParagraphParser();
        AbstractParser parser2 = new SentenceParser();
        AbstractParser parser3 = new TokenParser();
        parser1.setNext(parser2);
        parser2.setNext(parser3);
        TextData td;

        textData.setTextComponents(parser1.parseComponents(textData));
        td = textData;

        for(int i = 0; i < getParagraphCount(td); i++){
            for(int j = 0; j < getSentenceCount(td, i); j++){
                TextData sentences = td.getComponent(i).getComponent(j);
                for(int k = 0; k < getTokenCount(sentences, j); k++){
                    String token = sentences.getComponent(k).getText();
                    if(token.length() == l
                            && token.charAt(0) == c){
                        td.getComponent(i).getComponent(j).removeComponent(k);
                    }
                }
            }
        }

        return td;
    }
}
