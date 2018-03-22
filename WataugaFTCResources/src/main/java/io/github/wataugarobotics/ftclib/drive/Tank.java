package io.github.wataugarobotics.ftclib.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

/** Created by benbroce on 3/22/18. */
public class Tank extends Drive {
    /**
     * Constructs a tank drive with a hwMap and the String names of the drive motors
     *
     * @param hwMap a HardwareMap with which to access the motors
     * @param motors a String[] of the motor names {l, r, l, r, ...}
     */
    public Tank(HardwareMap hwMap, String[] motors) {
        super(hwMap, motors);
        for (int i = 0; i < this.motors.length; i++) {
            if (i % 2 == 0) {
                this.motors[i].setDirection(DcMotor.Direction.REVERSE);
            } else {
                this.motors[i].setDirection(DcMotor.Direction.FORWARD);
            }
        }
    }

    /**
     * Constructs a tank drive with a hwMap, the String names of the drive motors, & the motor
     * directions
     *
     * @param hwMap a HardwareMap with which to access the motors
     * @param motors a String[] of the motor names {l, r, l, r, ...}
     * @param directions a DcMotor.Direction[] of the directions the motors consider "forward"
     */
    public Tank(HardwareMap hwMap, String[] motors, DcMotor.Direction[] directions) {
        super(hwMap, motors, directions);
    }

    /**
     * Moves the drive base
     *
     * @param l left power/speed [-1 to 1]
     * @param r right power/speed [-1 to 1]
     */
    public void move(double l, double r) {
        move(l, r, 1.0);
    }

    /**
     * Moves the drive base at a reduced power/speed
     *
     * @param l left power/speed [-1 to 1]
     * @param r right power/speed [-1 to 1]
     * @param reduction power/speed scale reduction [0 to 1]
     */
    public void move(double l, double r, double reduction) {
        for (int i = 0; i < motors.length; i++) {
            if (i % 2 == 0) {
                motors[i].setPower(Range.clip((l), -reduction, reduction));
            } else {
                motors[i].setPower(Range.clip((r), -reduction, reduction));
            }
        }
    }
}
