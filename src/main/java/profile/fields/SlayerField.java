package profile.fields;

public class SlayerField extends Field<Integer> {

    public static final int[] EXPERIENCE_REQUIRED = {10, 30, 250, 1500, 5000, 20000, 100000, 400000, 1000000};

    public int max;

    public SlayerField(String jsonPath, int max) {
        super(jsonPath);
        this.max = max;
        this.value = 0;
    }

    @Override
    public double getWeight() {
        double weight = 0d;
        for(int i=1; i<=getLevel(); i++) {
            weight += max*(1d-Math.abs(getLevel()-9d)/9d);
        }
        weight += 10d/3d*max/(1d+Math.exp(-0.15d*getOverflow()/1000000d))-5d/3d*max;
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
