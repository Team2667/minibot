package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    CANSparkMax lmotor;
    CANSparkMax rmotor;
    DifferentialDrive drive;


    public DriveTrain() {
        this.lmotor = new CANSparkMax(Constants.ldrivetrainmotor, MotorType.kBrushless);
        this.rmotor = new CANSparkMax(Constants.rdrivetrainmotor, MotorType.kBrushless);
        this.drive = new DifferentialDrive(rmotor, lmotor);
    }

    
    public void drive(double xSpeed, double zRotation)
    {

        this.drive.arcadeDrive(xSpeed, zRotation);
    }
    
}
