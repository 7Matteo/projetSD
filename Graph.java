import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {

  private Set stationsSet;
  private List<Troncon> listeTroncons;

  public Graph(File lignes, File troncons) throws IOException {
    FileReader frLignes = new FileReader(lignes);
    BufferedReader brLignes = new BufferedReader(frLignes);
    FileReader frTroncons = new FileReader(troncons);
    BufferedReader brTroncons = new BufferedReader(frTroncons);
    stationsSet = new HashSet();
    listeTroncons = new LinkedList();
    String st;
    String[] tabTroncons;

    while ((st = brTroncons.readLine()) != null){
      tabTroncons = st.split(",");
      Station depart = new Station(tabTroncons[1]);
      Station arrivee = new Station(tabTroncons[2]);
      stationsSet.add(depart);
      stationsSet.add(arrivee);
      Troncon troncon = new Troncon(Integer.parseInt(tabTroncons[0]), depart, arrivee, Integer.parseInt(tabTroncons[3]));
      listeTroncons.add(troncon);
    }

  }


  public void calculerCheminMinimisantNombreTroncons(String depart, String arrivee) throws IOException {
    for (Troncon t: listeTroncons) {
      System.out.println(t.toString());
    }

  }

  public void calculerCheminMinimisantTempsTransport(String depart, String arrive) {
  }
}
