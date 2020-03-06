package com.example.index;

public class Readingdatamodel {
    String date;
    String time;
    String phvalue;
    String temperaturevalue;

    public Readingdatamodel()
    {

    }
         public Readingdatamodel (String date, String time, String phvalue, String temperaturevalue)
        {
            this.date = date;
            this.time = time;
            this.phvalue = phvalue;
            this.temperaturevalue = temperaturevalue;

        }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPhvalue() {
        return phvalue;
    }

    public String getTemperaturevalue() {
        return temperaturevalue;
    }
}
