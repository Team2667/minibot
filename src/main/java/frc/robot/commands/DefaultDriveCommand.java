package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DefaultDriveCommand extends CommandBase {
    public XboxController xboxcontroller;
    public DriveTrain driveTrain;
    private SlewRateLimiter limiter;
    
    
    public DefaultDriveCommand(DriveTrain dtrain, XboxController controller) {
        driveTrain = dtrain;
        this.addRequirements(driveTrain);
        dtrain.setDefaultCommand(this);
        xboxcontroller = controller;
        limiter = new SlewRateLimiter(1, -1, 0);
    }

    @Override
    public void execute() {
        //ToDo: use the limmiter to limit to calculate the speed.
        driveTrain.drive(xboxcontroller.getLeftX(),xboxcontroller.getLeftY()*-1);
        
    }
    
}
