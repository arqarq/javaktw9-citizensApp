package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.CsvFile;
import pl.sdacademy.citizens.model.CsvLine;
import pl.sdacademy.citizens.model.Person;

import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.function.Function;

public class PersonReader {
    public List<Person> readFromFile(File fileName) throws ParseException {
        CsvFile csvLines = CsvFile.fromFile(fileName);
//        List<Person> persons = new ArrayList<>();
        long start = System.currentTimeMillis();
        List<Person> persons = convert(csvLines);
        long stop = System.currentTimeMillis();
        System.out.println("Converted " + persons.size() + " in " + (stop - start) + " ms");
        return persons;
    }

    private List<Person> convert(CsvFile csvLines) throws ParseException {
        Function<CsvLine, Person> mappingFunction = (line) -> {
            try {
                return new Person(line);
            } catch (ParseException e) {
                return null;
            }
        };
        CsvConverter<Person> converter = new CsvConverter<>(csvLines, mappingFunction);
//        return converter.convert();
        return converter.convertUltraSimpleAndFastInJava();

//        List<Person> persons = new ArrayList<>();
//        for (CsvLine csvLine : csvLines) {
//            persons.add(new Person(csvLine));
//        }
//        return persons;
    }
}
