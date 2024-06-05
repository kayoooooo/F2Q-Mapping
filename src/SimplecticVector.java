public class SimplecticVector {
    private int[] Xvec;
    private int[] Zvec;

    private int size;
    public SimplecticVector(int size) {
        Xvec = new int[size];
        Zvec = new int[size];
        size = size;
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
}
