package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@Autonomous(name = "LIFTONLY")
public class LiftONLYAuto extends LinearOpMode {
    DcMotor fr, fl, br, bl, lift;
    Servo latch,wrist;
    @Override
    public void runOpMode() throws InterruptedException {
        fr = hardwareMap.dcMotor.get("fright");
        fl = hardwareMap.dcMotor.get("fleft");
        br = hardwareMap.dcMotor.get("bright");
        bl = hardwareMap.dcMotor.get("bleft");
        lift = hardwareMap.dcMotor.get("lift");

        latch = hardwareMap.servo.get("latch");
        wrist = hardwareMap.servo.get("wrist");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        ResetEncoder();
        waitForStart();
//        DriveForwardDistance(TestSpeed, 1400);
//        StrafeLeftDistance(TestSpeed,200);
//        wrist.setPosition(0);
//        sleep(1000);
//        DriveForwardDistance(TestSpeed,500);
//        wrist.setPosition(1);
//        sleep(1000);
//        //LiftUp(LiftSpeed, 100);
//        DriveForwardDistance(TestSpeed,-500);
//        StrafeRightDistance(TestSpeed, 3200); //2900 original
        //DriveForwardDistance(TestSpeed, 600);
        LiftUp(-LiftSpeed, 400);
       // sleep(1000);
       // LiftUp(LiftSpeed,-200);
//        wrist.setPosition(0);
//        sleep(1000);
//        DriveForwardDistance(TestSpeed,-700);
//        wrist.setPosition(1);
//        sleep(1000);
//        StrafeLeftDistance(TestSpeed, 3900);
//        wrist.setPosition(0);
//        sleep(1000);
//        DriveForwardDistance(TestSpeed,600);
//        wrist.setPosition(1);
//        sleep(1000);
//        //LiftUp(LiftSpeed, 100);
//        DriveForwardDistance(TestSpeed,-700);
//        StrafeRightDistance(TestSpeed, 3900);
//        DriveForwardDistance(TestSpeed,500);
//        //LiftUp(LiftSpeed, -100);
//        wrist.setPosition(0);
//        sleep(1000);
//        DriveForwardDistance(TestSpeed,-500);
//        wrist.setPosition(1);
//        sleep(1000);
//        StrafeLeftDistance(TestSpeed,900);
//        DriveForwardDistance(TestSpeed,100);
    }

    double TestSpeed = 0.7;
    double LiftSpeed = 0.4;

    public void DriveForward(double power) {
        fr.setPower(power);
        fl.setPower(power);
        br.setPower(power);
        bl.setPower(power);
    }

    public void DriveForwardDistance(double power, int distance) {
        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

        fr.setTargetPosition(distance);
        fl.setTargetPosition(distance);
        br.setTargetPosition(distance);
        bl.setTargetPosition(distance);

        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fr.setPower(power);
        fl.setPower(power);
        br.setPower(power);
        bl.setPower(power);

        while (fr.isBusy() && fl.isBusy() && br.isBusy() && bl.isBusy()) {
            telemetry.addData("distance", distance);
            telemetry.addData("fl", fl.getCurrentPosition());
            telemetry.addData("fr", fr.getCurrentPosition());
            telemetry.addData("bl", bl.getCurrentPosition());
            telemetry.addData("br", br.getCurrentPosition());
            telemetry.update();
        }
        StopDriving();
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    }

    public void StrafeRightDistance(double power, int distance) {
        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        fr.setTargetPosition(-distance);
        fl.setTargetPosition(distance);
        br.setTargetPosition(distance);
        bl.setTargetPosition(-distance);

        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fr.setPower(-power);
        fl.setPower(power);
        br.setPower(power);
        bl.setPower(-power);

        while (fr.isBusy() && fl.isBusy() && br.isBusy() && bl.isBusy()) {

        }

        StopDriving();
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    }

    public void StrafeLeftDistance(double power, int distance) {
        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        fr.setTargetPosition(distance);
        fl.setTargetPosition(-distance);
        br.setTargetPosition(-distance);
        bl.setTargetPosition(distance);

        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fr.setPower(power);
        fl.setPower(-power);
        br.setPower(-power);
        bl.setPower(power);

        while (fr.isBusy() && fl.isBusy() && br.isBusy() && bl.isBusy()) {

        }
        StopDriving();
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    }
    public void SpinRight (double power, int distance) {
        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        fr.setTargetPosition(-distance);
        fl.setTargetPosition(distance);
        br.setTargetPosition(-distance);
        bl.setTargetPosition(distance);

        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fr.setPower(-power);
        fl.setPower(power);
        br.setPower(-power);
        bl.setPower(power);

        while (fr.isBusy() && fl.isBusy() && br.isBusy() && bl.isBusy()) {

        }
        StopDriving();
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    }

    public void SpinLeft (double power, int distance) {
        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        fr.setTargetPosition(distance);
        fl.setTargetPosition(-distance);
        br.setTargetPosition(distance);
        bl.setTargetPosition(-distance);

        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fr.setPower(power);
        fl.setPower(-power);
        br.setPower(power);
        bl.setPower(-power);

        while (fr.isBusy() && fl.isBusy() && br.isBusy() && bl.isBusy()) {

        }
        StopDriving();
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    }

    public void LiftUp (double power, int distance) {
        lift.setMode(DcMotor.RunMode.RESET_ENCODERS);

        lift.setTargetPosition(distance);

        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        lift.setPower(power);

        while (lift.isBusy() && lift.getCurrentPosition()>-distance) {
            telemetry.addData("setpoint",distance);
        telemetry.addData("liftPos", lift.getCurrentPosition());
        telemetry.update();
        }
        StopDriving();
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    }


    public void StopDriving() {
        DriveForward(0);
    }

    public void ResetEncoder() {
        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        lift.setMode(DcMotor.RunMode.RESET_ENCODERS);
    }
}
