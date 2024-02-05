package example01;

public class Goal_DTO {
	String Objective;
	String Information;
	int Low_val;
	int High_val;
	String Unit;
	public String getObjective() {
		return Objective;
	}
	public String getInformation() {
		return Information;
	}
	public int getLow_val() {
		return Low_val;
	}
	public int getHigh_val() {
		return High_val;
	}
	public String getUnit() {
		return Unit;
	}
	public void setObjective(String objective) {
		Objective = objective;
	}
	public void setInformation(String information) {
		Information = information;
	}
	public void setLow_val(int low_val) {
		Low_val = low_val;
	}
	public void setHigh_val(int high_val) {
		High_val = high_val;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	
}
