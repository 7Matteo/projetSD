import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Graph {
  private BufferedReader lignes;
  private BufferedReader troncons;

  public Graph(File lignes, File troncons) throws FileNotFoundException {
    FileReader frLignes = new FileReader(lignes);
    BufferedReader brLignes = new BufferedReader(frLignes);
    FileReader frTroncons = new FileReader(troncons);
    BufferedReader brTroncons = new BufferedReader(frTroncons);
    this.lignes = brLignes;
    this.troncons = brTroncons;

  }


  public void calculerCheminMinimisantNombreTroncons(String depart, String arrivee) throws IOException {


  }

  public void calculerCheminMinimisantTempsTransport(String depart, String arrive) {
  }
}
