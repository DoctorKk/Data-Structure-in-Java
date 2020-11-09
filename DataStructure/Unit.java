package DataStructure;

public class Unit {
    public static int R = 30;
    private int val;
    private int x, y;
    private int cur;


    public Unit(int t){
        this.x = 0;
        this.y = 0;
        this.val = t;
        this.cur = 0;
    }
    public Unit(){
        this.x = 0;
        this.y = 0;
        this.val = 0;
        this.cur = 0;
    }
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void set(int x, int y, int t){
        this.x = x;
        this.y = y;
        this.val = t;
    }
    public void setc(){
        cur = 1;
    }
    public void relc(){
        cur = 0;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getV(){
        return val;
    }
    public int getC(){
        return cur;
    }
    
}
