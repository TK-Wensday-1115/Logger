# Logger
## 1. Wizja
### Funkcjonalność podstawowa
Komponent ma za zadanie wyświetlać dane tekstowe w czasie rzeczywistym.
### Wygląd
Okno komponentu będzie skalowalne oraz będzie posiadało scroll bar z prawej strony. Poszczególne wiadomości wyświetlać się będą każda w nowej linii, opatrzone aktualną datą i godziną.
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
|public void append(String content)|
|public void setColor(Color color)|
|public int getHistorySize()|
|public void setHistorySize(int historySize)|

### Technologia
Wykorzystane zostały biblioteki JavaFX wchodzące w skład JDK 1.8.