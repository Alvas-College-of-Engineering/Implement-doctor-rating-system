package service;

import model.Doctor;
import model.Rating;
import java.util.ArrayList;

/**
 * DoctorService manages all Doctor objects.
 *
 * Acts as a simple in-memory "database" using an ArrayList.
 * Provides methods to add doctors, find them by ID, submit ratings,
 * and display all doctor records.
 */
public class DoctorService {

    // ----- Internal storage -----
    private ArrayList<Doctor> doctors; // stores all Doctor objects

    // ----- Constructor -----
    /**
     * Initialises the service with an empty doctor list.
     */
    public DoctorService() {
        this.doctors = new ArrayList<>();
    }

    // ----- Methods -----

    /**
     * Registers a new Doctor in the system.
     *
     * @param doctor A fully constructed Doctor object
     */
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor registered: Dr. " + doctor.getDoctorName()
                + " [" + doctor.getDoctorId() + "]");
    }

    /**
     * Finds a doctor by their unique ID.
     *
     * @param doctorId The ID to search for (e.g. "D001")
     * @return The matching Doctor, or null if not found
     */
    public Doctor findDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equalsIgnoreCase(doctorId)) {
                return d;
            }
        }
        System.out.println("  ⚠ Doctor not found: " + doctorId);
        return null;
    }

    /**
     * Submits a Rating to a doctor identified by their ID.
     *
     * @param doctorId ID of the doctor to rate
     * @param rating   The Rating object to add
     */
    public void submitRating(String doctorId, Rating rating) {
        Doctor doctor = findDoctorById(doctorId);
        if (doctor != null) {
            doctor.addRating(rating);
        }
    }

    /**
     * Prints the full profile of every doctor to the console.
     */
    public void displayAllDoctors() {
        System.out.println("\n========== ALL DOCTORS ==========");
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered yet.");
        } else {
            for (Doctor d : doctors) {
                d.displayDetails();
            }
        }
    }

    /**
     * Returns the full list of doctors (used by other classes if needed).
     */
    public ArrayList<Doctor> getAllDoctors() {
        return doctors;
    }
}
