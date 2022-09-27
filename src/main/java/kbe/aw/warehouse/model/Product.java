package kbe.aw.warehouse.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import kbe.aw.warehouse.csvimport.IdToHardwareComponent;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @CsvBindByName
   private Integer id;

   @CsvBindByName
   private String name;

   @CsvBindByName
   private String description;

   @CsvBindAndSplitByName(elementType= HardwareComponent.class, splitOn = "\\|", converter = IdToHardwareComponent.class)
   @OneToMany(fetch = FetchType.EAGER)
   private List<HardwareComponent> hardwareComponents;
}
