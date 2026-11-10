package collectionsframework.taskpracticum.comparator;

import java.util.Comparator;

public class DateTimeComparator implements Comparator<DateTime> {

    @Override
    public int compare(DateTime dt1, DateTime dt2) {
        int res = Integer.compare(dt1.year, dt2.year);
        if (res != 0) return res;

        res = Integer.compare(dt1.month, dt2.month);
        if (res != 0) return res;

        res = Integer.compare(dt1.day, dt2.day);
        if (res != 0) return res;

        res = Integer.compare(dt1.hours, dt2.hours);
        if (res != 0) return res;

        res = Integer.compare(dt1.minutes, dt2.minutes);
        if (res != 0) return res;

        return Integer.compare(dt1.seconds, dt2.seconds);

    }

}
