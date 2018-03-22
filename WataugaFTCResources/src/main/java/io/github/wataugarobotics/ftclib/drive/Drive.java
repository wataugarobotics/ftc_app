package io.github.wataugarobotics.ftclib.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/** Created by benbroce on 3/22/18 */
abstract class Drive {
    protected DcMotor[] motors;

    public static double NEVEREST_CLASSIC_20_CPR = 560;
    public static double NEVEREST_CLASSIC_40_CPR = 1120;
    public static double NEVEREST_CLASSIC_60_CPR = 1680;
    public static double NEVEREST_ORBITAL_20_CPR = 537.6;
    public static double NEVEREST_ORBITAL_3_7_CPR = 103;
    public static double REV_CORE_HEX_CPR = 288;
    public static double REV_HD1_HEX_20_CPR = 1120;
    public static double REV_HD1_HEX_40_CPR = 2240;
    public static double REV_HD2_HEX_20_CPR = 560;
    public static double REV_HD2_HEX_40_CPR = 1120;
    public static double TETRIX_CPR = 1440;
    public static double MATRIX_9V_CPR = 757.12;
    public static double MATRIX_12V_CPR = 1478.4;

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

    /** Stops all drive motors */
    public void stop() {
        for (DcMotor mtr : motors) {
            mtr.setPower(0);
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
}
