package Plasma.common.pc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.Charset;

import Plasma.common.pc.core.CommonProxy;
/*
public class MLoggingLevel {

	String prefix;
	int Level;
	InputStream fis;
	
	FileWriter fstream  ; 

	
	BufferedReader br;

	BufferedWriter wr = new BufferedWriter(fstream);
	 
	public MLoggingLevel(String l_prefix, int Level, long ID) {
		this.Level = Level;
			prefix = l_prefix;
			try{ fstream = new FileWriter(CommonProxy.PREFIXFILE); }
			catch(IOException ioexc) {
				ioexc.printStackTrace();
			}
			try {
				 fis = new FileInputStream(CommonProxy.PREFIXFILE);
			} catch(FileNotFoundException exc) {
				exc.printStackTrace();
			}  
	}
	public int getLastIDRegistered() throws NumberFormatException, IOException
	{

		br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			
			return Integer.parseInt(br.readLine());
	}
	public MLoggingLevel getLoggingLevel(String pprefix) throws NumberFormatException, IOException { 
		wr.write(getLastIDRegistered());
		return new MLoggingLevel(pprefix, 1,getLastIDRegistered());
	}
}
*/
// IMPLEMENT : MODLOGGINGLEVEL
