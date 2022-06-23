package service;

import model.Word;
import org.springframework.beans.MutablePropertyValues;

import java.util.ArrayList;
import java.util.List;

public class WordService {
    static List<Word> wordList=new ArrayList<>();
    static {
        wordList.add(new Word("blue","mau xanh "));
        wordList.add(new Word("red","mau do"));
        wordList.add(new Word("black","mau den"));
    }

    public static List<Word> getWordList() {
        return wordList;
    }
}
