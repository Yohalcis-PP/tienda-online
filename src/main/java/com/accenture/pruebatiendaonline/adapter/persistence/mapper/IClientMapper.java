package com.accenture.pruebatiendaonline.adapter.persistence.mapper;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.Client;
import com.accenture.pruebatiendaonline.adapter.persistence.entity.Product;
import com.accenture.pruebatiendaonline.domain.ClientDTO;
import com.accenture.pruebatiendaonline.domain.ProductDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPurchaseMapper.class})
public interface IClientMapper {
    @Mappings({
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "fullname", target = "fullname"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "purchases", target = "purchasesDTO")
    })
    ClientDTO toClientDTO(Client client);
    List<ClientDTO> toClientsDTO(List<Client> clients);

    @InheritInverseConfiguration
    Client toClient(ClientDTO clientDTO);

}
