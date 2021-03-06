package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.PhysicalStoreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.PhysicalStoreEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.PhysicalStorePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("physicalStorePersistence")
public class PhysicalStorePersistenceMongodb implements PhysicalStorePersistence {

    private PhysicalStoreRepository physicalStoreRepository;

    @Autowired
    public PhysicalStorePersistenceMongodb(PhysicalStoreRepository physicalStoreRepository) {
        this.physicalStoreRepository = physicalStoreRepository;
    }

    private void assertAddressNotExist(String address) {
        this.physicalStoreRepository.findByAddress(address)
                .ifPresent(dbAddress -> {
                    throw new ConflictException("This address" + address + "exist yet");
                });
    }

    @Override
    public PhysicalStore create(PhysicalStore physicalStore) {
        this.assertAddressNotExist(physicalStore.getAddress());
        return this.physicalStoreRepository.save(new PhysicalStoreEntity(physicalStore))
                .toPhysicalStore();
    }

    @Override
    public void deletePhysicalStore(String address) {
        PhysicalStoreEntity physicalStoreEntity = this.physicalStoreRepository.findByAddress(address)
                .orElseThrow(() -> new NotFoundException("Not find address: " + address));
        this.physicalStoreRepository.delete(physicalStoreEntity);
    }
}
