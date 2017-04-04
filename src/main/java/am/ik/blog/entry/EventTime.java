package am.ik.blog.entry;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	final OffsetDateTime value;

	@Override
	public String toString() {
		return value == null ? null : value.toString();
	}
}
