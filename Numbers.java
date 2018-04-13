package my.java.utilities;

public class Numbers {
	
	public static void main(String args[]) {
		
		int numArr[] = {1,10,11,45,32,18,94,57,3,33};
		findLargest2ndLarget(numArr);		
		
	}
	
	public static void findLargest2ndLarget(int []numArr) {
		int largestNum=0;
		int secondLargestNum=0;
		int counter=0;
		while(counter<numArr.length) {
			System.out.format("numArr[%d]:%d\n",counter,numArr[counter]);
			if(largestNum < numArr[counter] ) {
				secondLargestNum=largestNum;
				
				largestNum=numArr[counter];
				System.out.println("If\tCounter:"+counter+"->"+largestNum+":"+secondLargestNum);
				counter++;
			}
			else {
				if(secondLargestNum<numArr[counter])
					secondLargestNum=numArr[counter];
				System.out.println("Else\tCounter:"+counter+"->"+largestNum+":"+secondLargestNum);
				counter++;
			}
		}
		System.out.println("\n\n\n"+largestNum+":"+secondLargestNum);	
	}

}
