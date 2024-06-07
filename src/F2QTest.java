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
}
