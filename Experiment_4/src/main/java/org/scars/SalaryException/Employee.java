package org.scars.SalaryException;

public class Employee {
    //错误处理类
    class SalaryException extends Exception {
        public SalaryException() {
        }

        public SalaryException(String message) {
            super(message);
        }
    }

    //员工类
    private double Salary;

    public void setSalary(double salary) throws SalaryException {
        if (salary < 1500) {
            throw new SalaryException("工资低于1500");
        }
        Salary = salary;
    }
}
