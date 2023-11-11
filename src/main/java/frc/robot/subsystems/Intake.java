package frc.robot.subsystems;

import java.io.Console;

import javax.xml.crypto.AlgorithmMethod;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    private CANSparkMax inMotor = new CANSparkMax(Constants.inMotorId, MotorType.kBrushless);
    public void moveIntake(double shpinSpd) { //makes it go
        inMotor.set(shpinSpd);
    }  
    public void stop() {//makes it not go
        inMotor.stopMotor();
    }
    public void periodic() { //tell where funni is
    
    }
}
