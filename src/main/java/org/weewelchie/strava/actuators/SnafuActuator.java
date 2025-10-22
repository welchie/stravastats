package org.weewelchie.strava.actuators;

import jakarta.websocket.ClientEndpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="snafu")
public class SnafuActuator {

    @ReadOperation
    public String myCustomerEndpoint() {
        return "{\"status\":\"Situation normal, how are you? Blah\"}";
    }
}
