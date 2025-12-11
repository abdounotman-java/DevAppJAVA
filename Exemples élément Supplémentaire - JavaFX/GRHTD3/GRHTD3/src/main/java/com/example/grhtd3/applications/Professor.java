package com.example.grhtd3.applications;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Professor
{
    private final StringProperty idpr;
    private final StringProperty nompr;
    private final StringProperty genrepr;
    private final StringProperty emailpr;
    private final StringProperty datepr;
    private final StringProperty  gradepr;
    private final StringProperty deppr;
    //public ObservableValue<String> nomProperty;

    public Professor()
    {
        idpr = new SimpleStringProperty(this, "idpr");
        nompr = new SimpleStringProperty(this, "nompr");
        genrepr = new SimpleStringProperty(this, "genrepr");
        emailpr = new SimpleStringProperty(this, "emailpr");
        datepr = new SimpleStringProperty(this, "datepr");
        gradepr = new SimpleStringProperty(this, "gradepr");
        deppr = new SimpleStringProperty(this, "deppr");
    }

    public StringProperty idProperty() { return idpr; }
    public String getId() { return idpr.get(); }
    public void setIdpr(String newId) { idpr.set(newId); }

    public StringProperty NomprProperty() { return nompr; }
    public String getnom() { return nompr.get(); }
    public void setnom(String newnom) { nompr.set(newnom); }

    public StringProperty genreProperty() { return genrepr; }
    public String getgenre() { return genrepr.get(); }
    public void setgenre(String newgenre) { genrepr.set(newgenre); }

    public StringProperty emailProperty() { return emailpr; }
    public String getemail() { return emailpr.get(); }
    public void setemail(String newemail) { emailpr.set(newemail); }

    public StringProperty dateProperty() { return datepr; }
    public String getdate() { return datepr.get(); }
    public void setdate(String newdate) { datepr.set(newdate); }

    public StringProperty gradeProperty() { return gradepr; }
    public String getgrade() { return gradepr.get(); }
    public void setgrade(String newgrade) { gradepr.set(newgrade); }

    public StringProperty depProperty() { return deppr; }
    public String getdep() { return deppr.get(); }
    public void setdep(String newdep) { deppr.set(newdep); }

}