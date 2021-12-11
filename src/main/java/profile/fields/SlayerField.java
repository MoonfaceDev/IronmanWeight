package profile.fields;

public class SlayerField extends Field<Integer> {

    public static final int[] EXPERIENCE_REQUIRED = {10, 30, 250, 1500, 5000, 20000, 100000, 400000, 1000000};

    public double max;
    public double overflowMax;

    public SlayerField(String jsonPath, double max, double overflowMax) {
        super(jsonPath);
        this.max = max;
        this.overflowMax = overflowMax;
        this.value = 0;
    }

    @Override
    public double getWeight() {
        return 1.5d*getLevel()*(Math.exp((0.02d+0.0195d*max)*getLevel())-1)
                +24d/overflowMax*max/(1+Math.exp(-0.8d*overflowMax*getOverflow()/1000000d))-12d/overflowMax*max;
    }

    public double getLevel() {
        double totalXP = value;
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
        return Math.max(0, value-totalSkillXP);
    }
}
