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
	private static double v_seed[] = {
            0.428956419,
            0.1954324947,
            0.1145661099,
            0.1835732737,
            0.794161987,
            0.1329531353,
            0.200496737,
            0.633816299,
            0.1410143363,
            0.1282538739
    };
	public static UniformDistr rand = new UniformDistr(0,1, (long) v_seed[0]);
	
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
