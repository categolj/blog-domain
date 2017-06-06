package am.ik.blog.entry.json;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

import java.io.IOException;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import am.ik.blog.entry.*;

public class FrontMatterDeserializer extends JsonObjectDeserializer<FrontMatter> {

	@Override
	protected FrontMatter deserializeObject(JsonParser jsonParser,
			DeserializationContext deserializationContext, ObjectCodec objectCodec,
			JsonNode jsonNode) throws IOException {
		Title title = new Title(nullSafeValue(jsonNode.get("title"), String.class));
		Tags tags = new Tags(stream(jsonNode.get("tags").spliterator(), false)
				.map(n -> new Tag(n.asText())).collect(toList()));
		Categories categories = new Categories(
				stream(jsonNode.get("categories").spliterator(), false)
						.map(n -> new Category(n.asText())).collect(toList()));
		PremiumPoint point = new PremiumPoint(
				nullSafeValue(jsonNode.get("point"), Integer.class));
		return new FrontMatter(title, categories, tags, EventTime.UNSET, EventTime.UNSET,
				point);
	}
}