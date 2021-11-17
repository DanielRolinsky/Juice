package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class AimLimelightCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final LimelightSubsystem limelightSubsystem;

    public AimLimelightCommand(DriveSubsystem driveSubsystem, LimelightSubsystem limelightSubsystem) {
        this.driveSubsystem = driveSubsystem;
        this.limelightSubsystem = limelightSubsystem;

        addRequirements(this.driveSubsystem, this.limelightSubsystem);
    }

    @Override
    public void initialize() {
        String result = "horizontal: " + limelightSubsystem.getX() + ", vertical: " + limelightSubsystem.getY();
        System.out.println(result);
    }
}
