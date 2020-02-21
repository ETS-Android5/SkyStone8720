package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@SuppressWarnings("unused")
@TeleOp(name="bloob", group="bloob")
public class bloob extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor puller1 = null;
    private DcMotor turny = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        puller1 = hardwareMap.get(DcMotor.class, "p");
        turny = hardwareMap.get(DcMotor.class, "t");

        puller1.setDirection(DcMotor.Direction.FORWARD);
        turny.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            float pull = gamepad1.left_stick_y;
            float p1Power = pull;
            float tPower = gamepad1.right_stick_x;



            puller1.setPower(p1Power);
            turny.setPower(tPower);




        }
    }
}
