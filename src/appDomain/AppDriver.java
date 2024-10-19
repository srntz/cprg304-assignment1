package appDomain;

import manager.SortManager;

public class AppDriver
{
	/**
	 * The program's entry point
	 * @param args Command line arguments
	 */
	public static void main( String[] args )
	{
		SortManager manager = new SortManager(args);
		manager.RunSorting();
	}

}
