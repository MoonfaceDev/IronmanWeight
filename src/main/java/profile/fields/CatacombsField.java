package profile.fields;

public class CatacombsField extends SimpleField<Number> {

    public static final int[] EXPERIENCE_REQUIRED = {
            50, 75, 110, 160, 230, 330, 470, 670, 950, 1340,
            1890, 2665, 3760, 5260, 7380, 10300, 14400, 20000, 27600, 38000,
            52500, 71500, 97000, 132000, 180000, 243000, 328000, 445000, 600000, 800000,
            1065000, 1410000, 1900000, 2500000, 3300000, 4300000, 5600000, 7200000, 9200000, 12000000,
            15000000, 19000000, 24000000, 30000000, 38000000, 48000000, 60000000, 75000000, 93000000, 116250000
    };

    public CatacombsField(String jsonPath) {
        super(jsonPath);
        this.value = 0d;
    }

    @Override
    public double getWeight() {
        return 22*Math.exp(0.085d*getLevel())-22
                +600d/(1+5*Math.exp(-0.007d*getOverflow()/1000000d))-100d;
    }

    public double getLevel() {
        double totalXP = value.doubleValue();
        int level = 0;
        while (level < EXPERIENCE_REQUIRED.length && totalXP >= EXPERIENCE_REQUIRED[level]) {
            totalXP -= EXPERIENCE_REQUIRED[level];
            level++;
        }
        if(level == EXPERIENCE_REQUIRED.length) {
            return level;
        }
        return level+totalXP/EXPERIENCE_REQUIRED[level];
    }

    public double getOverflow() {
        double totalSkillXP = 0d;
        for (int requiredXP : EXPERIENCE_REQUIRED) {
            totalSkillXP += requiredXP;
        }
        return Math.max(0, value.doubleValue()-totalSkillXP);
    }
}
