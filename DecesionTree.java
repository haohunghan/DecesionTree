//https://www.javagists.com/java-tree-data-structure

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;


public class DecesionTree {
	
    public static void main(String[] args) throws FileNotFoundException {
        
        double ttt = DecesionTreeCalculation("");
       
        
        /*for (int i =0; i < outlook.getArrIsPlaying().size(); i++){
            for (int k=0; k < outlook.getArrIsPlaying().get(i).length; k++){
                System.out.println(outlook.getArrIsPlaying().get(i)[k]); 
            }
            System.out.println();
        }*/
        
        /*String test  = "overcast,hot,high,false";
        System.out.println(DecesionTreeCalculation(test));
        Random rd = new Random();
        String outlook, temp, humidty,windy;
        int countPlay = 0, countNoplay = 0;
        for (int i=0; i < 200; i++){
            
            outlook = arrOutlook.get(rd.nextInt(arrOutlook.size()));
            temp = arrTemp.get(rd.nextInt(arrTemp.size()));
            humidty = arrHumidty.get(rd.nextInt(arrHumidty.size()));
            windy = arrWindy.get(rd.nextInt(arrWindy.size()));
            
            if (returnPlaying(outlook, temp, humidty, windy))     countPlay++;
            else countNoplay++;
            
        }
        System.out.println("Number play: " + countPlay);
        System.out.println("Number no play: " + countNoplay);
        */

    }
	
    static Property outlook = new Property();
    static Property humidty = new Property();
    static Property windy = new Property();
    static Property temp = new Property();
    static int[] t = {0, 0};
    static ArrayList<String> arrOutlook = new ArrayList<>();
    static ArrayList<String> arrTemp = new ArrayList<>(); 
    static ArrayList<String> arrHumidty = new ArrayList<>();
    static ArrayList<String> arrWindy = new ArrayList<>();
    
    static double DecesionTreeCalculation(String inputString) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data/tennis.txt"));
        String[] type = new String[5]; 
        String strTemp;
        ArrayList<String> dataArrL = new ArrayList<>();
        
        while (sc.hasNextLine()){
            dataArrL.add(sc.nextLine());
        }
        
        int numberOfYes = 0, numberOfNo = 0;
        
        ArrayList<String> numberYes = new ArrayList<>();     //Tong tat ca cac thuoc tinh yes
        ArrayList<String> numberNo = new ArrayList<>();       // tong tat ca thuoc tinh no
        ArrayList<String> allKindOfElement = new ArrayList<>();   //Tong tat ca cac thuoc tinh(khong trung)
        int sunnyYes = 0, sunnyNo = 0, overcastYes = 0, overcastNo = 0, rainyYes = 0, rainyNo = 0;
        int hotYes = 0, hotNo = 0, mildYes = 0, mildNo = 0, coolYes = 0, coolNo = 0; 
        int highYes = 0, highNo = 0, normalYes = 0, normalNo = 0;
        int falseYes =0, falseNo = 0, trueYes = 0, trueNo = 0;
        for (int i=0; i< dataArrL.size(); i++){ 
            
            //Them tat ca cac kieu du lieu vao keys
            String[] tmp = dataArrL.get(i).split(",");
            
            if (!outlook.getArrProperty().contains(tmp[0])){
                outlook.addElementProperty(tmp[0]); 
                outlook.addElementIsPlaying(t);
            }
            if (!temp.getArrProperty().contains(tmp[1])){
                temp.addElementProperty(tmp[1]);
                temp.addElementIsPlaying(t);
            }
            if (!humidty.getArrProperty().contains(tmp[2])){
                humidty.addElementProperty(tmp[2]);
                humidty.addElementIsPlaying(t);
            }
            if (!windy.getArrProperty().contains(tmp[3])){
            	windy.addElementProperty(tmp[3]);
                windy.addElementIsPlaying(t);
            }
            
            for (int o=0; o < outlook.getArrProperty().size(); o++){
                if (tmp[0].equals(outlook.getArrProperty().get(o)) && "yes".equals(tmp[4])){
                    outlook.getArrIsPlaying().get(o)[0]++;  //[play, noplay]
                    //System.out.println(outlook.getArrIsPlaying().get(o)[0]);
                    System.out.println(o);
                }
                else if (tmp[0].equals(outlook.getArrProperty().get(o)) && "no".equals(tmp[4])){
                    outlook.getArrIsPlaying().get(o)[1]++;
                }
            }
            
            if (tmp[0].equals("sunny") && tmp[4].equals("yes")) 		sunnyYes++;
            if (tmp[0].equals("sunny") && tmp[4].equals("no"))			sunnyNo++;
            if (tmp[0].equals("overcast") && tmp[4].equals("no"))		overcastNo++;
            if (tmp[0].equals("overcast") && tmp[4].equals("yes"))		overcastYes++;
            if (tmp[0].equals("rainy") && tmp[4].equals("yes"))                 rainyYes++;
            if (tmp[0].equals("rainy") && tmp[4].equals("no"))                  rainyNo++;
            
            if (tmp[1].equals("hot") && tmp[4].equals("yes"))                   hotYes++;
            if (tmp[1].equals("hot") && tmp[4].equals("no"))			hotNo++;
            if (tmp[1].equals("mild") && tmp[4].equals("no"))                   mildNo++;
            if (tmp[1].equals("mild") && tmp[4].equals("yes"))                  mildYes++;
            if (tmp[1].equals("cool") && tmp[4].equals("yes"))                  coolYes++;
            if (tmp[1].equals("cool") && tmp[4].equals("no"))                   coolNo++;
            
            if (tmp[2].equals("normal") && tmp[4].equals("yes"))                normalYes++;
            if (tmp[2].equals("normal") && tmp[4].equals("no"))			normalNo++;
            if (tmp[2].equals("high") && tmp[4].equals("no"))                   highNo++;
            if (tmp[2].equals("high") && tmp[4].equals("yes"))                  highYes++;
            
            if (tmp[3].equals("false") && tmp[4].equals("yes"))                 falseYes++;
            if (tmp[3].equals("false") && tmp[4].equals("no"))			falseNo++;
            if (tmp[3].equals("true") && tmp[4].equals("no"))                   trueNo++;
            if (tmp[3].equals("true") && tmp[4].equals("yes"))                  trueYes++;
            
            //Lay so lan xuat hien play = yes va play = no ( de tinh xac suat P(yes), P(no) )
            if ("yes".equals(tmp[4]))
                numberOfYes++;
            else numberOfNo++;
            
            for (int j=0; j < tmp.length; j++){
                
                //Them cac gia tri data(khong trung) vao element
                if (!allKindOfElement.contains(tmp[j])) {
                    //loai bo yes no cua class play
                    if (tmp[j].equals("yes") || tmp[j].equals("no") ){
                        
                    }
                    else {
                        allKindOfElement.add(tmp[j]);
                    }
                }
            }
        }
        
