package am.ik.blog.entry.json;

import java.io.IOException;
import java.time.OffsetDateTime;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import am.ik.blog.entry.Author;
import am.ik.blog.entry.EventTime;
import am.ik.blog.entry.Name;

public class AuthorDeserializer extends JsonObjectDeserializer<Author> {

	@Override
	protected Author deserializeObject(JsonParser jsonParser,
			DeserializationContext deserializationContext, ObjectCodec objectCodec,
			JsonNode jsonNode) throws IOException {
		Name name = new Name(nullSafeValue(jsonNode.get("name"), String.class));
		String dateText = nullSafeValue(jsonNode.get("date"), String.class);
		EventTime date = new EventTime(OffsetDateTime.parse(dateText));
		return new Author(name, date);
	}
}