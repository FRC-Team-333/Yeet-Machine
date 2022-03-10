package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

public class LimitSwitch {
    
  private DigitalInput m_limitSwitch;
  private boolean m_hasLimitSwitchBeenPressed;
  private Joystick m_joystick;
    
  public LimitSwitch(DigitalInput limitSwitch_)
  {
      m_limitSwitch = limitSwitch_;
      m_hasLimitSwitchBeenPressed = false;
  }

  public boolean isPhysicalSwitchPressed()
  {
      return !m_limitSwitch.get();
  }

  public boolean get()
  {
      return get(false);
  }

  public boolean get(boolean isFireButtonPressed)
  {
      if (isPhysicalSwitchPressed()) {
        m_hasLimitSwitchBeenPressed = true;
      }
  
      if (isFireButtonPressed) {
        m_hasLimitSwitchBeenPressed = false;
      }

      return m_hasLimitSwitchBeenPressed;
  }

  public boolean shouldIgnoreLimitSwitch()
  {
      return m_joystick.getThrottle() >= 0.7;
  }
}
