//https://www.javagists.com/java-tree-data-structure

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;


public class DecesionTree {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String test  = "overcast,hot,high,false";
        System.out.println(DecesionTreeCalculation(test));
		String outlook, temp, humidty, windy;
		Random rd = new Random();
		
		outlook = arrOutlook.get(rd.nextInt(arrOutlook.size()));
        temp = arrTemp.get(rd.nextInt(arrTemp.size()));
        humidty = arrHumidty.get(rd.nextInt(arrHumidty.size()));
        windy = arrWindy.get(rd.nextInt(arrWindy.size()));
       
        String strInput = "";
       strInput += outlook + "," + temp + "," + humidty + "," + windy;
		
		System.out.println(DecesionTreeCalculation(strInput));
		
	}
	
	static final int alpha = 1;
	static ArrayList<String> arrOutlook = new ArrayList<>();
    static ArrayList<String> arrTemp = new ArrayList<>(); 
    static ArrayList<String> arrHumidty = new ArrayList<>();
    static ArrayList<String> arrWindy = new ArrayList<>();
    static ArrayList<int[]> arrOutlookInt = new ArrayList<>();
    static ArrayList<int[]> arrTempInt = new ArrayList<>();
    static ArrayList<int[]> arrHumidtyInt = new ArrayList<>();
    static ArrayList<int[]> arrWindyInt = new ArrayList<>();
    
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
        int sunnyYes = 0, sunnyNo = 0, overcastYes = 0, overcastNo = 0, rainyYes = 0, raniyNo = 0;
        for (int i=0; i< dataArrL.size(); i++){ 
            
            //Them tat ca cac kieu du lieu vao keys
            String[] tmp = dataArrL.get(i).split(",");
            
            if (!arrOutlook.contains(tmp[0]))
                arrOutlook.add(tmp[0]);
            if (!arrTemp.contains(tmp[1]))
                arrTemp.add(tmp[1]);
            if (!arrHumidty.contains(tmp[2]))
                arrHumidty.add(tmp[2]);
            if (!arrWindy.contains(tmp[3]))
            	arrWindy.add(tmp[3]);
            
            if (tmp[0].equals("sunny") && tmp[4].equals("yes")) 		sunnyYes++;
            if (tmp[0].equals("sunny") && tmp[4].equals("no"))			sunnyNo++;
            if (tmp[0].equals("overcast") && tmp[4].equals("no"))		overcastNo++;
            if (tmp[0].equals("overcast") && tmp[4].equals("yes"))		overcastYes++;
            
            for (int k=0; k < arrOutlook.size(); k++) {
            	
            }
            
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
        
        double entropySunny =  ((double)(sunnyYes + sunnyNo)/(numberOfYes + numberOfNo))*calculateEntropy( (double) sunnyYes/(sunnyYes + sunnyNo), (double) sunnyNo/(sunnyYes + sunnyNo) );
        double entropyOvercast =  ((double)(overcastYes + overcastNo)/(numberOfYes + numberOfNo))*calculateEntropy
        		( (double) overcastYes/(overcastYes + overcastNo), (double) overcastNo/(sunnyYes + sunnyNo) );
        
        
        //Tong so luong cac phan tu ben trong data(loai bo di phan tu trung) va yes no cua play
        return entropyOvercast;
    }
    
    static int getNumberDuplicate(String str, ArrayList<String> arrL){
        int count=0;
        for (int i=0; i < arrL.size(); i++){
            if (str.equals(arrL.get(i)) )
                count++;    
        }
        return count;
    }
    
    static double calculateEntropy(double a, double b) {
    	if (a==0 || b== 0 )	return 0;
    	else return -a*Math.log(a) - b*Math.log(b);
    }
    
}
