package frc.robot.resources;

import edu.wpi.first.wpilibj.PWM;

public class RobotMap {

    public static final int[] LEFT_CHASSIS_MOTOR_PORTS = {2, 3};
    public static final TecbotSpeedController.TypeOfMotor[] LEFT_CHASSIS_MOTOR_TYPES = {TecbotSpeedController.TypeOfMotor.PWM_TALON_SRX, TecbotSpeedController.TypeOfMotor.SPARK};
    public static final boolean[] LEFT_CHASSIS_MOTOR_DIRECTIONS = {false, false};

    public static final int[] RIGHT_CHASSIS_MOTOR_PORTS = {0, 1};
    public static final TecbotSpeedController.TypeOfMotor[] RIGHT_CHASSIS_MOTOR_TYPES = {TecbotSpeedController.TypeOfMotor.PWM_TALON_SRX, TecbotSpeedController.TypeOfMotor.SPARK};
    public static final boolean[] RIGHT_CHASSIS_MOTOR_DIRECTIONS = {true, true};
}
