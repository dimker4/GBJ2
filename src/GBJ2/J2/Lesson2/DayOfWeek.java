package GBJ2.J2.Lesson2;

public enum DayOfWeek {
    MONDAY, TUESDAY,  WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    final private int cntHoursWorkingWeek = 40;
    final private int cntHoursWorkingDay = 8;

    public int getHoursToWeekend() { 

        if (this.ordinal() > 5) {
            return 0;
        } else {
            return cntHoursWorkingWeek - this.ordinal()  * cntHoursWorkingDay;
        }
    }
}
