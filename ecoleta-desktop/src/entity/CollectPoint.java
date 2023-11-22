package entity;

public class CollectPoint {

    private final int id_ponto;
    private final String nome;
    private final String email;
    private final String cidade;
    private final Double latitude;
    private final Double longitute;

    public CollectPoint(int id_ponto, String nome, String email, String cidade, Double latitude, Double longitute) {
        this.id_ponto = id_ponto;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.latitude = latitude;
        this.longitute = longitute;

    }

    public int getId_ponto() {
        return id_ponto;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitute() {
        return longitute;
    }

}
