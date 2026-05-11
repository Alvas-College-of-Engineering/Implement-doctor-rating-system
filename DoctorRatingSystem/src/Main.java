import model.Doctor;
import model.Rating;
import service.DoctorService;

/**
 * Main.java — entry point for the Doctor Rating System.
 *
 * Run this file to see Java console output demonstrating:
 *   - Creating Doctor objects
 *   - Submitting Rating objects
 *   - Auto-calculated average ratings
 *   - Full doctor performance reports
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      DOCTOR RATING SYSTEM — JAVA     ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        // ── Step 1: Create the service (our in-memory "database") ──
        DoctorService service = new DoctorService();

        // ── Step 2: Create Doctor objects using the Doctor constructor ──
        Doctor d1 = new Doctor("D001", "Aisha Kapoor",   "Cardiology");
        Doctor d2 = new Doctor("D002", "Rohan Mehta",    "Neurology");
        Doctor d3 = new Doctor("D003", "Priya Nair",     "Pediatrics");
        Doctor d4 = new Doctor("D004", "Samuel D'Cruz",  "Dermatology");

        // ── Step 3: Register doctors with the service ──
        System.out.println("--- Registering Doctors ---");
        service.addDoctor(d1);
        service.addDoctor(d2);
        service.addDoctor(d3);
        service.addDoctor(d4);

        // ── Step 4: Submit ratings using Rating objects ──
        System.out.println("\n--- Submitting Ratings ---");

        service.submitRating("D001", new Rating("Patient A", 5, "Excellent cardiologist!", "2025-05-01"));
        service.submitRating("D001", new Rating("Patient B", 4, "Very thorough.", "2025-05-03"));
        service.submitRating("D001", new Rating("Patient C", 5, "Highly recommend.", "2025-05-07"));

        service.submitRating("D002", new Rating("Patient D", 3, "Average experience.", "2025-05-02"));
        service.submitRating("D002", new Rating("Patient E", 4, "Knowledgeable doctor.", "2025-05-05"));

        service.submitRating("D003", new Rating("Patient F", 5, "Great with kids!", "2025-05-04"));
        service.submitRating("D003", new Rating("Patient G", 5, "Very patient and kind.", "2025-05-06"));
        service.submitRating("D003", new Rating("Patient H", 4, "Good overall.", "2025-05-08"));

        service.submitRating("D004", new Rating("Patient I", 2, "Long wait times.", "2025-05-03"));
        service.submitRating("D004", new Rating("Patient J", 3, "Okay experience.", "2025-05-05"));

        // ── Step 5: Display full performance report ──
        service.displayAllDoctors();

        System.out.println("\n✔ Open frontend/index.html in a browser for the interactive UI.");
    }
}
