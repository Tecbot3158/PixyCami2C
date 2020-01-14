/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.resources.Math;
import frc.robot.resources.RobotMap;
import frc.robot.resources.TecbotSpeedController;

import java.util.ArrayList;
import java.util.List;

public class Chassis extends SubsystemBase {
    /**
     * Creates a new Subsystem.
     */
    List<TecbotSpeedController> leftChassisMotors = new ArrayList<>();
    List<TecbotSpeedController> rightChassisMotors = new ArrayList<>();

    public Chassis() {
        for (int i = 0; i < RobotMap.LEFT_CHASSIS_MOTOR_PORTS.length; i++) {
            leftChassisMotors.add(new TecbotSpeedController(RobotMap.LEFT_CHASSIS_MOTOR_PORTS[i], RobotMap.LEFT_CHASSIS_MOTOR_TYPES[i]));
            leftChassisMotors.get(i).setInverted(RobotMap.LEFT_CHASSIS_MOTOR_DIRECTIONS[i]);
        }

        for (int i = 0; i < RobotMap.RIGHT_CHASSIS_MOTOR_PORTS.length; i++) {
            rightChassisMotors.add(new TecbotSpeedController(RobotMap.RIGHT_CHASSIS_MOTOR_PORTS[i], RobotMap.RIGHT_CHASSIS_MOTOR_TYPES[i]));
            rightChassisMotors.get(i).setInverted(RobotMap.RIGHT_CHASSIS_MOTOR_DIRECTIONS[i]);
        }
    }

    public void drive(double turn, double speed) {
        double leftSpeed = speed + turn;
        double rightSpeed = speed -turn;

        for (TecbotSpeedController m : leftChassisMotors) {
            m.set(Math.clamp(-0.15,0.15,leftSpeed));

        }
        for (TecbotSpeedController m : rightChassisMotors) {
            m.set(Math.clamp(-0.15,0.15,rightSpeed));
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        //drive(SmartDashboard.getNumber("turn",0),SmartDashboard.getNumber("speed",0));

    }


}
