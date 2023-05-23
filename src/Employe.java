import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.*;


public class Employe {

	private String code;
	private double salaire;
	
	
	//constructeur
	//1
	public Employe(){}
	public Employe(String code){this.code=code;}
	public Employe(String code,double salaire){this.code=code;this.salaire=salaire;}
	public Employe(Employe e){this(e.code,e.salaire);}
	
	
	//afficher
	@Override
	public String toString(){
		
		return this.code+" \tET \t"+ this.salaire;
		
	}
	
	//Equals
	@Override
	public boolean equals(Object o){

		if (o == null) {
			return false;
		}

		if (o.getClass() != getClass()) {
			return false;
		}
						Employe ee=(Employe)o;
					if(this.code.equals(ee.code))
						return true;
					return false;
		}
	
	//Comparer
	
	public int compare(Employe e){
		if(this.code.compareTo(e.code)<0)
				return-1;
		else return 1;
	}
	
	public  double getSalaire(){
		return this.salaire;
		
	}
	//COmparator
	public static Comparator<Employe> sp() {
		return Comparator.comparing(Employe::getSalaire);
	}
	//Comparator<Employe> sp=Comparator.comparing(Employe::getSalaire);
	//Predicate
	
	public static Predicate<Employe> sup(double m){
		
		return e->e.salaire>m;
		
		}
	//function
	public static Function<Employe,Employe> misaj(double x){
		return e->{
			e.salaire *= x;
			return e;
	};}
	
}
