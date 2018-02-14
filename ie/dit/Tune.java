package ie.dit;

class TuneBook
{
	
}

public class Tune
{
	int x;
	private String title;
	private String altTitle;
	private String notation;
	
	public Tune()
	{
		this.x=x;
		this.title = title;
		this.altTitle = altTitle;
		this.notation = notation;
	}
	
	public String toString()
    {

		String ret = x + "," + title + "," + altTitle;     
		return ret;
    }
}
