import java.util.function.Predicate;

public class test  {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Registre r=new Registre();
		//Registre r2=new Registre();
		Employe e=new Employe("c",101);
		Employe e1=new Employe("b");
		Employe e2=new Employe("a");
		//r.add(e);
		
		r.cons("test.txt");
		//r.tri();
		r.triSalaire();
		//r.set(0,e);
		//r.maper(Employe.misaj(2));
		//r=r.filltrer(Employe.sup(200));
		r=r.emaug(10,2);
		
	   System.out.print(r);
		//r.filltrer(Employe.sup(1000.54));
		
		//System.out.print(r.toString());

	}

	
}
