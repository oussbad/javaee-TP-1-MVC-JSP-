package metier;

public class CreditMetierImpl implements ICreditMetier {

	@Override
	public double calculerMensualiteCredite(double capitale, double taux, int duree) {
		// TODO Auto-generated method stub
		 double t=taux/100;
		 double t1=capitale *t/12;
		 double t2=1-Math.pow(1+t/12,- duree);
		 
		return t1/t2 ;
	}
	

}
