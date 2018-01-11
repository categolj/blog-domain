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
public class Categories implements Serializable {
	final List<Category> value;

	public Categories(Category... categories) {
		this(Arrays.asList(categories));
	}

	public Categories(List<Category> value) {
		if (value == null) {
			throw new IllegalArgumentException("value must not be null!!");
		}
		this.value = value;
	}

	public Stream<Category> stream() {
		return this.value.stream();
	}

	public <A, R> R collect(Collector<Category, A, R> collector) {
		return this.value.stream().collect(collector);
	}

	public int size() {
		return value.size();
	}

	@JsonIgnore
	public List<Category> getValue() {
		return Collections.unmodifiableList(value);
	}

	@JsonProperty("categories")
	List<String> values() {
		return stream().map(Category::getValue).collect(toList());
	}

	@Override
	public String toString() {
		return value == null ? null : value.toString();
	}
}
