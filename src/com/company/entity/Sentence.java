package com.company.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sentence implements DocumentEntity {
    private List<Word> words;

    public Sentence() {
    }

    public Sentence(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        for (Word word : words) {
            sb.append(word);
            if(word.isSignAfterWord()) {
                for (Symbol symbol : word.getSignAfterWord()) {
                    sb.append(symbol);
                }
            }
        }
        return sb.toString();
    }
}
