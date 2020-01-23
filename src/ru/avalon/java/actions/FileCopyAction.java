package ru.avalon.java.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        Path source = Paths.get("lab-3-Tolula-Develop\\src\\copy\\copy.txt");
        Path target = Paths.get("lab-3-Tolula-Develop\\src\\move");
        try {
            System.out.println(Thread.currentThread().getName());
            Files.copy(source, target.resolve(source.getFileName()), REPLACE_EXISTING);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("We've been interrupted");
        }
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */

        //throw new UnsupportedOperationException("Not implemented yet!");
    }
}
