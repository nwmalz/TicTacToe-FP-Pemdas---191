# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information

| Field      | Isi                                      |
|------------|------------------------------------------|
| Name       | Muhammad Naufal Akmal Ali Fanri          |
| Student ID | 5026251191                               |
| Class      | A                                        |

---

## Project Description

Aplikasi permainan Tic-Tac-Toe berbasis Java Swing dengan fitur login menggunakan database PostgreSQL, pencatatan statistik per pemain, dan tampilan Top 5 Scorers leaderboard. Pemain melawan komputer yang menggunakan algoritma **random** untuk menentukan langkah.

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
private static final String URL      = "jdbc:postgresql://localhost:5433/game_project";
private static final String USER     = "postgres";
private static final String PASSWORD = "akmal01073123";
```

### 4. Jalankan
- Run `Main.java`
- Login: `student1` / `12345`

---

## Class Explanation

| Class             | Fungsi                                                      |
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

<img width="311" height="195" alt="image" src="https://github.com/user-attachments/assets/dc01dd2a-8f56-471e-b5bf-095df408faf0" /> <img width="316" height="183" alt="image" src="https://github.com/user-attachments/assets/fbe3133d-2c27-4f5b-9460-f8006e5dbe55" /> <img width="302" height="189" alt="image" src="https://github.com/user-attachments/assets/2307f424-d9de-4763-bc68-68c36fd92c60" />
**Login**


<img width="244" height="218" alt="image" src="https://github.com/user-attachments/assets/d08ba11f-0254-4d49-ba0c-a5f1c2b6f164" />
**Main Menu**

<img width="298" height="356" alt="image" src="https://github.com/user-attachments/assets/281606d5-c604-46f7-9ffd-0aab1dbd9e6e" />
**Mulai Game**

<img width="306" height="362" alt="image" src="https://github.com/user-attachments/assets/96ec68ba-8d17-4ef1-b948-66d99bafc902" /> <img width="296" height="359" alt="image" src="https://github.com/user-attachments/assets/9e4a8690-7e17-49c5-bdac-963ca2abbec5" /> <img width="299" height="356" alt="image" src="https://github.com/user-attachments/assets/e49c5160-b9fc-4bf7-a811-dc5be51e443a" />
**Kondisi 'WIN','LOSE','DRAW'**

<img width="254" height="225" alt="image" src="https://github.com/user-attachments/assets/2e7b062e-6933-4568-8edc-9e3f8e293d39" />
**Statistik**

<img width="379" height="196" alt="image" src="https://github.com/user-attachments/assets/47f2a26e-ce94-4ad4-83ad-8d1cd900208d" />
**Top 5 Score Leaderboard**

<img width="251" height="220" alt="image" src="https://github.com/user-attachments/assets/d2a43cb9-f27d-4e37-98dd-4196e747310f" />
**Keluar Game**
---

## Video Link
YouTube: [_(isi link video)_](https://youtu.be/OInEZr8-Ey0)

## GitHub Link
_(isi link repository)_
