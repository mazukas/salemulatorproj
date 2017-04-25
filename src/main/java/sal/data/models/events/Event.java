package sal.data.models.events;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "events")
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@NotNull
	@Column(name="app_name")
	private String appName;
	
	@NotNull
	@Column(name="event_type")
	private String eventType;	
	
	@NotNull
	@Column(name="raw")
	@Lob
	private String raw;

	@Column(name="show_stopper_count")
	private int showStoppersCount;
	
	@Column(name="medium_count")
	private int mediumCount;
	
	@Column(name="minor_count")
	private int minorCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

	public int getShowStoppersCount() {
		return showStoppersCount;
	}

	public void setShowStoppersCount(int showStoppersCount) {
		this.showStoppersCount = showStoppersCount;
	}

	public int getMediumCount() {
		return mediumCount;
	}

	public void setMediumCount(int mediumCount) {
		this.mediumCount = mediumCount;
	}

	public int getMinorCount() {
		return minorCount;
	}

	public void setMinorCount(int minorCount) {
		this.minorCount = minorCount;
	}

}