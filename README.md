# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information

                                 |
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

### Login
| Form Login | Login Berhasil | Login Gagal |
|:---:|:---:|:---:|
| <img width="311" height="195" alt="Screenshot 2026-06-26 093106" src="https://github.com/user-attachments/assets/b5143a21-89d4-41b5-8c1b-62f589968fa8" /> | <img width="316" height="183" alt="Screenshot 2026-06-26 093122" src="https://github.com/user-attachments/assets/6407dcd3-d51e-4e0e-a79e-770200158b28" /> | <img width="302" height="189" alt="Screenshot 2026-06-26 093216" src="https://github.com/user-attachments/assets/547c6db5-bf14-42fa-b3df-511775d7f956" /> |

### Main Menu & Game
| Main Menu | Mulai Game |
|:---:|:---:|
| <img width="244" height="218" alt="Screenshot 2026-06-26 093244" src="https://github.com/user-attachments/assets/7efe7257-4d7c-4a95-ba06-ca8c4e0c4221" /> | <img width="298" height="356" alt="Screenshot 2026-06-26 093326" src="https://github.com/user-attachments/assets/59c8787b-f2fd-4060-8a1e-f7b318747880" /> |

### Kondisi Game
| Menang | Kalah | Draw |
|:---:|:---:|:---:|
| <img width="306" height="362" alt="Screenshot 2026-06-26 093412" src="https://github.com/user-attachments/assets/587fc5a8-c8b8-41f0-a97b-3b169a2d1c3f" /> | <img width="296" height="359" alt="Screenshot 2026-06-26 093429" src="https://github.com/user-attachments/assets/43a1035b-15f0-4284-a5c7-d249df8793ab" /> | <img width="299" height="356" alt="Screenshot 2026-06-26 093448" src="https://github.com/user-attachments/assets/69aa34cd-41d2-45ff-8286-e80acf24f8b8" /> |

### Statistik & Leaderboard
| Statistik | Top 5 Scorers | Keluar |
|:---:|:---:|:---:|
| <img width="254" height="225" alt="Screenshot 2026-06-26 093508" src="https://github.com/user-attachments/assets/d96089e9-266c-4839-b636-01892fc598be" /> | <img width="379" height="196" alt="Screenshot 2026-06-26 093547" src="https://github.com/user-attachments/assets/c1345615-494b-4345-8056-bca4e9fa3c63" /> | <img width="251" height="220" alt="Screenshot 2026-06-26 093608" src="https://github.com/user-attachments/assets/9182d381-83bb-4077-8bd6-9f332e639006" /> |
---

## Video Link
YouTube: [_(isi link video)_](https://youtu.be/OInEZr8-Ey0)

## GitHub Link
[_(isi link repository)_](https://github.com/nwmalz/FP-Pemdas-TicTacToe-Muhammad-Naufal-Akmal-Ali-Fanri-5026251191)
