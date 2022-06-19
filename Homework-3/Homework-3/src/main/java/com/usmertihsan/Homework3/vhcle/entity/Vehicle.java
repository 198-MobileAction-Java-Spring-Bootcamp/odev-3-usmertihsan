package com.usmertihsan.Homework3.vhcle.entity;

import com.usmertihsan.Homework3.gen.entity.BaseEntity;
import com.usmertihsan.Homework3.usr.entity.UsrUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@EntityScan
@Entity
@Getter
@Setter
public class Vehicle extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Vehicle", sequenceName = "VEHICLE_ID_SEQ")
    @GeneratedValue(generator = "Vehicle")
    private Long id;

    @Column(name = "VEHICLE_BRAND")
    private String vehicleBrand;

    @Column(name = "VEHICLE_MODEL")
    private String vehicleModel;

    @Column(name = "VEHICLE_PRODUCE_YEAR")
    private String vehicleProductionYear;

    @Column(name = "VEHICLE_PLATE_NO")
    private String vehiclePlateNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USR_USER")
    private UsrUser user;




}
