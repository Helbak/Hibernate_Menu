package menuHibernate;

public class CalculatorWeight {
    private  Long sumWeight;
    private Long weight;

    public CalculatorWeight() {

    }

    public Long getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(Long sumWeight) {
        this.sumWeight = sumWeight;
    }
    public void addWeight(Long weight){
        if(sumWeight==null){
            sumWeight=weight;
        }
        if(sumWeight!=null) {
            sumWeight = sumWeight + weight;
        }
    }
}
