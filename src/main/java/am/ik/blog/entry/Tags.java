package am.ik.blog.entry;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import static java.util.stream.Collectors.toList;

@EqualsAndHashCode
public class Tags implements Serializable {
	final List<Tag> value;

	public Tags(Tag... tags) {
		this(Arrays.asList(tags));
	}

	public Tags(List<Tag> value) {
		if (value == null) {
			throw new IllegalArgumentException("value must not be null!!");
		}
		this.value = value;
	}

	public Stream<Tag> stream() {
		return this.value.stream();
	}

	public <A, R> R collect(Collector<Tag, A, R> collector) {
		return this.value.stream().collect(collector);
	}

	public int size() {
		return value.size();
	}

	@JsonIgnore
	public List<Tag> getValue() {
		return Collections.unmodifiableList(value);
	}

	@JsonProperty("tags")
	List<String> values() {
		return stream().map(Tag::getValue).collect(toList());
	}

	@Override
	public String toString() {
		return value == null ? null : value.toString();
	}
}
