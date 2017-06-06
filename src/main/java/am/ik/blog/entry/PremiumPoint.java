package am.ik.blog.entry;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class PremiumPoint implements Serializable {
	@JsonProperty("point")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private final Integer value;

	public static final PremiumPoint UNSET = new PremiumPoint(null);

	public PremiumPoint(Integer value) {
		this.value = value;
	}

	@JsonIgnore
	public boolean isPremium() {
		return value != null;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
