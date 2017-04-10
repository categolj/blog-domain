package am.ik.blog.entry;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import am.ik.blog.entry.json.AuthorDeserializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@JsonDeserialize(using = AuthorDeserializer.class)
public class Author implements Serializable {
	@JsonUnwrapped
	final Name name;
	@JsonUnwrapped
	final EventTime date;
}
