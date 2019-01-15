package processengine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CallConfigureDrone implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        
        // Mit Camel "Lieferschein" - von Queue nehmen und die aufgeführten Variablen setzen, 
        // um in die Werte in der User-Task: 'Drohne für Lieferung konfigurieren' anzuzeigen/zu bestätigen. 
        
        execution.setVariable("vorname", "Max");
        execution.setVariable("nachname", "Mustermann");
        execution.setVariable("strasse", "Bei den Elben");
        execution.setVariable("stadt", "Bruchtal");
        execution.setVariable("gesamtgewicht", 12);
    }   

}
