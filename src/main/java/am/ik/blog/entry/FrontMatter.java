package am.ik.blog.entry;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class FrontMatter implements Serializable {
	@JsonUnwrapped
	final Title title;
	@JsonUnwrapped
	final Categories categories;
	@JsonUnwrapped
	final Tags tags;
	@JsonIgnore
	final EventTime date;
	@JsonIgnore
	final EventTime updated;

	public static final String SEPARATOR = "---";
}
