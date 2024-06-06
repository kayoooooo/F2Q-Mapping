import java.util.*;

public class TreeFromHam {
    private int size;
    public TreeFromHam(int size, Set<Set<Integer>> hamiltonian){   //this should be number of qubits
        this.size = size;
        Queue<Entry> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.key));
        Entry[] list = new Entry[size * 2];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Entry(0, new TreeNode(value));
        }
        for (Set<Integer> term : hamiltonian) {
            for (Integer operator : term) {
                list[operator].key++;
            }
        }
        queue.addAll(Arrays.asList(list));
    }

}

class Entry{
    int key;
    TreeNode value;
    public Entry(int key, TreeNode value) {
        this.key = key;
        this.value = value;
    }
}
