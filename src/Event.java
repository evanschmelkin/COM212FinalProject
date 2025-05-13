import java.time.LocalDateTime;


/*
this class is in control of the formatting of each event and compares their dates 
so we can print them out in order

*/

public class Event {
    int day;
    int month;
    int year;
    int hour;
    int minute;
    String strDay;
    String strMonth;
    String strYear;
    String strHour;
    String strMinute;

    String description;
    long dateComparison;
    String formatedDateTime;



    /**
     * @param dayp the day that the event will happen on
     * @param monthp the month that the event will happen on
     * @param yearp the year that the event will happen on
     * @param hourp the hour the event happens on
     * @param minutep the minute it happens on
     * @param descriptionp a string description of what the event is
     * 
     */
    public Event(int dayp, int monthp, int yearp, int hourp, int minutep, String descriptionp){
        day = dayp % 31;
        if (day< 10){
            strDay = "0"+ Integer.toString(day);
        }else{
            strDay = Integer.toString(day);
        }

        month = monthp % 12;
        if (month< 10){
            strMonth = "0"+ Integer.toString(month);
        }else{
            strMonth = Integer.toString(month);
        }


        year = yearp;
        if (year< 10){
            strYear = "000"+ Integer.toString(year);
        }else if(year < 100){
            strYear = "00"+ Integer.toString(year);

        }else if(year < 1000){
            strYear = "0"+ Integer.toString(year);

        }else{
            strYear = Integer.toString(year);
        }

        hour = hourp % 24;
        if (hour< 10){
            strHour = "0"+ Integer.toString(hour);
        }else{
            strHour = Integer.toString(hour);
        }

        minute = minutep % 60;
        if (minute< 10){
            strMinute = "0"+ Integer.toString(minute);
        }else{
            strMinute = Integer.toString(minute);
        }
        description = descriptionp;
        dateComparison = dateTimeComparison();
        formatedDateTime = formatDateTime();


    }
    /**
     * 
     * @return string that formatted date and time of the event so we are able to read off the txt file
     */
    public String formatDateTime(){
        return (strMonth +" " + strDay +" " + strYear +" "
                + strHour +" " + strMinute + " "+ description);
    }

    /**
     * 
     * @return string the description
     */
    public String getDescription(){

        return formatDateTime();
    }


    /**
     * 
     * @return long a number containing data about the time which we compare to other times
     */
    public long dateTimeComparison(){
        return Long.parseLong(strYear+strMonth+strDay+strHour+strMinute);

    }



    /**
     * 
     * @param other the other data we are comparing to
     * @return boolean if the event is before or at the same time
     * 
     */
    public boolean isBefore(Event other) {
        return this.dateComparison <= other.dateComparison;
    }


    /**
     * 
     * @param other the other data we are comparing to
     * @return boolean if the event is after or not
     * 
     */
    public boolean isAfter(Event other) {
        return this.dateComparison > other.dateComparison;
    }


    /**
     * @return boolean if the event s in the future
     * 
     */
    public boolean isInFuture() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime eventTime = LocalDateTime.of(year, month, day, hour, minute);
        return eventTime.isAfter(now);
    }
 /**
     * @return boolean if the event was in the past
     * 
     */
    public boolean wasInPast() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime eventTime = LocalDateTime.of(year, month, day, hour, minute);
        return eventTime.isBefore(now);
    }







    public static void main(String[] args){
        Event thisEvent = new Event(20,4,2001,12,34, "hi");

        Event thisEvent2 = new Event(2,4,201,1,34, "hieeee");

        System.out.println(thisEvent2.formatDateTime());
        System.out.println(thisEvent2.dateComparison);
        System.out.println(thisEvent2.isInFuture());
        System.out.println(thisEvent2.wasInPast());

    }

}
