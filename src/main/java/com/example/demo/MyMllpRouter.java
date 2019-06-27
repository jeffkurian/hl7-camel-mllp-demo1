package com.example.demo;

import ca.uhn.hl7v2.AcknowledgmentCode;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.component.hl7.HL7DataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import static org.apache.camel.component.hl7.HL7.ack;

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

        from("mllp://8088")
                .unmarshal(hl7)
                .bean(MyHL7BusinessLogicService.class,"handleA01")
                .transform(ack(AcknowledgmentCode.AA))
                .end();
    }

}