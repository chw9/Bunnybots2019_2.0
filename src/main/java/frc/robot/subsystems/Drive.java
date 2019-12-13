package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANAnalog.AnalogMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.frc5587.lib.pathfinder.SparkAbstractDrive;

import edu.wpi.first.wpilibj.SPI.Port;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Drive extends SparkAbstractDrive {
    
    public Drive() {
        super(new CANSparkMax(RobotMap.Drive.LEFT_ONE, MotorType.kBrushless),
                new CANSparkMax(RobotMap.Drive.RIGHT_ONE, MotorType.kBrushless),
                new CANSparkMax(RobotMap.Drive.LEFT_TWO, MotorType.kBrushless),
                new CANSparkMax(RobotMap.Drive.RIGHT_TWO, MotorType.kBrushless), true);

        setAHRS(new AHRS(Port.kMXP));
        // setConstants(Constants.Drive.K_MAX_VELOCITY, Constants.Drive.K_TIMEOUT_MS, Constants.Drive.WHEEL_DIAMETER, Constants.Drive.MIN_BUFFER_COUNT);

        leftSparkAnalog = leftOne.getAnalog(AnalogMode.kAbsolute);
        rightSparkAnalog = rightOne.getAnalog(AnalogMode.kAbsolute);
        leftOneSparkEncoder = leftOne.getEncoder();
        rightOneSparkEncoder = rightOne.getEncoder();
        leftTwoSparkEncoder = leftTwo.getEncoder();
        rightTwoSparkEncoder = rightTwo.getEncoder();

        configureSpark();
    }

    private void configureSpark() {
        // left one
        leftOne.setInverted(false);

        leftOne.setSoftLimit(SoftLimitDirection.kForward, Constants.Drive.MAX_PERCENT_FW);
        leftOne.setSoftLimit(SoftLimitDirection.kReverse, -Constants.Drive.MAX_PERCENT_BW);
        spark_pidControllerLeft.setOutputRange(-Constants.Drive.MAX_PERCENT_BW, Constants.Drive.MAX_PERCENT_FW);

        leftOne.setSmartCurrentLimit(40, 40);

        leftOne.enableVoltageCompensation(Constants.Drive.V_COMP_SATURATION);

        // right one
        rightOne.setInverted(false);

        rightOne.setSoftLimit(SoftLimitDirection.kForward, Constants.Drive.MAX_PERCENT_FW);
        rightOne.setSoftLimit(SoftLimitDirection.kReverse, -Constants.Drive.MAX_PERCENT_BW);
        spark_pidControllerRight.setOutputRange(-Constants.Drive.MAX_PERCENT_BW, Constants.Drive.MAX_PERCENT_FW);

        rightOne.setSmartCurrentLimit(40, 40);

        rightOne.enableVoltageCompensation(Constants.Drive.V_COMP_SATURATION);

        // left two
        leftTwo.setInverted(false);

        leftTwo.setSoftLimit(SoftLimitDirection.kForward, Constants.Drive.MAX_PERCENT_FW);
        leftTwo.setSoftLimit(SoftLimitDirection.kReverse, -Constants.Drive.MAX_PERCENT_BW);
        spark_pidControllerLeft.setOutputRange(-Constants.Drive.MAX_PERCENT_BW, Constants.Drive.MAX_PERCENT_FW);

        leftTwo.setSmartCurrentLimit(40, 40);

        leftTwo.enableVoltageCompensation(Constants.Drive.V_COMP_SATURATION);

        // right two
        rightTwo.setInverted(false);

        rightTwo.setSoftLimit(SoftLimitDirection.kForward, Constants.Drive.MAX_PERCENT_FW);
        rightTwo.setSoftLimit(SoftLimitDirection.kReverse, -Constants.Drive.MAX_PERCENT_BW);
        spark_pidControllerRight.setOutputRange(-Constants.Drive.MAX_PERCENT_BW, Constants.Drive.MAX_PERCENT_FW);

        rightTwo.setSmartCurrentLimit(40, 40);

        rightTwo.enableVoltageCompensation(Constants.Drive.V_COMP_SATURATION);
    }

    @Override
	public void configPID(int slot) {
       
	}

	@Override
	public void configSettings() {
		// var timeoutMs =  Constants.Drive.K_TIMEOUT_MS;
    }

	public void initDefaultCommand() {
	}
}