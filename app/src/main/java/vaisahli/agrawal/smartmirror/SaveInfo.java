package vaisahli.agrawal.smartmirror;

import android.text.Editable;

public class SaveInfo {
    public String timeID;
    public String analogId;
    public String digitalId;
    public String calendarId;
    public String dayId;
    public String dateId;
    public String eventId;
    public String newsId;
    public String msgId;
    public String callId;
    public String nOtifyId;
    public String todo;
    public String weathId;
    public String noteId;
    public String weathloc;

    public SaveInfo(String timeID, String analogId, String digitalId, String calendarId, String dayId, String dateId, String eventId,
                    String newsId, String msgId, String callId, String nOtifyId, String todo, String weathId, String noteId, String weathloc) {
        this.timeID = timeID;
        this.analogId = analogId;
        this.digitalId = digitalId;
        this.calendarId = calendarId;
        this.dayId = dayId;
        this.dateId = dateId;
        this.eventId = eventId;
        this.newsId = newsId;
        this.msgId = msgId;
        this.callId = callId;
        this.nOtifyId = nOtifyId;
        this.todo = todo;
        this.weathId = weathId;
        this.noteId = noteId;
        this.weathloc = weathloc;
    }
}
