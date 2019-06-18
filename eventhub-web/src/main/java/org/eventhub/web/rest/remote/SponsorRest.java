package org.eventhub.web.rest.remote;

import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.Sponsor;
import org.eventhub.facade.event.SponsorshipFacade;
import org.eventhub.web.rest.remote.adapter.EventAdapter;
import org.eventhub.web.rest.remote.adapter.SponsorAdapter;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.eventhub.web.rest.remote.dto.SponsorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class SponsorRest {

    @Autowired
    SponsorAdapter sponsorAdapter;

    @Autowired
    SponsorshipFacade sponsorshipFacade;

    @PostMapping(path = "sponsor" , params = "event")
    public JResponse<SponsorDTO> addSponsor(@RequestBody SponsorDTO sponsorDTO, @RequestParam("event") UUID eventId){
        JResponse<SponsorDTO> sponsorResponse = new JResponse<>();
        Sponsor sponsor = sponsorAdapter.fromSponsorDTO(sponsorDTO);

        try{
            Event event = new Event(eventId);
            sponsor.setEvent(event);
            sponsorshipFacade.createSponsor(sponsor);
            sponsorResponse.setDtoContent(sponsorDTO);
            sponsorResponse.setStatus("Success");
        }catch (Exception e){
            sponsorResponse.setStatus("Fail");
            sponsorResponse.setDtoContent(new SponsorDTO());

        }

        return sponsorResponse;
    }

    @PutMapping(value = "/sponsor" , params ="sponsor" )
    public JResponse<SponsorDTO> editSponsor(@RequestBody SponsorDTO sponsorDTO,@RequestParam("sponsor") UUID sponsorId){
        JResponse<SponsorDTO> sponsorResponse = new JResponse<>();
        Sponsor sponsor = sponsorAdapter.fromSponsorDTO(sponsorDTO);

        try{

            Sponsor oldSponsor = sponsorshipFacade.getSponsor(sponsorId);
            Event event = oldSponsor.getEvent();
            sponsor.setEvent(event);
            sponsorshipFacade.updateSponsor(sponsor);
            sponsorResponse.setDtoContent(sponsorDTO);
            sponsorResponse.setStatus("Success");
        }catch (Exception e){
            sponsorResponse.setStatus("Fail");
            sponsorResponse.setDtoContent(new SponsorDTO());

        }

        return sponsorResponse;
    }

}
