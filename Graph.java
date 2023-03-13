import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

  private Set<Station> stationsSet;
  private Map<Station,Set<Station>> mapTroncons;

  public Graph(File lignes, File troncons) throws IOException {
    FileReader frLignes = new FileReader(lignes);
    BufferedReader brLignes = new BufferedReader(frLignes);
    FileReader frTroncons = new FileReader(troncons);
    BufferedReader brTroncons = new BufferedReader(frTroncons);
    stationsSet = new HashSet();
    mapTroncons = new HashMap<>();
    String st;
    String[] tabTroncons;

    while ((st = brTroncons.readLine()) != null){
      tabTroncons = st.split(",");
      Station depart = new Station(tabTroncons[1]);
      Station arrivee = new Station(tabTroncons[2]);
      stationsSet.add(depart);
      stationsSet.add(arrivee);
      //Troncon troncon = new Troncon(Integer.parseInt(tabTroncons[0]), depart, arrivee, Integer.parseInt(tabTroncons[3]));
      if(!mapTroncons.containsKey(depart)){
        mapTroncons.put(depart,new HashSet<>());
      }
      mapTroncons.get(depart).add(arrivee);

    }

  }


  public void calculerCheminMinimisantNombreTroncons(String depart, String arrivee) throws IOException {
      LinkedList<Station> file = new LinkedList<>();
      Set<Station> stationsVisitee = new HashSet<>();
      Map<Station, Station> troncons = new HashMap<>();
      Station stationDepart = new Station(depart);
      Station stationArrivee = new Station(arrivee);

      file.addFirst(stationDepart);
      stationsVisitee.add(stationDepart);


      file.removeLast();
      for (Station s : mapTroncons.get(stationDepart)) {
        if(!stationsVisitee.contains(s)) {
          file.addFirst(s);
          stationsVisitee.add(s);
          troncons.put(s,stationDepart);
          if(s == stationArrivee)
        }
      }


  }

  public void calculerCheminMinimisantTempsTransport(String depart, String arrive) {
  }
}
