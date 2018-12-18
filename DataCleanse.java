import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DataCleanse {

	public static void main(String[] args) {
		BufferedReader br = null;
	    String line = "";
	    String delimiter = "\\|";
	    
		try {
	    	br = new BufferedReader(new FileReader("C:\\Users\\sandeep.das02\\Desktop\\sample1.txt"));
	    	
	    	String fieldNames []= br.readLine().split("\\|");
	    	for(int j=0;j<fieldNames.length;j++)System.out.print("Column["+j+"]:"+fieldNames[j]+"\t");
	    	
	    	System.out.println("\n");
	    	while ((line=br.readLine())!=null) {
	    		
	    		String[] data = line.split(delimiter);      
	    		for(int j=0;j<data.length;j++) {
	    			
	    			/*if(countSubstring("\"",data[j])%2!=0) {
	    				
	    				String str=data[j]+"|"+data[j+1];
	    				System.out.println("ColumnValue["+j+"]:"+data[j]+"|"+data[j+1]);
	    				j++;
	    				
	    			}
	    			else 
	    				System.out.println("ColumnValue["+j+"]:"+data[j]);*/
	    			String colAndIdx []= fetchCol(data[j], data,j).split("@");
	    			String col = colAndIdx[0];
	    			j=Integer.parseInt(colAndIdx[1]);
	    			System.out.println(col);
	    		}	    	
	    	}

		}catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	     catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static int countSubstring(String subStr, String str){
		return (str.length() - str.replace(subStr, "").length()) / subStr.length();
	}
	
	public static String fetchCol(String data, String dataArr[],int idx) {
		if(countSubstring("\"",data)%2==0) {
			return (data +"@"+idx);
			
		}
		else {

			return fetchCol(data+"|"+dataArr[idx+1], dataArr,idx+1);
		}
				
	}

}

