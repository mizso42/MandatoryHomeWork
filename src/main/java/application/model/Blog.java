package application.model;

import java.util.List;

public class Blog {

    //TODO refactor sql
    private long id;
    private String title;
    private User author;
    private ColorTheme colorTheme;
    private Category category;
    private byte[] backGround;

    List<Entry> entries;
}
