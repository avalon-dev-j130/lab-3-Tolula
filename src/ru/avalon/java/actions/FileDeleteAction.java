package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Действие, которое удаляет файлы с дискового
 * пространства.
 */
public class FileDeleteAction implements Action {
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        Path source = Paths.get("lab-3-Tolula-Develop\\src\\move\\copy.txt");
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000, 0);
            Files.delete(source);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        } catch (NoSuchFileException | InterruptedException x) {
            System.err.format("%s: no such" + " file or directory%n", source);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", source);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
    }

    @Override
    public void close() throws Exception {

    }
}
