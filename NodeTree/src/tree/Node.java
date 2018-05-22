package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * La clase Node representa un nodo con un n�mero indeterminado de hijos y sirve
 * para represantar al �rbol en si mismo.
 * 
 * @author Mar�a Espinosa
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
	 * A�ade un nodo a la lista de hijos del �rbol.
	 * 
	 * @param child
	 *            El nuevo hijo.
	 */
	public void add(Node<T> child) {
		this.children.add(child);
	}

	/**
	 * Crea y a�ade un nodo a la lista de hijos del �rbol.
	 *
	 * @param data
	 *            El elemento contenido por el nodo.
	 */
	public void add(T data) {
		children.add(new Node<T>(data));
	}

	/**
	 * A�ade una lista de nodos o sub�rbol al �rbol.
	 * 
	 * @param subTree
	 *            El sub�rbol a a�adir.
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
	 * M�todo privado que recorre el �rbol recursivamente y cuenta el n�mero de
	 * veces que cada dato aparece en el �rbol.
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
	 * Dado un Hashmap con los datos del �rbol y el n�mero de ocurrencias de
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
