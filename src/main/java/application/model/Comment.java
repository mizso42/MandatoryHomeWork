package application.model;

public class Comment {

    //TODO refactor sql
    private long id;
    private User author;
    private Entry entry;
    private Comment previous = null;
    private String text;
    private long date;
}
