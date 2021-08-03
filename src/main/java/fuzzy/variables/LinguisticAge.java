package fuzzy.variables;

public class LinguisticAge implements ILinguisticVariable {
    private int value;
    private String linguisticValue;
    public LinguisticAge(int age) {
        this.value = age;

        if(value > 25) {
            this.linguisticValue = "old";
        } else {
            this.linguisticValue = "young";
        }
    }

    @Override
    public String linguisticValue() {
        return this.linguisticValue;
    }
}
