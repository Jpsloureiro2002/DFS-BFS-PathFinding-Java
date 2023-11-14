public class Engine {
    Map map;
    Agent robot;

    public Engine(Map map, Agent robot, Global global, Settings settings){
        try {
            this.map = map;
            this.robot = robot;
            System.out.println("Engine initialized: " + this.hashCode());    
        } catch (Exception e) {
            System.out.println("Initializer Error:\n " + e);
        }
        
    }
    
    public void start(){
        
    }

    public void update(){

    }

    public void draw(){

    }

    public void main(){
        update();
        draw();
    }
}
