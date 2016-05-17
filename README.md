# Logger
## 1. Wizja
### Funkcjonalność podstawowa
Komponent ma za zadanie wyświetlać dane tekstowe w czasie rzeczywistym.
### Wygląd
Okno komponentu będzie skalowalne oraz będzie posiadało scroll bar z prawej strony. Poszczególne wiadomości wyświetlać się będą każda w nowej linii, opatrzone podaną datą i godziną.
### Komunikacja
Komunikacja z komponentem nastąpi poprzez wykorzystanie metod wystawionego API.
### Format danych wejściowych
Dane wejściowe to obiekty klasy String.
### Funkcjonalności dodatkowe
- konfigurowalny rozmiar historii (ustawialna maksymalna liczba znaków)
- możliwość zmiany domyślnego koloru (czarnego) na inne

## 2. Dokumentacja
### API
Dostępne do wykorzystania metody to:

|Logger|
|:-----|
|public void append(Date date, String content)|
|public void setColor(Color color)|
|public int getHistorySize()|
|public void setHistorySize(int historySize)|

Metoda append odpowiada za dodawanie wiadomości. Jako argumenty przyjmuje datę, z którą ma być wyświetlony dany content).
Metoda setColor ustawia kolor, w którym wyświetlane są wiadomości.
Metoda getHistorySize zwraca aktualny rozmiar bufora (dla 0 bufor nieograniczony).
Metoda setHistorySize ustawia aktualny rozmiar bufora.

### Technologia
Wykorzystane zostały biblioteki JavaFX wchodzące w skład JDK 1.8.

### Instrukcja użytkowania
Aby korzystać z komponentu należy zainicjalizować aplikację JavaFX. Następnie trzeba zainstancjonować Loggera przy użyciu bezparametrowego konstruktora.
Logger dziedziczy po klasie javafx.scene.control.ScrollPane, więc można go bezpośrednio osadzać np. w obiektach klasy javafx.scene.Scene i traktować jak część interfejsu JavaFX.
Aby dodawać wiadomości należy np. zaimplementować wątek, w którym na instancji loggera wywoływana będzie metoda apply(Date date, String content).
Przykładowe wykorzystanie loggera zademonstrowane jest w klasie DemoApp znajdującej się w folderze logger/example/ w ninejszym repozytorium.