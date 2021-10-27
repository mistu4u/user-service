package dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ToString
@Data
@Builder
public class UserDTO {
    @NotBlank
    @NotNull
    @NotEmpty
    public String name;
    @Email
    public String email;
    public String country;
}
