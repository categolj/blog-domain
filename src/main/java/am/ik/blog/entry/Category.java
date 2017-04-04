package am.ik.blog.entry;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class Category implements Serializable {
	final String value;

	@Override
	public String toString() {
		return value;
	}
}
