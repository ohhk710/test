package model.vo;

public class MeetingVO {
	private int id;
	private String name;
	private String title;
	private String meetingDate;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTitle() {
		return title;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	@Override
	public String toString() {
		return "MeetingVO [id="+id+",name="+name+",title="+title+",meetingDate=" + meetingDate + "]";
	}
}
