package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.treeConservation.InspectorName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class InspectorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        InspectorName inspectorNameTest = new InspectorName();
        inspectorNameTest.setDni("fakeDni");
        inspectorNameTest.setFirstName("fakeFirstName");
        inspectorNameTest.setLastName("fakeLastName");
        this.webTestClient
                .patch()
                .uri(InspectorResource.INSPECTORS)
                .body(BodyInserters.fromValue(inspectorNameTest))
                .exchange()
                .expectStatus().isNotFound();
    }
}
