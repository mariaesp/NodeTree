package tree;

import java.util.List;
import java.util.Map.Entry;

/**
 * Clase encargada de probar la esturctura de datos Node.
 * 
 * @author María Espinosa
 *
 */
public class TestTree {

	public static void main(String[] args) {
		Node<String> tree = createTree();
		List<Entry<String, Integer>> list = tree.countOccurrences();
		System.out.println(list.toString());
	}

	/**
	 * Genera y devuelve un árbol con cadenas de caracteres en sus nodos.
	 * 
	 * @return Devuelve el árbol generado.
	 */
	public static Node<String> createTree() {

		Node<String> root = new Node<String>("STF");
		Node<String> child1 = new Node<String>("AIT");
		Node<String> child2 = new Node<String>("QO");
		Node<String> child3 = new Node<String>("LP");
		Node<String> child4 = new Node<String>("AS");
		Node<String> child5 = new Node<String>("AIT");
		root.add(child1);
		root.add(child2);
		root.add(child3);
		child1.add(child4);
		child1.add(new Node<String>("LP"));
		child4.add(new Node<String>("QO"));
		child4.add(new Node<String>("STF"));
		child2.add(child5);
		child5.add(new Node<String>("STF"));
		child4.add(new Node<String>("STF"));

		return root;
	}

}
