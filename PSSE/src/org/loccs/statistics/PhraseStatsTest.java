package org.loccs.statistics;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loccs.index.IndexBuilder;

public class PhraseStatsTest {
	
	private IndexBuilder builder;
	
	private PhraseStats stats;
	
	private Analyzer analyzer = new SimpleAnalyzer();

	@Before
	public void setUp() throws Exception {
		builder = new IndexBuilder(analyzer);
		builder.prepareIndexDirectory("D:\\Research\\Evaluation\\PSSE\\Data\\Index\\debug");
		builder.addDirectory("D:\\Research\\Evaluation\\PSSE\\Data\\Documents\\debug");
		builder.close();
		
		stats = new PhraseStats("D:\\Research\\Evaluation\\PSSE\\Data\\Index\\debug", analyzer);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPhraseCount() throws IOException {
		assertEquals(42, stats.getPhraseCount(2));
	}

}
