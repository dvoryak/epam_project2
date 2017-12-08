package com.company.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word implements DocumentEntity {
    private List<Symbol> symbols;
    private List<Symbol> signAfterWord;
    private boolean isSignAfterWord = false;

    public Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> getSignAfterWord() {
        return Collections.unmodifiableList(signAfterWord);
    }

    public List<Symbol> getSymbols() {
        return Collections.unmodifiableList(symbols);
    }

    public void addSignAfterWord(Symbol sign) {
        if(signAfterWord == null) {
            signAfterWord = new ArrayList<>();
        }
        signAfterWord.add(sign);
    }

    public boolean isSignAfterWord() {
        return signAfterWord != null && signAfterWord.size() != 0;
    }

    public void deleteAllSingAfterWord() {
        signAfterWord.clear();
    }

    public void setSignAfterWord(List<Symbol> signAfterWord) {
        this.signAfterWord = signAfterWord;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        for (Symbol symbol : symbols) {
            sb.append(symbol);
        }
        return sb.toString();
    }
}
