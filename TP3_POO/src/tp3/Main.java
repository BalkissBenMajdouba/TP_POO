package tp3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personne p= new Personne("balkiss","bmamjdouba","Nabeul");
		//System.out.println(p);
		Personne p2= new Personne("Youssef","bmamjdouba","Sousse");
		Personne p3= new Personne("Sawsen","Nh","Tunis");
		Compte c1 = new Compte(p);
		Compte c2 = new Compte(p2);
		Compte c3=new Compte(p3);
		c1.crediter(3000);
		c2.crediter(200);
		c3.crediter(800);
		
		c1.retrait(500);
		//c1.crediter(-300);
		c3.virement(20, c1);
		Compte.virement(200, c1, c2);
		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		
		
		System.out.println("-----------------------");
		
		
		int nc=3;
		Compte[] TabC = new Compte[nc];
		TabC[0] = new Compte(p2, 3000, 800, 1000);
		TabC[1] = new Compte(p, 1300, 800, 1000);
		TabC[2]=new Compte(p3,450,800,1000);
		
		TabC[0].virement(500.0, TabC[1]);
		
		  for (Compte compte : TabC) {
			  if (compte != null)
	            System.out.println(compte.toString());
	            System.out.println();
	        }
		  
		  Compte SoldeMax = TabC[0]; 

		  for (Compte compte : TabC) {
			  if (compte != null)
			    if (compte.getSolde_cmpt() > SoldeMax.getSolde_cmpt()) {
			        SoldeMax = compte; 
			    }
			}
		  System.out.println("le propriétaire avec le solde le plus eleve:"+SoldeMax.getTitulaire().toString());
	
		
		
	}

}
