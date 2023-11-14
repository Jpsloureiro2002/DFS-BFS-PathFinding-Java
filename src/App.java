
import javax.swing.*;
import java.awt.*;
    public class App extends JFrame{
        private Map map;

        public App(Map map) {
            this.map = map;
            initializeUI();
        }

        private void initializeUI() {
            setTitle("DFS & BFS");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(50*map.map[0].length+50, 50*map.map.length + 50);
            MapPanel mapPanel = new MapPanel(map);
            add(mapPanel);

            setVisible(true);
        }
    public static void main(String[] args) throws Exception {
        Map map = new Map();

        int[] goal = {9,8};
        int[] pos = {0,0};
        for (int y = 0; y < map.getMap().length; y++) {
            for (int x = 0; x < map.getMap()[y].length; x++) {
                if( map.getMap()[y][x] == 5){
                    goal[0] = x;
                    goal[1] = y;
                    System.out.println("Goal -> x: " + x + ", y: " + y);
                }else if (map.getMap()[y][x] == 9) {
                    pos[0] = x;
                    pos[1] = y;
                    System.out.println("Goal -> x: " + x + ", y: " + y);
                }
            }
        }

        Agent robot = new Agent(1, pos, map, goal);

        //Change here the BFS or DFS or uncomment
        //robot.DFS();
        robot.BFS();
        SwingUtilities.invokeLater(() -> new App(map));
    }

    class MapPanel extends JPanel {
        private Map map;

        public MapPanel(Map map) {
            this.map = map;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int cellSize = 50; // Ajuste conforme necessário

            for (int y = 0; y < map.getViwemap().length; y++) {
                for (int x = 0; x < map.getViwemap()[y].length; x++) {
                    int cellValue;
                    if(map.map[y][x] == 9 || map.map[y][x] == 5){
                        cellValue = map.getMap()[y][x];
                    }else{
                        cellValue = map.getViwemap()[y][x];
                    }
                    

                    Color color;
                    switch (cellValue) {
                        case 0:
                            color = Color.WHITE;
                            break;
                        case 1:
                            color = Color.BLACK;
                            break;
                        case 3:
                            color = Color.PINK;
                            break;
                        case 5:
                            color = Color.RED;
                            break;
                        case 6:
                            color = Color.BLUE;
                            break;
                        case 7:
                            color = Color.YELLOW;
                            break;
                        case 9:
                            color = Color.GREEN;
                            break;
                        default:
                            color = Color.GRAY;
                    }
                    g.setColor(color);
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
                }
            }
        }
    }
}
