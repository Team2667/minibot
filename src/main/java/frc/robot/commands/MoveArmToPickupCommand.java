package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArmToPickupCommand  extends CommandBase {
    private Arm arm;

    public MoveArmToPickupCommand(Arm arm) {
        this.arm = arm;
        this.addRequirements(arm);
    }

    @Override
    public void initialize() {
        // Call a method on arm to move it to the pickup position
    }

    @Override
    public void execute() {
        // This method can remain empty
    }

    @Override
    public boolean isFinished() {
        // return true if the arm is at the pickup position
        return false;
    }

    @Override
    public void end(boolean isInterrupted) {
        // This method can remain empty

    }
    
}
