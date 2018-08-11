package am.ik.blog.entry.json;

import java.io.IOException;

import am.ik.blog.entry.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

public class FrontMatterDeserializer extends JsonObjectDeserializer<FrontMatter> {

	@Override
	protected FrontMatter deserializeObject(JsonParser jsonParser,
			DeserializationContext deserializationContext, ObjectCodec objectCodec,
			JsonNode jsonNode) throws IOException {
		Title title = new Title(nullSafeValue(jsonNode.get("title"), String.class));
		JsonNode tagsNode = jsonNode.get("tags");
		Tags tags = tagsNode == null ? new Tags()
				: new Tags(stream(tagsNode.spliterator(), false)
						.map(n -> new Tag(n.asText())).collect(toList()));
		JsonNode categoriesNode = jsonNode.get("categories");
		Categories categories = categoriesNode == null ? new Categories()
				: new Categories(stream(categoriesNode.spliterator(), false)
						.map(n -> new Category(n.asText())).collect(toList()));
		PremiumPoint point = new PremiumPoint(
				nullSafeValue(jsonNode.get("point"), Integer.class));
		return new FrontMatter(title, categories, tags, EventTime.UNSET, EventTime.UNSET,
				point);
	}
}