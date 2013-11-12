package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployeeDetails {
	EmployeeDetails empDetails = new EmployeeDetails();
	EMPBusinessLogic empBusiLogic = new EMPBusinessLogic();
  @Test
  public void testCalcualateAppraisal() {
	  empDetails.setName("Poovarasan");
	  empDetails.setAge(31);
	  empDetails.setMonthlySalary(31000);
	  double appraisal = empBusiLogic.calculateAppraisal(empDetails);
	  Assert.assertEquals(1000.0, appraisal);
  }
  @Test
  public void testCalculateYearlySalary(){
	  empDetails.setName("Poovarasan");
	  empDetails.setAge(31);
	  empDetails.setMonthlySalary(31000);
	  double salary = empBusiLogic.calculateYearlySalary(empDetails);
	  Assert.assertEquals(420000, salary);
  }
}
