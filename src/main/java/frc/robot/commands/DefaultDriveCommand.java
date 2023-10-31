package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;

public class DefaultDriveCommand extends CommandBase {
    public CommandXboxController xboxcontroller;
    public DriveTrain driveTrain;
    
    
    public DefaultDriveCommand(DriveTrain dtrain, CommandXboxController controller) {
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
