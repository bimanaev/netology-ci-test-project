package ru.bimanaev.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashbackHackServiceTest {
    private CashbackHackService service = new CashbackHackService();

    @Test
    public void amountLessThanBoundaryTest() {
        assertEquals(2, service.remain(999));
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
