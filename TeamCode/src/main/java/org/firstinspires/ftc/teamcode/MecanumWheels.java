package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "MecanumWheels")
public class MecanumWheels extends OpMode {
    DcMotor fr, fl, br, bl, extender;
    Servo wrist;
    @Override

    public void init() {
        fr = hardwareMap.dcMotor.get("fright");
        fl = hardwareMap.dcMotor.get("fleft");
        br = hardwareMap.dcMotor.get("bright");
        bl = hardwareMap.dcMotor.get("bleft");
        extender = hardwareMap.dcMotor.get("extender");

        wrist = hardwareMap.servo.get("wrist");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);

    }


    @Override
    public void loop() {

        double speed = 1;
        /**Dpad**/
        fr.setPower(gamepad1.left_stick_y*speed);
        fl.setPower(gamepad1.left_stick_y*speed);
        br.setPower(gamepad1.left_stick_y*speed);
        bl.setPower(gamepad1.left_stick_y*speed);
//            //North
//            if (gamepad1.dpad_up) {
//                fl.setPower(speed);
//                fr.setPower(speed);
//                bl.setPower(speed);
//                br.setPower(speed);
//            }
//            //South
//            else if (gamepad1.dpad_down) {
//                fl.setPower(-speed);
//                fr.setPower(-speed);
//                bl.setPower(-speed);
//                br.setPower(-speed);
//            }
//            //West
//            else if (gamepad1.dpad_left) {
//                fl.setPower(-speed);
//                fr.setPower(speed);
//                bl.setPower(speed);
//                br.setPower(-speed);
//            }
//            //East
//            else if (gamepad1.dpad_right) {
//                fl.setPower(speed);
//                fr.setPower(-speed);
//                bl.setPower(-speed);
//                br.setPower(speed);
//            }
//            else {
//                fl.setPower(0);
//                fr.setPower(0);
//                bl.setPower(0);
//                br.setPower(0);
//            }

        /**Stick**/
        //NW
        if (gamepad1.right_stick_y > 0 & gamepad1.right_stick_x > 0){
            fr.setPower(speed);
            bl.setPower(speed);
        }
        //NE
        else if (gamepad1.right_stick_y > 0 & gamepad1.right_stick_x < 0){
            fl.setPower(speed);
            br.setPower(speed);
        }
        //SW
        else if (gamepad1.right_stick_y < 0 & gamepad1.right_stick_x > 0) {
            fr.setPower(-speed);
            bl.setPower(-speed);
        }
        //SE
        else if (gamepad1.right_stick_y < 0 & gamepad1.right_stick_x < 0) {
            fl.setPower(-speed);
            br.setPower(-speed);
        }

        /**Spin**/
        //turn r
        if (gamepad1.right_bumper) {
            fl.setPower(-speed);
            bl.setPower(-speed);
            fr.setPower(speed);
            br.setPower(speed);
        }
        //turn l
        else if (gamepad1.left_bumper) {
            fl.setPower(speed);
            bl.setPower(speed);
            fr.setPower(-speed);
            br.setPower(-speed);
        }

        /**Claw**/
        if (gamepad1.y) {
            // Close
            wrist.setPosition(1);
        } else if (gamepad1.a) {
            // Open
            wrist.setPosition(0);
        }

        /**Extender**/
        if (/*extender.getCurrentPosition() < SLIDE_MAX &&*/ gamepad2.dpad_up) {
            // Out
            extender.setPower(0.3);
        } else if (/*extender.getCurrentPosition() > SLIDE_MIN &&*/ gamepad2.dpad_down) {
            // In
            extender.setPower(-0.3);
        } else {
            // Nowhere
            extender.setPower(0);
        }

        telemetry.addData("right stick x", gamepad1.right_stick_x);
        telemetry.addData("right stick y", gamepad1.right_stick_y);
    }

}
