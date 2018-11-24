package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.CsvFile;
import pl.sdacademy.citizens.model.CsvLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CsvConverter<T> {
    private final CsvFile csvFile;
    private final Function<CsvLine, T> mappingFunction;
    private final AtomicInteger lineCounter;

    public CsvConverter(CsvFile csvFile, Function<CsvLine, T> mappingFunction) {
        this.csvFile = csvFile;
        this.mappingFunction = mappingFunction;
        lineCounter = new AtomicInteger(0);
    }

    public List<T> convertUltraSimpleAndFastInJava() {
//        return csvFile.getLines().stream()
        return csvFile.getLines().parallelStream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    public List<T> convert() {
        Supplier<CsvLine> lineSupplier = () -> {
            int lineNumber = lineCounter.getAndIncrement();
            return csvFile.getLineAt(lineNumber);
        };

        List<T> results = Collections.synchronizedList(new ArrayList<>());

        int threadCount = Runtime.getRuntime().availableProcessors() - 1;
        System.out.println(threadCount);
        List<Thread> workerThread = new ArrayList<>();
        for (int threadNo = 0; threadNo < threadCount; threadNo++) {
            Runnable task = new ConverterWorker(lineSupplier, mappingFunction, results);
            Thread thread = new Thread(task);
            workerThread.add(thread);
        }
        workerThread.forEach(Thread::start);
        workerThread.forEach((thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//2       CsvLine lineToConvert;
//        while ((lineToConvert = lineSupplier.get()) != null) {
//            T mappedResult = mappingFunction.apply(lineToConvert);
//            results.add(mappedResult);
//        }

//1       List<CsvLine> allCsvLines = csvFile.getLines();
//        for (CsvLine csvLine : allCsvLines) {
//            T mappedResult = mappingFunction.apply(csvLine);
//            results.add(mappedResult);
//        }
        return results;
    }

    private class ConverterWorker implements Runnable {
        private final Supplier<CsvLine> lineSupplier;
        private final Function<CsvLine, T> converter;
        private final List<T> results;

        private ConverterWorker(Supplier<CsvLine> lineSupplier, Function<CsvLine, T> converter, List<T> results) {
            this.lineSupplier = lineSupplier;
            this.converter = converter;
            this.results = results;
        }

        @Override
        public void run() {
            CsvLine lineToConvert;
            while ((lineToConvert = lineSupplier.get()) != null) {
                T mappedResult = converter.apply(lineToConvert);
                results.add(mappedResult);
            }
        }
    }
}
