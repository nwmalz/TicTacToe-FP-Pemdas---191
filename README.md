# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information

| Field      | Isi                                      |
|------------|------------------------------------------|
| Name       | _(isi nama kamu)_                        |
| Student ID | _(isi NRP kamu)_                         |
| Class      | ES234211 – Programming Fundamental       |

---

## Project Description

Aplikasi permainan Tic-Tac-Toe berbasis Java Swing dengan fitur login menggunakan database PostgreSQL, pencatatan statistik per pemain, dan tampilan Top 5 Scorers. Pemain berlomba melawan komputer yang menggunakan algoritma **Minimax** untuk menentukan langkah terbaik.

---

## Features

- Login menggunakan data dari database (username & password)
- Papan Tic-Tac-Toe interaktif berbasis JButton 3x3
- Komputer menggunakan algoritma Minimax
- Deteksi otomatis: menang, kalah, dan seri
- Statistik (wins, losses, draws, score) tersimpan di database setelah setiap game
- Halaman Statistik Pribadi yang diambil langsung dari database
- Halaman Top 5 Scorers menggunakan JTable

---

## Score Calculation

| Hasil  | Tambahan Skor |
|--------|---------------|
| Menang | +10 poin      |
| Seri   | +3 poin       |
| Kalah  | +0 poin       |

---

## Database

**DBMS:** PostgreSQL  
**Nama Database:** `game_project`  
**Jumlah Tabel:** 1 (tabel `players`)

### Skema Tabel `players`

| Kolom    | Tipe         | Keterangan          |
|----------|--------------|---------------------|
| id       | SERIAL (PK)  | ID unik pemain      |
| username | VARCHAR(50)  | Nama login (UNIQUE) |
| password | VARCHAR(100) | Password pemain     |
| wins     | INT          | Jumlah kemenangan   |
| losses   | INT          | Jumlah kekalahan    |
| draws    | INT          | Jumlah seri         |
| score    | INT          | Total skor          |

---

## How to Run

### 1. Siapkan Database
- Buka pgAdmin → buat database `game_project`
- Buka Query Tool → jalankan `database/schema_postgresql.sql`

### 2. Tambahkan PostgreSQL JDBC Driver
- Download di: https://jdbc.postgresql.org/download/
- Di IntelliJ: File → Project Structure → Libraries → + → Java → pilih file .jar

### 3. Konfigurasi DatabaseManager.java
```java
private static final String URL      = "jdbc:postgresql://localhost:5432/game_project";
private static final String USER     = "postgres";
private static final String PASSWORD = "password_kamu";
```

### 4. Jalankan
- Run `Main.java`
- Login: `student1` / `12345`

---

## Class Explanation

| Class             | Tanggung Jawab                                              |
|-------------------|-------------------------------------------------------------|
| Main              | Entry point, membuka LoginFrame                            |
| DatabaseManager   | Menyediakan koneksi JDBC ke PostgreSQL                     |
| Player            | Model data pemain (id, username, statistik)                |
| PlayerService     | Operasi database: login, update statistik, Top 5           |
| GameLogic         | Logika board: validasi move, cek menang/seri, AI Minimax   |
| LoginFrame        | Window login                                               |
| MainMenuFrame     | Window navigasi utama setelah login                        |
| GameFrame         | Window permainan Tic-Tac-Toe interaktif                    |
| StatisticsFrame   | Window statistik pribadi pemain                            |
| TopScorersFrame   | Window Top 5 Scorers menggunakan JTable                    |

---

## Screenshots

_(tambahkan screenshot setelah program berjalan)_

---

## Video Link
YouTube: _(isi link video)_

## GitHub Link
_(isi link repository)_
