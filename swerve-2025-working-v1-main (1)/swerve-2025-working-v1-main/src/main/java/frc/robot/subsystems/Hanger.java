package frc.robot.subsystems;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.XboxController;

public class Hanger extends TimedRobot {
    private final Spark HangerleftMotor = new Spark(0);
    private final Spark HangerrightMotor = new Spark(1);
    private final XboxController controller = new XboxController(0);

    @Override
    public void teleopPeriodic() {
        if (controller.getYButton()) { // Y button
            HangerleftMotor.set(1.0); // Forward
            HangerrightMotor.set(1.0); // Forward
        } else if (controller.getAButton()) { // A button
            HangerleftMotor.set(-1.0); // Backward
            HangerrightMotor.set(-1.0); // Backward
        } else {
            HangerleftMotor.set(0.0); // Stop
            HangerrightMotor.set(0.0); // Stop
        }
    }
}

/** 
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import com.revrobotics.spark.SparkMax; // Updated import paths
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType; // Updated import paths

public class Hanger extends TimedRobot {
    private final SparkMax HangerleftMotor = new SparkMax(0, MotorType.kBrushed);
    private final SparkMax HangerrightMotor = new SparkMax(1, MotorType.kBrushed);
    private final XboxController controller = new XboxController(0);

    @Override
    public void robotInit() {
        // Set the motors to brake mode
        HangerleftMotor.setIdleMode(IdleMode.kBrake);
        HangerrightMotor.setIdleMode(IdleMode.kBrake);
    }

    @Override
    public void teleopPeriodic() {
        if (controller.getYButton()) { // Y button
            HangerleftMotor.set(1.0); // Forward
            HangerrightMotor.set(1.0); // Forward
        } else if (controller.getAButton()) { // A button
            HangerleftMotor.set(-1.0); // Backward
            HangerrightMotor.set(-1.0); // Backward
        } else {
            HangerleftMotor.set(0.0); // Stop
            HangerrightMotor.set(0.0); // Stop
        }
    }
}
*/