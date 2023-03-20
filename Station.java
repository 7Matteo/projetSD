import java.util.Objects;

public class Station {
  private String nom;

  public Station(String nom) {
    this.nom = nom;
  }

  @Override
  public String toString() {
    return nom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Station station = (Station) o;
    return Objects.equals(nom, station.nom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom);
  }


}
