package Arona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    protected LocalDate from;
    protected LocalDate to;

    /**
     * Constructor for the events class which encapsulates a task with a set start and end date
     * @param  description  the name of the task
     * @param  from  the start date given in LocalDate readable format, time not included
     * @param  to  the start date given in LocalDate readable format, time not included
     */
    public Events(String description, LocalDate from, LocalDate to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String getCategory() {
        return "[E]";
    }

    public String toFriendlyString() {
        return super.toString() + " (by: " + from.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " to: "
                + to.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
