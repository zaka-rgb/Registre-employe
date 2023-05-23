import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.io.*;
public class Registre extends LinkedList<Employe>{
	
	//constructeur
	public Registre(){}
	public Registre(Registre r){int n=r.size();for(int i=0;i<n;i++)this.set(i,r.get(i));}
	//Or/ public Registre(Registre r){for(Employe e:r)this.add(e);}

	
	//ajouter employe
	@Override
	public boolean add(Employe e){
				if(this.contains(e)==true)
					return false;
				if(e==null)
					return false;
				super.add(e);
				return true;
	}
	
	//Supprimer un employe
	public boolean remove(String code){
					Employe ee=new Employe(code);
					for(Employe e:this)
						if(e.equals(ee))
							{super.remove(e);
							 return true;}
					return false;
					
				}
	
	public Registre cons(String fs) throws Exception {
		
							File f=new File(fs);
							Scanner s=new Scanner(f);
							
							
						while(s.hasNextLine())
							this.add(new Employe(s.next(),s.nextDouble()));
							
		return this;					
		
	}
	//cloner 
	@Override
	public Registre clone(){
		Registre r=(Registre)super.clone();
		int n=this.size();
		for(int i=0;i<n;i++)
			r.set(i,this.get(i));
		
		return r;
		
	}
	
	//trier
	public Registre tri(){
		
		
		int n=this.size();
		Employe min;
		
		for(int i=0;i<n;i++)
				{
					int indice=i;
							for(int j=i+1;j<n;j++)
									{
										if(get(indice).compare(get(j))>0)
									indice=j;
									}
			Employe aux=get(i);
			
			set(i,get(indice));
			
			set(indice,aux);
				}
		
		return this;
	}
	
	
	
	//afficher
	@Override
	public String toString(){
			String s="";
			for(Employe e:this)
				s+=e.toString()+"\n";
	
			return s;
	
	
	}
	//filtrer
	public Registre filltrer(Predicate<Employe> p) {
		Registre r=new Registre();
		for(Employe e:this)
		if(p.test(e))
			r.add(e);
		return r;
		
		}
	
	//maper
	public Registre maper(Function<Employe,Employe> f)
	{
		for(Employe e:this)
			f.apply(e);
		return this;
	}
	
	//triSalaire
	public Registre triSalaire() {
		sort(Employe.sp());
		return this;
	}
	//salairesup
	public Registre emsup(double m) {
		return filltrer(Employe.sup(m));
	}
	//augmanter
	public Registre emaug(double aug,double m) {
		Registre r=new Registre();
		r=this.filltrer(Employe.sup(m).negate());
		r.maper(Employe.misaj(aug));
		return r;
		
	}
	
}
