package ru.avalon.java.actions;

import java.io.BufferedOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Действие, которое создает файл на дисковом
 * пространстве.
 */
public class FileCreateAction {
    /**
     * {@inheritDoc}
     */
    private FileWriter fileWriter;
    public FileCreateAction (String file) throws IOException {
            fileWriter = new FileWriter(file, true);
    }
    public synchronized void writing(String str, int i) {
        try {
            fileWriter.append(str + i);
            System.out.print(str + i);
                Thread.sleep(1000, 0);
            fileWriter.append("new char " + i + " loop");
            System.out.print("new char " + i + " ");
        } catch (IOException | InterruptedException e) {
            System.err.print("File error: " + e);
        }
    }
    public static class SynchronizedThread extends Thread {
        private FileCreateAction fca;
        public SynchronizedThread(String name,  FileCreateAction fca) {
            super(name);
            this.fca = fca;
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                fca.writing(getName(), i);
            }
        }
    }
        public void close() throws Exception {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.print("File closing error: " + e);
            }
        }
    }
