package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    public Warehouse exportWarehouses() {
        return new Warehouse();
    }

    public Hop getWarehouse(String code) {
        return new Hop();
    }

    public void importWarehouses(WarehouseEntity warehouse) {

    }

}
