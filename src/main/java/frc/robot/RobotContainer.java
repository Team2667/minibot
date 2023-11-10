// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.commands.DefaultArmCommand;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();
  private Arm arm= new Arm();
  private DefaultDriveCommand drivecommand;
  private DefaultArmCommand defaultArmCommand;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController xbvCommandXboxController =
      new CommandXboxController(Constants.kDriverControllerPort);

  public void createCommands(){
    drivecommand = new DefaultDriveCommand(driveTrain, xbvCommandXboxController);
    defaultArmCommand = new DefaultArmCommand(arm, xbvCommandXboxController);
}

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    createCommands();
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
   
  }
}
