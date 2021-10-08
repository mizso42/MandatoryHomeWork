package application.model;

import java.util.List;

public class Blog {

    private long id;
    private String title;
    private User author;
    private Template template;

    List<Entry> entries;
}
