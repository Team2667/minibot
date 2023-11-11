// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.commands.DefaultArmCommand;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.MoveArmToPickupCommand;
import frc.robot.commands.PickupCubeCommand;
import frc.robot.commands.ThrowCubeCommand;
import frc.robot.commands.MoveArmToRestCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();
  private Arm arm= new Arm();
  private Intake intake = new Intake();
  private DefaultDriveCommand drivecommand;
  private DefaultArmCommand defaultArmCommand;
  private ThrowCubeCommand throwCubeCommand;
  private PickupCubeCommand pickupCubeCommand;
  private MoveArmToRestCommand moveArmToRestCommand;
  private MoveArmToPickupCommand moveArmToPickupCommand;


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController xbvCommandXboxController =
      new XboxController(Constants.kDriverControllerPort);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    createCommands();
    configureBindings();
  }

  public void createCommands(){
    drivecommand = new DefaultDriveCommand(driveTrain, xbvCommandXboxController);
    defaultArmCommand = new DefaultArmCommand(arm, xbvCommandXboxController);
    throwCubeCommand = new ThrowCubeCommand(intake);
    pickupCubeCommand = new PickupCubeCommand(intake);
    moveArmToPickupCommand = new MoveArmToPickupCommand(arm);
    moveArmToRestCommand = new MoveArmToRestCommand(arm);
    
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
    var leftBumper = new JoystickButton(xbvCommandXboxController, XboxController.Button.kLeftBumper.value);
    leftBumper.whileTrue(new RepeatCommand(throwCubeCommand));

    var rightBumper = new JoystickButton(xbvCommandXboxController, XboxController.Button.kRightBumper.value);
    rightBumper.whileTrue(new RepeatCommand(pickupCubeCommand));

    var yButton = new JoystickButton(xbvCommandXboxController, XboxController.Button.kY.value);
    yButton.whileTrue(moveArmToPickupCommand);
    
    var aButton = new JoystickButton(xbvCommandXboxController, XboxController.Button.kA.value);
    aButton.whileTrue(moveArmToRestCommand);
  }
}
