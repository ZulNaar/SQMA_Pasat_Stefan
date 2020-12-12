public class Locomotive {
	
	public static final int MAX_SPEED = 150;
	public static final int MIN_SPEED = 0;
	
	EngineStates engineStatus = EngineStates.STOPPED;
	float currentSpeed = 0;
	float kmSinceDeparture;	
	
	
	public Locomotive(EngineStates engineStatus, float tripKm, float currentSpeed) throws Exception {
		super();
		this.kmSinceDeparture = tripKm;
		if(currentSpeed < MIN_SPEED || currentSpeed > MAX_SPEED)
			throw new Exception();
		this.currentSpeed = currentSpeed;
		if(currentSpeed == 0 && engineStatus == EngineStates.RUNNING)
			throw new Exception();
		if(currentSpeed != 0 && (engineStatus == EngineStates.STARTING || engineStatus == EngineStates.STOPPED))
			throw new Exception();
		this.engineStatus = engineStatus;
	}
	
	public EngineStates getEngineStatus() {
		return engineStatus;
	}
	
	public void setEngineStatus(EngineStates engineStatus) {
		this.engineStatus = engineStatus;
	}
	
	public float getTripKm() {
		return kmSinceDeparture;
	}

	public void setTripKm(float tripKm) {
		this.kmSinceDeparture = tripKm;
	}

	public float getCurrentSpeed() {
		return currentSpeed;
	}
	
	public void setCurrentSpeed(float currentSpeed) throws Exception {
		if(currentSpeed < MIN_SPEED || currentSpeed > MAX_SPEED)
			throw new Exception();
		this.currentSpeed = currentSpeed;
		if(currentSpeed == 0 && engineStatus == EngineStates.RUNNING)
			throw new Exception();
		if(currentSpeed != 0 && (engineStatus == EngineStates.STARTING || engineStatus == EngineStates.STOPPED))
			throw new Exception();
		this.engineStatus = EngineStates.STOPPED;
	}
	
	public void emergencyStop(){
		this.currentSpeed = 0;
		this.engineStatus = EngineStates.STOPPED;
	}
	
}