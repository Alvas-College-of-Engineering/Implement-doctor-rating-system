package model;

import java.util.ArrayList;

/**
 * Doctor class represents a medical doctor in the rating system.
 *
 * OOP Concepts demonstrated:
 *   - Encapsulation : all fields are private; accessed via getters/setters
 *   - Constructor   : initialises object state on creation
 *   - Methods       : addRating(), calculateAverage(), displayDetails()
 */
public class Doctor {

    // ----- Attributes -----
    private String doctorId;
    private String doctorName;
    private String specialization;
    private double averageRating;   // calculated automatically
    private int    totalRatings;    // count of all ratings received
    private ArrayList<Rating> ratingHistory; // stores every Rating object

    // ----- Constructor -----
    /**
     * Creates a new Doctor with zero ratings.
     *
     * @param doctorId       Unique identifier (e.g. "D001")
     * @param doctorName     Full name of the doctor
     * @param specialization Medical specialization (e.g. "Cardiology")
     */
    public Doctor(String doctorId, String doctorName, String specialization) {
        this.doctorId       = doctorId;
        this.doctorName     = doctorName;
        this.specialization = specialization;
        this.averageRating  = 0.0;
        this.totalRatings   = 0;
        this.ratingHistory  = new ArrayList<>(); // empty list on creation
    }

    // ----- Core Methods -----

    /**
     * Adds a new Rating to this doctor's history and recalculates the average.
     *
     * @param rating A Rating object submitted by a patient
     */
    public void addRating(Rating rating) {
        ratingHistory.add(rating);      // store the rating
        totalRatings++;                 // increment counter
        calculateAverage();             // update average
        System.out.println("  ✔ Rating added for Dr. " + doctorName);
    }

    /**
     * Recalculates the average rating from the full rating history.
     * Called automatically after every addRating().
     */
    public void calculateAverage() {
        if (totalRatings == 0) {
            averageRating = 0.0;
            return;
        }
        int sum = 0;
        for (Rating r : ratingHistory) {
            sum += r.getStars();
        }
        // Round to 1 decimal place
        averageRating = Math.round((double) sum / totalRatings * 10.0) / 10.0;
    }

    /**
     * Prints all doctor details and rating history to the console.
     */
    public void displayDetails() {
        System.out.println("==============================================");
        System.out.println("  Doctor ID     : " + doctorId);
        System.out.println("  Name          : Dr. " + doctorName);
        System.out.println("  Specialization: " + specialization);
        System.out.printf( "  Average Rating: %.1f / 5.0%n", averageRating);
        System.out.println("  Total Ratings : " + totalRatings);
        System.out.println("  Rating History:");
        if (ratingHistory.isEmpty()) {
            System.out.println("    (No ratings yet)");
        } else {
            for (Rating r : ratingHistory) {
                System.out.println(r.toString());
            }
        }
        System.out.println("==============================================");
    }

    // ----- Getters -----
    public String           getDoctorId()       { return doctorId; }
    public String           getDoctorName()     { return doctorName; }
    public String           getSpecialization() { return specialization; }
    public double           getAverageRating()  { return averageRating; }
    public int              getTotalRatings()   { return totalRatings; }
    public ArrayList<Rating> getRatingHistory() { return ratingHistory; }
}
