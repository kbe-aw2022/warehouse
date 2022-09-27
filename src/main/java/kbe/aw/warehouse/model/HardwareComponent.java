package kbe.aw.warehouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindByName;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HardwareComponent
{
   @Id
   @CsvBindByName
   private Integer id;

   @CsvBindByName
   private String name;

   @CsvBindByName
   private String vendor;

   @NotNull
   @CsvBindByName
   private double price;

   @CsvBindByName
   private String description;

   @CsvBindByName
   private String location;

   @CsvBindByName
   private String manufacture;

   @CsvBindByName
   private String productGroup;

   @CsvBindByName
   private int weightInGramm;

   @CsvBindByName
   private Status status;

   @CsvBindByName
   private String eanNumber;
}
