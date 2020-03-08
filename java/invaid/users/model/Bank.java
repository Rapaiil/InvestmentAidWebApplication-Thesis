package invaid.users.model;

public enum Bank {
	BANK1("Metropolitan Bank & Trust Co."),
	BANK2("Philippine National Bank"),
	BANK3("BPI Asset Management and Trust Corporation"),
	BANK4("Asia United Bank"),
	BANK5("Bank of Commerce"),
	BANK6("BDO Unibank, Inc."),
	BANK7("China Banking Corporation"),
	BANK8("EastWest Banking Corporation"),
	BANK9("LandBank of the Philippines"),
	BANK10("Philippine Bank of Communications"),
	BANK11("Rizal Commercial Banking Corporation"),
	BANK12("Security Bank Corporation"),
	BANK13("Union Bank"),
	BANK14("United Coconut Planters Bank"),
	BANK15("Development Bank of the Philippines"),
	BANK16("AB Capital"),
	BANK17("Philippine Business Bank"),
	BANK18("ATRAM Trust Corporation"),
	BANK19("Philippine Savings Bank"),
	BANK20("Sterling Bank of Asia"),
	BANK21("Robinsons Bank"),
	BANK22("China Bank Savings"),
	BANK23("CTBC Bank (Philippines) Corp."),
	BANK24("Manulife Asset Management and Trust Corporation (MAMTC)"),
	BANK25("Maybank Philippines Inc."),
	BANK26("Pru Life UK Investments");
	
	private String action;
	
	public String getAction() {
		return this.action;
	}
	
	private Bank(String action) {
		this.action = action;
	}
}
