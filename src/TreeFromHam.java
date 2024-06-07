import java.util.*;

public class TreeFromHam {
    private int size;
    Queue<Entry> queue;

    SimplecticVector[] mapping;
    public TreeFromHam(int size, Set<Set<Integer>> hamiltonian){   //this should be number of qubits
        this.size = size;
        queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.key));
        mapping = new SimplecticVector[size * 2 + 1];
        Entry[] list = new Entry[size * 2 + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Entry(0, new TreeNode(i));
        }
        for (Set<Integer> term : hamiltonian) {
            for (Integer operator : term) {
                list[operator].key++;
            }
        }
        queue.addAll(Arrays.asList(list));
        this.makeTree();
    }

    public void makeTree() {
        for (int i = size - 1; i >= 0; i++) {
            Entry XChild = queue.poll();
            Entry YChild = queue.poll();
            Entry ZChild = queue.poll();
            int newKey = Math.max(XChild.key, Math.max(YChild.key, ZChild.key));
            TreeNode intNode = new TreeNode();

            XChild.value.setParent(intNode);
            YChild.value.setParent(intNode);
            ZChild.value.setParent(intNode);
            setX(XChild.value, i);
            setY(YChild.value, i);
            setZ(ZChild.value, i);
            intNode.xChild = XChild.value;
            intNode.yChild = YChild.value;
            intNode.zChild = ZChild.value;
            queue.add(new Entry(newKey, intNode));
        }
    }

    public void setX(TreeNode node, int qubit) {
        if (node.isLeaf()) {
            mapping[node.getQubit()].setX(qubit);
            return;
        }
        setX(node.xChild, qubit);
        setX(node.yChild, qubit);
        setX(node.zChild, qubit);
    }

    public void setY(TreeNode node, int qubit) {
        if (node.isLeaf()) {
            mapping[node.getQubit()].setY(qubit);
            return;
        }
        setY(node.xChild, qubit);
        setY(node.yChild, qubit);
        setY(node.zChild, qubit);
    }

    public void setZ(TreeNode node, int qubit) {
        if (node.isLeaf()) {
            mapping[node.getQubit()].setZ(qubit);
            return;
        }
        setZ(node.xChild, qubit);
        setZ(node.yChild, qubit);
        setZ(node.zChild, qubit);
    }

    public void displayMapping() {
        for (int i = 0; i < size * 2 + 1; i++) {
            String display = "Fermionic mode ";
            display = display.concat(Integer.toString(i));
            display = display.concat(": ");
            System.out.print(display);
            System.out.print(mapping[i].getPauliString());
        }
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
