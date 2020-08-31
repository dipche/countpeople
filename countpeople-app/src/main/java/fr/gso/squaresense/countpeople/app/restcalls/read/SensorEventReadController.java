package fr.gso.squaresense.countpeople.app.restcalls.read;


import fr.gso.squaresense.countpeople.api.SensorEventApis;
import fr.gso.squaresense.countpeople.app.restcalls.create.SensorEventCreationJSONRequest;
import fr.gso.squaresense.countpeople.app.restcalls.create.SensorEventCreationJSONResponse;
import fr.gso.squaresense.countpeople.presentation.SensorEventCreationRequest;
import fr.gso.squaresense.countpeople.presentation.SensorEventDomainException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/peoplestock")
public class SensorEventReadController {

    private SensorEventApis sensorEventApis;

    public SensorEventReadController(SensorEventApis sensorEventApis) {
        this.sensorEventApis = sensorEventApis;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SensorEventCreationJSONResponse readPeopleStock() throws SensorEventDomainException {
        Long id = sensorEventApis.createSensorEvent(SensorEventCreationRequest.
                createSensorEventRequest(request.sensorName, request.peopleOut,
                        request.peopleOut, request.eventDateTime));
        return new SensorEventCreationJSONResponse(id);
    }
}
