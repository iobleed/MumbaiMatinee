package com.plaxedo.MumbaiMatinee.data.entity;

import com.plaxedo.MumbaiMatinee.data.enums.Enums;
import org.springframework.data.annotation.Id;

public class Movie {

    @Id
    private String id;

    private String title;
    private String desc;
    private Enums.MOVIE_LANG lang;
    private Enums.MOVIE_GENRE genre;

    @Override
    public String toString(){
        return String.format(
                "Movie:\nid: %s \ntitle: %s \ndesc: %s \nlanguage: %s \ngenre: %s",
                id, title, desc, lang, genre);
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Enums.MOVIE_LANG getLang() {
        return lang;
    }

    public void setLang(Enums.MOVIE_LANG lang) {
        this.lang = lang;
    }

    public Enums.MOVIE_GENRE getGenre() {
        return genre;
    }

    public void setGenre(Enums.MOVIE_GENRE genre) {
        this.genre = genre;
    }
}
