package tp3;

public class Compte {
	private Personne titulaire;
	private int num_cmpt;
	static private int dcmpt=0;//pas forcément initialisation
	private double solde_cmpt;
	private double decouvertMax= 800;
	private double debitMax=1000;
	private boolean decouvertCompt;
	
	public Compte( Personne p) {
		this.titulaire=p;
		//ken te9leb tweli tebda m zero
		Compte.dcmpt++;
		this.num_cmpt = dcmpt;
		this.solde_cmpt = 0;
		
	}
	public Compte(Personne p2,double solde_cmpt,double debitMax,double decouvertMax) {
		this.solde_cmpt =solde_cmpt ;
		this.titulaire=p2;
		this.debitMax=debitMax;
		this.decouvertMax=decouvertMax;
		this.dcmpt++;
		this.num_cmpt = dcmpt;
	}

	public Personne getTitulaire() {
		return titulaire;
	}
	public int getNum_cmpt() {
		return num_cmpt;
	}
	public double getSolde_cmpt() {
		return solde_cmpt;
	}
	public double getDecouvertMax() {
		return decouvertMax;
	}
	public double getDebitMax() {
		return debitMax;
	}
	public boolean isDecouvertCompt() {
		return decouvertCompt;
	}
	public void setNum_cmpt(int num_cmpt) {
		this.num_cmpt = num_cmpt;
	}
	public void setSolde_cmpt(double solde_cmpt) {
		
			this.solde_cmpt = solde_cmpt;
			
		
		
	}
	public void setDecouvertMax(double decouvertMax) {
		this.decouvertMax = decouvertMax;
	}
	public void setDebitMax(double debitMax) {
		this.debitMax = debitMax;
	}
	public void setDecouvertCompt(boolean decouvertCompt) {
		this.decouvertCompt = estaDecouvert();
	}
	
	@Override
	public String toString() {
		return "Compte du titulaire : " + titulaire + ", son numero du compte" + num_cmpt +  ", son solde est "
				+ solde_cmpt + ", le decouvertMax=" + decouvertMax + ", le debitMax=" + debitMax + ", situation du compte decouvertCompt="
				+ decouvertCompt + "]";
	}

	
	public void crediter(double mont_credit) {
		if(mont_credit>0) {
			solde_cmpt+=mont_credit;
		}
		
		
	}
	private void debiter(double mont_debit) {
		double d=Math.abs(solde_cmpt-mont_debit);
		 if((mont_debit>0)&&(d>=decouvertMax)) {
			 solde_cmpt-=mont_debit;
		 }
		
			 
		 
		
	 }
	/*public boolean retrait (double mont_retrait) {//tetbadel traja boolean ken sar vrai ken le false (methode virement1)
		 
		
		 if ((mont_retrait<=debitMax)&&(mont_retrait>0)&&(mont_retrait<=(solde_cmpt+decouvertMax))){
			 solde_cmpt-=mont_retrait;
			 debiter(mont_retrait);
			 this.decouvertCompt= this.estaDecouvert();}*/
	public boolean retrait(double mont_retrait) {
	    if (mont_retrait > 0 && mont_retrait <= debitMax && mont_retrait <= (solde_cmpt + decouvertMax)) {
	        debiter(mont_retrait);
	        this.decouvertCompt = this.estaDecouvert();
	        return true;
	    } else {
	        return false;
	    }
	}

		
			
		 
		
	 
	public boolean estaDecouvert()
	{
		return(solde_cmpt<= 0);
		
	}
	public double MontantDecouvert() {
		if(estaDecouvert()) 
			return Math.abs(solde_cmpt);
		else 
			return 0;
		
	}
	public void virement(double mtant, Compte compte1) {
		if (this.retrait(mtant)) {
			compte1.crediter(mtant);
		}
			
	}
	public static void virement(double mtant, Compte compte1, Compte compteE)
	{
		if (compte1.retrait(mtant)) {
			compteE.crediter(mtant);
		}
	}
		
	 
	
	//virment2 surcharge static
	
	
	
}
