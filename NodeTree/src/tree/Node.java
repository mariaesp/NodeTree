package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * La clase Node representa un nodo con un número indeterminado de hijos y sirve
 * para represantar al árbol en si mismo.
 * 
 * @author María Espinosa
 *
 * @param <T>
 *            El tipo de los elementos que contiene el nodo.
 */
public class Node<T extends Comparable<T>> {
	private T data;
	private List<Node<T>> children = new ArrayList<Node<T>>();

	/**
	 * Constructor de nodos.
	 * 
	 * @param data
	 *            El contenido del nodo.
	 */
	public Node(T data) {
		this.data = data;
	}

	/**
	 * Añade un nodo a la lista de hijos del árbol.
	 * 
	 * @param child
	 *            El nuevo hijo.
	 */
	public void add(Node<T> child) {
		this.children.add(child);
	}

	/**
	 * Crea y añade un nodo a la lista de hijos del árbol.
	 *
	 * @param data
	 *            El elemento contenido por el nodo.
	 */
	public void add(T data) {
		children.add(new Node<T>(data));
	}

	/**
	 * Añade una lista de nodos o subárbol al árbol.
	 * 
	 * @param subTree
	 *            El subárbol a añadir.
	 */
	public void add(List<Node<T>> subTree) {
		this.children.addAll(subTree);
	}

	/**
	 * Devuelve contenido del nodo.
	 * 
	 * @return El dato.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Establece el contenido del nodo.
	 *
	 * @param data
	 *            El dato con el contenido del nodo.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Devuelve la lista de hijos del nodo.
	 * 
	 * @return La lista de hijos.
	 */
	public List<Node<T>> getChildren() {
		return children;
	}

	/**
	 * Método privado que recorre el árbol recursivamente y cuenta el número de
	 * veces que cada dato aparece en el árbol.
	 * 
	 * @param list
	 *            La lista de pares en la que se almacenan los datos.
	 */
	private void countOccurrences(HashMap<T, Integer> counterMap) {
		for (Node<T> n : getChildren()) {
			n.countOccurrences(counterMap);
		}

		int value = counterMap.getOrDefault(data, 0);
		counterMap.put(data, value + 1);

	}

	/**
	 * Dado un Hashmap con los datos del árbol y el número de ocurrencias de
	 * cada dato, devuelve una lista de parejas con los mismos.
	 * 
	 * @return Devuelve una lista de pares [elemento, ocurrencias] con el
	 *         resultado.
	 */
	public List<Entry<T, Integer>> countOccurrences() {
		HashMap<T, Integer> counterMap = new HashMap<T, Integer>();
		countOccurrences(counterMap);
		return new ArrayList<Entry<T, Integer>>(counterMap.entrySet());
	}

}
