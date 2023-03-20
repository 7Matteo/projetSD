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

  public Station getStationDepart() {
    return stationDepart;
  }

  public Station getStationArrivee() {
    return stationArrivee;
  }

  public int getIdLigne() {
    return idLigne;
  }

  public int getDuree() {
    return duree;
  }

  @Override
  public String toString() {
    return "Troncon[" +
        "depart=" + stationDepart.toString()+
        ", arrivee=" + stationArrivee.toString()+
        ", duree=" + duree +
        " ligne=";
  }
}
