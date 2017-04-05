package am.ik.blog.entry;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class EntryId implements Serializable {
	@JsonProperty("entryId")
	final Long value;

	public EntryId(String entryId) {
		this(Long.valueOf(entryId));
	}

	@Override
	public String toString() {
		return value == null ? null : value.toString();
	}
}
