
package Presentacion;

import java.util.List;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Modelo.Route;
import Modelo.Station;

public class RUNNER {

	public static void main(String[] args) {
		// Crear grafo de transporte p�blico
		Graph<String, Double> transportGraph = new DirectedSparseGraph<>();

		// Crear estaciones
		String stationA = "Estaci�n Acevedo";
		String stationB = "Estaci�n Aguacatala";
		String stationC = "Estaci�n Industriales";
		String stationD = "Estaci�n Parque Berr�o";

		// A�adir estaciones al grafo
		transportGraph.addVertex(stationA);
		transportGraph.addVertex(stationB);
		transportGraph.addVertex(stationC);
		transportGraph.addVertex(stationD);

		// Crear rutas y a�adirlas al grafo con su respectiva distancia en km
		transportGraph.addEdge(10.5, stationA, stationB, EdgeType.DIRECTED);
		transportGraph.addEdge(7.2, stationA, stationC, EdgeType.DIRECTED);
		transportGraph.addEdge(5.9, stationB, stationD, EdgeType.DIRECTED);
		transportGraph.addEdge(2.8, stationC, stationD, EdgeType.DIRECTED);

		// Encontrar la ruta m�s corta entre dos estaciones
		DijkstraShortestPath<String, Double> dijkstraAlg = new DijkstraShortestPath<>(transportGraph);
		List<Double> shortestPath = dijkstraAlg.getPath(stationA, stationD);

		// Mostrar la ruta m�s corta y su distancia total en km
		System.out.println("Ruta m�s corta de " + stationA + " a " + stationD + ": ");
		for (Double distance : shortestPath) {
			System.out.print(distance + " km ");
		}
		System.out.println("\nDistancia total: " + dijkstraAlg.getDistance(stationA, stationD) + " km");
	}
}