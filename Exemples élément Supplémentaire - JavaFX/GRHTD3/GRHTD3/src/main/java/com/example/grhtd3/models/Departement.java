package com.example.grhtd3.models;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Departement
{
    private final StringProperty iddep;
    private final StringProperty nomdep;
    private final StringProperty aboutdep;
    private final StringProperty anneedep;

    public Departement()
    {
        iddep = new SimpleStringProperty(this, "iddep");
        nomdep = new SimpleStringProperty(this, "nomdep");
        aboutdep = new SimpleStringProperty(this, "aboutdep");
        anneedep = new SimpleStringProperty(this, "anneedep");
    }

    public StringProperty iddepoperty() { return iddep; }
    public String getId() { return iddep.get(); }
    public void setiddep(String newId) { iddep.set(newId); }

    public StringProperty nomdepProperty() { return nomdep; }
    public String getnom() { return nomdep.get(); }
    public void setnom(String newnom) { nomdep.set(newnom); }

    public StringProperty aboutdepoperty() { return aboutdep; }
    public String getaboutdep() { return aboutdep.get(); }
    public void setaboutdep(String newaboutdep) { aboutdep.set(newaboutdep); }

    public StringProperty anneedepoperty() { return anneedep; }
    public String getanneedep() { return anneedep.get(); }
    public void setanneedep(String newanneedep) { anneedep.set(newanneedep); }

}