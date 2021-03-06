package es.upm.miw.apaw_practice.adapters.rest.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import es.upm.miw.apaw_practice.domain.services.videoclub.CustomerAssociateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerAssociateResource.CUSTOMERASSOCIATES)
public class CustomerAssociateResource {

    static final String CUSTOMERASSOCIATES = "/videoclub/customers";
    static final String DOCUMENT_DOCUMENT = "/{document_id}";
    static final String NAME_NAME = "/name";

    private CustomerAssociateService customerAssociateService;

    public CustomerAssociateResource(CustomerAssociateService customerAssociateService) {
        this.customerAssociateService = customerAssociateService;
    }

    @PutMapping(DOCUMENT_DOCUMENT + NAME_NAME)
    public CustomerAssociate updateName(@PathVariable String document_id, @RequestBody NameDto nameDto) {
        return this.customerAssociateService.updateName(document_id, nameDto.getName());
    }
}
