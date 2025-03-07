package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax; // Updated import paths
import com.revrobotics.spark.SparkLowLevel.MotorType; // Updated import paths
import com.revrobotics.AbsoluteEncoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Arm extends TimedRobot {
    private final SparkMax ArmleftMotor = new SparkMax(9, MotorType.kBrushless); // Updated class name
    private final SparkMax ArmrightMotor = new SparkMax(10, MotorType.kBrushless); // Updated class name
    private final XboxController controller = new XboxController(0);
    private final AbsoluteEncoder encoder = ArmleftMotor.getAbsoluteEncoder(); // Initialize the absolute encoder

    // Define the target angles in degrees
    private static final double TARGET_ANGLE_1 = 20.0;
    private static final double TARGET_ANGLE_2 = 20.0;

    @Override
    public void teleopPeriodic() {
        double currentAngle = encoder.getPosition(); // Get the current position in degrees

        if (controller.getXButton()) { // X button
            if (currentAngle < TARGET_ANGLE_1) {
                ArmleftMotor.set(1.0); // Forward
                ArmrightMotor.set(1.0); // Forward
            } else {
                ArmleftMotor.set(0.0); // Stop
                ArmrightMotor.set(0.0); // Stop
            }
        } else if (controller.getBButton()) { // B button
            if (currentAngle > -TARGET_ANGLE_2) {
                ArmleftMotor.set(-1.0); // Backward
                ArmrightMotor.set(-1.0); // Backward
            } else {
                ArmleftMotor.set(0.0); // Stop
                ArmrightMotor.set(0.0); // Stop
            }
        } else {
            ArmleftMotor.set(0.0); // Stop
            ArmrightMotor.set(0.0); // Stop
        }
    }
}