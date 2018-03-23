package io.github.wataugarobotics.ftclib.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/** Created by benbroce on 3/22/18 */
public abstract class Drive {
    protected DcMotor[] motors;

    /**
     * Constructs a drive with a hwMap and the String names of the drive motors
     *
     * @param hwMap a HardwareMap with which to access the motors
     * @param motors a String[] of the motor names (see patterns in subclasses)
     */
    public Drive(HardwareMap hwMap, String[] motors) {
        this.motors = new DcMotor[motors.length];
        for (int i = 0; i < motors.length; i++) {
            this.motors[i] = hwMap.dcMotor.get(motors[i]);
        }
    }

    /**
     * Constructs a drive with a hwMap and the String names of the drive motors
     *
     * @param hwMap a HardwareMap with which to access the motors
     * @param motors a String[] of the motor names (see patterns in subclasses)
     * @param directions a DcMotor.Direction[] of the directions the motors consider "forward"
     */
    public Drive(HardwareMap hwMap, String[] motors, DcMotor.Direction[] directions) {
        this.motors = new DcMotor[motors.length];
        for (int i = 0; i < motors.length; i++) {
            this.motors[i] = hwMap.dcMotor.get(motors[i]);
        }
        for (int i = 0; i < this.motors.length; i++) {
            this.motors[i].setDirection(directions[i]);
        }
    }

    /**
     * Initialization routine for drive motors
     *
     * @param zeroPowerBehavior DCMotor.ZeroPowerBehavior.[BRAKE or FLOAT]
     * @param runMode DcMotor.RunMode.[RUN_USING_ENCODERS or RUN_WITHOUT_ENCODERS]
     */
    public void init(DcMotor.ZeroPowerBehavior zeroPowerBehavior, DcMotor.RunMode runMode) {
        for (DcMotor mtr : motors) {
            mtr.setZeroPowerBehavior(zeroPowerBehavior);
            mtr.setMode(runMode);
        }
        stop(); // stop drive
    }

    /**
     * Moves the drive base a given y distance at a set speed (NON-BLOCKING)
     *
     * @param rotations
     * @param power
     */
    public void moveDistance(double rotations, double power) {
        for (DcMotor mtr : motors) {
            mtr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            mtr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            mtr.setTargetPosition(
                    (int) Math.round(mtr.getMotorType().getTicksPerRev() * rotations));
            mtr.setPower(power);
        }
    }

    /** Stops all drive motors */
    public void stop() {
        for (DcMotor mtr : motors) {
            mtr.setPower(0);
        }
    }
}
