package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ThrowCubeCommand extends CommandBase{
    private Intake intake;

    public ThrowCubeCommand(Intake intake) {
        this.intake = intake;
        this.addRequirements(intake);
    }

    @Override
    public void initialize() {
        // Turn the intake motor to throw a cube
    }

    @Override
    public void execute() {
        // This method can remain empty
    }

    @Override
    public boolean isFinished() {
        // This method does not need to change. The command will end when the user releases a button
        return false;
    }

    @Override
    public void end(boolean isInterrupted) {
        // Stop the motor
    }
}
