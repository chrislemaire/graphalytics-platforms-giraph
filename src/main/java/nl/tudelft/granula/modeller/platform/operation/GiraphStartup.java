/*
 * Copyright 2015 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.tudelft.granula.modeller.platform.operation;

import nl.tudelft.granula.modeller.Type;
import nl.tudelft.granula.modeller.platform.info.BasicInfo;
import nl.tudelft.granula.modeller.platform.info.Info;
import nl.tudelft.granula.modeller.platform.info.InfoSource;
import nl.tudelft.granula.modeller.platform.info.Source;
import nl.tudelft.granula.modeller.rule.derivation.ColorDerivation;
import nl.tudelft.granula.modeller.rule.derivation.DerivationRule;
import nl.tudelft.granula.modeller.rule.derivation.FilialCompletenessDerivation;
import nl.tudelft.granula.modeller.rule.derivation.SimpleSummaryDerivation;
import nl.tudelft.granula.modeller.rule.derivation.time.DurationDerivation;
import nl.tudelft.granula.modeller.rule.derivation.time.FilialEndTimeDerivation;
import nl.tudelft.granula.modeller.rule.derivation.time.FilialStartTimeDerivation;
import nl.tudelft.granula.modeller.rule.derivation.time.JobStartTimeDerivation;
import nl.tudelft.granula.modeller.rule.linking.UniqueParentLinking;

import java.util.ArrayList;
import java.util.List;

public class GiraphStartup extends AbstractOperationModel {

    public GiraphStartup() {
        super(Type.Giraph, Type.Startup);
    }

    public void loadRules() {
        super.loadRules();
        addLinkingRule(new UniqueParentLinking(Type.Giraph, Type.Job));

        addInfoDerivation(new JobStartTimeDerivation(1));
        addInfoDerivation(new FilialEndTimeDerivation(5));
        addInfoDerivation(new DurationDerivation(6));
        this.addInfoDerivation(new FilialCompletenessDerivation(2));

        String summary = "Prepare.";
        addInfoDerivation(new SimpleSummaryDerivation(11, summary));

        addInfoDerivation(new ColorDerivation(11, "#666"));
    }

}

