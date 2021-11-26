package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class FollowLimelightCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final LimelightSubsystem limelightSubsystem;

    public FollowLimelightCommand(DriveSubsystem driveSubsystem, LimelightSubsystem limelightSubsystem) {
        this.driveSubsystem = driveSubsystem;
        this.limelightSubsystem = limelightSubsystem;

        addRequirements(driveSubsystem, limelightSubsystem);
    }

    @Override
    public void execute() {
        // A general speed softener. The factor by which the robot should be slowed down.
        double softener = 2;

        double x = limelightSubsystem.getX();
        double area = limelightSubsystem.getA();

        /* We calculate the speed based on the area that the target covers. The closer the object, the slower the speed
        * should be. We can translate this to "higher area -> slower speed" - the values are inversely related. Here's
        * a mapping of (approximate) areas in comparison to their speeds:
        *
        * area | speed
        * ------------
        * 10%  | 1.0
        * 20%  | 0.9
        * 30%  | 0.8
        * ...  | ...
        * 80%  | 0.3
        * 90%  | 0.2
        * 100% | 0.1
        *
        * To achieve this, we use a simple formula: `speed = (-area/10 + 11) / 10`. For example, given an area of 70%,
        * we can calculate to be `(-7 + 11) / 10`, or `0.4`.
        */
        double speed = (-area + 11) / 10 / softener;

        if (x == 0) {
            // If we don't see anything.
            driveSubsystem.arcadeDrive(0, 0);
        } else if (limelightSubsystem.getA() > 5) {
            // If the object is closer than half
            driveSubsystem.arcadeDrive(0, 0);
        } else {
            // If the object is farther than half
            driveSubsystem.arcadeDrive(speed, -(x / 40));
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
