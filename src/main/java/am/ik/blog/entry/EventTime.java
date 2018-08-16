package am.ik.blog.entry;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class EventTime implements Serializable {
	public static EventTime UNSET = new EventTime(null) {
		@Override
		public String toString() {
			return "";
		}
	};

	public static EventTime now() {
		return new EventTime(OffsetDateTime.now());
	}

	@JsonProperty("date")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	final OffsetDateTime value;

	@JsonIgnore
	public boolean isSet() {
		return value != null;
	}

	@Override
	public String toString() {
		return value == null ? null : value.toString();
	}

	@JsonIgnore
	public boolean isOverHalfYearOld() {
		return this.isOld(6, ChronoUnit.MONTHS);
	}

	@JsonIgnore
	public boolean isOverOneYearOld() {
		return this.isOld(1, ChronoUnit.YEARS);
	}

	@JsonIgnore
	public boolean isOverThreeYearsOld() {
		return this.isOld(3, ChronoUnit.YEARS);
	}

	@JsonIgnore
	public boolean isOverFiveYearsOld() {
		return this.isOld(5, ChronoUnit.YEARS);
	}

	private boolean isOld(long amount, TemporalUnit unit) {
		return this.value.plus(amount, unit) //
				.isBefore(OffsetDateTime.now());
	}

	public String rfc1123() {
		return this.value.format(DateTimeFormatter.RFC_1123_DATE_TIME);
	}
}
