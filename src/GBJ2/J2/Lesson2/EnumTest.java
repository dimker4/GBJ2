package GBJ2.J2.Lesson2;

public class EnumTest {
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.MONDAY;
        int numDay = day.ordinal();
        System.out.println(day.getHoursToWeekend(numDay));

    }
}


