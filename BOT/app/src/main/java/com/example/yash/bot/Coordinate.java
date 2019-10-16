package com.example.yash.bot;
import com.google.firebase.firestore.Exclude;

import java.io.Serializable;
public class Coordinate implements Serializable
{
    @Exclude private String id;
    private int x;
    private int y;
    public Coordinate(){
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
