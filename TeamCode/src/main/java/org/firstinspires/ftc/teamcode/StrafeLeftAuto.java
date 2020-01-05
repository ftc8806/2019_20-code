package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "StrafeLeftPark")
public class StrafeLeftAuto extends LinearOpMode {
    DcMotor fr, fl, br, bl;

    @Override
    public void runOpMode() throws InterruptedException {
        fr = hardwareMap.dcMotor.get("fright");
        fl = hardwareMap.dcMotor.get("fleft");
        br = hardwareMap.dcMotor.get("bright");
        bl = hardwareMap.dcMotor.get("bleft");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        //Change Forward Distance Short = 200 Long = ???
        DriveForwardDistance(TestSpeed, 200);
        StrafeLeftDistance(TestSpeed,900);


    }

    double TestSpeed = 0.5;

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

        fr.setTargetPosition(distance);
        fl.setTargetPosition(distance);
        br.setTargetPosition(distance);
        bl.setTargetPosition(distance);

        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        DriveForward(power);

        while (fr.isBusy() && fl.isBusy() && br.isBusy() && bl.isBusy()) {

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

        fr.setTargetPosition(distance);
        fl.setTargetPosition(distance);
        br.setTargetPosition(distance);
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

    public void StopDriving() {
        DriveForward(0);
    }
}

