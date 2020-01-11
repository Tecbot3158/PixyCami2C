/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.PrintAllData;

import java.util.ArrayList;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    public static RobotContainer m_robotContainer;
    public static Command printAllData;

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
        // autonomous chooser on the dashboard.
        m_robotContainer = new RobotContainer();
        printAllData = new PrintAllData();
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    /**
     * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
     */
    @Override
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        /*
        m_robotContainer.getPixyCamMIne().getFormattedData().add(0);
        m_robotContainer.getPixyCamMIne().getFormattedData().add(0);
        m_robotContainer.getPixyCamMIne().getFormattedData().add(0);
        m_robotContainer.getPixyCamMIne().getFormattedData().add(0);
        */
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        int x = 0, y = 0, width = 0, height = 0;
        //m_robotContainer.getPixyCami2C().read();
        //System.out.println(bytes[4]);
        //System.out.println(Byte.toUnsignedInt(bytes.get(4)));
        //System.out.println(String.format("%02X",bytes.get(0)));
        //System.out.println(bytes.get(4).byteValue());
        //System.out.println(successful);
        //*****************************************
        //m_robotContainer.getPixyCami2C().read();


        /*
        byte[] bytes = new byte[16];
        int lastX = m_robotContainer.getPixyCamMIne().getFormattedData().get(0);
        int lastY = m_robotContainer.getPixyCamMIne().getFormattedData().get(1);
        int lastWidth = m_robotContainer.getPixyCamMIne().getFormattedData().get(2);
        int lastHeight = m_robotContainer.getPixyCamMIne().getFormattedData().get(3);
        m_robotContainer.getPixyCamMIne().read(m_robotContainer.getPixyCamMIne().address, 16, bytes);
        int deltaX = Math.abs(lastX - m_robotContainer.getPixyCamMIne().formattedData.get(0));
        int deltaY = Math.abs(lastX - m_robotContainer.getPixyCamMIne().formattedData.get(1));
        int deltaWidth = Math.abs(lastX - m_robotContainer.getPixyCamMIne().formattedData.get(2));
        int deltaHeight = Math.abs(lastX - m_robotContainer.getPixyCamMIne().formattedData.get(3));
        SmartDashboard.putNumber("DELTA X", deltaX);
        SmartDashboard.putNumber("DELTA Y", deltaY);
        SmartDashboard.putNumber("DELTA width", deltaWidth);
        SmartDashboard.putNumber("DELTA height", deltaHeight);

        //X
        if (deltaX > 100) x = lastX;
        else x = m_robotContainer.getPixyCamMIne().getFormattedData().get(0);

        //Y
        if (deltaY > 100) y = lastY;
        else y = m_robotContainer.getPixyCamMIne().getFormattedData().get(1);

        //width
        if (deltaWidth > 100) width = lastWidth;
        else width = m_robotContainer.getPixyCamMIne().getFormattedData().get(2);

        //height
        if (deltaHeight > 100) height = lastHeight;
        else height = m_robotContainer.getPixyCamMIne().getFormattedData().get(3);


        //SmartDashboard.putData(new PrintAllData());
        //CommandScheduler.getInstance().schedule(false, printAllData);
        SmartDashboard.putNumber("x", x);
        SmartDashboard.putNumber("y", y);
        SmartDashboard.putNumber("width", width);
        SmartDashboard.putNumber("height", height);


        */

        SmartDashboard.putNumber("X",m_robotContainer.getPixyCamMIne().getX());
        SmartDashboard.putBoolean("objectPresent",m_robotContainer.getPixyCamMIne().objectPresent());
    }

    @Override
    public void testInit() {

        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }


}
