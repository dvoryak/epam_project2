package com.company.parser;

import com.company.entity.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.entity.Symbol.Type.*;

public class SymbolParser extends Parser<Symbol> {
    Pattern pattern;
    Matcher matcher;

    @Override
    public List<Symbol> parse(char[] chars) {
        List<Symbol> out = new ArrayList<>();
        for (char c : chars) {
            if(c > 1) {
                Symbol symbol = new Symbol();
                symbol.setSymbol(c);
                if (isEndOfSentenceSymbol(c)) {
                    symbol.setType(END_OF_SENTENCE);
                }
                if (isSeparator(c)) {
                    symbol.setType(SEPARATOR);
                }
                if (isSimpleLetter(c)) {
                    symbol.setType(LETTER);
                }
                out.add(symbol);
            }
        }
        return out;
    }

    private boolean isSimpleLetter(char c) {
        pattern = Pattern.compile("[A-Za-zА-Яа-я]");
        matcher = pattern.matcher(Character.toString(c));
        return (matcher.matches());
    }

    private boolean isSeparator(char c) {
        pattern = Pattern.compile("[\\s-,\"\']");
        matcher = pattern.matcher(Character.toString(c));
        return (matcher.matches());
    }

    private boolean isEndOfSentenceSymbol(char c) {
        pattern = Pattern.compile("[!//.;?]");
        matcher = pattern.matcher(Character.toString(c));
        return (matcher.matches());
    }
}
