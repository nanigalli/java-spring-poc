package com.galli.poc.mapper;

import com.galli.poc.model.User;
import com.galli.poc.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(expression = "java(user.getLastName() + \", \" + user.getFirstName())", target = "name")
    UserDto userToUserDto(User user);


    @Mapping(target = "firstName", expression = "java(userDto.getName().split(\", \")[1])")
    @Mapping(target = "lastName", expression = "java(userDto.getName().split(\", \")[0])")
    User userDtoToUser(UserDto userDto);

}
