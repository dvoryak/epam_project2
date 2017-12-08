package com.company.manager;

import com.company.entity.Document;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;

import java.util.List;

public class Manager {
    Document document;

    public Manager(Document document) {
        this.document = document;
    }

    public void replaceFirstAndLastWordInSentence() {
        List<Sentence> sentences = document.getSentences();
        for (Sentence sentence : sentences) {
            if(sentence.getWords().size() > 2) {
                Word firstTmp = sentence.getWords().get(0);
                Word lastTmp = sentence.getWords().get(sentence.getWords().size() - 1);

                List<Symbol> signAfterWordFirst = firstTmp.getSignAfterWord();
                List<Symbol> signAfterWordLast = lastTmp.getSignAfterWord();

                lastTmp.setSignAfterWord(signAfterWordFirst);
                firstTmp.setSignAfterWord(signAfterWordLast);


                sentence.getWords().set(0, lastTmp);
                sentence.getWords().set(sentence.getWords().size() - 1, firstTmp);
            }
        }
    }
}
