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
        start();

        Path source = Paths.get("d:\\Users\\lab-3-Tolula\\src\\test.txt");
       // Path path = Paths.get("c:\\data\\myfile.txt");

        Path target = Paths.get("d:\\Users\\lab-3-Tolula\\src\\dir");
        try {
            Files.copy(source, target.resolve(source.getFileName()), REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
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
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
