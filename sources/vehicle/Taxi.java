package vehicle;

public class Taxi extends Vehicule implements Runnable{
	
	private final Plateforme p;
	private final long dureeCourse;
	
	Taxi(int id, Plateforme p, long d){
		super(id);
		this.p = p;
		dureeCourse = Math.abs(d);
	}
	
	public void run() {
		while(! Thread.interrupted()){
			Course c = p.lireCourse();
			System.out.println("l'id du véhicule : " + this.getIdVehicule());
			System.out.println("kilometrage de course " + c.getKm() + " " + c.getNom() + " par le véhicule id : " + this.getIdVehicule());
			System.out.println("taxi numéro " + this.getIdVehicule() + " effectue la course " + c.getNom());
			
			try{Thread.sleep(dureeCourse);}catch(InterruptedException e){
				System.out.println("dureecourse catch" + e.getMessage());
			};
			this.addKmVehicule(c.getKm());
			this.updateTotalMileage(c.getKm());

			//notifyAll();
		}
		System.out.println("Affichage du kilometrage" + this.getKmVehicule());

		/*
		if(Thread.holdsLock(dureeCourse)){
			System.out.println("Affichage du kilometrage : " + this.getKmTotal());
		}

		 */
		
	}
	
}
