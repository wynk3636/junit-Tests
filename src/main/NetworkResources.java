package main;

import java.io.IOException;
import java.io.InputStreamReader;

public class NetworkResources {
	
	public NetworkLoader loader = new NetworkLoader();
	
	public String load() throws IOException{
		
		try(InputStreamReader reader = new InputStreamReader(loader.getInput());) {
			StringBuilder str = new StringBuilder();
			char[] buf = new char[512];
			
			for(;;) {
				int len = reader.read(buf);
				if(len == -1) break;
				str.append(new String(buf,0,len));
			}
			return str.toString();
		}

	}

}
