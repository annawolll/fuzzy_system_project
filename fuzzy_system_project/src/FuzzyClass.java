import fuzzlib.DefuzMethod;
import fuzzlib.FuzzySet;
import fuzzlib.norms.SNorm;
import fuzzlib.norms.TNorm;
import fuzzlib.reasoning.ReasoningSystem;
import fuzzlib.reasoning.SystemConfig;

public class FuzzyClass {
private int coughingValue = 0;
private int feverValue = 0;
private int breathingValue = 0;

    public FuzzyClass(int coughingValue, int feverValue, int breathingValue) {
        this.coughingValue = coughingValue;
        this.feverValue = feverValue;
        this.breathingValue = breathingValue;
    }

public double calculateInfectionRisk() throws Exception{
    ReasoningSystem rs1;
    FuzzySet pCoughingVeryLow,pCoughingLow,pCoughingMedium,pCoughingHigh,pCoughingVeryHigh;
    FuzzySet pFeverVeryLow,pFeverLow,pFeverMedium,pFeverHigh,pFeverVeryHigh;
    FuzzySet pBreathVeryLow,pBreathLow, pBreathMedium,pBreathHigh,pBreathVeryHigh;
    FuzzySet cRiskVeryLow,cRiskLow,cRiskMedium, cRiskHigh,cRiskVeryHigh;

    //Assigning identificators
    pCoughingVeryLow = new FuzzySet("c_very_low","");
    pCoughingLow = new FuzzySet("c_low","");
    pCoughingMedium = new FuzzySet("c_medium","");
    pCoughingHigh = new FuzzySet("c_high","");
    pCoughingVeryHigh = new FuzzySet("c_very_high","");

    pFeverVeryLow = new FuzzySet("f_very_low","");
    pFeverLow = new FuzzySet("f_low","");
    pFeverMedium = new FuzzySet("f_medium","");
    pFeverHigh = new FuzzySet("f_high","");
    pFeverVeryHigh = new FuzzySet("f_very_high","");

    pBreathVeryLow = new FuzzySet("b_very_low","");
    pBreathLow = new FuzzySet("b_low","");
    pBreathMedium= new FuzzySet("b_medium","");
    pBreathHigh = new FuzzySet("b_high","");
    pBreathVeryHigh = new FuzzySet("b_very_high","");

    cRiskVeryLow = new FuzzySet("r_very_low","");
    cRiskLow = new FuzzySet("r_low","");
    cRiskMedium = new FuzzySet("r_medium","");
    cRiskHigh=new FuzzySet("r_high","");
    cRiskVeryHigh= new FuzzySet("r_very_high", "");

    //Defining content of sets
    pFeverVeryLow.addPoint(0,0);
    pFeverVeryLow.addPoint(10,1);
    pFeverVeryLow.addPoint(20,0);
    pFeverLow.addPoint(20,0);
    pFeverLow.addPoint(30,1);
    pFeverLow.addPoint(40,0);
    pFeverMedium.addPoint(40,0);
    pFeverMedium.addPoint(50,1);
    pFeverMedium.addPoint(60,0);
    pFeverHigh.addPoint(60,0);
    pFeverHigh.addPoint(70,1);
    pFeverHigh.addPoint(80,0);
    pFeverVeryHigh.addPoint(80,0);
    pFeverVeryHigh.addPoint(90,1);
    pFeverVeryHigh.addPoint(100,0);

    pCoughingVeryLow.addPoint(0,0);
    pCoughingVeryLow.addPoint(10,1);
    pCoughingVeryLow.addPoint(20,0);
    pCoughingLow.addPoint(20,0);
    pCoughingLow.addPoint(30,1);
    pCoughingLow.addPoint(40,0);
    pCoughingMedium.addPoint(40,0);
    pCoughingMedium.addPoint(50,1);
    pCoughingMedium.addPoint(60,0);
    pCoughingHigh.addPoint(60,0);
    pCoughingHigh.addPoint(70,1);
    pCoughingHigh.addPoint(80,0);
    pCoughingVeryHigh.addPoint(80,0);
    pCoughingVeryHigh.addPoint(90,1);
    pCoughingVeryHigh.addPoint(100,0);

    pBreathVeryLow.addPoint(0,0);
    pBreathVeryLow.addPoint(10,1);
    pBreathVeryLow.addPoint(20,0);
    pBreathLow.addPoint(20,0);
    pBreathLow.addPoint(30,1);
    pBreathLow.addPoint(40,0);
    pBreathMedium.addPoint(40,0);
    pBreathMedium.addPoint(50,1);
    pBreathMedium.addPoint(60,0);
    pBreathHigh.addPoint(60,0);
    pBreathHigh.addPoint(70,1);
    pBreathHigh.addPoint(80,0);
    pBreathVeryHigh.addPoint(80,0);
    pBreathVeryHigh.addPoint(90,1);
    pBreathVeryHigh.addPoint(100,0);

    cRiskVeryLow.addPoint(0,0);
    cRiskVeryLow.addPoint(10,1);
    cRiskVeryLow.addPoint(20,0);
    cRiskLow.addPoint(20,0);
    cRiskLow.addPoint(30,1);
    cRiskLow.addPoint(40,0);
    cRiskMedium.addPoint(40,0);
    cRiskMedium.addPoint(50,1);
    cRiskMedium.addPoint(60,0);
    cRiskHigh.addPoint(60,0);
    cRiskHigh.addPoint(70,1);
    cRiskHigh.addPoint(80,0);
    cRiskVeryHigh.addPoint(80,0);
    cRiskVeryHigh.addPoint(90,1);
    cRiskVeryHigh.addPoint(100,0);

    //System configurations
    SystemConfig config = new SystemConfig();
    config.setInputWidth(3); // 3 inputs
    config.setOutputWidth(1);// 1 input
    config.setNumberOfPremiseSets(15); // number of premises definitions
    config.setNumberOfConclusionSets(5); // number of conclusions definitions

    config.setIsOperationType( TNorm.TN_PRODUCT );
    config.setAndOperationType(  TNorm.TN_MINIMUM  );
    config.setOrOperationType( SNorm.SN_PROBABSUM );
    config.setImplicationType( TNorm.TN_MINIMUM); //TNorm as implication
    config.setConclusionAgregationType(SNorm.SN_PROBABSUM);// SNorm as aggregation
    config.setAutoDefuzzyfication(false);
    config.setDefuzzyfication( DefuzMethod.DF_COG );
    config.setAutoAlpha(true);

    FuzzySet fuzzyfier = new FuzzySet();
    fuzzyfier.newTriangle(0, 0.01);

    rs1 = new ReasoningSystem(config);
    rs1.getInputVar(0).id = "fever";
    rs1.getInputVar(1).id = "cough";
    rs1.getInputVar(2).id = "breath";

    rs1.getOutputVar(0).id = "risk";

    //Adding premises and conclusions
    rs1.addPremiseSet(pCoughingVeryLow);
    rs1.addPremiseSet(pCoughingLow);
    rs1.addPremiseSet(pCoughingMedium);
    rs1.addPremiseSet(pCoughingHigh);
    rs1.addPremiseSet(pCoughingVeryHigh);
    rs1.addPremiseSet(pFeverVeryLow);
    rs1.addPremiseSet(pFeverLow);
    rs1.addPremiseSet(pFeverMedium);
    rs1.addPremiseSet(pFeverHigh);
    rs1.addPremiseSet(pFeverVeryHigh);
    rs1.addPremiseSet(pBreathVeryLow);
    rs1.addPremiseSet(pBreathLow);
    rs1.addPremiseSet(pBreathMedium);
    rs1.addPremiseSet(pBreathHigh);
    rs1.addPremiseSet(pBreathVeryHigh);
    rs1.addConclusionSet(cRiskVeryLow);
    rs1.addConclusionSet(cRiskLow);
    rs1.addConclusionSet(cRiskMedium);
    rs1.addConclusionSet(cRiskHigh);
    rs1.addConclusionSet(cRiskVeryHigh);

    //Adding rules
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_very_low","AND","cough","c_very_low");
    rs1.addRuleItem("breath","b_very_low","AND", "cough","c_very_low");
    rs1.addRuleItem("breath","b_very_low","AND", "fever","f_very_low");
    rs1.addRuleConclusion("risk","r_very_low");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_very_low","AND","cough","c_low");
    rs1.addRuleItem("breath","b_low","AND","cough","c_low");
    rs1.addRuleItem("breath","b_low","AND","fever","f_very_low");
    rs1.addRuleConclusion("risk","r_very_low");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_low","AND","cough","c_very_low");
    rs1.addRuleItem("breath","b_low","AND","cough","c_very_low");
    rs1.addRuleItem("breath","b_low","AND","fever","f_low");
    rs1.addRuleConclusion("risk","r_very_low");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_low","AND","cough","c_medium");
    rs1.addRuleItem("breath","b_low","AND","cough","c_medium");
    rs1.addRuleItem("fever","f_low","AND","breath","b_low");
    rs1.addRuleConclusion("risk","r_low");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_low","AND","cough","c_medium");
    rs1.addRuleItem("breath","b_medium","AND","cough","c_medium");
    rs1.addRuleItem("fever","f_low","AND","breath","b_medium");
    rs1.addRuleConclusion("risk","r_low");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_medium","AND","cough","c_medium");
    rs1.addRuleItem("breath","b_medium","AND","cough","c_medium");
    rs1.addRuleItem("fever","f_medium","AND","breath","b_medium");
    rs1.addRuleConclusion("risk","r_medium");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_medium","AND","cough","c_low");
    rs1.addRuleItem("breath","b_medium","AND","cough","c_low");
    rs1.addRuleItem("fever","f_medium","AND","breath","b_medium");
    rs1.addRuleConclusion("risk","r_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_medium","AND","cough","c_high");
    rs1.addRuleItem("breath","b_low","AND","cough","c_high");
    rs1.addRuleItem("fever","f_medium","AND","breath","b_low");
    rs1.addRuleConclusion("risk","r_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_high","AND","cough","c_high");
    rs1.addRuleItem("breath","b_medium","AND","cough","c_high");
    rs1.addRuleItem("fever","f_high","AND","breath","b_medium");
    rs1.addRuleConclusion("risk","r_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_high","AND","cough","c_high");
    rs1.addRuleItem("breath","b_low","AND","cough","c_high");
    rs1.addRuleItem("fever","f_high","AND","breath","b_low");
    rs1.addRuleConclusion("risk","r_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_medium","AND","cough","c_high");
    rs1.addRuleItem("breath","b_high","AND","cough","c_high");
    rs1.addRuleItem("fever","f_medium","AND","breath","b_high");
    rs1.addRuleConclusion("risk","r_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_very_high","AND","cough","c_high");
    rs1.addRuleItem("breath","b_low","AND","cough","c_high");
    rs1.addRuleItem("fever","f_very_high","AND","breath","b_low");
    rs1.addRuleConclusion("risk","r_very_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_medium","AND","cough","c_very_high");
    rs1.addRuleItem("breath","b_medium","AND","cough","c_very_high");
    rs1.addRuleItem("fever","f_medium","AND","breath","b_medium");
    rs1.addRuleConclusion("risk","r_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_very_high","AND","cough","c_very_high");
    rs1.addRuleItem("breath","b_low","AND","cough","c_very_high");
    rs1.addRuleItem("fever","f_very_high","AND","breath","b_low");
    rs1.addRuleConclusion("risk","r_very_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_very_high","AND","cough","c_very_high");
    rs1.addRuleItem("breath","b_very_high","AND","cough","c_very_high");
    rs1.addRuleItem("fever","f_very_high","AND","breath","b_very_high");
    rs1.addRuleConclusion("risk","r_very_high");
    rs1.addRule(3,1);
    rs1.addRuleItem("fever","f_medium","AND","cough","c_high");
    rs1.addRuleItem("breath","b_very_high","AND","cough","c_high");
    rs1.addRuleItem("fever","f_medium","AND","breath","b_very_high");
    rs1.addRuleConclusion("risk","r_high");
    rs1.addRule(1,1);
    rs1.addRuleItem("fever","f_high","AND","cough","c_high");
    rs1.addRuleItem("breath","b_high","AND","cough","c_high");
    rs1.addRuleItem("fever","f_high","AND","breath","b_high");
    rs1.addRuleConclusion("risk","r_high");

    rs1.setInput(0,this.feverValue);
    rs1.setInput(1,this.coughingValue);
    rs1.setInput(2,this.breathingValue);
    rs1.Process();

    System.out.println("Wynik:" + rs1.getOutputVar(0).outset.DeFuzzyfy());
    return rs1.getOutputVar(0).outset.DeFuzzyfy();

}
}
