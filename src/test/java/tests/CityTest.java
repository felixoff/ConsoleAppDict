package tests;
import org.felix.dictionary.model.City;
import org.junit.Test;

public class CityTest {
    @Test
    public void testToString() {
        String[] s = {"1","Moskow","Moskow","Central","38282","1928"};
        City city1 = new City(s);
        System.out.println(city1.toString());
        System.out.println("City(name='"+city1.getName()+"', region='"+city1.getRegion()+"',district='"+
                city1.getDistrict()+"',population='"+city1.getPopulation()+"',foundation='"+city1.getFoundation()+"')");
    }
}