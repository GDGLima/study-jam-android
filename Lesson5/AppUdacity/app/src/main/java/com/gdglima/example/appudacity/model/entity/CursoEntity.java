package com.gdglima.example.appudacity.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by emedinaa on 07/03/2015.
 */
@DatabaseTable(tableName = "cursos")
public class CursoEntity implements Serializable {

    @DatabaseField(generatedId = true)
    private int courseID;

    @DatabaseField
    private String name;

    @DatabaseField
    private String url;

    public CursoEntity() {
    }

    public CursoEntity(int courseID, String name, String url) {
        this.courseID = courseID;
        this.name = name;
        this.url = url;
    }

    public CursoEntity(String name, String url) {
        this.name = name;
        this.url = url;
    }


    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
