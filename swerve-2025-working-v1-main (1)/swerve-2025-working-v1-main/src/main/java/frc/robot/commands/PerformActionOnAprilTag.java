package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class PerformActionOnAprilTag extends CommandBase {
    private final Limelight limelight;

    public PerformActionOnAprilTag(Limelight limelight) {
        this.limelight = limelight;
        addRequirements(limelight);
    }

    @Override
    public void initialize() {
        // Initialization code
    }

    @Override
    public void execute() {
        int tagID = limelight.getAprilTagID();
        if (tagID != -1) {
            limelight.logAprilTagID();
            // Perform action based on the detected tag ID
            switch (tagID) {
                case 1:
                    // Action for tag ID 1
                    break;
                case 2:
                    // Action for tag ID 2
                    break;
                // Add cases for other tag IDs
                default:
                    // Default action
                    break;
            }
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        // Cleanup code
    }
}
