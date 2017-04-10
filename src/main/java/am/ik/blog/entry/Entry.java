package am.ik.blog.entry;

import java.io.Serializable;

import am.ik.blog.entry.json.EntryDeserializer;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.*;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Getter
@JsonDeserialize(using = EntryDeserializer.class)
public class Entry implements Serializable {
	@JsonUnwrapped
	final EntryId entryId;
	@JsonUnwrapped
	final Content content;
	final Author created;
	final Author updated;
	final FrontMatter frontMatter;

	public Entry.EntryBuilder copy() {
		return Entry.builder().entryId(entryId).content(content).created(created)
				.updated(updated).frontMatter(frontMatter);
	}

	public Entry useFrontMatterDate() {
		EntryBuilder builder = copy();
		if (frontMatter != null && frontMatter.date != null
				&& frontMatter.date.value != null && created != null) {
			builder.created(new Author(created.name, frontMatter.date));
		}
		if (frontMatter != null && frontMatter.updated != null
				&& frontMatter.updated.value != null && updated != null) {
			builder.updated(new Author(updated.name, frontMatter.updated));
		}
		return builder.build();
	}
}
