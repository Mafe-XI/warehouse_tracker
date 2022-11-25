package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.factory.Mappers;

public interface WarehouseNextHopsMapper {
    WarehouseNextHopsMapper INSTANCE = Mappers.getMapper(WarehouseNextHopsMapper.class);

    WarehouseNextHops entityToDTO(WarehouseNextHopsEntity warehouseNextHopsEntity);
    WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops warehouseNextHops);
}
