//package my_grid;

public class SparseGridNode {
	private Object occupant;
    private int col;
    private SparseGridNode next;
	public SparseGridNode() {
		occupant = null;
		col = 0;
	}
    public SparseGridNode(Object e, int my_col) {
    	occupant = e;
    	col = my_col;
    }
}
