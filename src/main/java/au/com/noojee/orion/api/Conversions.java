package au.com.noojee.orion.api;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.javamoney.moneta.Money;

public interface Conversions
{
	static final CurrencyUnit currencyUnit = Monetary.getCurrency(Locale.getDefault());

	/**
	 * Money
	 * 
	 * @param value
	 * @return
	 */
	public static Money asMoney(double value)
	{
		return Money.of(value, currencyUnit);
	}

	public static double asDouble(Money value)
	{
		return value.getNumber().doubleValue();
	}

	/**
	 * Local Date
	 * 
	 * @param dateToSeconds
	 * @return A LocalDate representing the epoc in the current system timezone. If the dateToSeconds is zero then the
	 *         constant Constants.DATEZERO is returned.
	 */
	public static LocalDate toLocalDate(long dateToSeconds)
	{
		LocalDate localDate = Instant.ofEpochSecond(dateToSeconds).atZone(ZoneId.systemDefault()).toLocalDate();

		return localDate;
	}

	public static long toLong(LocalDate localDate)
	{
		return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();

	}

	/**
	 * LocalDateTime
	 * 
	 * @param dateToSeconds
	 * @return A LocalDateTime representing the epoc in the current system timezone. If the dateToSeconds is zero then
	 *         the constant Constants.DATETIMEZERO is returned.
	 */
	public static LocalDateTime toLocalDateTime(long dateToSeconds)
	{
		LocalDateTime localDateTime = Instant.ofEpochSecond(dateToSeconds).atZone(ZoneId.systemDefault())
				.toLocalDateTime();

		return localDateTime;
	}

	public static Long toLong(LocalDateTime localDateTime)
	{
		return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();

	}

	/**
	 * Date
	 * 
	 * @param localDate
	 * @return
	 */
	public static Date toDate(LocalDate localDate)
	{
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDateTime toLocalDateTime(LocalDate cutoffDate)
	{
		return LocalDateTime.of(cutoffDate, LocalTime.of(0, 0));
	}

}
