package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        //throw new UnsupportedOperationException("Not implemented yet!");

        Path source = Paths.get("lab-3-Tolula-Develop\\src\\move\\copy.txt");
        Path target = Paths.get("lab-3-Tolula-Develop\\src\\copy");
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000, 0);
            Files.move(source, target.resolve(source.getFileName()), REPLACE_EXISTING);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("We've been interrupted");
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }

}
