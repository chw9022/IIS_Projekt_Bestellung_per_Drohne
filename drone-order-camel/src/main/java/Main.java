import adapter.CamundaMessageAdapter;

// #######################################
// Author: Felix Ziegner
// #######################################
public class Main {

	public static void main(String[] args) throws Exception {
		CamelApp ca = new CamelApp();
		ca.start();
		CamundaMessageAdapter camundaMessageAdapter = new CamundaMessageAdapter();
		camundaMessageAdapter.start();
	}
}
