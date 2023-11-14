import java.util.*;



public class Agent {
    //Vetores de Direção
    //y ->,x top ,y <- , x down
    private int[] vdir = {1,-1,-1,1};
    Map map;
    
    //identifire
    int id;
    protected String name = "";
    
    //Outros
    //Cost of the search
    int cost = 0;
    //Isto mostra quantos nodes expandio
    int totalCost = 0;

    //----Brain----
    Stack<Nodes> stack = new Stack<Nodes>();
    Queue<Nodes> queue = new LinkedList<Nodes>();
    Vector<int[]> visited = new Vector<int[]>();
    //-------Map location-------
    int[] pos = {0,0};
    int[] goal = new int[2];
    
    
    public Agent(int id, int[] pos, Map map, int[] goal){
        this.id = id;
        this.pos = pos;
        this.map = map;
        this.goal = goal;
        System.out.println("Agent created: " + id);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int[] getGoal() {
        return goal;
    }
    public void setGoal(int[] goal) {
        this.goal = goal;
    }
    public int[] getPos() {
        return pos;
    }
    public void setPos(int[] pos) {
        this.pos = pos;
    }

    //Methods

    private Boolean checkBounds(int dir, int index,Nodes node){
        int[] node_pos = node.getPos();
        if (index % 2 == 0){
            if(dir + node_pos[0] < 0 || dir + node_pos[0] >= map.map[0].length){
                return false;
            }else{
                if(map.map[node_pos[1]][dir+node_pos[0]] == 1)
                    return false;
                return true;
            }
        }else{
            if(dir + node_pos[1] < 0 || dir + node_pos[1] >= map.map.length){
                return false;
            }else{
                if(map.map[dir+node_pos[1]][node_pos[0]] == 1)
                    return false;
                return true;
            }
        }
    }


    public void DFS(){
        Nodes goalNode = startDFS();
        int cost = 0;
        if(goalNode == null){
            System.out.println("No path");
        }else{
            while (goalNode.father != null) {
                
                Character dir = 'y';
                if (goalNode.getis_X()){
                    dir = 'x';
                }
                System.out.println( " | " + goalNode.getDir() + ", " + dir);
                cost += 1;
                goalNode = goalNode.father;
                map.viwemap[goalNode.pos[1]][goalNode.pos[0]] = 3;
            }
            System.out.println("Cost: "+ cost);
        }
    }

    public void BFS(){
        Nodes goalNode = startBFS();
        int cost = 0;
        if(goalNode == null){
            System.out.println("No path");
        }else{
            while (goalNode.father != null) {
                
                Character dir = 'y';
                if (goalNode.getis_X()){
                    dir = 'x';
                }
                System.out.println( " | " + goalNode.getDir() + ", " + dir);
                cost += 1;
                goalNode = goalNode.father;
                //just for the map view not needed
                map.viwemap[goalNode.pos[1]][goalNode.pos[0]] = 3;
            }
            System.out.println("Cost: "+ cost);
        }
    }

    
    private boolean checkGoal(Nodes node){
        if(map.map[node.getPos()[1]][node.getPos()[0]] == 5){
            return true;
        }
        return false;

    }

    public Nodes startBFS(){
        Nodes Start = new Nodes(0, null, this.pos[0],this.pos[1], false);
        queue.add(Start);
        Nodes Corrent;
        while (!queue.isEmpty()) {
            Corrent = queue.poll();
            
            if(checkGoal(Corrent)){
                System.out.println("Nodes Expanded:" + totalCost);
                end();
                return Corrent;
            }
            if(!contains(Corrent.getPos())){
                visited.add(Corrent.getPos());
                totalCost += 1;
                map.viwemap[Corrent.getPos()[1]][Corrent.getPos()[0]] = 6; 
                expandQueue(Corrent);
            }
        }
        System.out.println("Nodes Expanded:" + totalCost);
        end();
        return null;
    }


    public Nodes startDFS(){
        Nodes Start = new Nodes(0, null, this.pos[0],this.pos[1], false);
        stack.add(Start);
        Nodes Corrent;
        while (!stack.isEmpty()) {
            Corrent = stack.pop();
            
            if(checkGoal(Corrent)){
                System.out.println("Nodes Expanded:" + totalCost);
                end();
                return Corrent;
            }
            if(!contains(Corrent.getPos())){
                visited.add(Corrent.getPos());
                totalCost += 1;
                map.viwemap[Corrent.getPos()[1]][Corrent.getPos()[0]] = 6; 
                expand(Corrent);
            }
        }
        System.out.println("Nodes Expanded:" + totalCost);
        end();
        return null;
    }


    
    
    public void expand(Nodes node){
        int[] nodePos = node.getPos();
        int[] newPos = new int[2];
        for (int i = 0; i < vdir.length; i++) {
            if(i % 2 == 0){
                if(checkBounds(vdir[i],i,node)){
                    newPos[0] = vdir[i]+nodePos[0];
                    newPos[1] = nodePos[1];
                    if(!contains(newPos)){
                        Nodes newNode = new Nodes(vdir[i], node,vdir[i]+nodePos[0],nodePos[1], true);
                        map.viwemap[newNode.getPos()[1]][newNode.getPos()[0]] = 7;
                        stack.addElement(newNode);
                    }
                }
            }else{
                if(checkBounds(vdir[i],i,node)){
                    newPos[0] = nodePos[0];
                    newPos[1] = vdir[i]+nodePos[1];
                    if(!contains(newPos)){
                        Nodes newNode = new Nodes(vdir[i], node,nodePos[0],vdir[i]+nodePos[1], false);
                        map.viwemap[newNode.getPos()[1]][newNode.getPos()[0]] = 7; 
                        stack.addElement(newNode);
                    }                
                }
            }
            
        }
    }

    public void expandQueue(Nodes node){
        int[] nodePos = node.getPos();
        int[] newPos = new int[2];
        for (int i = 0; i < vdir.length; i++) {
            if(i % 2 == 0){
                if(checkBounds(vdir[i],i,node)){
                    newPos[0] = vdir[i]+nodePos[0];
                    newPos[1] = nodePos[1];
                    if(!contains(newPos)){
                        Nodes newNode = new Nodes(vdir[i], node,vdir[i]+nodePos[0],nodePos[1], true); 
                        map.viwemap[newNode.getPos()[1]][newNode.getPos()[0]] = 7;
                        queue.add(newNode);
                    }
                }
            }else{
                if(checkBounds(vdir[i],i,node)){
                    newPos[0] = nodePos[0];
                    newPos[1] = vdir[i]+nodePos[1];
                    if(!contains(newPos)){
                        Nodes newNode = new Nodes(vdir[i], node,nodePos[0],vdir[i]+nodePos[1], false); 
                        map.viwemap[newNode.getPos()[1]][newNode.getPos()[0]] = 7;
                        queue.add(newNode);
                    }                
                }
            }
            
        }
    }
    
    public boolean contains(int[] pos){
        for (int i = 0; i < visited.size(); i++) {
            if(visited.get(i)[0] == pos[0] && visited.get(i)[1] == pos[1]){
                return true;
            }
        }
        return false;
    }

    public void end(){
        stack.clear();
        queue.clear();
        visited.clear();
        totalCost = 0;
        System.out.println("End of Process!\nClearing Brain...");
    }
}
