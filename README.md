# Do wszystkich zadań staramy się napisać testy jednostkowe!

## CSV
W aplikacji, w katalogu src/main/resources są wygenerowane dwa pliki: person.csv oraz animal.csv. Są to pliki w postaci CSV (Comma-Separated Values), czyli pliki, w których wartości są rozdzielone przecinkami. Każda linia pliku oznacza jeden zestaw danych, w którym informacje zawarte są na ściśle określonych pozycjach:
W pliku person.csv w kolejnych miejscach w linii znajdują się:
* identyfikator osoby
* imię
* nazwisko
* płeć
* data urodzenia
 
W pliku animal.csv w kolejnych miejscach w linii znajdują się:
* identyfikator właściciela (czyli ten sam identyfikator co identyfikator osoby z pliku person.csv)
* imię zwierzęcia
* gatunek
 
## O Programie
Aplikację uruchamia się z klasy pl.sdacademy.citizens.Main. Klasa Main tworzy i uruchamia klasę CitizensApplication, która za pomocą klasy PersonReader odczytuje z pliku dane o osobach i konwertuje je do listy obiektów typy Person. Następnie na wczytanej liście wykonywane są pewne operacje.
Zadania starałem się posortować po poziomie trudności.

## Zadania
1. W klasie CitizensApplication napisz metodę, która będzie grupować osoby po nazwisku i liczyć, ile osób ma dane nazwisko. Metoda powina zwracać mapę, gdzie kluczem będzie nazwisko, a wartością ilość osób z tym nazwiskiem.
2. W klasie CitizensApplication napisz metodę, która będzie grupować obiekty klasy Person po imieniu. Metoda powinna zwracać mapę, gdzie kluczem będzie imie, a wartością będzie lista osób z danym nazwiskiem.
3. W klasie CitizensApplication napisz metodę, która będzie filtrować osoby tak, aby zostały tylko te mające więcej niż 35 oraz mniej niż 55 lat. Metoda będzie zwracała liczbę takich osób.
4. W klasie CitizensApplication napisz metodę, która policzy osoby mogące ubiegać się o emeryturę (60 lat dla kobiet oraz 65 dla mężczyzn)
5. Utworzone metody (oraz jedną istniejącą) wydziel do nowej klasy - jak nazwiesz tę klasę?
6. Korzystając ze Stream API, spróbuj przepisać metody w nowej, wydzielonej klasie tak, aby miały jak najmniejszą objętość. Możesz posiłkować się wydzielaniem zagnieżdżonych metod.
7. W konstruktorze klasy Person jest tworzony obiekt typu SimpleDateFormat. Jest to kosztowna operacja, spróbuj więc jakoś zoptymalizować to miejsce. Po przetworzeniu wyników wyświetlany jest czas wykonywania konwersji - po prostej optymalizacji na moim komputerze udało przyśpieszyć się ten proces o połowę.
8. Zaimplementuj wzorzec Builder dla klasy Person.
9. Dodaj walidację wczytanych danych klasy Person:
   - Imię nie może być puste oraz nie może być krótsze niż 2 znaki
   - Nazwisko nie może być puste oraz nie może być krótsze niż 2 znaki
   - Płeć musi zawierać tylko jeden z następujących znaków: "F" albo "M"
   - Data urodzenia nie może być z przyszłości
   - Osoba musi być pełnoletnia
   
    Niepoprawne wyniki odrzuć.
10. Zaimplementuj klasę Animal - niech zawiera imię oraz gatunek zwierzęcia. Dodaj listę posiadanych zwierząt do klasy Person.
11. Napisz klasę AnimalReader, która będzie odczytywała plik animal.csv
12. Policz, ile jest zwierząt każdego z gatunków
13. Znajdź wszystkie osoby, które mają conajmniej 2 zwierzęta
14. Przepisz walidację wczytywanych danych tak, aby używała wzorca projektówego (odpowiedni wzorzec był omawiany na prezentacji)
15. Dopisz do klas CsvFile oraz CsvLine metody umożliwiające zapis pliku CSV na dysku
16. Wygeneruj plik z danymi osób, które nie przeszły walidacji (taki sam rekord jak w pliku wejściowym), dodając do niego informację o powodzie odrzucenia
17. Wczytaj plik person.csv oraz animal.csv, a następnie zapisz plik wynikowy, który będzie zawierał:
	- ID osoby
	- Imię
	- Utajnione nazwisko: Pierwsza litera nazwiska, pięć znaków `*`, ostatnia litera nazwiska (`Kowalski` -> `K*****i`; `Nowak` -> `N*****k`)
	- wiek w przybliżeniu do pięciu lat (osoby w wieku 23,24,25,26,27 są grupowane do 25 lat, osoby w wieku 28,29,30,31,32 są grupowane do wieku 30 lat, itd.)
	- ilość psów posiadanych przez osobę
	- ilość kotów posiadanych przez osobę
	- ilość papug posiadanych przez osobę
	- ilość rybek posiadanych przez osobę