package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;

public class FloorIntake extends Command {
  private static Intake m_intake;

  public FloorIntake(Intake m_intake) {
    FloorIntake.m_intake = m_intake;
    setName("FloorIntake");
    addRequirements(m_intake);
  }

  @Override
  public void initialize() {
    m_intake.startIntake();
  }

  @Override
  public void execute(){
    SmartDashboard.putBoolean("Has Note", m_intake.hasNote());
  }

  @Override
  public void end(boolean interrupted) {
    m_intake.stopIntake();
    new HoldNoteIntake(m_intake).schedule();
  }

  @Override
  public boolean isFinished() {
    //return m_intake.hasNote();
    return false;
  }
}
