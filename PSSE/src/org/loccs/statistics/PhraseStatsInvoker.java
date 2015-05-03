package org.loccs.statistics;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.loccs.index.IndexBuilder;
import org.loccs.office.spreadsheet.ApachePOIHSSF;
import org.loccs.office.spreadsheet.Cell;
import org.loccs.office.spreadsheet.Sheet;
import org.loccs.office.spreadsheet.SpreadSheet;

public class PhraseStatsInvoker {
	
	private String statsObject = "rfc1000";
	
	private int totalDocumentCount = 1000;
	
	private int documentPercentage = 0;
	
	private int minPhraseLength = 7;
	private int maxPhraseLength = 7;
	
	private String rootDirectory = "D:\\Research\\Evaluation\\PSSE\\Data"; 
	
	private Analyzer analyzer = new SimpleAnalyzer();
	
	private SpreadSheet spread = new ApachePOIHSSF();

	public PhraseStatsInvoker() {
		// TODO Auto-generated constructor stub
		spread.open(rootDirectory + "\\Results\\" + statsObject + "\\statistics.xls");
	}
	
	public void setDocumentPercentage(int percentage) {
		documentPercentage = percentage;
	}
	
	public void setResultsTableHeader() {
		Sheet overviewSheet = spread.getSheet(0);
		
		for (int i = 2; i <= maxPhraseLength; i++) {
			Cell cell = overviewSheet.getCell(i - 1, 0);
			cell.setNumericValue(i);
		}
		
		int tenthCount = totalDocumentCount / 10;
		for (int i = 1; i <= 10; i++) {
			Cell cell = overviewSheet.getCell(0, i);
			cell.setNumericValue(i * tenthCount);
		}
		
		Sheet detailSheet = spread.getSheet(1);
		for (int i = 2; i <= maxPhraseLength; i++) {
			Cell cell = detailSheet.getCell(0, i - 1);
			cell.setNumericValue(i);
		}
		
		for (int i = 1; i <= totalDocumentCount; i++) {
			Cell cell = detailSheet.getCell(i, 0);
			cell.setNumericValue(i);
		}
		
		spread.save();
	}
	
	public void buildIndex() throws IOException {
		IndexBuilder builder = new IndexBuilder(analyzer);
		builder.prepareIndexDirectory(rootDirectory + "\\Index\\" + statsObject); 
		
		int documentCount = totalDocumentCount * documentPercentage / 100;
		builder.addDirectory(rootDirectory + "\\Documents\\" + statsObject, documentCount);
		
		builder.close();
	}
	
	public void overviewStats() {
		
		Sheet overviewSheet = spread.getSheet(0);
		
		for (int i = 1; i <= 10; i++) {
			setDocumentPercentage(i * 10);
			
			try {
				buildIndex();
				
				PhraseStats stats = new PhraseStats(rootDirectory + "\\Index\\" + statsObject, analyzer);
				
				for (int j = minPhraseLength; j <= maxPhraseLength; j++) {
					int count = stats.getPhraseCount(j);
					Cell cell = overviewSheet.getCell(j - 1, i);
					cell.setNumericValue(count);
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Percentage " + (i * 10) + " finished.");
		}
		
		spread.save();
	}
	
	public void detailStats() {
		Sheet detailSheet = spread.getSheet(1);
		
		setDocumentPercentage(100);
		
		try {
			buildIndex();
			
			PhraseStats stats = new PhraseStats(rootDirectory + "\\Index\\" + statsObject, analyzer);
			for (int i = minPhraseLength; i <= maxPhraseLength; i++) {
				PhraseStatsResults results = stats.getPhraseDetailCount(i);
				int[] detailCount = results.getPhraseDetailCount();
				for (int j = 1; j <= totalDocumentCount; j++) {
					Cell cell = detailSheet.getCell(j, i - 1);
					cell.setNumericValue(detailCount[j - 1]);
				}
				
				System.out.println("Phrase of length " + i + " finished.");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		spread.save();
	}
	
	public void finish() {
		
		spread.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhraseStatsInvoker invoker = new PhraseStatsInvoker();
		
		invoker.setResultsTableHeader();
		
		//invoker.overviewStats();
		invoker.detailStats();
		
		invoker.finish();
	}

}
