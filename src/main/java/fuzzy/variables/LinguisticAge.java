package fuzzy.variables;

import java.io.Serializable;

public class LinguisticAge {
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
    public String toString() {
        return this.linguisticValue;
    }
}
