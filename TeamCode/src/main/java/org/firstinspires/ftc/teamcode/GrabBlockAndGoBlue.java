package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "GrabBlockAndGoBlue")
public class GrabBlockAndGoBlue extends LinearOpMode {
    DcMotor left, right;
    Servo wrist,flip;
    @Override
    public void runOpMode() throws InterruptedException{
        right = hardwareMap.dcMotor.get("right");
        left = hardwareMap.dcMotor.get("left");
        wrist = hardwareMap.servo.get("wrist");
        flip = hardwareMap.servo.get("flip");

        right.setDirection(DcMotor.Direction.REVERSE);

        ResetEncoder();
        waitForStart();
        FlipDown();
        WristOpen();
        DriveForwardDistance(IAmSpeed, IAmSpeed, 660, 660);
        ResetEncoder();
        WristClose();
        TurnLeftDistance(TestSpeed, TestSpeed, 340, -340);
        ResetEncoder();
        DriveForwardDistance(IAmSpeed,IAmSpeed, 1000, 1000);
        DriveBackwardDistance(TestSpeed,TestSpeed,200,200);
        ResetEncoder();
        WristOpenKinda();
        TurnLeftDistance(TestSpeed,TestSpeed, 590, -590);
        ResetEncoder();
        WristClose();
        DriveForwardDistance(IAmSpeed,IAmSpeed, 1560, 1570);
        ResetEncoder();
        TurnLeftDistance(TestSpeed,TestSpeed, 350,-350);
        ResetEncoder();
        WristOpen();
        DriveForwardDistance(TestSpeed,TestSpeed,200,200);
        WristClose();
        ResetEncoder();
        TurnLeftDistance(TestSpeed,TestSpeed, 355,-355);
        ResetEncoder();
        DriveForwardDistance(IAmSpeed,IAmSpeed,1500,1500);
        ResetEncoder();
        WristOpenKinda();
        TurnLeftDistance(TestSpeed,TestSpeed,600,-600);
        ResetEncoder();
        DriveForwardDistance(TestSpeed,TestSpeed,300,300);
    }
    double TestSpeed = 0.5;
    double IAmSpeed = 1;
    public void DriveForwardDistance (double power1, double power2, int distance1, int distance2){
        int Cur_Location1 = right.getCurrentPosition();
        int Cur_Location2 = left.getCurrentPosition();
        int i=3;
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        left.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setTargetPosition((Cur_Location1+distance1));
        left.setTargetPosition(Cur_Location2+distance2);
        right.setPower(power1);
        left.setPower(power2);
        while (opModeIsActive() && (right.getCurrentPosition())>distance2){

            telemetry.addData("d1", distance1);
            telemetry.addData("d2", distance2);

            telemetry.addData("left encoder", left.getCurrentPosition());
            telemetry.addData("right encoder", right.getCurrentPosition());
            telemetry.update();

        }
        left.setPower(0);
        right.setPower(0);

    }
    public void TurnLeftDistance (double power1, double power2, int distance1, int distance2){
        int Cur_Location1 = right.getCurrentPosition();
        int Cur_Location2 = left.getCurrentPosition();
        int i=3;
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        left.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setTargetPosition((Cur_Location1+distance1));
        left.setTargetPosition(Cur_Location2+distance2);
        right.setPower(power1);
        left.setPower(power2);
        while (opModeIsActive() && (left.getCurrentPosition())<distance2){

            telemetry.addData("d1", distance1);
            telemetry.addData("d2", distance2);

            telemetry.addData("left encoder", left.getCurrentPosition());
            telemetry.addData("right encoder", right.getCurrentPosition());
            telemetry.update();

        }
        left.setPower(0);
        right.setPower(0);

    }
    public void DriveBackwardDistance (double power1, double power2, int distance1, int distance2){
        int Cur_Location1 = right.getCurrentPosition();
        int Cur_Location2 = left.getCurrentPosition();
        int i=3;
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        left.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setTargetPosition((Cur_Location1-distance1));
        left.setTargetPosition(Cur_Location2-distance2);
        right.setPower(power1);
        left.setPower(power2);
        while (opModeIsActive() && (left.getCurrentPosition()-1)<distance2){

            telemetry.addData("d1", distance1);
            telemetry.addData("d2", distance2);

            telemetry.addData("left encoder", left.getCurrentPosition());
            telemetry.addData("right encoder", right.getCurrentPosition());
            telemetry.update();

        }
        left.setPower(0);
        right.setPower(0);

    }
    public void WristOpen () {
        wrist.setPosition(0);
    }
    public void WristOpenKinda () {
        wrist.setPosition(.5);
    }
    public void WristClose () {
        wrist.setPosition(1);
    }
    public void FlipDown () {
        flip.setPosition(1);
    }
    public void ResetEncoder () {
        left.setMode(DcMotor.RunMode.RESET_ENCODERS);
        right.setMode(DcMotor.RunMode.RESET_ENCODERS);
    }
}
