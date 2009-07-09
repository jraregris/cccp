package org.illithid.cccp;

import java.util.ArrayList;

public class MessageBuffer {
	private ArrayList<String> buffer = new ArrayList<String>();

	public void say(String string) {
		buffer.add(string);
	}

	public String[] getHead(int i) {
		String[] sa = new String[i];
		if (i < buffer.size()) {
			for (int n = 0; n < i; n++)
				if (buffer.get(buffer.size() - i + n) != null)
					sa[n] = buffer.get(buffer.size() - i + n);
				else
					sa[n] = "";
		} else {
			for(int n = 0; n < buffer.size();n++)
				if(buffer.get(n) != null)
					sa[n] = buffer.get(n);
				else
					sa[n] = "";
		}
		return sa;
	}

}