        //Entropy root
        double rateYes = (double) numberOfYes/(numberOfYes + numberOfNo);
        double rateNo = (double) numberOfNo/(numberOfYes + numberOfNo); 
        double entropyRoot = calculateEntropy(rateYes, rateNo);
        
        //outlook
        double entropySunny =  ((double)(sunnyYes + sunnyNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) sunnyYes/(sunnyYes + sunnyNo), (double) sunnyNo/(sunnyYes + sunnyNo) );
        double entropyOvercast =  ((double)(overcastYes + overcastNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) overcastYes/(overcastYes + overcastNo), (double) overcastNo/(sunnyYes + sunnyNo) );
        double entropyRainy =  ((double)(rainyYes + rainyNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) rainyYes/(rainyYes + rainyNo), (double) rainyNo/(rainyYes + rainyNo) );
        
        //temperature
        double mildEntropy = ((double)(mildYes + mildNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) mildYes/(mildYes + mildNo), (double) mildNo/(mildYes + mildNo) );
        double hotEntropy = ((double)(hotYes + hotNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) hotYes/(hotYes + hotNo), (double) hotNo/(hotYes + hotNo) );
        double coolEntropy = ((double)(coolYes + coolNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) coolYes/(coolYes + coolNo), (double) coolNo/(coolYes + coolNo) );
        
        //humidty
        double normalEntropy = ((double)(normalYes + normalNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) normalYes/(normalYes + normalNo), (double) normalNo/(normalYes + normalNo) );
        double highEntropy = ((double)(highYes + highNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) highYes/(highYes + highNo), (double) highNo/(highYes + highNo) );
        
        //windy
        double trueEntropy = ((double)(trueYes + trueNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) trueYes/(trueYes + trueNo), (double) trueNo/(trueYes + trueNo) );
        double falseEntropy = ((double)(falseYes + falseNo)/(numberOfYes + numberOfNo))
                *calculateEntropy( (double) falseYes/(falseYes + falseNo), (double) falseNo/(falseYes + falseNo) );
        
        double entropyOutlook = entropySunny + entropyOvercast + entropyRainy;
        double entropyTemp = mildEntropy + hotEntropy + coolEntropy;
        double entropyHumidty = normalEntropy + highEntropy;
        double entropyWindy = trueEntropy + falseEntropy;
        double arrDouble[] = {entropyOutlook, entropyTemp, entropyHumidty, entropyWindy};
        Arrays.sort(arrDouble);
        
        //Tong so luong cac phan tu ben trong data(loai bo di phan tu trung) va yes no cua play
        return entropyWindy;
    }
    
    
    static double calculateEntropy(double a, double b) {
    	if (a==0 || b== 0 )	return 0;
    	else return -a*Math.log(a) - b*Math.log(b);
    }
    
    static boolean returnPlaying(String outlook, String temp, String humidty, String windy){
        if ("overcast".equals(outlook))      return true;
        
        else if ("sunny".equals(outlook) && "normal".equals(humidty) )
            return true;
        else if ("rainy".equals(outlook) && "true".equals(windy))
            return true;
        else return false;
    }
    
}
