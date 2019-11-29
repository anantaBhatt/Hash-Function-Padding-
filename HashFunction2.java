/**
 * 
 */

/**
 * @author Ananta Bhatt
 *
 */
public class HashFunction2 {
	public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' ,' '};
    public static char elements[]  = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
    public static char[][] matrix1 = new char[5][5];
    public static int[][] matrix2 = new int[5][5];
    static String input="the birthday attack can be performed for any hash functions including sha three";
    public static char[][] input_string_Matrix(String str)
    {
    	
    	for (int i = 0; i < 5; i++) {
    	    for (int j = 0; j < 5; j++) {
    	        matrix1[i][j] = str.charAt(5 * i + j);
    	    }
    	}
    	System.out.println("Matrix form ");
    	for (int i = 0; i < 5; i++) {
    	    for (int j = 0; j < 5; j++) {
    	      System.out.print(" " + matrix1[i][j]);
    	    }
    	    System.out.println("");
    	    }
		return matrix1;
    	
    }
    public static int[] map_numbers(String input)
    {
        int i=0;
        int[] a=new int[input.length()];
    	   //Mapping correspondence elements with the plaintext and alphabets
        for (i = 0; i < input.length(); i++)
        {
                for (int j = 0; j < 28; j++)
                {
                    if (p[j] == input.charAt(i))
                    {
                        a[i] = elements[j];
                        break;
                    }
                }
        }
        return a;
    }
    public static char[] map_elements(int[] e)
    {
        int i=0;
        char[] a=new char[e.length];
    	   //Mapping correspondence elements with the plaintext and alphabets
        for (i = 0; i < e.length; i++)
        {
                for (int j = 0; j < 28; j++)
                {
                    if (elements[j] == e[i])
                    {
                        a[i] = p[j];
                        break;
                    }
                }
        }
        return a;
    }

    public static int[][] map_Matrix(String str)
    {
    	int[] a=new int[str.length()];
    	a=map_numbers(str);
        
    	//System.out.println(number);
    	for (int i = 0; i < 5; i++) {
    	    for (int j = 0; j < 5; j++) {
    	    	
    	        matrix2[i][j] =  a[5 * i + j];
    	    }
    	}System.out.println("Mapped Matrix");
    	for (int i = 0; i < 5; i++) {
    	    for (int j = 0; j < 5; j++) {
    	      System.out.print(" " + matrix2[i][j]);
    	    }
    	    System.out.println();
    	    }
		return matrix2;
    	
    }
    public static int[] round1(int[][] matrix2)
    {
    	int[] out= {0,0,0,0,0};
    	for(int j=0;j<5;j++)
    	{
    	for (int i = 0; i < 5; i++) {
    	     
    	    	out[j]+=matrix2[i][j];
    	    }  
    	}
    	for (int i = 0; i < 5; i++) {
    	out[i]=out[i]%27;}
    
		return out;
    	
    }
    public static int[] sum_row_out(int[][] matrix2)
    {
    	int[] out= {0,0,0,0,0};
    	for(int j=0;j<5;j++)
    	{
    	for (int i = 0; i < 5; i++) {
    	     
    	    	out[j]+=matrix2[j][i];
    	    }  
    	}
    	for (int i = 0; i < 5; i++) {
    	out[i]=out[i]%27;}
    
		return out;
    	
    }
    public static int[][] round2(int[][] mtx)
    {
    	int [][] myInt = new int[5][5];
        for(int i = 0; i< mtx.length; i++){
            for (int j = 0; j < mtx[i].length; j++){
                myInt[i][j] = mtx[i][j];
            }
        }
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			if(i==0)
    			{
    				if(j==0)
                     mtx[i][j+4]=myInt[i][j];
    				else
    			mtx[i][j-1]=myInt[i][j];
    			}
    		
    		else if(i==1)
    		{
			 if(j==2||j==3||j==4)
                	 mtx[i][j-2]=myInt[i][j]; 
			 else
			      mtx[i][j+3]=myInt[i][j];
				}
    		else if(i==2)
    		{
    			if(j==3||j==4)
    				 mtx[i][j-3]=myInt[i][j]; 
    			else
    			mtx[i][j+2]=myInt[i][j];	
    		}
    		else if(i==3)
    		{
    			if(j==4)
    				 mtx[i][j-4]=myInt[i][j]; 
    			else
    			mtx[i][j+1]=myInt[i][j];	
    		}
    		else if(i==4)
    			mtx[i][j]=myInt[i][j];
		}
    		}
