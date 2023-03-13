package pl.mlis;
import org.junit.jupiter.api.Test;
public class FirstTest {
    @Test
    void testIt() {
        assert true == true;
    }

    @Test
    void testIt2() {
        String myName = "Małgorzata";
        String output = String.format("Hello %s", myName);

        assert output.equals("Hello Małgorzata");
    }

    @Test
    void baseSchema() {
        // Arrange   // Given   // Input
        // Act       // When    // Interaction
        // Assert    // Then    // Output


    }
}
