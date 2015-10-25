import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.String;

public class GetData {
	public List<String> list;
	
	GetData() throws MalformedURLException, IOException
	{
	String tekst = new Scanner(new URL("http://zagorski.im.pwr.wroc.pl/courses/kbk2015/l1.php?id=" + 208867).openStream(), "ASCII").useDelimiter("//A").next();
	String[] parts = tekst.split(Pattern.quote("<br /><br /><br /><b>(zad 2)</b> znajdz klucz, ktorego 8 znakow to:"));
	tekst=parts[0];
	tekst=tekst.replace("<br /><br /><br /><br /><b>(zad 1) kryptogram do zdeszyfrowania:</b><br />", "<br /><br />kryptogram nr 21:<br />");
	List<String> dane = Arrays.asList(tekst.split("<br /><br />kryptogram nr (\\d)*:<br />"));
	for(int i=1;i<22;i++)
	{
		String object=dane.get(i);
		object=object.replace(" ", "");
		dane.set(i, object);
	}
	list=dane;
	
	}
	
}

