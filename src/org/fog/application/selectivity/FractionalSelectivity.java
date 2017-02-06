package org.fog.application.selectivity;

import org.cloudbus.cloudsim.distributions.UniformDistr;

/**
 * Generates an output tuple for an incoming input tuple with a fixed probability
 * @author Harshit Gupta
 *
 */
public class FractionalSelectivity implements SelectivityModel{

	/**
	 * The fixed probability of output tuple creation per incoming input tuple
	 */
	double selectivity;
	public static UniformDistr rand = new UniformDistr(0,1, (long) 0.428956419);
	
	public FractionalSelectivity(double selectivity){
		setSelectivity(selectivity);
	}
	public double getSelectivity() {
		return selectivity;
	}
	public void setSelectivity(double selectivity) {
		this.selectivity = selectivity;
	}
	
	@Override
	public boolean canSelect() {
		//double a = Math.random();
		double a = rand.sample();
		System.out.println("teste " + a);
		if(a < getSelectivity()) { // if the probability condition is satisfied
			return true;
		}
		return false;
	}
	
	@Override
	public double getMeanRate() {
		return getSelectivity(); // the average rate of tuple generation is the fixed probability value
	}
	
	@Override
	public double getMaxRate() {
		return getSelectivity(); // the maximum rate of tuple generation is the fixed probability value
	}
	
}
