package com.server.entity;

import lombok.Data;

@Data
public class BookEntityTelegram {
    private long id;
    private String author;
    private String publishing;
    private String title;
    private String typeBook;
    private String year;
}
