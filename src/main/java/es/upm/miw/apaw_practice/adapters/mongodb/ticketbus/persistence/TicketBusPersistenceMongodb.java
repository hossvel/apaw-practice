package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.TicketBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBusCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.TicketBusPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("ticketBusPersistenceMongodb")
public class TicketBusPersistenceMongodb implements TicketBusPersistence {

    private TicketBusRepository ticketBusRepository;

    @Autowired
    public TicketBusPersistenceMongodb(TicketBusRepository ticketBusRepository) {
        this.ticketBusRepository = ticketBusRepository;
    }

    @Override
    public Stream<TicketBus> findAll() {
        return ticketBusRepository.findAll().stream().map(TicketBusEntity::toTicketBus);
    }

    @Override
    public TicketBus update(String reference, PassengerBusCreation passenger) {
        TicketBusEntity ticketBusEntity = ticketBusRepository.findByReference(reference)
                .orElseThrow(() -> new NotFoundException("TicketBus with reference: " + reference + " not found"));
        ticketBusEntity.changePassenger(passenger);
        return ticketBusRepository.save(ticketBusEntity).toTicketBus();
    }

    @Override
    public void delete(String reference) {
        TicketBusEntity ticketBusEntity = ticketBusRepository.findByReference(reference)
                .orElseThrow(() -> new NotFoundException("TicketBus with reference: " + reference + " not found"));
        ticketBusRepository.deleteByReference(ticketBusEntity.getReference());
    }

    @Override
    public TicketBus save(TicketBusCreation ticketBusCreation) {
        TicketBusEntity ticketBusEntity = new TicketBusEntity(ticketBusCreation);
        return ticketBusRepository.save(ticketBusEntity).toTicketBus();
    }

}
