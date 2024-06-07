import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> ham = new HashSet<>();
        ham.add(1);
        ham.add(2);
        ham.add(3);
        ham.add(5);
        Set<Set<Integer>> hamiltonian = new HashSet<>();
        hamiltonian.add(ham);
        TreeFromHam encoding = new TreeFromHam(3, hamiltonian);
        encoding.displayMapping();
    }
}