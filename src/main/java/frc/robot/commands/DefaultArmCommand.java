package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Arm;

public class DefaultArmCommand extends CommandBase{
    private Arm turnyBit;
    private CommandXboxController trigger;
    public DefaultArmCommand(Arm turnyBit, CommandXboxController trigger) {
		this.turnyBit=turnyBit;
		this.trigger=trigger;
		this.addRequirements(turnyBit);
		this.turnyBit.setDefaultCommand(this);
	}

	public void execute(){
		if (trigger.getRightTriggerAxis()!=0){
			turnyBit.shpinArm(0.13);
		}else if (trigger.getLeftTriggerAxis()!=0){
			turnyBit.shpinArm(-0.13);
		}else {
			turnyBit.shpinArm(0);
		}
	}
}
