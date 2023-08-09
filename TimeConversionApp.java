import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter date and time (yyyy-MM-dd HH:mm:ss): ");
        String inputDateTime = scanner.nextLine();

        System.out.print("Enter source time zone (e.g., America/New_York): ");
        String sourceTimeZoneId = scanner.nextLine();

        System.out.print("Enter target time zone (e.g., Asia/Tokyo): ");
        String targetTimeZoneId = scanner.nextLine();

        // Parse input date-time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(inputDateTime, formatter);

        // Convert to source time zone
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(sourceTimeZoneId));

        // Convert to target time zone
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZoneId));

        // Display results
        System.out.println("Source Time: " + sourceZonedDateTime);
        System.out.println("Target Time: " + targetZonedDateTime);
    }
}
