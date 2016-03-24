
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
public class TestLadung {

	@Test
	/**
	 * Überprüfung des auf- und entladen
	 * ohne sonderfälle
	 */
	public void test(){

	LKW l1 = new LKW("W-23456",3500,1500,3);
	assertEquals(0,l1.getNutzLast()); //ergebniss true
	assertEquals(1500, l1.getEigenGewicht()); //ergebniss true
	assertEquals(3500, l1.getHoechstZulaessigesGesamtGewicht()); //ergebniss true
	System.out.println(l1.getNutzLast()+" kg"); //0
	System.out.println(l1.getEigenGewicht()+" kg"); // 1500
	System.out.println(l1.getHoechstZulaessigesGesamtGewicht()+" kg"); //3500
	l1.aufladen(500);
	System.out.println(l1.getNutzLast()+" kg");
	assertEquals(500,l1.getNutzLast()); // true
	l1.entladen(200);
	assertEquals(300, l1.getNutzLast()); //true
	System.out.println(l1.getNutzLast()+" kg"); //300

	}
	
	@Test
	/**
	 * Überprüfung des auf- und entladen
	 * mit sonderfall: überladen
	 */
	public void test1(){
		
		LKW l2 = new LKW("W-23456",3500,3500,3);
		l2.aufladen(4500); // GewichtException: Ladegut zu schwer
		l2.entladen(4500); // Fehler nicht entladbar
	}
	
	@Test
	/**
	 * Überprüfung des auf- und entladen
	 * mit sonderfall: negativ laden
	 */
	public void test2(){
		
		LKW l3 = new LKW("W-23456",3500,3500,3);
		l3.aufladen(-500); // GewichtException //-500 kg im LKG
		l3.entladen(500); // Fehler nicht entladbar
	}
	
}
