import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

  private Map<String, Station> mapStations;
  private Map<Station,Set<Troncon>> mapTroncons;

  public Graph(File lignes, File troncons) throws IOException {
    FileReader frLignes = new FileReader(lignes);
    BufferedReader brLignes = new BufferedReader(frLignes);
    FileReader frTroncons = new FileReader(troncons);
    BufferedReader brTroncons = new BufferedReader(frTroncons);
    mapStations = new HashMap<>();
    mapTroncons = new HashMap<>();
    String st;
    String[] tabTroncons;

    //hashmap pour lignes avec id comme clé

    while ((st = brTroncons.readLine()) != null){
      tabTroncons = st.split(",");
      Station depart = new Station(tabTroncons[1]);
      Station arrivee = new Station(tabTroncons[2]);
      mapStations.put(tabTroncons[1], depart);
      mapStations.put(tabTroncons[2], arrivee);
      Troncon troncon = new Troncon(Integer.parseInt(tabTroncons[0]), depart, arrivee, Integer.parseInt(tabTroncons[3]));
      if(!mapTroncons.containsKey(depart)){
        mapTroncons.put(depart,new HashSet<>());
      }
      mapTroncons.get(depart).add(troncon);




    }
    System.out.println(mapTroncons.get(mapStations.get("BOILEAU")));
  }


  public void calculerCheminMinimisantNombreTroncons(String depart, String arrivee) throws IOException {
    LinkedList<Station> file = new LinkedList<>();
    Set<Station> stationsVisitee = new HashSet<>();
    Map<Station, Station> troncons = new HashMap<>();
    Station stationDepart = mapStations.get(depart);
    Station stationArrivee = mapStations.get(arrivee);
    ArrayList<Station> chemin = new ArrayList<>();

    //ajout du départ dans la file et le set
    file.addFirst(stationDepart);
    stationsVisitee.add(stationDepart);

    //BFS
    while(!stationsVisitee.contains(stationArrivee)){
      stationDepart = file.removeLast();
      for (Troncon t : mapTroncons.get(stationDepart)) {
        Station stationArriveeTemp = t.getStationArrivee();
        if(!stationsVisitee.contains(stationArriveeTemp)) {
          file.addFirst(stationArriveeTemp);
          stationsVisitee.add(stationArriveeTemp);
          troncons.put(stationArriveeTemp,stationDepart);
        }
      }
    }

    //récupération de la station de départ
    stationDepart = new Station(depart);
    chemin.add(stationArrivee);

    //création du chemin en partant de l'arrivée jusqu'au départ
    while (!stationArrivee.equals(stationDepart)){
      System.out.println(chemin);
      chemin.add(troncons.get(stationArrivee));
      stationArrivee = troncons.get(stationArrivee);
    }

    chemin.add(stationDepart);

    System.out.println(chemin);


  }

  public void calculerCheminMinimisantTempsTransport(String depart, String arrive) {
  }
}