System.out.println("Rotated Matrix");
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			System.out.print(" "+mtx[i][j]);
    		}System.out.println("");}
		return mtx;
    
    }
    public static int[][] round3(int[][] mtx1,int[][] mtx2)
    {
		int n=5;
		int d=1;
		int[] [] block4= new int[5][5];
		//Matrix column shifting
		for(int i=0;i<5;i++)
		{
			int[] temp = new int[5];
			for(int j=0;j<5;j++)
			{
			  temp[(j-d+n)%n] =mtx1[j][i] ;
			}
			
			int t1=0;
			int swap=3;
			for(int j=0;j<2;j++)
			{
				
				t1=temp[j];
				temp[j]=temp[j+swap];
				temp[j+swap]=t1;
				swap= swap-2;
			}
			for(int j=0;j<5;j++)
			{
				block4[i][j]= temp[j];
			}
			d++;
		}
		int i=4;
		for(int j=0;j<5;j++)
		{
			block4[j][i]= mtx2[j][i];
		}
		System.out.println("column rotated");
		for(int k=0;k<5;k++)
    	{
    		for(int l=0;l<5;l++)
    		{
    			System.out.print(" "+block4[k][l]);
    		}System.out.println("");}
    return block4;
    }
    public static void main(String arg[])
	{
    	if(input.length()%25!=0)
    	{
    		for(int i=0;i<input.length()%25;i++)
    			input+=" ";
    	}
    	 int[][] block1_int = new int[5][5];
    	 int[][] block2_int = new int[5][5];
    	 int[][] block3_int = new int[5][5];
    	 int[][] block4_int = new int[5][5];
    	 int[][] mtx3 = new int[5][5];
    	 int[][] mtx31 = new int[5][5];
    	 int[][] mtx32 = new int[5][5];
    	 int[][] mtx33 = new int[5][5];
    	 int[][] mtx4 = new int[5][5];
    	 int[][] mtx41 = new int[5][5];
    	 int[][] mtx42 = new int[5][5];
    	 int[][] mtx43 = new int[5][5];
    	 char[][] block1_char = new char[5][5];
    	 char[][] block2_char = new char[5][5];
    	 char[][] block3_char = new char[5][5];
    	 char[][] block4_char = new char[5][5];
    	String str1="";
    	for(int i=0;i<25;i++)
    		str1+=input.charAt(i);
    	
    	String str2="";
    	for(int i=25;i<50;i++)
    		str2+=input.charAt(i);
    	String str3="";
    	for(int i=50;i<75;i++)
    		str3+=input.charAt(i);
    	String str4="";
    	for(int i=75;i<input.length();i++)
    		str4+=input.charAt(i);
    	 block1_char=input_string_Matrix(str1);
    	 block2_char=input_string_Matrix(str2); 
    	 block3_char=input_string_Matrix(str3); 
    	 block4_char=input_string_Matrix(str4); 
    	 block1_int= map_Matrix(str1);
    	
    	 
    	
    	 int [][] block1_int_rep = new int[5][5];
         for(int i = 0; i< block1_int.length; i++){
             for (int j = 0; j < block1_int[i].length; j++){
                 block1_int_rep[i][j] = block1_int[i][j];
             }}
    	 
            
        
         
         //Out operation
         int[] out_block1_r1,out_block2_r1,out_block3_r1,out_block4_r1;
    	 out_block1_r1=round1(block1_int);
    	 //Rotated row
    	 mtx3=round2(block1_int);
    	 //Out operation
    	 int[] out_block1_r2;
    	 out_block1_r2=round1(mtx3);
    	 int[] out_block1_r1r2= new int[5];
    	 for (int l = 0; l < 5; l++) {
    		 out_block1_r1r2[l]=(out_block1_r1[l]+out_block1_r2[l])%27;}
    	 for (int m = 0; m < 5; m++) {
         	System.out.println("The Out Array after round 2 is:"+out_block1_r1r2[m]);}
    	 //Rotation Column 
    	 mtx4=round3(block1_int_rep, mtx3);
    	 //Out operation
    	 int[] d;
    	 d=sum_row_out(mtx4);
    	 int[] out_block1_r1r2r3= new int[5];
    	 for (int l = 0; l < 5; l++) {
    	    	out_block1_r1r2r3[l]=(out_block1_r1r2[l]+d[l])%27;}
    	 for (int m = 0; m < 5; m++) {
          	System.out.println("The Out Array after round 3 is:"+out_block1_r1r2r3[m]);}
    	 
    	 //Block2
    	 int [][] block2_int_rep = new int[5][5];
    	 block2_int= map_Matrix(str2);
         for(int i = 0; i< block2_int.length; i++){
             for (int j = 0; j < block2_int[i].length; j++){
                 block2_int_rep[i][j] = block2_int[i][j];}}
    	 
    	 //Out operation for block2
    	 out_block2_r1=round1(block2_int);
    	 //Rotation row
    	 mtx31=round2(block2_int);
    	 //Out operation
    	 int[] out_block2_r2;
    	 out_block2_r2=round1(mtx31);
    	 int[] out_block2_r1r2= new int[5];
    	 for (int l = 0; l < 5; l++) {
    		 out_block2_r1r2[l]=(out_block2_r1[l]+out_block2_r2[l])%27;}
    	 //Rotation column
    	 mtx41=round3(block2_int_rep, mtx31);
    	 //Out operation
    	 int[] d1;
    	 d1=sum_row_out(mtx41);
    	 int[] out_block2_r1r2r3= new int[5];
    	 for (int l = 0; l < 5; l++) {
    		 out_block2_r1r2r3[l]=(out_block2_r1r2[l]+d1[l])%27;}
    	 for (int m = 0; m < 5; m++) {
           	System.out.println("The Out Array after round 3 is:"+out_block2_r1r2r3[m]);}
    	 
    	 //Block1 and block2 out operation
    	 int[] block_12= new int[5];
    	 for (int l = 0; l < 5; l++) {
    	    	block_12[l]=(out_block2_r1r2r3[l]+out_block1_r1r2r3[l])%27;}
    	 
    	 //Block3
    	 block3_int= map_Matrix(str3);
    	 int [][] block3_int_rep = new int[5][5];
         for(int i = 0; i< block3_int.length; i++){
             for (int j = 0; j < block3_int[i].length; j++){
            	 block3_int_rep[i][j] = block3_int[i][j];
             }}
    	 //Out operation for block3
        
    	 out_block3_r1=round1(block3_int);
    	 //Rotation row
    	 mtx32=round2(block3_int);
    	 //Out operation
    	 int[] out_block3_r2;
    	 out_block3_r2=round1(mtx32);
    	 int[] out_block3_r1r2= new int[5];
    	 for (int l = 0; l < 5; l++) {
    		 out_block3_r1r2[l]=(out_block3_r1[l]+out_block3_r2[l])%27;}
    	 //Rotation column
    	 mtx42=round3(block3_int_rep, mtx32);
    	 //Out operation
    	 int[] d2;
       	 d2=sum_row_out(mtx42);
       	 int[] out_block3_r1r2r3= new int[5];
       	 for (int l = 0; l < 5; l++) {
       		out_block3_r1r2r3[l]=(out_block3_r1r2[l]+d2[l])%27;}
       	for (int m = 0; m < 5; m++) {
           	System.out.println("The Out Array after round 3 is:"+out_block3_r1r2r3[m]);}
       	 
       	 //Block1,block2,block3
       	 int[] block_123= new int[5];
    	 for (int l = 0; l < 5; l++) {
    	    	block_123[l]=(out_block3_r1r2r3[l]+block_12[l])%27;}
    	 
    	 
    	 //Block4
    	 block4_int= map_Matrix(str4);
    	 int [][] block4_int_rep = new int[5][5];
         for(int i = 0; i<  block4_int.length; i++){
             for (int j = 0; j < block4_int[i].length; j++){
            	 block4_int_rep[i][j] = block4_int[i][j];
             }}
    	 //Out operation for block4
         out_block4_r1=round1(block4_int);
       	 //Rotation row
       	 mtx33=round2(block4_int);
       	 //Out operation
       	int[] out_block4_r2;
       	out_block4_r2=round1(mtx33);
   	 int[] out_block4_r1r2= new int[5];
   	 for (int l = 0; l < 5; l++) {
   		out_block4_r1r2[l]=(out_block4_r1[l]+out_block4_r2[l])%27;}
   //Rotation column
   	 mtx43=round3(block4_int_rep, mtx33);
   	 //Out operation
   	int[] d3;
	 d3=sum_row_out(mtx43);
	 int[] out_block4_r1r2r3= new int[5];
	 for (int l = 0; l < 5; l++) {
		 out_block4_r1r2r3[l]=(out_block4_r1r2[l]+d3[l])%27;}
    		for (int k = 0; k < 5; k++) {
            	System.out.println("The Out Array afrer round 3 is:"+out_block4_r1r2r3[k]);}
    		
   //Block1,2,3,4
    	 int[] block_1234= new int[5];
    	 for (int l = 0; l < 5; l++) {
    	    	block_1234[l]=(block_123[l]+out_block4_r1r2r3[l])%27;}
    	 char[] hashed_output;
    	 hashed_output=map_elements(block_1234);
    	 System.out.print("The Hashed Output is:");
    	 for (int m = 0; m < hashed_output.length; m++) {
           	System.out.print(""+hashed_output[m]);}
	}
}


