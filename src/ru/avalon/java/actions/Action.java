package ru.avalon.java.actions;

/**
 * Абстрактное представление о действии, как функциональном
 * элементе приложения.
 * <p>
 * Действие является потоковым объектом, что позволяет
 * исполнять несколько действий параллельно и не блокировать
 * основной поток исполнения.
 */
public interface Action extends Runnable, AutoCloseable {
    /**
     * Запускает потоковый объект на исполнение в отдельном
     * потоке исполнения.
     */
     default void start(Runnable r) throws InterruptedException {
        /*
         * TODO №1 Реализуйте метод start интерфейса Action.
         */
        Thread t = new Thread(r);
         t.start();
         while (t.isAlive()) {
             t.join(10000);
             System.out.println("Waiting...");
             if (t.isAlive()){
                 System.out.println("Tired of waiting!");
                 t.interrupt();
                 t.join();
             }
         }
         System.out.println(t.getName() + ": Done!");
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
}