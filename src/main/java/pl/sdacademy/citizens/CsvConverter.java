package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.CsvFile;
import pl.sdacademy.citizens.model.CsvLine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;

public class CsvConverter<T> {
    private final CsvFile csvFile;
    private final Function<CsvLine, T> mappingFunction;
    private final AtomicInteger lineCounter;

    public CsvConverter(CsvFile csvFile, Function<CsvLine, T> mappingFunction) {
        this.csvFile = csvFile;
        this.mappingFunction = mappingFunction;
        lineCounter = new AtomicInteger(0);
    }

    public List<T> convert() {
        Supplier<CsvLine> lineSupplier = () -> {
            int lineNumber = lineCounter.getAndIncrement();
            return csvFile.getLineAt(lineNumber);
        };

        List<T> results = new ArrayList<>();

        CsvLine lineToConvert;
        while ((lineToConvert = lineSupplier.get()) != null) {
            T mappedResult = mappingFunction.apply(lineToConvert);
            results.add(mappedResult);
        }
//        List<CsvLine> allCsvLines = csvFile.getLines();
//        for (CsvLine csvLine : allCsvLines) {
//            T mappedResult = mappingFunction.apply(csvLine);
//            results.add(mappedResult);
//        }
        return results;
    }
}
