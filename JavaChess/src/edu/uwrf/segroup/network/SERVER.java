package edu.uwrf.segroup.network;

import java.io.*;
import java.net.*;

public class SERVER {

	public static void main(String[] args) throws IOException {
		//try{
		
			ServerSocket ss = new ServerSocket(8888);
			Socket s = ss.accept();
			
			//Input/Output Streams
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Simular to scanner
			
			String inputM = "",outputM="";
			
			while(!outputM.equals("end")){
				
				inputM = din.readUTF();//Read from input stream
				System.out.println(inputM);//print client message to console
				outputM = br.readLine();//read input from console
				dout.writeUTF(outputM + " //Server Message//");//write to output stream
				dout.flush();
				}//End While
			
			ss.close();
	
			

	}//end main

}//end class
