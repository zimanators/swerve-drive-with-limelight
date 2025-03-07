package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
    private final NetworkTableInstance ntInst = NetworkTableInstance.getDefault();

    public Limelight() {
        // Constructor
    }

    public int getAprilTagID() {
        double[] defaultValue = new double[0];
        double[] tagIDs = ntInst.getTable("limelight").getEntry("tid").getDoubleArray(defaultValue);
        if (tagIDs.length > 0) {
            return (int) tagIDs[0];
        }
        return -1; // No tag detected
    }

    public void logAprilTagID() {
        int tagID = getAprilTagID();
        if (tagID != -1) {
            System.out.println("Detected AprilTag ID: " + tagID);
        } else {
            System.out.println("No AprilTag detected.");
        }
    }
}
