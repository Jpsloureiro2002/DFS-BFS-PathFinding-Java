

public class Nodes {
    public int dir;
    public int[] pos = new int[2];
    boolean is_x;
    public Nodes father;

    public Nodes(int dir, Nodes father, int x,int y, boolean is_x){
        this.dir = dir;
        this.is_x = is_x;
        this.pos[0] = x;
        this.pos[1] = y;
        this.father = father;
    }

    public Nodes(int dir){
        this.dir = dir;
        this.father = null;
    }

    public int[] getPos() {
        return pos;
    }
    public void setPos(int[] pos) {
        this.pos = pos;
    }
    public int getDir() {
        return dir;
    }
    public void setDir(int dir) {
        this.dir = dir;
    }
    public boolean getis_X() {
        return this.is_x;
    }
    public void setIs_x(boolean is_x) {
        this.is_x = is_x;
    }   
    
}
