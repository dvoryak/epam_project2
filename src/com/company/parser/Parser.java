package com.company.parser;

import com.company.entity.DocumentEntity;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.List;


public abstract class Parser<T extends DocumentEntity> {

    public abstract List<T> parse(char[] chars);

    public List<T> parse(File file) throws IOException {
        CharBuffer charBuffer = CharBuffer.allocate((int)file.length());
        try(FileReader fileReader = new FileReader(file)) {
            while(fileReader.ready()) {
                fileReader.read(charBuffer);
            }
        }
        return parse(charBuffer.array());
    }

    public List<T> parse(String fileName) throws IOException {
        File file = new File(fileName);
        return parse(file);
    }

    public List<T> parse(URI uri) throws IOException {
        File file = new File(uri);
        return parse(file);
    }
}
