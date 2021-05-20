package fuzzy.variables;

import fuzzy.operators.interfaces.ILinguisticVariable;

public class LinguisticAge implements ILinguisticVariable {
    public int value;
    public String linguisticValue;
    public LinguisticAge(int age) {
        this.value = age;

        if(value > 25) {
            this.linguisticValue = "old";
        } else {
            this.linguisticValue = "young";
        }
    }

    @Override
    public String returnStringValue() {
        return this.linguisticValue;
    }
}
