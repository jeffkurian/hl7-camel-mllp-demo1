package com.example.demo;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.component.hl7.HL7DataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import static org.apache.camel.component.hl7.HL7.ack;
import static org.apache.camel.component.hl7.HL7.messageConforms;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MyMllpRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        DataFormat hl7 = new HL7DataFormat();

        onException(HL7Exception.class)
                .log("Handling Exception ")
                .transform(ack(AcknowledgmentCode.AE,"Error tranforming he message", ErrorCode.UNSUPPORTED_MESSAGE_TYPE))
                .handled(true)
                .end()  ;

        from("mllp://8088")
                .log("Recieved message ")
                .unmarshal(hl7)
                .log("done unmarshelling")
                .validate(messageConforms())
                .log("done validating")
                .bean(MyHL7BusinessLogicService.class,"handleA01")
                .log("done calling business")
                .transform(ack(AcknowledgmentCode.AA))
                .end();


    }

}