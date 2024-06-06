public class TreeNode {

    private int qubit;
    private TreeNode parent;
    private TreeNode xChild;
    private TreeNode yChild;
    private TreeNode zChild;

    // default constructor
    public TreeNode()
    {
        qubit = -1;
        xChild = null;
        yChild = null;
        zChild = null;
    }

    public TreeNode(int qubit)
    {
        this.qubit = qubit;
        xChild = null;
        yChild = null;
        zChild = null;
    }

    /* =============
    * SET
    ============= */
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void setChild(char option, TreeNode node) {
        switch (option) {
            case 0:
                xChild = node;
                break;
            case 1:
                yChild = node;
                break;
            case 2:
                zChild = node;
                break;
            default:
                System.out.println("Invalid child assignment!");
                break;
        }
        node.setParent(this);
    }

    public void setQubit(int qubit) {
        this.qubit = qubit;
    }

    /* =============
    * GET
    ============= */
    public int getQubit() {
        return qubit;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getChild(char option) {
        switch (option) {
            case 0:
                return xChild;
            case 1:
                return yChild;
            case 2:
                return zChild;
            default:
                System.out.println("Invalid child query!");
                return null;
        }
    }

    /* ============
    * MISC.
    ============ */
    public TreeNode removeChild(char option) {
        TreeNode removed = null;
        switch (option) {
            case 0:
                removed = xChild;
                xChild = null;
                break;
            case 1:
                removed = yChild;
                yChild = null;
                break;
            case 2:
                removed = zChild;
                zChild = null;
                break;
            default:
                System.out.println("Invalid child removal!");
        }
        return removed;
    }

}
