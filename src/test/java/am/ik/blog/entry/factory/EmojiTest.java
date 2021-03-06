package am.ik.blog.entry.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EmojiTest {
	@Test
	public void parse() throws Exception {
		String s = Emoji.parse("Good \uD83D\uDE4C");
		assertThat(s).isEqualTo(
				"Good <img class=\"emoji\" draggable=\"false\" src=\"https://twemoji.maxcdn.com/16x16/1f64c.png\">");
	}

}