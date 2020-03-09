package invaid.users.util;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell; 
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

public class PDFUtil {
	private static String file = "/Downloads/Invaid_Risk_Profile_Recommendation.pdf";
	
	
	public void exportPDF() {
		try {
			PdfFont headers_titles = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
		    PdfFont subFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
		    
			PdfWriter writer = new PdfWriter(file);
			
            PdfDocument document = new PdfDocument(writer);
            
            document.addNewPage();
            
            Document doc = new Document(document);
            
            //LOGO            
            ImageData logo = ImageDataFactory.create("/assets/logo.png");
            
            Image invAidLogo = new Image(logo);
            invAidLogo.setFixedPosition(200, 200);
            
            doc.add(invAidLogo);
            
            //COMPANY HEADING
            Text invAidTitle = new Text("InvAid - Investment Aid");
            Text invAidSubtitle = new Text("Philippine Mutual Fund and Unit Investment Trust Fund Monitoring and Tracking App");

            invAidTitle.setFont(headers_titles);
            invAidTitle.setTextAlignment(TextAlignment.CENTER);
            
            invAidSubtitle.setFont(subFont);
            invAidSubtitle.setTextAlignment(TextAlignment.CENTER);
            
            Paragraph title = new Paragraph(invAidTitle);
            Paragraph subtitle = new Paragraph(invAidSubtitle);
            doc.add(title);
            doc.add(subtitle);
            
            //RISK PROFILE RESULTS
            Text riskProfileTitle = new Text("RISK PROFILE");
            
            riskProfileTitle.setFont(subFont);
            riskProfileTitle.setTextAlignment(TextAlignment.CENTER);
            
            Paragraph riskProfile = new Paragraph(riskProfileTitle);
            doc.add(riskProfile);
            
            //INVESTOR TYPE
            PdfFont italic = PdfFontFactory.createFont(StandardFonts.TIMES_ITALIC);
            Text investorType = new Text("You are a/an [Risk Appetite] Investor");
            investorType.setFont(italic);
            
            Paragraph investorProfile = new Paragraph(investorType);
            
            doc.add(investorProfile);
            
            //INVESTENT OBJECTIVE
            PdfFont bold = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
            Table investmentObjectiveTable = new Table(2);
            
            Cell investorObjective = new Cell();
            investorObjective.add(new Paragraph("Investor Objective:"));
            investorObjective.setBorder(Border.NO_BORDER);
            investorObjective.setFont(bold);
            Cell investor = new Cell();
            investor.add(new Paragraph("[Investor Objective]"));
            investor.setBorder(Border.NO_BORDER);
            
            investmentObjectiveTable.addCell(investorObjective);
            investmentObjectiveTable.addCell(investor);
            
            doc.add(investmentObjectiveTable);
            
            //HORIZON
            Table investmentHorizonTable = new Table(2);
            
            Cell investmentHorizon = new Cell();
            investmentHorizon.add(new Paragraph("Investor Horizon:"));
            investmentHorizon.setBorder(Border.NO_BORDER);
            investmentHorizon.setFont(bold);
            Cell horizon = new Cell();
            horizon.add(new Paragraph("[Investor Horizon]"));
            horizon.setBorder(Border.NO_BORDER);
            
            investmentHorizonTable.addCell(investmentHorizon);
            investmentHorizonTable.addCell(horizon);
            
            doc.add(investmentHorizonTable);
            
            //CHARACTERISTICS
            Table investmentCharacteristicsTable = new Table(2);
            
            Cell investmentCharacteristics = new Cell();
            investmentCharacteristics.add(new Paragraph("Investor Characteristics:"));
            investmentCharacteristics.setBorder(Border.NO_BORDER);
            investmentCharacteristics.setFont(bold);
            Cell characteristics = new Cell();
            characteristics.add(new Paragraph("[Investor Characteristics]"));
            characteristics.setBorder(Border.NO_BORDER);
            
            investmentCharacteristicsTable.addCell(investmentCharacteristics);
            investmentCharacteristicsTable.addCell(characteristics);
            
            doc.add(investmentCharacteristicsTable);
            
            //FUND RECOMMENDATIONS
            Text fundRec = new Text("FUND RECOMMENDATIONS");
            fundRec.setFont(subFont);
            Text fundRecSub = new Text("Here are the Top 5 fund recommendations based on your Risk Profile result.");
            
            Paragraph fundRecTitle = new Paragraph(fundRec);
            Paragraph fundRecSubtitle = new Paragraph(fundRecSub);
            
            doc.add(fundRecTitle);
            doc.add(fundRecSubtitle);
            
            //TABLE
            Table recommendationTable = new Table(3);
            
            Cell fundNameCell = new Cell();
            fundNameCell.add(new Paragraph("FUND NAME"));
            fundNameCell.setTextAlignment(TextAlignment.CENTER);
            fundNameCell.setFont(bold);
            
            Cell fundTypeCell = new Cell();
            fundNameCell.add(new Paragraph("FUND TYPE"));
            fundNameCell.setTextAlignment(TextAlignment.CENTER);
            fundNameCell.setFont(bold);
            
            Cell fundTypeAffiliation = new Cell();
            fundNameCell.add(new Paragraph("FUND AFFILIATION"));
            fundNameCell.setTextAlignment(TextAlignment.CENTER);
            fundNameCell.setFont(bold);
            
            recommendationTable.addCell(fundNameCell);
            recommendationTable.addCell(fundTypeCell);
            recommendationTable.addCell(fundTypeAffiliation);
            
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
