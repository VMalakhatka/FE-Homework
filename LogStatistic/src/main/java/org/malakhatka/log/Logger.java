package org.malakhatka.log;

import org.malakhatka.exception.LoggerException;
import org.malakhatka.io.FileAccessor;

import java.nio.file.Path;
import java.util.List;

public class Logger {
    private FileAccessor fileAccessor;
    private int countReader;
    private int countWriter;
    private int lieneCount;

    public Logger(Path path) {
        this.fileAccessor = new FileAccessor(path);
        countReader = 0;
        countWriter = 0;
        lieneCount = 0;
    }

    public synchronized void startReading() {
        while (countWriter > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new LoggerException("Прервано ожидание начала чтения", e);
            }
            countReader++;
        }
    }

    public List<String> readLastNLines(int nLines) {
        return fileAccessor.readLastNLines(nLines);
    }

    public synchronized void endReading() {
        countReader--;
        notifyAll();
    }

    public synchronized void startWriting() {
        while (countReader > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new LoggerException("Прервано ожидание начала записи", e);
            }
            countWriter++;
        }
    }

    public void writeAtEnd(String text) {
        fileAccessor.writeAtEnd(text);
        lieneCount+=text.lines().count();
    }

    public synchronized void endWriting() {
        countWriter--;
        notifyAll();
    }
    public int getLieneCount() {
        return lieneCount;
    }
}
