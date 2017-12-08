package com.company;


import com.company.controller.Controller;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;
import com.company.parser.Parser;
import com.company.parser.SentenceParser;
import com.company.parser.WordParser;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.run();
    }
}
