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

    public SaveInfo() {
    }

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

    public void setTimeID(String timeID) {
        this.timeID = timeID;
    }

    public void setAnalogId(String analogId) {
        this.analogId = analogId;
    }

    public void setDigitalId(String digitalId) {
        this.digitalId = digitalId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public void setnOtifyId(String nOtifyId) {
        this.nOtifyId = nOtifyId;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setWeathId(String weathId) {
        this.weathId = weathId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public void setWeathloc(String weathloc) {
        this.weathloc = weathloc;
    }

    public String getTimeID() {
        return timeID;
    }

    public String getAnalogId() {
        return analogId;
    }

    public String getDigitalId() {
        return digitalId;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public String getDayId() {
        return dayId;
    }

    public String getDateId() {
        return dateId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getNewsId() {
        return newsId;
    }

    public String getMsgId() {
        return msgId;
    }

    public String getCallId() {
        return callId;
    }

    public String getnOtifyId() {
        return nOtifyId;
    }

    public String getTodo() {
        return todo;
    }

    public String getWeathId() {
        return weathId;
    }

    public String getNoteId() {
        return noteId;
    }

    public String getWeathloc() {
        return weathloc;
    }
}
