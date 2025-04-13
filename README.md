### 🔖  Aplikacja do zarządzania kampaniami reklamowymi

Umożliwia tworzenie, edytowanie, przeglądanie oraz usuwanie kampanii, które zawierają podstawowe informacje takie jak: nazwa, słowa kluczowe, stawka, budżet, status, lokalizacja i zasięg.

---

#### 🌍 Aplikacja dostępna online: 

https://campaigns-production-b5ed.up.railway.app/

---

### 💡 Dodatki:
- Saldo konta jest aktualizowane dynamicznie (pobieranez z serwera, odejmowane przy tworzeniu, różnicowane przy edycji, zwracane przy usunięciu).
- Frontend zbudowany jako SPA (Single Page Application) w czystym JavaScript (vanilla JS) z podstronami /, /new, /edit.

---

### 📌 API Endpoints

#### GET: `/api/getAll`

- Zwraca wszystkie dodane kampanie (aktywna jak i nieaktywne).

#### GET: `/api/getCampaign/id`

- Zwraca konkretną wybraną kampanie.

#### GET: `/api/balance`

- Pobiera z serwera obecny balans konta (ustawiona domyślnie wartość początkowa: 1000).

#### POST: `/api/new`

- Dodaje nową kampanie do bazy.

#### PUT: `/api/edit/id`

- Edytuje wybraną istniejąca kampanię.

#### DELETE: `/api/remove/id`

- Usuwa wybraną istniejącą kampanię.

---

### 🛠️  Użyte technologie
- **Java 17** + **Spring Boot** tworzy backend REST API
- **Spring Data JPA** operacje na kampaniach w bazie
- **Maven** dla zarządzania zależnościami
- **H2 database** działającą w pamięci
- **JavaScript** generowanie dynamicznego elementów + SPA 
- **HTML, CSS** prosty wygląd strony
---




---
