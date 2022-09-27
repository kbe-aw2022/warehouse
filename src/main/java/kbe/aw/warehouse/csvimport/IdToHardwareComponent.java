package kbe.aw.warehouse.csvimport;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import kbe.aw.warehouse.model.HardwareComponent;

public class IdToHardwareComponent extends AbstractCsvConverter
{
   @Override
   public Object convertToRead(final String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException
   {
      HardwareComponent hardwareComponent = new HardwareComponent();
      hardwareComponent.setId(Integer.valueOf(value));

      return hardwareComponent;
   }

}
