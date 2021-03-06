package com.courses.week5.jdbc.entity;


public class Movie extends AbstractEntity {

    private String title;
    private int year;
    private String director;

    public Movie(long id, String title, int year, String director) {
        super(id);
        this.title = title;
        this.year = year;
        this.director = director;

    }

    public Movie(long id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                '}';
    }
}
