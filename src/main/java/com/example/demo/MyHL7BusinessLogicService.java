package com.example.demo;

import ca.uhn.hl7v2.model.v24.datatype.PN;
import ca.uhn.hl7v2.model.v24.datatype.XPN;
import ca.uhn.hl7v2.model.v24.message.QRY_A19;
import org.springframework.stereotype.Component;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v24.message.ADR_A19;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.MSA;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v24.segment.QRD;

@Component()
public class MyHL7BusinessLogicService {

    public Message handleA19(Message msg) throws Exception {
        // here you can have your business logic for A19 messages
        // assertTrue(msg instanceof QRY_A19);
        // just return the same dummy response

        if (msg instanceof QRY_A19){
            // do processing
        }
        return msg;
    }

    public Message handleA01(Message msg) throws Exception {
        // here you can have your business logic for A01 messages
        // assertTrue(msg instanceof ADT_A01);
        // just return the same dummy response
        if (msg instanceof ADT_A01 ){
            ADT_A01 adtMsg = (ADT_A01)msg;
            MSH msh = adtMsg.getMSH();
            String msgType = msh.getMessageType().getMessageType().getValue();
            String msgTrigger = msh.getMessageType().getTriggerEvent().getValue();
            // Prints "ADT A01"
            System.out.println(msgType + " " + msgTrigger);
            /* Now let's retrieve the patient's name from the parsed message.
              *
              * PN is an HL7 data type consisting of several components, such as
              * family name, given name, etc.
          */
            XPN patientName = adtMsg.getPID().getPatientName(0);

            String firstName = patientName.getGivenName().getValue();
            String lastName = patientName.getFamilyName().getSurname().getValue();
            System.out.println("Name : " + firstName + ' ' + lastName);

        }

        return msg;

    }

}
