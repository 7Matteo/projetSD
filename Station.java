public class Station {
  private String nom;

  public Station(String nom) {
    this.nom = nom;
  }

  @Override
  public String toString() {
    return "Station{" +
        "nom='" + nom + '\'' +
        '}';
  }
}
