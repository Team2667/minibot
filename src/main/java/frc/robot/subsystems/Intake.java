package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    private CANSparkMax inMotor = new CANSparkMax(Constants.inMotorId, MotorType.kBrushless);
    private SparkMaxPIDController sparkPidController;
    private RelativeEncoder encoder;
    private double pV = 4e-1;
	private double iV = 0;
    private double dV = 0;

    public Intake() {
        inMotor = new CANSparkMax(Constants.inMotorId, MotorType.kBrushless);
        sparkPidController = inMotor.getPIDController();
        encoder = inMotor.getEncoder();
        sparkPidController.setP(pV);
        sparkPidController.setI(iV);
        sparkPidController.setD(dV);
    }
    
    public void moveIntake(double shpinSpd) { //makes it go
        inMotor.set(shpinSpd);
    }

    public void stop() {//makes it not go
        inMotor.stopMotor();
    }

    public void pickupCube() {
        sparkPidController.setReference(Constants.intakeCubeInVelosity, ControlType.kVelocity);
    }

    public void throwCube() {
        sparkPidController.setReference( -1 * Constants.intakeCubeInVelosity, ControlType.kVelocity);
    }

    public void periodic() { //tell where funni is
    
    }
}
