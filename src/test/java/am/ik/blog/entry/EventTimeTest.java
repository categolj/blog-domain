package am.ik.blog.entry;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.OffsetDateTime;

import org.junit.Test;

public class EventTimeTest {
	@Test
	public void isOverHalfYearOld_ok() throws Exception {
		EventTime eventTime = new EventTime(
				OffsetDateTime.now().minusMonths(6).minusMinutes(1));
		assertThat(eventTime.isOverHalfYearOld()).isTrue();
	}

	@Test
	public void isOverHalfYearOld_ng() throws Exception {
		EventTime eventTime = new EventTime(
				OffsetDateTime.now().minusMonths(6).plusMinutes(1));
		assertThat(eventTime.isOverHalfYearOld()).isFalse();
	}

	@Test
	public void isOverOneYearOld_ok() throws Exception {
		EventTime eventTime = new EventTime(
				OffsetDateTime.now().minusYears(1).minusMinutes(1));
		assertThat(eventTime.isOverOneYearOld()).isTrue();
	}

	@Test
	public void isOverOneYearOld_ng() throws Exception {
		EventTime eventTime = new EventTime(
				OffsetDateTime.now().minusYears(1).plusMinutes(1));
		assertThat(eventTime.isOverOneYearOld()).isFalse();
	}

	@Test
	public void isOverThreeYearsOld_ok() throws Exception {
		EventTime eventTime = new EventTime(
				OffsetDateTime.now().minusYears(3).minusMinutes(1));
		assertThat(eventTime.isOverThreeYearsOld()).isTrue();
	}

	@Test
	public void isOverThreeYearsOld_ng() throws Exception {
		EventTime eventTime = new EventTime(
				OffsetDateTime.now().minusYears(3).plusMinutes(1));
		assertThat(eventTime.isOverThreeYearsOld()).isFalse();
	}

	@Test
	public void isOverFiveYearsOld_ok() throws Exception {
		EventTime eventTime = new EventTime(
				OffsetDateTime.now().minusYears(5).minusMinutes(1));
		assertThat(eventTime.isOverFiveYearsOld()).isTrue();
	}

	@Test
	public void isOverFiveYearsOld_ng() throws Exception {
		EventTime eventTime = new EventTime(
				OffsetDateTime.now().minusYears(5).plusMinutes(1));
		assertThat(eventTime.isOverFiveYearsOld()).isFalse();
	}
}