package application.model;

import java.sql.Timestamp;
import java.util.List;

public class Entry {

    private long id;
    private String subtitle;
    private String intro;
    private String body;
    private Timestamp postedAt;
    private Blog blog;

    List<Comment> comments;

}
