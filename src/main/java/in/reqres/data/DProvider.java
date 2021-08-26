package in.reqres.data;

import org.testng.annotations.DataProvider;

public class DProvider {
    @DataProvider(name = "data")
    public Object[][] nameAndJobData() {
        return new Object[][]{
                {"Ivan", "Pyatyorochka"},
                {"Sergey", "Gazprom"},
                {"Oleg", "School"}
        };
    }
}
