public class Ligne {

  private int identifiant;
  private int numero;
  private Station  stationDepart;
  private Station stationArrivee;
  private Transport transport;
  private int tempsAttenteMoyen;

  public Ligne(int identifiant, int numero, Station stationDepart, Station stationArrivee,
      Transport transport, int tempsAttenteMoyen) {
    this.identifiant = identifiant;
    this.numero = numero;
    this.stationDepart = stationDepart;
    this.stationArrivee = stationArrivee;
    this.transport = transport;
    this.tempsAttenteMoyen = tempsAttenteMoyen;
  }

  enum Transport {
    bus,tram,metro;
  }

}
