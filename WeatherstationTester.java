
public class WeatherstationTester {
	public static void main(String[] args) {
		Weatherstation weatherstation = new Weatherstation();
		for(int i=0;i<500;i++)
		{
			System.out.println(weatherstation.generateWeatherMessage());
		}
		
		System.out.println(weatherstation.getStormAndColdWarningCount());
		System.out.println("========================================================================================");
	}
}
