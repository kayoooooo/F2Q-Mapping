public class SimplecticVector {
    private int[] Xvec;
    private int[] Zvec;

    private final int size;
    public SimplecticVector(int size) {         //size denotes number of qubits.
        Xvec = new int[size];
        Zvec = new int[size];
        this.size = size;
    }

    public void setX(int i) {
        if (i >= size) {
            throw new IllegalArgumentException("Out of bounds");
        }
        Xvec[i] = 1;
    }

    public void setZ(int i) {
        if (i >= size) {
            throw new IllegalArgumentException("Out of bounds");
        }
        Zvec[i] = 1;
    }

    public void setY(int i) {
        if (i >= size) {
            throw new IllegalArgumentException("Out of bounds");
        }
        Zvec[i] = 1;
        Xvec[i] = 1;
    }

    public SimplecticVector add(SimplecticVector v1, SimplecticVector v2) {
        SimplecticVector sum = new SimplecticVector(v1.size);
        for (int i = 0; i < size; i++) {
            sum.Xvec[i] = (v1.Xvec[i] + v2.Xvec[i]) % 2;
            sum.Zvec[i] = (v1.Zvec[i] + v2.Zvec[i]) % 2;
        }
        return sum;
    }

    public int getWeight() {
        int weight = 0;
        for (int i = 0; i < size; i++) {
            if (this.Xvec[i] == 1 || this.Zvec[i] == 1) {
                weight++;
            }
        }
        return weight;
    }

    public String getPauliString() {
        String pauli = "";
        for (int i = 0; i < size; i++) {
            if (Xvec[i] == 1 && Zvec[i] == 1) {
                pauli = pauli.concat("Y");
            }
            else if (Xvec[i] == 1) {
                pauli = pauli.concat("X");
            }
            else if (Zvec[i] == 1) {
                pauli = pauli.concat("Z");
            }
            else {
                pauli = pauli.concat("I");
            }
        }
        return pauli;
    }
}
