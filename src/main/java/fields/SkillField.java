package fields;

public class SkillField extends Field<Double>{

    public static final int[] EXPERIENCE_REQUIRED = {
            50, 125, 200, 300, 500, 750, 1000, 1500, 2000, 3500,
            5000, 7500, 10000, 15000, 20000, 30000, 50000, 75000, 100000, 200000,
            300000, 400000, 500000, 600000, 700000, 800000, 900000, 1000000, 1100000, 1200000,
            1300000, 1400000, 1500000, 1600000, 1700000, 1800000, 1900000, 2000000, 2100000, 2200000,
            2300000, 2400000, 2500000, 2600000, 2750000, 2900000, 3100000, 3400000, 3700000, 4000000,
            4300000, 4600000, 4900000, 5200000, 5500000, 5800000, 6100000, 6400000, 6700000, 7000000
    };

    public int max;

    public SkillField(String jsonPath, int max) {
        super(jsonPath);
        this.max = max;
    }

    @Override
    public double getWeight() {
        double weight = 0d;
        for (int i=1;i<=getLevel()-1;i++) {
            weight += max * (1d - (Math.abs(i - 50d)) / (50d));
        }
        weight += max * (1d - (Math.abs(getLevel() - 50d)) / (50d));
        weight=weight+((20d*max)/(1+Math.exp(-0.1*(getOverflow()/1000000d))))-max*10d;
        return weight;
    }

    public double getLevel() {
        double totalXP = value;
        int level = 0;
        while (level < EXPERIENCE_REQUIRED.length && totalXP >= EXPERIENCE_REQUIRED[level]) {
            totalXP -= EXPERIENCE_REQUIRED[level];
            level++;
        }
        if(level == EXPERIENCE_REQUIRED.length) {
            totalXP = 0;
        }
        return level+totalXP/EXPERIENCE_REQUIRED[level-1];
    }

    public double getOverflow() {
        double totalSkillXP = 0;
        for (int requiredXP : EXPERIENCE_REQUIRED) {
            totalSkillXP += requiredXP;
        }
        return Math.max(0, value-totalSkillXP);
    }
}
