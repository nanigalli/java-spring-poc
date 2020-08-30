package com.galli.poc.mapper;

import com.galli.poc.model.User;
import com.galli.poc.model.UserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    @Test
    public void testUserToUserDto() {
        User user = new User(33000000, "Pedro", "Picapiedra");
        user.setId(1);

        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);

        assertNotNull(userDto);
        assertEquals(user.getDni(), userDto.getDni());
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getLastName() + ", " + user.getFirstName(), userDto.getName());
        assertTrue(userDto.getEnabled());
    }

    @Test
    public void testUserDtoToUser() {
        String firstName = "Pedro";
        String lastName = "Picapiedra";
        UserDto userDto = new UserDto(1, 33000000, lastName + ", " + firstName, true);

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);

        assertNotNull(user);
        assertEquals(userDto.getDni(), user.getDni());
        assertEquals(userDto.getId(), user.getId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertTrue(user.getEnabled());
    }

}
