package profile.fields;

public class FarmingSkillField extends SkillField{
    public FarmingSkillField(String jsonPath, double max) {
        super(jsonPath, max);
    }

    @Override
    public double getWeight()
    {
        return (Math.min(50,Math.floor(getLevel()))-50)*5+1.5*getLevel()*(Math.exp((0.005d+0.0021d*max)*getLevel())-1)
                +((20d*max)/(1+Math.exp(-0.1*(getOverflow()/1000000d))))-max*10d;
    }
}
