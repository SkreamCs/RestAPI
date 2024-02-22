package abdul.restApi.model;

import java.util.Date;

public class Message {
    private Date date;
    private String text;

    public Message(Date date, String text) {
        this.date = date;
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
