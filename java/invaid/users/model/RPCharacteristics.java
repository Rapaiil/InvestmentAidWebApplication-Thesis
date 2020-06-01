package invaid.users.model;

public interface RPCharacteristics {
	final String CONSERVATIVE = "Conservative";
	final String MODERATELY_CONSERVATIVE = "Moderately Conservative";
	final String MODERATE = "Moderate";
	final String MODERATELY_AGGRESSIVE = "Moderately Aggressively";
	final String AGGRESSIVE = "Aggressive";
	
	final String C_OBJ = "Prioritizes the preservation of capital over market funds";
	final String MC_OBJ = "Values principal preservation";
	final String M_OBJ = "Prefers reducing risks and enhancing quality returns";
	final String MA_OBJ = "Prioritizes higher long-term returns and is willing to accept significant risk";
	final String A_OBJ = "Values maximizing returns and is willing to accept substantial risk";
	
	final String C_HORIZON = "Less than 3 years";
	final String MC_HORIZON = "3-5 years";
	final String M_HORIZON = "5-6 years";
	final String MA_HORIZON = "6-11 years";
	final String A_HORIZON = "More than 11 years";
	
	final String C_DESC = "Portfolio will have large amount of low-risk, fixed-income investments and a small smattering of high-quality stocks or funds";
	final String MC_DESC = "Desires greater liquidity, is willing to accept lower returns, and is willing to accept minimal losses";
	final String M_DESC = "Endure a short-term loss of principal and lower degree of liquidity in exchange for long-term appreciation";
	final String MA_DESC = "Liquidity may not be a concern to a Moderately Aggressive investor";
	final String A_DESC = "Maximizing long-term returns is more important than protecting principal";
	
	final String NO_COMPATIBLE = "not-yet-ready";
}
