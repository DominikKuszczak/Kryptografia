
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deszyfrator 
{
	public static void main(String[] args) throws IOException
	{
	List<List<String>> klucze = new ArrayList<>();
	GetData Data=new GetData();
	List<String> kody=new ArrayList<>();
	for(int k=1;k<Data.list.size();k++)
	{
		kody.add(Data.list.get(k));
	}
	WhiteList whiteList=new WhiteList();
	String kryptogram=Data.list.get(21);
	
	for(int i=0;i<kryptogram.length()/8;i++)
	{
		List<String> mozliweklucze=new ArrayList<>();
		
		for(int j=0;j<256;j++)
		{
			boolean check=true;
			int znak=0;
			for(String object:kody)
			{
				znak=Integer.parseInt(object.substring((i+1)*8-8, (i+1)*8), 2) ^ j;
				if(whiteList.WList.contains(znak))
				{
					check=true;
				}
				else
				{
					check=false;
					break;
				}				
			}	
			if(check==true)
			{					
				mozliweklucze.add(Integer.toString(znak));					
			}
		}
		klucze.add(mozliweklucze);
	}
	for(List<String> lista:klucze)
	{		
		for(String asd:lista)
		{
			System.out.print((char)Integer.parseInt(asd)+"_");			
		}
		System.out.println("");		
	}	
	}
}
