package invaid.users.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.RPCharacteristics;
import invaid.users.model.RiskProfileModel;

@SuppressWarnings({"serial"})
public class RiskProfileAction extends ActionSupport implements ModelDriven<RiskProfileModel>, RPCharacteristics {
	private RiskProfileModel rpModel = new RiskProfileModel();
	
	@Override
	public String execute() {
		int timeHorizonScore = 0, riskToleranceScore = 0;
		
		timeHorizonScore = rpModel.getTimeHorizon1() + rpModel.getTimeHorizon2();
		riskToleranceScore = rpModel.getRiskTolerance1() + rpModel.getRiskTolerance2() + rpModel.getRiskTolerance3() + rpModel.getRiskTolerance4() + rpModel.getRiskTolerance5();
		
		switch(evaluateScore(timeHorizonScore, riskToleranceScore)) {
			case 1: rpModel.setRiskProfileResult(CONSERVATIVE);
					rpModel.setRiskProfileObjectives(C_OBJ);
					rpModel.setRiskProfileHorizon(C_HORIZON);
					rpModel.setRiskProfileDesc(C_DESC); break;
			case 2: rpModel.setRiskProfileResult(MODERATELY_CONSERVATIVE);
					rpModel.setRiskProfileObjectives(MC_OBJ);
					rpModel.setRiskProfileHorizon(MC_HORIZON);
					rpModel.setRiskProfileDesc(MC_DESC); break;
			case 3: rpModel.setRiskProfileResult(MODERATE);
					rpModel.setRiskProfileObjectives(M_OBJ);
					rpModel.setRiskProfileHorizon(M_HORIZON);
					rpModel.setRiskProfileDesc(M_DESC); break;
			case 4: rpModel.setRiskProfileResult(MODERATELY_AGGRESSIVE);
					rpModel.setRiskProfileObjectives(MA_OBJ);
					rpModel.setRiskProfileHorizon(MA_HORIZON);
					rpModel.setRiskProfileDesc(MA_DESC); break;
			case 5: rpModel.setRiskProfileResult(AGGRESSIVE);
					rpModel.setRiskProfileObjectives(A_OBJ);
					rpModel.setRiskProfileHorizon(A_HORIZON);
					rpModel.setRiskProfileDesc(A_DESC); break;
			default: rpModel.setRiskProfileResult(NO_COMPATIBLE); rpModel.setRiskProfileObjectives("NONE"); rpModel.setRiskProfileHorizon("NONE"); rpModel.setRiskProfileDesc("NONE");
		}
		
		return SUCCESS;
	}
	
	@Override
	public RiskProfileModel getModel() {
		return rpModel;
	}
	
	private int evaluateScore(int timeHorizonScore, int riskToleranceScore) {		
		switch(timeHorizonScore) {
			case 1:
			case 2: return 0;
			case 3:
			case 4: if(riskToleranceScore < 19)
						return 1;
					else if(riskToleranceScore >= 19 && riskToleranceScore <= 31)
						return 2;
					else
						return 3;
			case 5: if(riskToleranceScore < 16)
						return 1;
					else if(riskToleranceScore >= 16 && riskToleranceScore <= 24)
						return 2;
					else if(riskToleranceScore >= 25 && riskToleranceScore <= 35)
						return 3;
					else
						return 4;
			case 7: 
			case 8:
			case 9: if(riskToleranceScore < 13)
						return 1;
					else if(riskToleranceScore >= 13 && riskToleranceScore <= 20)
						return 2;
					else if(riskToleranceScore >= 21 && riskToleranceScore <= 28)
						return 3;
					else if(riskToleranceScore >= 29 && riskToleranceScore <= 37)
						return 4;
					else
						return 5;
			case 10:
			case 11:
			case 12: if(riskToleranceScore < 12)
						return 1;
					else if(riskToleranceScore >= 12 && riskToleranceScore <= 18)
						return 2;
					else if(riskToleranceScore >= 19 && riskToleranceScore <= 26)
						return 3;
					else if(riskToleranceScore >= 27 && riskToleranceScore <= 34)
						return 4;
					else
						return 5;
			case 14:
			case 15:
			case 16:
			case 17:
			case 18: if(riskToleranceScore < 11)
						return 1;
					else if(riskToleranceScore >= 11 && riskToleranceScore <= 18)
						return 2;
					else if(riskToleranceScore >= 19 && riskToleranceScore <= 24)
						return 3;
					else if(riskToleranceScore >= 25 && riskToleranceScore <= 31)
						return 4;
					else
						return 5;					
		}
		
		return -1; 
	}
}
