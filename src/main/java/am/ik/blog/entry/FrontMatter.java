package am.ik.blog.entry;

import java.io.Serializable;

import am.ik.blog.entry.json.FrontMatterDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

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

	public FrontMatter(Title title, Categories categories, Tags tags, EventTime date,
			EventTime updated, PremiumPoint point) {
		this.title = title;
		this.categories = categories;
		this.tags = tags;
		this.date = defaultValue(date, EventTime.UNSET);
		this.updated = defaultValue(updated, EventTime.UNSET);
		this.point = defaultValue(point, PremiumPoint.UNSET);
	}

	public FrontMatter(Title title, Categories categories, Tags tags, EventTime date,
			EventTime updated) {
		this(title, categories, tags, date, updated, PremiumPoint.UNSET);
	}

	private <T> T defaultValue(T value, T defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

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
