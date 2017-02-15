package tbdp.common.result;

import tbdp.common.Result;
import tbdp.model.Employee;

/**
 * Created by xbkaishui on 17/2/14.
 */
public class EmployResult extends Result {

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
