package model;

public class Word {
    private String word;
    private String nghia;

    public Word(String word, String nghia) {
        this.word = word;
        this.nghia = nghia;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }
}
