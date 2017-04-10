package am.ik.blog.entry;

import java.io.Serializable;

import am.ik.blog.entry.json.FrontMatterDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@JsonDeserialize(using = FrontMatterDeserializer.class)
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
