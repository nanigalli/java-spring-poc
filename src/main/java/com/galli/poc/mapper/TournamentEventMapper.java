package com.galli.poc.mapper;

import com.galli.poc.model.TournamentEvent;
import com.galli.poc.model.TournamentEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TournamentEventMapper {

    TournamentEventMapper INSTANCE = Mappers.getMapper( TournamentEventMapper.class );

    @Mapping(expression = "java(event.getLocation().getAddress() + \", \" + event.getLocation().getLocality() + \", \" + event.getLocation().getProvince())", target = "address")
    @Mapping(source = "date", dateFormat = "dd MMM yyyy hh:mm", target = "date")
    @Mapping(target = "latitude", source = "location.latitude")
    @Mapping(target = "longitude", source = "location.longitude")
    TournamentEventDto tournamentEventToTournamentEventDto(TournamentEvent event);

    @Mapping(target = "location.address", expression = "java(tournamentEventDto.getAddress().split(\", \")[0])")
    @Mapping(target = "location.locality", expression = "java(tournamentEventDto.getAddress().split(\", \")[1])")
    @Mapping(target = "location.province", expression = "java(tournamentEventDto.getAddress().split(\", \")[2])")
    @Mapping(target = "location.latitude", source = "latitude")
    @Mapping(target = "location.longitude", source = "longitude")
    @Mapping(source = "date", dateFormat = "dd MMM yyyy hh:mm", target = "date")
    TournamentEvent tournamentEventDtoTotournamentEvent(TournamentEventDto tournamentEventDto);

}
