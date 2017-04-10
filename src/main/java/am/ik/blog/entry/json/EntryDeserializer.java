package am.ik.blog.entry.json;

import java.io.IOException;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import am.ik.blog.entry.*;

public class EntryDeserializer extends JsonObjectDeserializer<Entry> {

	@Override
	protected Entry deserializeObject(JsonParser jsonParser,
			DeserializationContext deserializationContext, ObjectCodec objectCodec,
			JsonNode jsonNode) throws IOException {
		Entry.EntryBuilder builder = Entry.builder();
		builder.entryId(new EntryId(nullSafeValue(jsonNode.get("entryId"), Long.class)));
		builder.content(
				new Content(nullSafeValue(jsonNode.get("content"), String.class)));
		JsonNode frontMatterNode = jsonNode.get("frontMatter");
		FrontMatter frontMatter = objectCodec
				.readValue(frontMatterNode.traverse(objectCodec), FrontMatter.class);
		builder.frontMatter(frontMatter);
		JsonNode createdNode = jsonNode.get("created");
		Author created = objectCodec.readValue(createdNode.traverse(objectCodec),
				Author.class);
		builder.created(created);
		JsonNode updatedNode = jsonNode.get("updated");
		Author updated = objectCodec.readValue(updatedNode.traverse(objectCodec),
				Author.class);
		builder.updated(updated);
		return builder.build();
	}
}
