package delta.agriculture.service;


import delta.agriculture.domain.Maintenance;
import delta.agriculture.reposy.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public Optional<Maintenance> getMaintenance(final Long id) {
        return maintenanceRepository.findById(id);
    }

    public Iterable<Maintenance> getMaintenance() {
        return maintenanceRepository.findAll();
    }

    public void deleteMaintenance(final Long id) {
        maintenanceRepository.deleteById(id);
    }

    public Maintenance saveMaintenance(Maintenance maintenance) {
        Maintenance savedMaintenance = maintenanceRepository.save(maintenance);
        return savedMaintenance;
    }
}
