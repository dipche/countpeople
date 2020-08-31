package fr.gso.squaresense.countpeople.app.restcalls.read;


import fr.gso.squaresense.countpeople.api.SensorEventApis;
import fr.gso.squaresense.countpeople.domain.PeopleStock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SensorEventReadController {

    private SensorEventApis sensorEventApis;

    public SensorEventReadController(SensorEventApis sensorEventApis) {
        this.sensorEventApis = sensorEventApis;
    }

    @RequestMapping(value = "/peoplestock", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SensorEventReadJSONResponse readPeopleStock() {
        PeopleStock peopleStock = sensorEventApis.readPeopleStock();
        return new SensorEventReadJSONResponse(peopleStock.getPeopleStock());
    }

    @RequestMapping(value = "/peoplestock", params = "atInstant",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public SensorEventReadJSONResponse readPeopleStockAtInstant(@RequestParam(value = "atInstant") String atInstantDatetime) {
        PeopleStock peopleStock = sensorEventApis.readPeopleStockAtInstant(atInstantDatetime);
        return new SensorEventReadJSONResponse(peopleStock.getPeopleStock());
    }
}
