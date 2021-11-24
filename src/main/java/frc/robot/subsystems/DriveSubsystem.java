package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    private final WPI_TalonSRX right1 = new WPI_TalonSRX(Constants.Drive.rightDrive1);
    private final WPI_TalonSRX right2 = new WPI_TalonSRX(Constants.Drive.rightDrive2);
    private final SpeedControllerGroup right = new SpeedControllerGroup(right1, right2);

    private final WPI_TalonSRX left1 = new WPI_TalonSRX(Constants.Drive.leftDrive1);
    private final WPI_TalonSRX left2 = new WPI_TalonSRX(Constants.Drive.leftDrive2);
    private final SpeedControllerGroup left = new SpeedControllerGroup(left1, left2);

    private final DifferentialDrive drive = new DifferentialDrive(right, left);

    public DriveSubsystem() {
        // We fitted this robot backwards :(
        left.setInverted(true);
        right.setInverted(true);
    }

    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }
}
