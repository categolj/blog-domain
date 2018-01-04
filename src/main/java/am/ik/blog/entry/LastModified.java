package am.ik.blog.entry;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class LastModified implements Serializable {
	public static final LastModified EPOCH = new LastModified(0L);

	final ZonedDateTime value;

	public LastModified(ZonedDateTime value) {
		this.value = value;
	}

	public LastModified(Instant value) {
		this.value = value.atZone(ZoneId.systemDefault());
	}

	public LastModified(long epochMilli) {
		this(Instant.ofEpochMilli(epochMilli));
	}

	@Override
	public String toString() {
		return value == null ? null : value.toString();
	}
}
