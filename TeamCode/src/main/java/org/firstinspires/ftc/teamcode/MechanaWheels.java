package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "MechanaWheels")
public class MechanaWheels extends OpMode {
    DcMotor fr, fl, br, bl;
    @Override

    public void init() {
        fr = hardwareMap.dcMotor.get("fright");
        fl = hardwareMap.dcMotor.get("fleft");
        br = hardwareMap.dcMotor.get("bright");
        bl = hardwareMap.dcMotor.get("bleft");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);

    }


    @Override
    public void loop() {

        double speed = 1;
       // double frontspeed = .5;
        //forward
       //if (gamepad1.right_stick_y > 0) {
            fr.setPower(gamepad1.right_stick_y*speed);
            fl.setPower(gamepad1.right_stick_y*speed);
            br.setPower(gamepad1.right_stick_y*speed);
            bl.setPower(gamepad1.right_stick_y*speed);
        //}
        //backwards
       // else if (gamepad1.right_stick_y < 0) {
         //   fr.setPower(-frontspeed);
           // fl.setPower(-frontspeed);
            //br.setPower(-backspeed);
            //bl.setPower(-backspeed);
        //}
        //straferight
        //straferight
         if (gamepad1.left_stick_x < 0) {
            fr.setPower(-speed/* *2 */);
            fl.setPower(speed/* *2 */);
            br.setPower(speed);
            bl.setPower(-speed);
        }
        //strafeleft
        else if (gamepad1.left_stick_x > 0) {
            fr.setPower(speed/* *2 */);
            fl.setPower(-speed/* *2 */);
            br.setPower(-speed);
            bl.setPower(speed);
        }
        //NW
//        else if (gamepad1.right_stick_y > 0 & gamepad1.right_stick_x > 0){
//            fr.setPower(frontspeed);
//            bl.setPower(backspeed);
//        }
//        //NE
//        else if (gamepad1.right_stick_y > 0 & gamepad1.right_stick_x < 0){
//            fl.setPower(frontspeed);
//            br.setPower(backspeed);
//        }
//        //SW
//        else if (gamepad1.right_stick_y < 0 & gamepad1.right_stick_x > 0) {
//            fr.setPower(-frontspeed);
//            bl.setPower(-backspeed);
//        }
//        //SE
//        else if (gamepad1.right_stick_y < 0 & gamepad1.right_stick_x < 0) {
//            fl.setPower(-frontspeed);
//            br.setPower(-backspeed);
//        }
        // turn r
         if (gamepad1.right_bumper) {
            fl.setPower(-speed/* *2 */);
            bl.setPower(-speed);
            fr.setPower(speed/* *2 */);
            br.setPower(speed);
        }
        //turn l
        else if (gamepad1.left_bumper) {
            fl.setPower(speed/* *2 */);
            bl.setPower(speed);
            fr.setPower(-speed/* *2 */);
            br.setPower(-speed);
            }
        // no move
//        else {
//            fl.setPower(0);
//            bl.setPower(0);
//            fr.setPower(0);
//            br.setPower(0);
//        }

    telemetry.addData("right stick x", gamepad1.right_stick_x);
    telemetry.addData("right stick y", gamepad1.right_stick_y);
    }

}
