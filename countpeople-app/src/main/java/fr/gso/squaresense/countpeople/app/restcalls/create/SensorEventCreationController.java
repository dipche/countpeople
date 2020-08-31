package fr.gso.squaresense.countpeople.app.restcalls.create;


import fr.gso.squaresense.countpeople.api.SensorEventApis;
import fr.gso.squaresense.countpeople.presentation.SensorEventCreationRequest;
import fr.gso.squaresense.countpeople.presentation.SensorEventDomainException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/webhook")
public class SensorEventCreationController {

    private SensorEventApis sensorEventApis;

    public SensorEventCreationController(SensorEventApis sensorEventApis) {
        this.sensorEventApis = sensorEventApis;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public SensorEventCreationJSONResponse createSensorEvent(@RequestBody SensorEventCreationJSONRequest request) throws SensorEventDomainException {
        Long id = sensorEventApis.createSensorEvent(SensorEventCreationRequest.
                createSensorEventRequest(request.sensorName, request.peopleIn,
                        request.peopleOut, request.eventDateTime));
        return new SensorEventCreationJSONResponse(id);
    }
}
