package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ZeroArmCommand extends CommandBase {
    private Arm arm;

    // Define a constructor
    //  - Initiailze Arm
    //  - Add a requirement to this command

    public ZeroArmCommand(Arm arm) {
        this.arm = arm;
        this.addRequirements(arm);
    }

    @Override
    public void initialize() {
        // start the arm moving towards the resting position
    }

    @Override
    public void execute() {
        // This method can remain empty
    }

    @Override
    public boolean isFinished() {
        // return true if the arm is at the rest limmit
        return false;
    }

    @Override
    public void end(boolean isInterrupted) {
        // Zero the arm
    }
}
