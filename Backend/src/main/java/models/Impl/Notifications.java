package models.Impl;

import java.util.List;

public class Notifications {
	private final List<OverDue> overDue;
	private final List<Upcoming> upcoming;

	private Notifications(Builder builder) {
		super();
		this.overDue = builder.overDue;
		this.upcoming = builder.upcoming;
	}

	public List<OverDue> getOverDue() {
		return overDue;
	}

	public List<Upcoming> getUpcoming() {
		return upcoming;
	}

	public static class Builder {
		private List<OverDue> overDue;
		private List<Upcoming> upcoming;

		private Builder() {

		}

		public static Builder newInstance() {
			return new Builder();
		}

		public Builder setOverDue(List<OverDue> overDue) {
			this.overDue = overDue;
			return this;
		}

		public Builder setUpcoming(List<Upcoming> upcoming) {
			this.upcoming = upcoming;
			return this;
		}

		public Notifications Build() {
			return new Notifications(this);
		}
	}
}
