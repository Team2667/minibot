package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Arm;

public class DefaultArmCommand extends CommandBase{
    private Arm turnyBit;
    private XboxController controller;
    public DefaultArmCommand(Arm turnyBit, XboxController trigger) {
		this.turnyBit=turnyBit;
		this.controller=trigger;
		this.addRequirements(turnyBit);
		this.turnyBit.setDefaultCommand(this);
	}

	public void execute(){
		int dPadDir = controller.getPOV();
		switch(dPadDir){
			case -1: turnyBit.stop();
			break;

			case 0: turnyBit.moveArm(0.1);
			break;

			case 180: turnyBit.moveArm(-0.1);
			break;

			default: turnyBit.stop();
			break;
	}
	}
}
