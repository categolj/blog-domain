package am.ik.blog.entry;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class Content implements Serializable {
	@JsonProperty("content")
	final String value;

	@Override
	public String toString() {
		return value;
	}

	public boolean isEmpty() {
		return value == null || value.isEmpty();
	}
}
