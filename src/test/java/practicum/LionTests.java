package practicum;

import com.example.Feline;
import com.example.Lion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    private static final String male = "Самец";

    private Lion lion;


    @Mock
    private Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion(male, feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }


    @Test
    public void GetFoodTest() throws Exception {
        lion = new Lion(male, feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void invalidGenderTest() {
        try {
            Lion lion = new Lion("Оно", feline);
            lion.doesHaveMane();
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

}
