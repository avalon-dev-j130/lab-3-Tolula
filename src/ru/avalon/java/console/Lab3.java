package ru.avalon.java;

import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileCreateAction;
import ru.avalon.java.actions.FileDeleteAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {

        System.out.println("create thread : " + Thread.currentThread().getName());
        new Lab3().run();
        System.out.println("close thread : " + Thread.currentThread().getName());
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws Exception {
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */
                new  FileCopyAction().start(new  FileCopyAction());
                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */
                new  FileMoveAction().start(new  FileMoveAction());
                break;
            case exit:
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
            case delete:
                new FileDeleteAction().start(new  FileDeleteAction());
            case create:
                FileCreateAction f = null;
                try {
                    f = new FileCreateAction ("lab-3-Tolula-Develop\\src\\copy\\copy.txt");
                    FileCreateAction.SynchronizedThread t1 = new FileCreateAction.SynchronizedThread("Java", f);
                    FileCreateAction.SynchronizedThread t2 = new  FileCreateAction.SynchronizedThread("J130", f);
                    t1.start();
                    t2.start();
                    t1.join();
                    t2.join();
                } catch (IOException e) {
                    System.err.print("File error: " + e);
                } catch (InterruptedException e) {
                    System.err.print("Thread error: " + e);
                } finally {
                    assert f != null;
                    f.close();
                }
            }




        }
    }

