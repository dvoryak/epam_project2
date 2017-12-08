package com.company.entity;

import java.util.*;

public class Document {
    private String name;
    private List<Sentence> sentences;

    public Document() {
        this(new Date().toString(),null);
    }

    public Document(String name, List<Sentence> sentences) {
        this.sentences = sentences;
        this.name = name;
    }

    public void setText(String text) {

    }

    public String getText() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence);
        }
        return sb.toString();
    }
}
