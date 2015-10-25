import java.util.ArrayList;

public class WhiteList {
public ArrayList<Integer> WList=new ArrayList();
WhiteList()
	{
	WList.add((int) ' ');
    WList.add((int) '!');
    WList.add((int) '.');
    WList.add((int) ',');
    WList.add((int) '?');
    WList.add((int) ':');
    WList.add((int) '-');
    WList.add((int) ';');
    WList.add((int) '(');
    WList.add((int) ')');
    WList.add((int) '"');
    WList.add((int) ';');
    for (int i = 48; i <= 57; i++) 
    {
        WList.add(i);
    }
    for (int i = 65; i <= 90; i++) 
    {
        WList.add(i);
    }
    for (int i = 97; i <= 122; i++) 
    {
        WList.add(i);
    }
	}
}
