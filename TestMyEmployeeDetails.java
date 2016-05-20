import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class TestMyEmployeeDetails {

    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmpBusinessLogic empBusinessLogic2 = new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();
    EmployeeDetails employee2 = new EmployeeDetails();

    @DataProvider(name="emp")
    public Iterator<Object[]> createData(){

        //TODO: Read a file of names and use them for processing
        EmpBusinessLogic[] employ = new EmpBusinessLogic[]{empBusinessLogic,empBusinessLogic2};
        List list = Arrays.asList(employ);
        Iterator itr = list.iterator();

        return(itr);

    }

    @Test(dataProvider = "emp")
    public void testPhillipAppriasal(){

        employee.setName("Phillip");
        employee.setAge(52);
        employee.setMonthlySalary(28000);

        double appraisal = empBusinessLogic.calculateAppraisal(employee);
        Assert.assertEquals(1000, appraisal, 0.0, "1000");
    }

    @Test
    public void testCalculateAppriasal() {

        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);

        double appraisal = empBusinessLogic.calculateAppraisal(employee);
        Assert.assertEquals(500, appraisal, 0.0, "500");
    }

    // Test to check yearly salary
    @Test
    public void testCalculateYearlySalary() {

        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);

        double salary = empBusinessLogic.calculateYearlySalary(employee);
        Assert.assertEquals(96000, salary, 0.0, "8000");
    }

}
