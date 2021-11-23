package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {
    private final NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
    private final NetworkTableEntry tx = limelight.getEntry("tx");
    private final NetworkTableEntry ty = limelight.getEntry("ty");
    private final NetworkTableEntry ta = limelight.getEntry("ta");

    public LimelightSubsystem() {}

    public double getX() {
        return tx.getDouble(0.);
    }

    public double getY() {
        return ty.getDouble(0.);
    }

    public double getA() {
        return ta.getDouble(0.);
    }
}

