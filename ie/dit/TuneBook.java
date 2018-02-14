package ie.dit;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class TuneBook {
	
	ArrayList<Tune> tunes = new ArrayList<Tune>();
	Tune t = new Tune();
	String loadname;
	public TuneBook(String loadname) {
		// TODO Auto-generated constructor stub
		this.loadname=loadname;
		loadFile(loadname);
	}
	
  public void loadFile(String firename)
	    {

	        BufferedReader inputStream = null;

	        try {
	            inputStream = new BufferedReader(new FileReader(firename));
	            
	            String l;
	            while ((l = inputStream.readLine()) != null) {
	            	if(l.startsWith("X:"))
	            	{
	            		t.x =Integer.parseInt(l.substring(2,3));
	            	}
	            	if(l.startsWith("T:"))
	            	{
	            		t.title =l.substring(2,l.length());
	            	}
	            	
	            	tunes.add(t);
	            }
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            if (inputStream != null) {
	                try
	                {
	                    inputStream.close();
	                }
	                catch(Exception e)
	                {
	                    e.printStackTrace();
	                }
	            }
	        }
	   }
	 	
	 	
	public Tune findTune(String title)  
	{
		StringBuffer sb = new StringBuffer();
        for(Tune t:tunes)
        {
            if(title.equals(t.title))
            {
            	return t;
            }
        }
	}
	
	interface Tune {
		   public void play(Tune t);
		   {
			   System.out.println(t.notation);
		   }
	}

	public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for(Tune t:tunes)
        {
            sb.append(t + ", ");
        }

        return sb.toString();
    }
	
	 public static void main(String[] args)
     {
         TuneBook tb = new TuneBook("hnj0.abc");
         System.out.println(tb);

         Tune t = tb.findTune("Scotsman over the Border");
         t.play();
     }

}
