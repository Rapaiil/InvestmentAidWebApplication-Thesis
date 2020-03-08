package invaid.users.util;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFUtil {
	private static String file = "Invaid_Risk_Profile_Recommendation.pdf";
	private static Font headers_titles = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font sectionTitle = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD);
	
	public void exportPDF() {
		try {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(file));
            
            document.open();
            
            //LOGO            
            Image logo = Image.getInstance("/assets/logo.png");
            logo.setAbsolutePosition(100f, 550f);
            logo.scaleAbsolute(200, 200);
            
            document.add(logo);
            
            //COMPANY HEADING
            Paragraph invAidTitle = new Paragraph("InvAid - Investment Aid", headers_titles);
            Paragraph invAidSubtitle = new Paragraph("Philippine Mutual Fund and Unit Investment Trust Fund Monitoring and Tracking App", subFont);
            invAidTitle.setAlignment(Element.ALIGN_CENTER);
            invAidSubtitle.setAlignment(Element.ALIGN_CENTER);
            
            document.add(invAidTitle);
            document.add(invAidSubtitle);
            
            //RISK PROFILE RESULTS
            Paragraph riskProfileTitle = new Paragraph("RISK PROFILE", sectionTitle);

            document.add(riskProfileTitle);
            
            //INVESTOR TYPE
            PdfPTable investorTypeTable = new PdfPTable(1);
            investorTypeTable.setWidthPercentage(100);
            
            PdfPCell investorType = new PdfPCell();
            investorType.setHorizontalAlignment(Element.ALIGN_CENTER);
            investorType.setBorder(0);
            
            investorTypeTable.addCell("You are a/an [Risk Appetite] Investor");
            
            document.add(investorTypeTable);
            
            //INVESTENT OBJECTIVE
            PdfPTable investmentObjectiveTable = new PdfPTable(2);
            investorTypeTable.setWidthPercentage(100);
            
            PdfPCell investorObjective = new PdfPCell();
            investorObjective.setBorder(0);
            
            investmentObjectiveTable.addCell("Investment Objective");
            investmentObjectiveTable.addCell("[Investment Objective]");
            
            document.add(investmentObjectiveTable);
            
            //HORIZON
            PdfPTable investmentHorizonTable = new PdfPTable(2);
            investorTypeTable.setWidthPercentage(100);
            
            PdfPCell investmentHorizon = new PdfPCell();
            investmentHorizon.setBorder(0);
            
            investmentHorizonTable.addCell("Investment Horizon");
            investmentHorizonTable.addCell("[Investment Horizon]");
            
            document.add(investmentHorizonTable);
            
            //CHARACTERISTICS
            PdfPTable investmentCharacteristicsTable = new PdfPTable(2);
            investmentCharacteristicsTable.setWidthPercentage(100);
            
            PdfPCell investmentCharacteristics = new PdfPCell();
            investmentCharacteristics.setBorder(0);
            
            investmentCharacteristicsTable.addCell("Characteristics");
            investmentCharacteristicsTable.addCell("[Characteristics]");
            
            document.add(investmentCharacteristicsTable);
            
            //FUND RECOMMENDATIONS
            Paragraph fundRecTitle = new Paragraph("FUND RECOMMENDATIONS", sectionTitle);
            Paragraph fundRecSubtitle = new Paragraph("Here are the Top 5 fund recommendations based on your Risk Profile result.");
            
            document.add(fundRecTitle);
            document.add(fundRecSubtitle);
            
            //TABLE
            PdfPTable recommendationTable = new PdfPTable(3);
            
            PdfPCell recommendationCell = new PdfPCell(new Phrase("FUND NAME"));
            recommendationCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            recommendationTable.addCell(recommendationCell);

            recommendationCell = new PdfPCell(new Phrase("FUND TYPE"));
            recommendationCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            recommendationTable.addCell(recommendationCell);

            recommendationCell = new PdfPCell(new Phrase("FUND AFFILIATION"));
            recommendationCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            recommendationTable.addCell(recommendationCell);
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
