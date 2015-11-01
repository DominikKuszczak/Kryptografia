import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * Result
 * key = c9288684791ae4c3 message = Lyft Teams Up With Hertz And Shell
 */
public class Zadanie2
{
    public static void main(String[] args)
    {
        String filename = "src/Kryptogram.txt";
        String ciphertext = "";
        String k1 = "", k2 = "", k3 = "791ae4c3";
        Random r = new Random();

        RC4Engine engine = new RC4Engine();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null)
            {
                StringBuilder sb = new StringBuilder();
                for (String word : line.split(" "))
                {
                    sb.append((char) (Integer.parseInt(word, 2)));
                }
                ciphertext = sb.toString();
            }
            reader.close();
        } catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return;
        }

        for(int i = 0 ; i <= 0xffff ; ++i)
        {
            for (int j = 0; j <= 0xffff; j++)
            {
                k1 = ("0000" + Integer.toHexString(i));
                k1 = k1.substring(k1.length() - 4) ;
                k2 = ("0000" + Integer.toHexString(j));
                k2 = k2.substring(k2.length() - 4) ;

                engine.init(true, new KeyParameter((k1+k2+k3).getBytes()));

                StringBuilder sb = new StringBuilder();
                boolean broken = false;
                for (int k = 0; k < ciphertext.length(); k++)
                {
                    char c = (char) engine.returnByte((byte) (ciphertext.charAt(k)));
                    if( c < 32 || 126 < c)
                    {
                        broken = true;
                        break;
                    }
                    else sb.append(c);

                }
                if(!broken)
                {
                    System.out.println("key = " + k1 + k2 + k3 + " message = " + sb.toString());
                }
            }
        }
    }

}