package pt.deti.ies.ex4rest;

import java.util.*;

public class Movie{
    private String title;
    private int showid;
    private ArrayList<String> quotes;

    public Movie(String title,int showid, ArrayList<String> quotes) {
        this.title = title;
        this.showid = showid;
        this.quotes = quotes;
    }
    public Movie(String title, int showid) {
        this.title = title;
        this.showid = showid;
        this.quotes = new ArrayList<String>();
    }
    
    public String getShowid() {
        return String.valueOf(this.showid);
    }
    public void setShowid(int showid) {
        this.showid = showid;
    }
    public String getTitle() {
        if(this.title == null){
            return "Movie Title is null";
        }
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public ArrayList<String> getQuotes() {
        return quotes;
    }
    public void addQuotes(String quote) {
        this.quotes.add(quote);
    }
    
    
}
