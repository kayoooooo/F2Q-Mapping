import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class F2QTest {
    @Test
    public void firstTest() {
        Set<Integer> ham = new HashSet<>();
        ham.add(1);
        ham.add(2);
        ham.add(3);
        ham.add(5);
        Set<Set<Integer>> hamiltonian = new HashSet<>();
        hamiltonian.add(ham);
        TreeFromHam encoding = new TreeFromHam(3, hamiltonian);
        encoding.displayMapping();
        int x = encoding.getWeight();
    }

    @Test
    public void secondTest() {
        Set<Integer> ham1 = new HashSet<>();
        ham1.add(1);
        ham1.add(2);
        ham1.add(3);
        ham1.add(5);
        Set<Integer> ham2 = new HashSet<>();
        ham2.add(1);
        ham2.add(2);
        ham2.add(3);
        ham2.add(4);
        Set<Set<Integer>> hamiltonian = new HashSet<>();
        hamiltonian.add(ham1);
        hamiltonian.add(ham2);
        TreeFromHam encoding = new TreeFromHam(3, hamiltonian);
        encoding.displayMapping();
        int x = encoding.getWeight();
    }
}
