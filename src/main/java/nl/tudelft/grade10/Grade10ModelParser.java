package nl.tudelft.grade10;

import nl.tudelft.granula.modeller.Type;
import nl.tudelft.granula.modeller.platform.Platform;
import nl.tudelft.granula.modeller.platform.operation.Operation;
import nl.tudelft.granula.modeller.rule.derivation.DerivationRule;

public class Grade10ModelParser extends DerivationRule {

    public Grade10ModelParser(int level) {
        super(level);
    }

    @Override
    public boolean execute() {

        Platform platform = (Platform) entity;

        try {
            Operation processGraph = platform.findOperation(Type.Giraph, Type.ProcessGraph);
            long processingTime = Long.parseLong(processGraph.getInfo("Duration").getValue());

            System.out.println("Processing time of this job:" + processingTime);
        } catch (Exception e) {
            System.out.println(String.format("Failed to Parse Grade10 Model.", e.toString()));
        }
        return true;
    }
}
