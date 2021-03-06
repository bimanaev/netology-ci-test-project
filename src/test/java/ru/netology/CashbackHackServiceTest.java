package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CashbackHackServiceTest {
    private CashbackHackService service = new CashbackHackService();

    @ParameterizedTest
    @ValueSource(ints = { 900, 999 })
    public void amountLessThanBoundaryTest(int amount) {
        assertEquals(1000 - amount, service.remain(amount));
    }

    @Test
    public void amountGreaterThanBoundaryTest() {
        assertEquals(999, service.remain(1001));
    }

    @Test
    public void amountEqualToBoundaryTest() {
        assertEquals(0, service.remain(1000));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 0 })
    public void amountLessThanOrEqualToZeroTest(int amount) {
        assertThrows(IllegalArgumentException.class, () -> service.remain(amount), "amount must be greater than zero");
    }
}
