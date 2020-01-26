package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name = "StrafeRightPark")
public class StrafeRightAuto extends LinearOpMode{
    DcMotor fr, fl, br, bl;
    @Override
    public void runOpMode() throws InterruptedException{
        fr = hardwareMap.dcMotor.get("fright");
        fl = hardwareMap.dcMotor.get("fleft");
        br = hardwareMap.dcMotor.get("bright");
        bl = hardwareMap.dcMotor.get("bleft");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        ResetEncoder();
        waitForStart();
        sleep(15000);
        //Change Forward Distance Short = 200 Long = 1600
        //DriveForward(TestSpeed);
        DriveForwardDistance(TestSpeed, 200);
        //wait(2000);
        StrafeRightDistance(TestSpeed, 1200);


    }
    double TestSpeed = 0.5;
    public void DriveForward (double power) {
        fr.setPower(power);
        fl.setPower(power);
        br.setPower(power);
        bl.setPower(power);
    }
    public void DriveForwardDistance (double power, int distance) {
        //fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        //fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        //br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        //bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

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

        while (fr.isBusy() && fl.isBusy() && br.isBusy() && bl.isBusy()){
        telemetry.addData("distance", distance);
        telemetry.addData("fl", fl.getCurrentPosition());
        telemetry.addData("fr", fr.getCurrentPosition());
        telemetry.addData("bl", bl.getCurrentPosition());
        telemetry.addData("br", br.getCurrentPosition());
        telemetry.update();
        }
        StopDriving();
//        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
//        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
//        br.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
//        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    }
    public void StrafeRightDistance (double power, int distance){
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

        while (fr.isBusy() && fl.isBusy() && br.isBusy() && bl.isBusy()){

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
    public void ResetEncoder () {
        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);
    }
}