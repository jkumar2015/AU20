import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import weiser.LKW;

/**
 * AU20
 * @author jyotikumar
 * @version 2016_03_24
 * git@github.com:jkumar2015/AU20.git
 */
public class TestPerson {

	@Test
	/**
	 * Überprüfung des ein- und austeigens
	 * ohne sonderfälle
	 */
	public void test(){
		LKW l3 = new LKW("W-23456",3500,1500,3);
		assertEquals(0,l3.getPersonenZahl()); // true
		assertEquals(3,l3.getHoechstZulaessigePersonenZahl()); //true
		l3.einsteigen();
		System.out.println(l3.getPersonenZahl()+" Person"); //1 Person
		l3.einsteigen();
		l3.einsteigen();
		System.out.println(l3.getPersonenZahl()+" Personen"); //3 Personen
		l3.aussteigen();
		System.out.println(l3.getPersonenZahl()+" Personen");// 2 Personen
		l3.einsteigen();
		System.out.println(l3.getPersonenZahl()+" Personen"); //3Personen
		l3.aussteigen();
		System.out.println(l3.getPersonenZahl()+" Personen"); //2 Personen

	}
	
	@Test
	/**
	 * Überprüfung des ein- und austeigens
	 * mit sonderfall : austeigen bei 0 Personen und gleich danach einsteigen
	 * 
	**/
	public void test1(){
		
		LKW l4 = new LKW("W-23456",3500,1500,3);
		assertEquals(0, l4.getPersonenZahl()); //true
		l4.aussteigen(); //austeigen bei 0 = -1 
		System.out.println(l4.getPersonenZahl()); //Personen Exception keine Person im LKW
		l4.einsteigen(); //geht nicht weil Fehler in der zeile 41
		System.out.println(l4.getPersonenZahl());
	}
	
	@Test
	/**
	 * Überprüfung des ein- und austeigens
	 * mit sonderfall : 2 x einsteigen bei max 1 Personen & gleich danach aussteigen
	 * 
	 */
	public void test2(){
		
		LKW l5 = new LKW("W-23456",3500,1500,1);
		assertEquals(1, l5.getHoechstZulaessigePersonenZahl());//true
		l5.einsteigen(); //1 Person : max = 1 Person
		l5.einsteigen(); //2 Personen : max = 1 Person
		System.out.println(l5.getPersonenZahl());//Zu viele Personen im LKW
		l5.aussteigen(); // geht nicht weil Fehler in der Zeile 57
		System.out.println(l5.getPersonenZahl());//Keine Anzeige
	}
}
