package com.company.entity;

public class Symbol implements DocumentEntity {

    public static enum Type{
        END_OF_SENTENCE, SEPARATOR, LETTER
    }

    private char symbol;
    private Type type;

    public Symbol() {
    }

    public Symbol(char symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }


    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
