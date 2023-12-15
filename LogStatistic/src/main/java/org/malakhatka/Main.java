package org.malakhatka;

import org.malakhatka.log.Logger;
import org.malakhatka.model.Reader;
import org.malakhatka.model.Writer;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

//Есть 3 потока, которые периодически записывают данные о произошедших в системе событиях в лог (файл).
//        События могут быть уровня info, warning и error. Другие два потока читают новую информацию в логе.
//        Первый читающий поток ведёт статистику событий с помощью класса Statistics.
//        Второй читающий поток анализирует записи на предмет содержания чувствительной информации (пароли, email’ы)
//        с помощью класса Secure.
//        Ещё в одном потоке работает экземпляр класса Signalization, который принимает данные от Statistics и Secure.
//        Если в собранной статистике доля событий типа error в системе становится больше заданного процента
//        (например, 20%),  то Signalization выдаёт предупреждение команде эксплуатации, что система находится в
//        критическом состоянии.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Path path=Path.of("log.log");
        Logger logger=new Logger(path);
        List<Writer> writers= Arrays.stream(new int[3]).mapToObj(e-> new Writer(logger)).toList();
        List<Thread> writerThreads = writers.stream().map(Thread::new).peek(Thread::start).toList();
        Thread.sleep(3000);
        List<Reader> readers = Arrays.stream(new int[3]).mapToObj(e-> new Reader(logger)).toList();
        List<Thread> readerThreads = readers.stream().map(Thread::new).peek(Thread::start).toList();
    }
}