package appDomain;

import manager.SortManager;

public class AppDriver
{

	public static void main( String[] args )
	{
		SortManager manager = new SortManager(args);
		manager.RunSorting();
	}

}
