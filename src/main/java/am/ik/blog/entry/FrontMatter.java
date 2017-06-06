package am.ik.blog.entry;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import am.ik.blog.entry.json.FrontMatterDeserializer;
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
	@JsonUnwrapped
	final PremiumPoint point;

	public static final String SEPARATOR = "---";

	public Title title() {
		return title;
	}

	public Tags tags() {
		return tags;
	}

	public Categories categories() {
		return categories;
	}

	public EventTime date() {
		return date;
	}

	public EventTime updated() {
		return updated;
	}

	public PremiumPoint point() {
		return point;
	}
}
