package com.company.parser;

import com.company.entity.Symbol;
import com.company.entity.Word;

import java.util.ArrayList;
import java.util.List;

import static com.company.entity.Symbol.Type.END_OF_SENTENCE;
import static com.company.entity.Symbol.Type.LETTER;
import static com.company.entity.Symbol.Type.SEPARATOR;

public class WordParser extends Parser<Word> {
    @Override
    public List<Word> parse(char[] chars) {
        List<Word> out = new ArrayList<>();

        List<Symbol> symbols = new SymbolParser().parse(chars);

        List<Symbol> charsArray = new ArrayList<>();

        for (Symbol symbol : symbols) {
            if (symbol.getType() == LETTER) {
                charsArray.add(symbol);
            }
            if (symbol.getType() == SEPARATOR || symbol.getType() == END_OF_SENTENCE) {
                if(charsArray.size() > 1) {
                    Word e = new Word(new ArrayList<>(charsArray));
                    e.addSignAfterWord(symbol);
                    out.add(e);
                    charsArray.clear();
                } else
                    charsArray.add(symbol);
            }
        }
        return out;
    }
}
