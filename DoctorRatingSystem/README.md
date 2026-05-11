# Doctor Rating System
A Java + HTML/CSS/JS project demonstrating OOP concepts.

## Folder Structure
```
DoctorRatingSystem/
├── src/
│   ├── Main.java               ← Entry point (run this)
│   ├── model/
│   │   ├── Doctor.java         ← Doctor class (OOP)
│   │   └── Rating.java         ← Rating class (OOP)
│   └── service/
│       └── DoctorService.java  ← Manages ArrayList<Doctor>
└── frontend/
    └── index.html              ← Full website (open in browser)
```

## Run the Java Backend (VS Code)

### Option A — Terminal
```bash
cd src
javac model/Rating.java model/Doctor.java service/DoctorService.java Main.java
java -cp . Main
```

### Option B — Extension Pack for Java
1. Install **Extension Pack for Java** from the VS Code marketplace.
2. Open `src/Main.java`.
3. Click **▷ Run Java** in the top-right corner.

## Run the Frontend Website
1. Open `frontend/index.html` in any browser (no server needed).
2. Or install the **Live Server** VS Code extension, right-click `index.html` → **Open with Live Server**.

## OOP Concepts Used
| Concept        | Where                              |
|----------------|------------------------------------|
| Classes        | Doctor, Rating, DoctorService      |
| Constructors   | `Doctor(...)`, `Rating(...)`       |
| Encapsulation  | private fields + getters           |
| Objects        | `new Doctor(...)`, `new Rating(...)` |
| Methods        | `addRating()`, `calculateAverage()`, `displayDetails()` |
| ArrayList      | `DoctorService.doctors`            |
