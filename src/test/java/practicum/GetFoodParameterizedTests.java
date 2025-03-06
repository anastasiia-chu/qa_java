package practicum;

import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetFoodParameterizedTests {
    private Animal animal;
    private static final String herbivore = "Травоядное";
    private static final String predator = "Хищник";
    private static final List<String> herbivoreFood = List.of("Трава", "Различные растения");
    private static final List<String> predatorFood = List.of("Животные", "Птицы", "Рыба");

    final String animalKind;
    final List<String> foods;

    public GetFoodParameterizedTests(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {herbivore, herbivoreFood},
                {predator, predatorFood}
        };
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actual = animal.getFood(animalKind);
        assertEquals("Список еды для животных не совпадает с ожидаемым",
                foods, actual);
    }

}
