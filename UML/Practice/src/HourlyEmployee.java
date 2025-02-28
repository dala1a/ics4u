// This class is an employee pay record for hourly employees.
//  The calcPay() method calculates regular pay and overtime pay
import java.io.*;
public class HourlyEmployee  {
    private String name;
    private int empNum;
    private double hourlyRate;
    private double hoursWorked;
    private double regularPay;
    private double overtimePay;
    private final long recLen = 80;
    // constructors - first with parameters and second without)
    public HourlyEmployee (String name, int empNum, double hourlyRate, double hoursWorked)  {
        this.name = name;
        this.empNum = empNum;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        calcPay ();
    }
    public HourlyEmployee ()    {
        name = "";
        empNum = 0;
        hourlyRate = 0;
        hoursWorked = 0;
    }
    public void setName (String name)  {
        this.name = name;
    }
    public void setEmpNum (int empNum)   {
        this.empNum = empNum;
    }
    public void setHourlyRate (double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void setHoursWorked (double hoursWorked)  {
        this.hoursWorked = hoursWorked;
    }
    public void calcPay ()  {
        if (hoursWorked > 40)  {
            regularPay = 40 * hourlyRate;
            overtimePay = (hoursWorked - 40) * hourlyRate * 1.5;
        }
        else  {
            regularPay = hoursWorked * hourlyRate;
            overtimePay = 0;
        }
    }
    public String getName ()  {
        return name;
    }
    public long getEmpNum ()  {
        return empNum;
    }
    public double getHourlyRate () {
        return hourlyRate;
    }
    public double getHoursWorked () {
        return hoursWorked;
    }
    public double getRegularPay ()  {
        return regularPay;
    }
    public double getOvertimePay () {
        return overtimePay;
    }    



} // HourlyEmployee class