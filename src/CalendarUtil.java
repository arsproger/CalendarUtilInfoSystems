/**
 * @author Arsen Bekboev
 */
public class CalendarUtil {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CalendarUtil <год> <мес€ц>");
            return;
        }

        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);

        if (month < 1 || month > 12) {
            System.out.println("ћес€ц должен быть от 1 до 12.");
            return;
        }

        printCalendar(year, month);
    }

    public static void printCalendar(int year, int month) {
        String[] months = {
                "январь", "‘евраль", "ћарт", "јпрель", "ћай", "»юнь",
                "»юль", "јвгуст", "—ент€брь", "ќкт€брь", "Ќо€брь", "ƒекабрь"
        };
        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        int dayOfWeek = calculateDayOfWeek(year, month, 0);
        int daysInCurrentMonth = daysInMonth[month - 1];

        System.out.println(months[month - 1] + " " + year);
        System.out.println(" M  T  W  T  F  S  S");

        for (int i = 0; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= daysInCurrentMonth; day++) {
            System.out.printf("%2d ", day);
            if ((dayOfWeek + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static int calculateDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int dayOfWeek = (day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 - 2 * j) % 7;
        return (dayOfWeek + 5) % 7 + 1;
    }
}
