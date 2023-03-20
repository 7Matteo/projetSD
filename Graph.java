import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {

  private Map<String, Station> mapStations;
  private Map<Station,Set<Troncon>> mapTroncons;

  private Map<Integer, Ligne> mapLignes;

  public Graph(File lignes, File troncons) throws IOException {
    FileReader frLignes = new FileReader(lignes);
    BufferedReader brLignes = new BufferedReader(frLignes);
    FileReader frTroncons = new FileReader(troncons);
    BufferedReader brTroncons = new BufferedReader(frTroncons);
    mapStations = new HashMap<>();
    mapTroncons = new HashMap<>();
    mapLignes = new HashMap<>();
    String st;
    String[] tabTroncons;
    String[] tabLignes;

    //hashmap pour lignes avec id comme clé
    while((st = brLignes.readLine()) != null){
      tabLignes = st.split(",");
      Station terminusDepart = new Station(tabLignes[2]);
      Station terminusArrivee = new Station(tabLignes[3]);
      Ligne ligne = new Ligne(Integer.parseInt(tabLignes[0]), tabLignes[1], terminusDepart, terminusArrivee, tabLignes[4], Integer.parseInt(tabLignes[5]));
      mapLignes.put(Integer.parseInt(tabLignes[0]),ligne);
    }

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
  }


  public void calculerCheminMinimisantNombreTroncons(String depart, String arrivee) throws IOException {
    LinkedList<Station> file = new LinkedList<>();
    Set<Station> stationsVisitee = new HashSet<>();
    Map<Station, Station> troncons = new HashMap<>();
    Station stationDepart = mapStations.get(depart);
    Station stationArrivee = mapStations.get(arrivee);
    ArrayList<Troncon> chemin = new ArrayList<>();

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


    //création du chemin en partant de l'arrivée jusqu'au départ
    while (!stationArrivee.equals(stationDepart)){
      for (Troncon t: mapTroncons.get(troncons.get(stationArrivee))) {
        if(t.getStationArrivee().equals(stationArrivee)){
          chemin.add(t);
          break;
        }
      }
      stationArrivee = troncons.get(stationArrivee);
    }

    Collections.reverse(chemin);

    int dureeTransport = 0;
    int dureeTotale = 0;
    Set<Ligne> lignesUtilisees = new HashSet<>();

    for (Troncon t : chemin) {
      Ligne ligneUtilisee = mapLignes.get(t.getIdLigne());
      lignesUtilisees.add(ligneUtilisee);
      dureeTransport += t.getDuree();
      System.out.println(t + mapLignes.get(t.getIdLigne()).toString());
    }

    for (Ligne l : lignesUtilisees){
      dureeTotale += l.getTempsAttenteMoyen();
    }

    dureeTotale += dureeTransport;

    System.out.println("dureeTransport=" + dureeTransport);
    System.out.println("dureeTotale=" + dureeTotale);



  }

  public void calculerCheminMinimisantTempsTransport(String depart, String arrivee) {
    HashMap<Station, Integer> etiquetteProvisoire = new HashMap<>();
    HashMap<Station, Integer> etiquetteDefinitive = new HashMap<>();
    HashMap<Station, Station> stationPrecedentes = new HashMap<>();
    Station stationCourante = mapStations.get(depart);
    Station stationArrivee = mapStations.get(arrivee);
    etiquetteProvisoire.put(stationCourante,Integer.MAX_VALUE);
    etiquetteDefinitive.put(stationCourante,0);

    while(true){
      int dureeMin = Integer.MAX_VALUE;
      Station stationMin = null;
      for (Troncon troncon : mapTroncons.get(stationCourante)) {
        etiquetteProvisoire.put(troncon.getStationArrivee(), troncon.getDuree());

      }


      for (Station station : etiquetteProvisoire.keySet()) {
        if(etiquetteProvisoire.get(station) < dureeMin) {
          dureeMin = etiquetteProvisoire.get(station);
          stationMin = station;
        }
      }

      etiquetteDefinitive.put(stationMin,dureeMin);
      stationCourante = stationMin;


    }
  }
}


