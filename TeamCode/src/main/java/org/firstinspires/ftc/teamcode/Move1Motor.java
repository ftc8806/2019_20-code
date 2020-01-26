package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "Lift WITHOUT LIMITS")
public class Move1Motor extends OpMode {
    DcMotor lift;
    public void init () {
        lift = hardwareMap.dcMotor.get("lift");
    }
    public void loop () {
       lift.setPower(-gamepad2.right_stick_y);
    }
}
