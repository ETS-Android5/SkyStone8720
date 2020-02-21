package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="OmnibotTele", group="Omnibot")
public class Olivia_learning extends LinearOpMode {


    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor FLDrive = null;
    private DcMotor FRDrive = null;
    private DcMotor BLDrive = null;
    private DcMotor BRDrive = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        FLDrive = hardwareMap.get(DcMotor.class, "fld");
        FRDrive = hardwareMap.get(DcMotor.class, "frd");
        BLDrive = hardwareMap.get(DcMotor.class, "bld");
        BRDrive = hardwareMap.get(DcMotor.class, "brd");

        FLDrive.setDirection(DcMotor.Direction.FORWARD);
        FRDrive.setDirection(DcMotor.Direction.REVERSE);
        BLDrive.setDirection(DcMotor.Direction.FORWARD);
        BRDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {






        }


    }   }
