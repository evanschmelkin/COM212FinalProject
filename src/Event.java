import java.time.LocalDate;
import java.time.LocalDateTime;

/*
Evan, Max, and Abdullah
4/22/2025
Data Structures
Final Project
Professor Tarimo
Friends.java
 */
public class Event {

    public LocalDateTime dateTime;
    public String description;

    public Event(LocalDateTime dateTimeP, String descriptionP){
        this.dateTime = dateTimeP;
        this.description = descriptionP;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public String getDescription(){
        return description;
    }
}
