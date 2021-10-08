package application.model;

import java.sql.Timestamp;
import java.util.List;

public class Comment {

    private long id;
    private User author;
    private Entry entry;
    private Comment previous = null;
    private String text;
    private Timestamp postedAt;

    private List<Comment> replies;
}
