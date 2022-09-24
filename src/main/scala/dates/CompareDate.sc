import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder}
import java.time.temporal.ChronoField
import java.time.{Instant, LocalDateTime, ZoneOffset}

Instant.now()

val TIMESTAMP_PATTERN1 = "yyyy-MM-dd HH:mm:ss"
val formatter1 = DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN1).withZone(ZoneOffset.UTC)
// in our case we are using last.value which is of Instant Type
formatter1.format(Instant.now())

// val TIMESTAMP_PATTERN2 = "yyyy-MM-dd HH:mm:ss.SSS"
// val formatter2 = DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN1)//.withZone(ZoneOffset.UTC)
// val dateString = "2020-06-15 17:35:47"
// OffsetDateTime.parse(dateString, formatter2)
// LocalDateTime.parse(dateString, formatter2)

val dateInString = "2016-09-18 12:17:21.651421";
val formatter3 = new DateTimeFormatterBuilder()
  .append(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN1)) //.withZone(ZoneOffset.UTC))
  .appendLiteral('.')
  .appendFraction(ChronoField.MILLI_OF_SECOND, 1, 6, false)
  //.appendOffsetId()
  .toFormatter();

// val offset = OffsetDateTime.parse(dateString, formatter3)
val instant = LocalDateTime.parse(dateInString, formatter3).atOffset(ZoneOffset.UTC)
// val zonedDateTime = instant.atZone(ZoneId.of("Asia/Kolkata"))
