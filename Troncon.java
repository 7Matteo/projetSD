public class Troncon {

  private int idLigne;
  private Station stationDepart;
  private Station stationArrivee;
  private int duree;

  public Troncon(int idLigne, Station stationDepart, Station stationArrivee, int duree) {
    this.idLigne = idLigne;
    this.stationDepart = stationDepart;
    this.stationArrivee = stationArrivee;
    this.duree = duree;
  }
}