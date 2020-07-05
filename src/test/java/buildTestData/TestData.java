package buildTestData;

import googleAPI.AddPlace;
import googleAPI.Location;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public AddPlace serializationAddPlace() {
        AddPlace addPlace = new AddPlace();

        addPlace.setAccuracy(50);
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setLanguage("French-IN");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setWebsite("http://google.com");
        addPlace.setName("Frontline hous");

        List<String> list = new ArrayList<>();
        list.add("shoe par");
        list.add("shop");
        addPlace.setTypes(list);
        addPlace.setLocation(new Location());

        return addPlace;


    }
}
