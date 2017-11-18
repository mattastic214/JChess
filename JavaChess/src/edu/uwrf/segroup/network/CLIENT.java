package edu.uwrf.segroup.network;

import java.io.*;
import java.net.*;
public class CLIENT {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
			Socket s = new Socket("10.20.29.72",8888);//IP of machine want coms with. Same port as server.
			
			//Input/Output Stream for messages
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Simular to scanner
			
			String inputM = "", outputM = "";
			
			while(!outputM.equals("end")){
				
				outputM = br.readLine();//Reads input from console
				dout.writeUTF(outputM + " //Client Message//");//writes to output stream
				inputM = din.readUTF();//Reads from input stream(Server)
				System.out.println(inputM);//Print Server Message
				dout.flush();
			}//End While
			
			s.close();
		

	}//End Main

}
