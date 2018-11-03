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