package exercise5_13;

import java.time.*;
import java.util.Date;

public class DateTimeConvertor {
   public static Date toDate(LocalDateTime ldt) {
      return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
   }
}
