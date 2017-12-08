package com.company.controller;

import com.company.entity.Document;
import com.company.entity.Sentence;
import com.company.manager.Manager;
import com.company.parser.Parser;
import com.company.parser.SentenceParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    public void run() throws IOException {
        Parser<Sentence> sentenceParser = new SentenceParser();
        Document doc1 = new Document("doc1", sentenceParser.parse(new File("source2.txt")));
        Manager manager = new Manager(doc1);
        manager.replaceFirstAndLastWordInSentence();
        System.out.println(doc1);
    }
}
