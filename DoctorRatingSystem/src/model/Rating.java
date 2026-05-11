package model;

/**
 * Rating class stores a single patient rating for a doctor.
 * Demonstrates encapsulation using private fields and public getters.
 */
public class Rating {

    // ----- Attributes (private for encapsulation) -----
    private String patientName;
    private int stars;          // 1 to 5
    private String comment;
    private String date;        // e.g. "2025-06-01"

    // ----- Constructor -----
    /**
     * Creates a new Rating object.
     *
     * @param patientName Name of the patient leaving the rating
     * @param stars       Rating value from 1 to 5
     * @param comment     Optional comment from the patient
     * @param date        Date the rating was submitted
     */
    public Rating(String patientName, int stars, String comment, String date) {
        // Validate star range
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Stars must be between 1 and 5.");
        }
        this.patientName = patientName;
        this.stars = stars;
        this.comment = comment;
        this.date = date;
    }

    // ----- Getters (public accessors) -----
    public String getPatientName() { return patientName; }
    public int getStars()          { return stars; }
    public String getComment()     { return comment; }
    public String getDate()        { return date; }

    // ----- Display method -----
    /**
     * Returns a formatted string representation of this rating.
     */
    public String toString() {
        return String.format("  [%s] %s gave %d/5 stars — \"%s\"",
                date, patientName, stars, comment);
    }
}
