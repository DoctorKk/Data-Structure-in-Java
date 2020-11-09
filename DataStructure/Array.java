package DataStructure;
import java.util.*;
import DataStructure.Unit;

public class Array {
    private static List<Unit> val = new ArrayList<>();
    private static int Y = 500;
    
    Array(){
        val = new ArrayList<>();
    }

    public static void repos(){
        int t = 770-val.get(val.size()/2).getX();
        if(t==0)    return;
        else{
            for(Unit temp : val){
                temp.set(temp.getX()+t, temp.getY());
            }
        }
    }

    public static Unit get(int index){
        if(val.isEmpty())   return null;
        if (index>=0 && index<val.size())
            return val.get(index);
        return null;
    }

    public static void repos(int index){
        for(;index<val.size();index++){
            val.get(index).set(val.get(index).getX()+2*Unit.R+20, val.get(index).getY());
        }
    }

    public static int insert(Unit t, int index){
        if(val.isEmpty()){
            t.set(770,Y);
            val.add(t);
            return 1;
        }
        
        if(index>0){
            val.get(index-1).relc();
        }

        if(t.getV()<=val.get(index).getV()){
            repos(index);
            t.set(val.get(index).getX()-2*Unit.R-20, val.get(index).getY());
            val.add(index, t);
            repos();
        }
        else if(index==val.size()-1){
            t.set(val.get(index).getX()+2*Unit.R+20, val.get(index).getY());
            val.add(t);
            repos();
        }
        else if(t.getV()>val.get(index).getV()){
            val.get(index).setc();
            return -1;
        }
        
        return 1;
    }
}
