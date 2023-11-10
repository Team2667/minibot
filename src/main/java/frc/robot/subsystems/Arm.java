package frc.robot.subsystems;

import java.io.Console;

import javax.xml.crypto.AlgorithmMethod;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    private CANSparkMax armMotor = new CANSparkMax(Constants.ldrivetrainmotor, MotorType.kBrushless);
    public void shpinArm(double shpinSpd) { //makes it go
        armMotor.set(shpinSpd);
    }  
    public void stop() {//makes it not go
        armMotor.stopMotor();
    }
    public void periodic() { //tell where is
        var encoder=armMotor.getEncoder();
        var turnyPos=encoder.getPosition();
        SmartDashboard.putNumber("TurnyBitPosition",turnyPos);
    }
}
