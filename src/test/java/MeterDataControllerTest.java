import org.example.controllers.MeterDataController;
import org.example.models.Meter;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MeterDataControllerTest {

    @Test
    public void testGetActualMeterData_WithData() {
        User user = new User("john", "password");
        MeterDataController meterDataController = new MeterDataController();

        ArrayList<Meter> meterData = user.getUserMeterData();
        meterData.add(new Meter(user));

        Meter actualMeter = meterDataController.getActualMeterData(user);

        assertThat(actualMeter).isNotNull();
        assertThat(actualMeter.getUser()).isEqualTo(user);
    }

    @Test
    public void testGetActualMeterData_EmptyData() {
        User user = new User("john", "password");
        MeterDataController meterDataController = new MeterDataController();

        Meter actualMeter = meterDataController.getActualMeterData(user);

        assertThat(actualMeter).isNull();
    }

    @Test
    public void testGetMeterDataByUser() {
        User user = new User("john", "password");
        MeterDataController meterDataController = new MeterDataController();

        ArrayList<Meter> meterData = user.getUserMeterData();
        meterData.add(new Meter(user));
        meterData.add(new Meter(user));

        List<Meter> actualMeterData = meterDataController.getMeterDataByUser(user);

        assertThat(actualMeterData).hasSize(2);
        assertThat(actualMeterData.get(0).getUser()).isEqualTo(user);
        assertThat(actualMeterData.get(1).getUser()).isEqualTo(user);
    }

    @Test
    public void testGetUserMeterDataByMonth_WithMatchingMonth() {
        User user = new User("john", "password");
        MeterDataController meterDataController = new MeterDataController();

        ArrayList<Meter> meterData = user.getUserMeterData();
        Meter matchingMeter = new Meter(user);
        matchingMeter.setMonth("January");
        meterData.add(matchingMeter);

        Meter userMeterDataByMonth = meterDataController.getUserMeterDataByMonth(user, "January");

        assertThat(userMeterDataByMonth).isNotNull();
        assertThat(userMeterDataByMonth.getUser()).isEqualTo(user);
        assertThat(userMeterDataByMonth.getMonth()).isEqualTo("January");
    }

}
