package io.github.wataugarobotics.ftclib.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

/** ClassDoc */
abstract class Drive {
    protected HardwareMap hwMap;
    protected DcMotor[] motors;
    protected DcMotor.Direction[] directions;

    public abstract void move(float power);

    public abstract void set();
}
