import java.util.Arrays;

public class SortingUtility {
	
	
	public static void main(String[] args) {
	    int[] arr={5,3,1,2,6,4,2};
	    System.out.println("Input Array: "+Arrays.toString(arr));
	    //int[] res=mergeSort(arr);
	    //insertionSort(arr);
	  // System.out.println("Output Array: "+Arrays.toString(arr));
	    QuickSort(arr, 0, arr.length-1);
	    System.out.println("Output Array: "+Arrays.toString(arr));
	   //System.out.println("Output Array: "+Arrays.toString(res));
	   //isPrimeNumber(3);
	}
	
//	public static void printArr(int[] arr){
//		System.out.println("\t\t");
//		for (int i : arr) {
//			System.out.print(i+"\t");
//		}
//		System.out.println("\n");
//	}
	
	public static void isPrimeNumber(int n){
		if(n<=1){
			return;
		}
		if(n==2){
			System.out.println("PRIME NUMBER");
			return;
		}
		boolean isPrime=true;
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0){
				isPrime=false;
				break;
			}
		}
		if(isPrime){
			System.out.println("PRIME NUMBER");
		}else{
			System.out.println("NOT PRIME NUMBER");
		}
	}
	
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					arr[i]=arr[i]+arr[j];
					arr[j]=arr[i]-arr[j];
					arr[i]=arr[i]-arr[j];
				}
			}
		}
	}
	
	public static void insertionSort(int arr[]){
		int holeIndex;
		int holeValue;
		for(int i=1;i<arr.length;i++){
			holeIndex=i;
			holeValue=arr[holeIndex];
			while(holeIndex>0 && arr[holeIndex-1]>holeValue){				
				arr[holeIndex]=arr[holeIndex-1];
				holeIndex--;
			}
			arr[holeIndex]=holeValue;			
		}
	}
	
	public static void selectionSort(int[] arr){
		int minIndex;
		int temp;
		for(int i=0;i<arr.length;i++){
			minIndex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[minIndex] > arr[j]){
					minIndex=j;
				}
			}
			temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
	
	public static int[] mergeSort(int[] arr){
		return splitArray(arr);
	}
	
    public static int[] splitArray(int[] arr){
    	if(arr.length<=1){
    		return arr;
    	}
    	int mid = arr.length/2;
    	int left[]=new int[mid];
    	for(int i=0;i<mid;i++){
    		left[i]=arr[i];
    	}
    	
    	int[] right;
    	if(arr.length%2==0){
    		right=new int[mid];
    	}else{
    		right=new int[mid+1]; 
    	} 
    	
    	for(int i=mid,k=0;i<arr.length && k<right.length;i++,k++){
    		right[k]=arr[i];
    	}
    	
    	System.out.println("Left-SubArray: "+Arrays.toString(left));
    	left=splitArray(left);
    	System.out.println("Right-SubArray: "+Arrays.toString(right));
    	right=splitArray(right);
    	return mergeArrays(left,right);
    	
    }
    
     public static int[] mergeArrays(int[] left, int right[]){
    	 int leftIndex=0;
    	 int rightIndex=0;
    	 int resultIndex=0;
    	 int[] result=new int[left.length+right.length];
    	 
    	 while(leftIndex<left.length || rightIndex<right.length){
    		 if(leftIndex<left.length && rightIndex<right.length){
    			 if(left[leftIndex]<=right[rightIndex]){
    				 result[resultIndex]=left[leftIndex];
    				 leftIndex++;
    				 resultIndex++;
    			 }else{
    				 result[resultIndex]=right[rightIndex];
    				 rightIndex++;
    				 resultIndex++;
    			 }
    			 
    		 }else if(leftIndex<left.length){
    			 result[resultIndex]=left[leftIndex];
				 leftIndex++;
				 resultIndex++;
    		 }else if(rightIndex<right.length){
    			 result[resultIndex]=right[rightIndex];
				 rightIndex++;
				 resultIndex++;
    		 }
    	 }
    	 System.out.println("Merged-Array: "+Arrays.toString(result));
    	 return result;
     }
     
     public static void QuickSort(int[] arr, int startIndex,int endIndex){
    	 if(startIndex<endIndex){
    		 int partitionIndex=partition(arr,startIndex,endIndex);
    		 QuickSort(arr, startIndex, partitionIndex-1);
    		 QuickSort(arr, partitionIndex+1, endIndex);
    	 }
     }

	private static int partition(int[] arr, int startIndex, int endIndex) {
		int pivot=arr[endIndex];
		int partitionIndex=startIndex;
		for(int i=startIndex;i<endIndex;i++){
			if(arr[i]<=pivot){
				int temp=arr[i];
				arr[i]=arr[partitionIndex];
				arr[partitionIndex]=temp;
				partitionIndex++;
			}
		}
		int temp=arr[partitionIndex];
		arr[partitionIndex]=arr[endIndex];
		arr[endIndex]=temp;
		return partitionIndex;
	}

}
