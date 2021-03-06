package com.example.cap02;

import androidx.annotation.NonNull;

public class Board {
    private String id;
    private String title;
    private String contents;
    private String name;

    public Board() {
    }

    public Board(String id, String title, String contents, String name) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Qna_Board{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + contents + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
