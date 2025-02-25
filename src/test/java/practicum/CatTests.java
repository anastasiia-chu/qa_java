package practicum;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("Кошка не мяукает", expectedSound, actualSound);
    }

    @Test
    public void getFoodTest() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

}
