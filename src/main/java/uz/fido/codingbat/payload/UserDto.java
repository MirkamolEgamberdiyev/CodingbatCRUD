package uz.fido.codingbat.payload;

import lombok.Data;
@Data
public class UserDto {
    private String name;
    private Integer level;
    private Integer xp_amount;
    private Integer language_id;
    private Integer task_id;
    private Integer sertificates_id;
    private Integer achievment_id;

}
