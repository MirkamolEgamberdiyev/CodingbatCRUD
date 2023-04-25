package uz.fido.codingbat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer level;
    private Integer xp_amount;
    @OneToOne
    private Language language;
    @OneToOne
    private Task task;
    @OneToOne
    private Sertificates sertificates;
    @OneToOne
    private Achievment achievment;





}
