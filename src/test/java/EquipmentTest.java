
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


class EquipmentTest {
    private Equipment equipmentTest;

    @BeforeEach
    public void init() {
        equipmentTest = new Equipment() {
            @Override
            public void setType(String type) {
            }
        };
    }


    @Test
     public void returnTrueIfNeedsCleaningTest() {
        //given
        equipmentTest.setCleaningInterval(30);
        String dateStr = "28/09/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        equipmentTest.setDateLastClean(localDate);

        //when
        boolean result =  equipmentTest.returnTrueIfNeedsCleaning();

        //then
        assertTrue(result);
    }

    @Test
    public void returnTrueIfNeedsRepairsTest() {
        //given
        equipmentTest.setMaxUsage(30);
        String dateStr = "28/09/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(dateStr, formatter);

        equipmentTest.setDateLastCheck(localDate);

        //when
        boolean result =  equipmentTest.returnTrueIfNeedsRepairs();

        //then
        assertTrue(result);
    }
}