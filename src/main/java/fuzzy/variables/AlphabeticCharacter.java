package fuzzy.variables;

public class AlphabeticCharacter {
    public String value;
    public String kind;
    public AlphabeticCharacter(String value) {
        this.value = value;
        switch (value) {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                this.kind = "vowel";
                break;
            default:
                this.kind = "consonant";
        }
    }

    @Override
    public String toString() {
        return "AlphabeticCharacter{" +
                "value='" + value + '\'' +
                ", kind='" + kind + '\'' +
                '}';
    }
}
