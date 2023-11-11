package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DefaultDriveCommand extends CommandBase {
    public XboxController xboxcontroller;
    public DriveTrain driveTrain;
    
    
    public DefaultDriveCommand(DriveTrain dtrain, XboxController controller) {
        driveTrain = dtrain;
        this.addRequirements(driveTrain);
        dtrain.setDefaultCommand(this);
        xboxcontroller = controller;
    }

    @Override
    public void execute() {
        driveTrain.drive(xboxcontroller.getLeftX(),xboxcontroller.getLeftY()*-1);
        
    }
    
}
