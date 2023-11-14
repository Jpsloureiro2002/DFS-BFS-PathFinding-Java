public class Map {
    public int[][] map = {
        { 9 , 0 , 1 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 1 , 1 , 0},
        { 1 , 0 , 1 , 0 , 0 , 1 , 1 , 0 , 1 , 0 , 1 , 1 , 0},
        { 1 , 0 , 1 , 1 , 0 , 0 , 1 , 0 , 1 , 0 , 0 , 1 , 0},
        { 1 , 0 , 1 , 1 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
        { 0 , 0 , 0 , 0 , 1 , 0 , 1 , 1 , 0 , 1 , 1 , 1 , 1},
        { 0 , 1 , 1 , 0 , 1 , 0 , 1 , 1 , 0 , 1 , 1 , 1 , 1},
        { 0 , 1 , 1 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 1},
        { 0 , 0 , 1 , 1 , 1 , 1 , 0 , 1 , 1 , 0 , 0 , 0 , 1},
        { 1 , 0 , 1 , 0 , 0 , 0 , 0 , 5 , 0 , 0 , 0 , 1 , 0},
        { 1 , 0 , 1 , 0 , 1 , 1 , 0 , 1 , 0 , 0 , 0 , 0 , 1},
        { 1 , 0 , 1 , 0 , 1 , 1 , 0 , 1 , 1 , 1 , 1 , 0 , 1},
        { 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0}
    };
    public int[][] viwemap = new int[map.length][map[0].length];

    public Map(){
        System.out.println("Map Initialized: " + this.hashCode());
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                viwemap[y][x] = map[y][x];
            }
        }
    }
    public Map(int[][] map){
        this.map = map;
        System.out.println("Map Initialized with new Map: " + this.hashCode());
    }
    public int[][] getMap() {
        return map;
    }
    public void setMap(int[][] map) {
        this.map = map;
    }
    public int[][] getViwemap() {
        return viwemap;
    }
    public void setViwemap(int[][] viwemap) {
        this.viwemap = viwemap;
    }
}
