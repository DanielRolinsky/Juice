// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.FollowLimelightCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LimelightSubsystem;

public class RobotContainer {
  // Controllers
  public final XboxController masterController = new XboxController(0);

  // Subsystems
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();

  // Commands
  private final FollowLimelightCommand autoCommand = new FollowLimelightCommand(driveSubsystem, limelightSubsystem);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(masterController, 1).whenPressed(new FollowLimelightCommand(driveSubsystem, limelightSubsystem));

    driveSubsystem.setDefaultCommand(new RunCommand(() -> driveSubsystem
            .arcadeDrive(masterController.getY(GenericHID.Hand.kLeft), masterController.getX(GenericHID.Hand.kLeft)), driveSubsystem));
  }

  public Command getAutonomousCommand() {
    return autoCommand;
  }
}
