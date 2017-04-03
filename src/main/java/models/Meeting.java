package models;

public class Meeting {
    private final int id;
    private String sala;
    private String godzinaRozpoczecia;
    private String godzinaZakonczenia;

    public Meeting () {
        this.id = 0;
    }

    public Meeting(int id, String sala, String godzinaRozpoczecia, String godzinaZakonczenia) {
        this.id = id;
        this.sala = sala;
        this.godzinaRozpoczecia = godzinaRozpoczecia;
        this.godzinaZakonczenia = godzinaZakonczenia;
    }

    public int getId() {
        return id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getGodzinaRozpoczecia() {
        return godzinaRozpoczecia;
    }

    public void setGodzinaRozpoczecia(String godzinaRozpoczecia) {
        this.godzinaRozpoczecia = godzinaRozpoczecia;
    }

    public String getGodzinaZakonczenia() {
        return godzinaZakonczenia;
    }

    public void setGodzinaZakonczenia(String godzinaZakonczenia) {
        this.godzinaZakonczenia = godzinaZakonczenia;
    }
}
