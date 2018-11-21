package utils;
import utils.Prop;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Start
{
	public static void main(String[] args)
	{
		Runtime rt = Runtime.instance();
		Profile p = new ProfileImpl();
		String sn_a = Prop.getProperty("sn_a");
		String rn_a = Prop.getProperty("rn_a");
		String ac_a = Prop.getProperty("ac_a");
		ContainerController cc = rt.createMainContainer(p);
        
		try {
			AgentController ac = cc.createNewAgent(sn_a, "smarthome.agent.SensorAgent", null);
			AgentController ac2 = cc.createNewAgent(rn_a, "smarthome.agent.ReasonerAgent", null);
			AgentController ac3 = cc.createNewAgent(ac_a, "smarthome.agent.ActuatorAgent", null);
			ac.start();
			ac2.start();
			ac3.start();
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
