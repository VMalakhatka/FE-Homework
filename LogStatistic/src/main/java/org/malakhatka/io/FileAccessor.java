package org.malakhatka.io;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.malakhatka.exception.FileAccessorException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileAccessor {
    private Path path;

    public FileAccessor(Path path) {
        verify(path);
        this.path = path;
    }

    private void verify(Path path){
        if (path==null) throw new FileAccessorException("Path is null");
        if(!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new FileAccessorException("Can't create "+path,e);
            }
        }
        if (!Files.isRegularFile(path)) throw new FileAccessorException("in not File " +path);
        if (!Files.isReadable(path)) throw new FileAccessorException("can't read "+path);
        if (!Files.isWritable(path)) throw new FileAccessorException("can't write in"+path);
    }

    public void writeAtEnd(String text){
        try {
            Files.writeString(path,text, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new FileAccessorException("Can't write in "+path,e);
        }
    }

    public List<String> readLastNLines(int nLines){
        if (nLines<=0) throw new FileAccessorException("Incorrect count of lines "+nLines);
        try(ReversedLinesFileReader reader=ReversedLinesFileReader.builder().setPath(path).setCharset(Charset.defaultCharset()).get()) {
             return reader.readLines(nLines); // TODO отсортировать в обратном порядке при необходимости
        } catch (IOException e) {
            throw new FileAccessorException("Can't read "+path,e);
        }
    }
}