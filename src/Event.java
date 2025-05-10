import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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

    public String formatDateTime(){
        return (strMonth +" " + strDay +" " + strYear +" "
                + strHour +" " + strMinute);
    }

    public long dateTimeComparison(){
        return Long.parseLong(strYear+strMonth+strDay+strHour+strMinute);

    }
    public boolean isBefore(Event other) {
        return this.dateComparison <= other.dateComparison;
    }

    public boolean isAfter(Event other) {
        return this.dateComparison > other.dateComparison;
    }

    public boolean isInFuture() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime eventTime = LocalDateTime.of(year, month, day, hour, minute);
        return eventTime.isAfter(now);
    }

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
