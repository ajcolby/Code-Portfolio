// Assignment 5
// Name: <Austin Colby>
// Section: <1>
// Fall 2014

import java.util.*;
import java.io.*;
import java.util.Random;

public class Sorting
{ 
	public static void main(String[] args) { 
	boolean go = true;
	boolean go2	= true;
	int n = 10; 
	while(true){
		
		double[] a = new double[n];
		double[] b = new double[n]; 
		
		for(int i = 0; i < a.length; i++){
			Random r = new Random();
			double ran = r.nextDouble();
			a[i] = ran;
			b[i] = ran; 
		}	
		
		
			try{
			if(go2){
				long start2 = System.currentTimeMillis();
				MergeSort(b);
				long end2 = System.currentTimeMillis();
				long duration2 = end2 - start2;
				long Stop2 = start2 + 20000;
				System.out.println("Merge sort took: " +  duration2 + " Milliseconds");
				if(System.currentTimeMillis() >= Stop2){
					System.out.println("Merge sort took Longer than 20 seconds");
					go2 = false; 
				}
			}else{
			
			}
			} catch (OutOfMemoryError Ex){
				System.out.println("Merge Sort Program out of Memory");
				System.exit(1);
			}
			
			try{
			if(go){
			long start = System.currentTimeMillis();
				Bubble(a); 
			long end = System.currentTimeMillis();
			long duration = (end - start);
			long Stop = start + 20000;
			System.out.println("Bubble sort took: " +duration+ " Milliseconds");
				if(System.currentTimeMillis() >= Stop){
					System.out.println("Bubble sort took Longer than 20 seconds");
					go = false; 
				}
			} else{
			
			}
			} catch (OutOfMemoryError E){
				System.out.println("Bubble Sort Program out of Memory");
				System.exit(1);
			}
					
		n *= 10; 
		
		}
	} 
	
	public static double[] Bubble(double[] a){
		double temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length - i; j++) {
				if (a[j - 1] > a[j]) {
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	
	public static double[] MergeSort(double[] b){
		if( b.length <= 1){
			return b;
		}
		
    double[] left  = new double[b.length];
	double[] right  = new double[b.length];
	double[] result  = new double[b.length];
	
    int middle = b.length/ 2;
    for(int i = 0; i < middle; i++){
         left[i] = b[i];
	}
    for(int j = middle; j < b.length; j++){
         right[j] = b[j]; 
	}
		//left = MergeSort(left);
		//right = MergeSort(right);
		result = Merge(left, right,b);
		
    return result;
	
	}
	
	public static double[] Merge(double [] left, double[] right, double[] b){
		double[] result = new double[b.length];
		int i = 0; 
		while(left.length > 0 || right.length > 0){
		if(i >= b.length){
			break;
		} else{
			if(left.length > 0 && right.length > 0){
				if(left[i] < right[i]){
					result[i] = left[i]; 
					left[i] = left[i];
				}else{
					result[i] = right[i];
					right[i] = right[i];
				}
			}else if(left.length > 0){
				result[i] = left[i]; 
				left[i] = left[i];            
			}else if(right.length > 0){
				result[i] = right[i];
				right[i] = right[i];
			}
			i++;
		
			}
		}
		return result;
	}
} 