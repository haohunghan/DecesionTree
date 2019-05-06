
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author STUDENT TDTU
 */
public class Property {
    
    private ArrayList<String> arrProperty;
    private double entropy;
    
    private ArrayList<int[]> arrIsPlaying;
    
    public Property(){
        arrProperty = new ArrayList<>();
        entropy = 0;
        arrIsPlaying = new ArrayList<>();
    }

    public double getEntropy() {
        return entropy;
    }

    public void setEntropy(double entropy) {
        this.entropy = entropy;
    }
    
    public void addElementProperty(String ele){
        arrProperty.add(ele);
    }
    
    public void addElementIsPlaying(int[] a){
        arrIsPlaying.add(a);
    }
        
    public ArrayList<String> getArrProperty() {
        return arrProperty;
    }
    
    public ArrayList<int[]> getArrIsPlaying() {
        return arrIsPlaying;
    }
    
}
