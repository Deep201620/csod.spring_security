package demo.csod.securitydemo.csod.spring_security.utils;
import demo.csod.securitydemo.csod.spring_security.dto.RegisterDto;
import demo.csod.securitydemo.csod.spring_security.models.Users;
import org.modelmapper.ModelMapper;

public class dtoMapper {

    private final static ModelMapper modelMapper = new ModelMapper();

    public RegisterDto entity_to_Dto(Users users) {
        return modelMapper.map(users, RegisterDto.class);
    }

    public Users dto_to_Entity(RegisterDto registerDto) {
        return modelMapper.map(registerDto, Users.class);
    }
}
