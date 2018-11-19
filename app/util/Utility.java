package util;

import models.Bookings;

import java.util.Comparator;

public class Utility {

    public static class SortBookingByTime implements Comparator<Bookings> {

        @Override
        public int compare(Bookings o1, Bookings o2) {
            return o1.getStartTime().compareTo(o2.getStartTime());
        }
    }
}
