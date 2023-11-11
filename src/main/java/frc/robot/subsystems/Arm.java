package frc.robot.subsystems;

import java.io.Console;

import javax.xml.crypto.AlgorithmMethod;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch.Type;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    private CANSparkMax armMotor;
    private SparkMaxPIDController sparkPidController;
    private RelativeEncoder encoder;
    private double pV = 4e-1;
	private double iV = 0;
    private double dV = 0;

    public Arm() {
        armMotor = new CANSparkMax(Constants.armMotorId, MotorType.kBrushless);
        sparkPidController = armMotor.getPIDController();
        encoder = armMotor.getEncoder();
        sparkPidController.setP(pV);
        sparkPidController.setI(iV);
        sparkPidController.setD(dV);
    }

    public void moveArm(double speed) { //makes it go'
        armMotor.set(speed);
    }

    public void stop() {//makes it not go
        armMotor.stopMotor();
    }

    public void moveToPickupPosition() {
        sparkPidController.setReference(Constants.armPickupPosition, ControlType.kPosition);
    }

    public boolean isAtPickupPosition() {
        double diff = Constants.armPickupPosition - encoder.getPosition();
        return Math.abs(diff) <= Constants.armVariance;
    }

    public void moveToRestPosition() {
        sparkPidController.setReference(Constants.armRestPosition, ControlType.kPosition);
    }

    public boolean isAtRestPosition() {
        double diff = Constants.armRestPosition - encoder.getPosition();
        return Math.abs(diff) <= Constants.armVariance;
    }

    public boolean isAtRestLimit() {
        return armMotor.getReverseLimitSwitch(Type.kNormallyOpen).isLimitSwitchEnabled();
    }

    public void zeroArm(){
        encoder.setPosition(0);
    }

    public void periodic() { //tell where is
        var armPos=encoder.getPosition();
        SmartDashboard.putNumber("Arm Pos",armPos);
    }
}
