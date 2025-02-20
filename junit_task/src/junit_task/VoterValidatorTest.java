package junit_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VoterValidatorTest {

    VoterValidator voterValidator = new VoterValidator(); // Creating an instance of the class

    // Test case for exception when age is negative
    @Test
    void testValidateVoterAgeThrowsException() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            voterValidator.validateVoterAge(-5); // Negative age should throw an exception
        });

        // Verify the exception message
        Assertions.assertEquals("Invalid age", exception.getMessage());
    }

    // Parameterized test for valid voter age (should return true)
    @ParameterizedTest
    @ValueSource(ints = {19, 20, 45, 78}) // Testing multiple valid ages
    void validateVoterAgeTest_ValidAges(int age) throws Exception {
        Assertions.assertTrue(voterValidator.validateVoterAge(age)); // Should return true for valid ages
    }

    // Parameterized test for invalid voter age (should return false)
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 10, 17}) // Testing multiple invalid ages
    void validateVoterAgeTest_InvalidAges(int age) throws Exception {
        Assertions.assertFalse(voterValidator.validateVoterAge(age)); // Should return false for ages < 18
    }
}

