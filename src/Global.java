import java.util.*;

public class Global {
    Vector<int[]> expanded = new Vector<int[]>();
    Vector<int[]> visited = new Vector<int[]>();
    int[] current = new int[2];
    Vector<int[]> w8ting = new Vector<int[]>();

    
    
    public Global(){
        expanded = null;
        visited = null;
        current = null;
        w8ting = null;
    }

    public int[] getCurrent() {
        return current;
    }
    public void setCurrent(int[] current) {
        this.current = current;
    }
    public Vector<int[]> getExpanded() {
        return expanded;
    }
    public void setExpanded(Vector<int[]> expanded) {
        this.expanded = expanded;
    }
    public Vector<int[]> getVisited() {
        return visited;
    }
    public void setVisited(Vector<int[]> visited) {
        this.visited = visited;
    }
    public Vector<int[]> getW8ting() {
        return w8ting;
    }
    public void setW8ting(Vector<int[]> w8ting) {
        this.w8ting = w8ting;
    }
}
