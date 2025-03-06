package practicum;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class FelineTests {


    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();

        assertEquals("Ожидаемое семейство не соответствует фактическому",
                expectedResult, actualResult);
    }

    @Test
    public void testGetKittens() {
        int actualResult = feline.getKittens();
        Mockito.verify(feline).getKittens(1);

        assertEquals("Количество котят не соответствует ожидаемому",
                1, actualResult);
    }

    @Test
    public void testGetKittensMock() {
        int actual = feline.getKittens(3);
        Mockito.verify(feline).getKittens(Mockito.anyInt());

        assertEquals("Количество котят не соответствует ожидаемому",
                3, actual);
    }
}

