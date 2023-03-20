public class Ligne {

  private int identifiant;
  private String numero;
  private Station  terminusDepart;
  private Station terminusArrivee;
  private String transport;
  private int tempsAttenteMoyen;

  public Ligne(int identifiant, String numero, Station terminusDepart, Station terminusArrivee,
      String transport, int tempsAttenteMoyen) {
    this.identifiant = identifiant;
    this.numero = numero;
    this.terminusDepart = terminusDepart;
    this.terminusArrivee = terminusArrivee;
    this.transport = transport;
    this.tempsAttenteMoyen = tempsAttenteMoyen;
  }

  public int getTempsAttenteMoyen() {
    return tempsAttenteMoyen;
  }

  @Override
  public String toString() {
    return "Ligne[" +
        "id=" + identifiant +
        ", numero='" + numero + '\'' +
        ", source=" + terminusDepart +
        ", destination=" + terminusArrivee +
        ", type='" + transport + '\'' +
        ", tempsAttenteMoyen=" + tempsAttenteMoyen +
        "]]";
  }
}
