package com.company.parser;

import com.company.entity.DocumentEntity;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.company.entity.Symbol.Type.END_OF_SENTENCE;

public class SentenceParser extends Parser<Sentence> {

    @Override
    public List<Sentence> parse(char[] chars) {
        List<Word> words = new WordParser().parse(chars);

        List<Sentence> out = new ArrayList<>();
        List<Word> tmp = new ArrayList<>();

        for (Word word : words) {
            tmp.add(word);
            for (Symbol symbol : word.getSignAfterWord()) {
                if (symbol.getType() == END_OF_SENTENCE) {
                    Sentence sentence = new Sentence(new ArrayList<>(tmp));
                    out.add(sentence);
                    tmp.clear();
                }
            }


        }
        out.add(new Sentence(tmp));
        return out;
    }
}
