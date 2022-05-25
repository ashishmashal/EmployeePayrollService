package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {


    public enum IOService {
        CONSOLE_IO, FILE_IO
    }
static Scanner scanner= new Scanner(System.in);
    public List<EmployeePayrollData> employeePayrollList;
    public EmployeePayrollService(){}

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollData) {
        this.employeePayrollList = employeePayrollData;
    }

    public long readEmployeePayrollData(IOService ioService){
        if (ioService.equals(IOService.FILE_IO)) {
            EmployeePayrollFileI0Service.readData();
        }
        else if (ioService.equals(IOService.CONSOLE_IO)){
            System.out.println("Enter Employee ID.: ");
            int id = scanner.nextInt();
            System.out.println("Enter Employee name: ");
            String name = scanner.next();
            System.out.println("Enter Employee salary: ");
            long salary = scanner.nextLong();
            employeePayrollList.add(new EmployeePayrollData(id,name,salary));
        }
        return employeePayrollList.size();
    }

    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\n Writing Employee Payroll Roaster to Console\n" + employeePayrollList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileI0Service().writeData(employeePayrollList);
    }


    public static void main(String[] args) {
        System.out.println("Welcome To Employee Payroll Service Project");
        ArrayList<EmployeePayrollData> employeepayrolllist = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeepayrolllist);
        Scanner scanner = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(IOService.CONSOLE_IO);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);

    }

    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileI0Service().printData();
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileI0Service().countEntries();
        return 0;
    }


}
