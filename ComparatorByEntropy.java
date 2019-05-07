
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anhha
 */

//sap xep theo tu nho den lon
public class ComparatorByEntropy implements Comparator<Property> {

    @Override
    public int compare(Property o1, Property o2) {
        if (o1.getEntropy() == o2.getEntropy() )
            return 0;
        else if (o1.getEntropy() > o2.getEntropy())
            return 1;
        return -1;
    }
    
}
