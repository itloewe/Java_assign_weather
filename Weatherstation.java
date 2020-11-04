
public class Weatherstation {
	private double temperature;
	private double windspeed;
	
	private double temperatureStep = 5;
	private double windspeedStep = 8;
	
	public Weatherstation(){
		this.temperature = -10.0;
		this.windspeed = 0;
	}
	
	public String generateWeatherMessage(){
		double chillTemp = calculateWindChillTemperature(measureTemperature(), measureWindspeed());
		
		String message = "Actual weather: Temp: " +this.temperature+"\u00B0"+"C"+" (Wind: "+this.windspeed+"km/h) ChillTemp: "+chillTemp+"\u00B0"+"C, ";
		
		String warning = "";
		
		if(this.windspeed>=70 && chillTemp <= -18)
			warning = WarningMessages.STORM_WARNING;
		else if(this.windspeed >= 70)
			warning = WarningMessages.WIND_WARNING;
		else if(chillTemp <= -18)
			warning = WarningMessages.COLD_WARNING;
		else
			warning = WarningMessages.NO_WARNING;
	
		return message + warning;
	}
	
	private double measureTemperature(){
		this.temperature += temperatureStep;
		if(this.temperature == 30)
			temperatureStep = -1;
		else if(this.temperature == -10 )
			temperatureStep = 5;
		
		return this.temperature;
	}
	
	private double measureWindspeed(){
		this.windspeed += windspeedStep;
		if(this.windspeed == 80)
			windspeedStep = -16;
		else if(this.windspeed == 0 )
			windspeedStep = 8;
		
		return this.windspeed;
	}
	
	private double calculateWindChillTemperature(double temperature, double windspeed){
		 double chillTemp = 13.12 + 0.6215*temperature + ((0.3965*temperature - 11.37)*(Math.pow(windspeed, 0.16)));
		 
		 return chillTemp;
	}
}
