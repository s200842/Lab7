package it.polito.tdp.dizionario.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionario.dao.ParolaDAO;

public class DizionarioModel {
	
	SimpleGraph<Parola, DefaultEdge> graph;
	
	public boolean isSimile(Parola s1, Parola s2){
		//Controlla la lunghezza delle due stringhe
		if(s1.toString().length() != s2.toString().length()){
			return false;
		}
		//Se hanno la stessa lunghezza controlla carattere per carattere. Ogni volta che trova un carattere diverso
		//aggiorna la flag. Se questa è > 1 allora differiscono per più di un carattere e ritorna false.
		int flag = 0;
		for(int i=0; i<s1.toString().length(); i++){
			if(s1.toString().charAt(i) != s2.toString().charAt(i)){
				flag ++;
			}
		}
		if(flag==1){
			return true;
		}
		else return false;
	}
	
	public void createGraph(int l){
		graph = new SimpleGraph<Parola, DefaultEdge>(DefaultEdge.class);
		ParolaDAO dao = new ParolaDAO();
		List<Parola> paroleTotali = dao.findWordByLength(l);
		for(Parola p : paroleTotali){
			//System.out.println(p.toString());
			graph.addVertex(p);
		}
		//Ora ho un grafo con tutte le parole da "l lettere" come nodi.
		//Creo i vertici controllando parola per parola le somiglianze
		for(Parola p1: paroleTotali){
			for(Parola p2 : paroleTotali){
				//Non devono essere la stessa parola
				if(!p1.equals(p2)){
					//Se differiscono per una sola lettera
					if(this.isSimile(p1, p2)){
						graph.addEdge(p1, p2);
					}
				}
			}
		}
	}
	
	public Set<Parola> findNeighbors(Parola p){
		Set<Parola> vicini = new HashSet<Parola>();
		//Controllo se ho un nodo contenente la parola
		if(!graph.containsVertex(p)){
			return null;
		}
		else{
			for(Parola p2 : Graphs.neighborListOf(graph, p)){
				vicini.add(p2);
			}
		}
		return vicini;
	}
	
	public List<Parola> findConnections(Parola p){
		List<Parola> visited = new ArrayList<Parola>();
		//Controllo se ho un nodo contenente la parola
		if(!graph.containsVertex(p)){
			return null;
		}
		else{
			//Visita in profondità del grafo
			
			dfv(p, visited);
		}
		return visited;
	}
	
	public void dfv(Parola start, List<Parola> visited){
		//Algoritmo ricorsivo per la visita in profondità del grafo
		//Se ho già visitato il nodo esco
		if(visited.contains(start)){
			return;
		}
		visited.add(start);
		for(Parola p2 : Graphs.neighborListOf(graph, start)){
			dfv(p2, visited);
		}
	}

	public SimpleGraph<Parola, DefaultEdge> getGraph() {
		return graph;
	}
	

}
