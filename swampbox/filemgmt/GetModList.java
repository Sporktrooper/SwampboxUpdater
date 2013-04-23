package swampbox.filemgmt;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class GetModList {
	public static void main(String[] args) throws Exception{
		String modIndex = "mods.txt";
		String coremodIndex = "coremods.txt";
		String configIndex = "config.txt";

		String[] mods = getURLs(modIndex,"mods");
		String[] coremods = getURLs(coremodIndex,"coremods");
		String[] configs = getURLs(configIndex,"config");
		
		for(int i = 0; i < mods.length; i++){
			System.out.println(mods[i]);
		}
		for(int i = 0; i < coremods.length; i++){
			System.out.println(coremods[i]);
		}
		for(int i = 0; i < configs.length; i++){
			System.out.println(configs[i]);
		}
		
	}
	
	public static String[] getURLs(String list, String type) throws Exception{
		URL packDir = new URL("https://googledrive.com/host/0B4J4lMoc2heLSVdnOGV6SWRiZ00/pack/");
		URL listURL = new URL(packDir + list);
		ArrayList<String> listURLs = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(listURL.openStream()));
		
		String subdir = type + "/";
		
		String inputLine;
		while((inputLine = in.readLine()) != null){
			listURLs.add(packDir + subdir + inputLine);
		}
		in.close();
		
		String[] listArray = new String[listURLs.size()];
		listURLs.toArray(listArray);
		

		return listArray;
	}
}
