package practicum;

import com.example.Feline;
import com.example.Lion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.mockito.Mockito;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTests {
    private Lion lion;
    private Feline feline;
    private final String gender;
    private final boolean hasMane;


    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    public LionParameterizedTests(String gender, boolean hasMane) {
        this.gender = gender;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        lion = new Lion(gender, feline);
        boolean actualResult = lion.doesHaveMane();
        assertEquals(hasMane,
                actualResult);
    }

}

