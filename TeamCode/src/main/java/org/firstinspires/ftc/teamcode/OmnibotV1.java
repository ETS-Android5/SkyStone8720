package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
@SuppressWarnings("unused")
@TeleOp(name="OmnibotTele", group="Omnibot")
public class OmnibotV1 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor FleftDrive = null;
    private DcMotor FrightDrive = null;
    private DcMotor BleftDrive = null;
    private DcMotor BrightDrive = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        FleftDrive  = hardwareMap.get(DcMotor.class, "fld");
        FrightDrive = hardwareMap.get(DcMotor.class, "frd");
        BleftDrive  = hardwareMap.get(DcMotor.class, "bld");
        BrightDrive = hardwareMap.get(DcMotor.class, "brd");

        FleftDrive.setDirection(DcMotor.Direction.FORWARD);
        FrightDrive.setDirection(DcMotor.Direction.REVERSE);
        BleftDrive.setDirection(DcMotor.Direction.FORWARD);
        BrightDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            float Forwardbackward = -gamepad1.left_stick_y;
            float Leftright = gamepad1.left_stick_x;
            float Spin = gamepad1.right_stick_x;


            float FleftPower = -Forwardbackward - Leftright - Spin;
            float FrightPower = Forwardbackward - Leftright - Spin;
            float BrightPower = Forwardbackward + Leftright - Spin;
            float BleftPower = -Forwardbackward + Leftright - Spin;

            FrightPower = Range.clip(FrightPower, -1, 1);
            FleftPower = Range.clip(FleftPower, -1, 1);
            BleftPower = Range.clip(BleftPower, -1, 1);
            BrightPower = Range.clip(BrightPower, -1, 1);

            FleftDrive.setPower(FleftPower);
            FrightDrive.setPower(FrightPower);
            BleftDrive.setPower(BleftPower);
            BrightDrive.setPower(BrightPower);

            telemetry.addData("Text", "*** Robot Data***");
            telemetry.addData("Joy XL YL XR",  String.format("%.2f", Leftright) + " " +
                    String.format("%.2f", Forwardbackward) + " " +  String.format("%.2f", Spin));
            telemetry.addData("f left pwr",  "front left  pwr: " + String.format("%.2f", FleftPower));
            telemetry.addData("f right pwr", "front right pwr: " + String.format("%.2f", FrightPower));
            telemetry.addData("b right pwr", "back right pwr: " + String.format("%.2f", BrightPower));
            telemetry.addData("b left pwr", "back left pwr: " + String.format("%.2f", BleftPower));


        }


        }
        double scaleInput(double dVal)  {
            double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                    0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

            int index = (int) (dVal * 16.0);

            if (index < 0) {
                index = -index;
            }

            if (index > 16) {
                index = 16;
            }

            double dScale = 0.0;
            if (dVal < 0) {
                dScale = -scaleArray[index];
            } else {
                dScale = scaleArray[index];
            }

            return dScale; }




    }
