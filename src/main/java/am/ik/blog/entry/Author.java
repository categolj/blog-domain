package am.ik.blog.entry;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Author implements Serializable {
	@JsonUnwrapped
	final Name name;
	@JsonUnwrapped
	final EventTime date;
}
