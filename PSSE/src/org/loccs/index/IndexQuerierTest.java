package org.loccs.index;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IndexQuerierTest {
	
	private IndexBuilder builder;
	
	private IndexQuerier querier;
	
	private Analyzer analyzer = new SimpleAnalyzer();

	@Before
	public void setUp() throws Exception {
		builder = new IndexBuilder(analyzer);
		builder.prepareIndexDirectory("D:\\Research\\Evaluation\\PSSE\\Data\\Index\\debug");
		builder.addDirectory("D:\\Research\\Evaluation\\PSSE\\Data\\Documents\\debug");
		
		querier = new IndexQuerier("D:\\Research\\Evaluation\\PSSE\\Data\\Index\\debug", analyzer);
	}

	@After
	public void tearDown() throws Exception {
		builder.close();
	}

	@Test
	public void testGetDocumentCount() {
		assertEquals(3, querier.getDocumentCount());
	}

	@Test
	public void testSearchWordForCount() throws IOException {
		assertEquals(2, querier.searchWordForCount("Holm"));
	}

	@Test
	public void testSearchPhraseForCount() throws IOException {
		Vector<String> phrase = new Vector<String>();
		phrase.add("New");
		phrase.add("York");
		assertEquals(2, querier.searchPhraseForCount(phrase, 0, 2));
		
		phrase.clear();
		phrase.add("Central");
		phrase.add("Park");
		phrase.add("West");
		assertEquals(1, querier.searchPhraseForCount(phrase, 0, 3));
	}

	@Test
	public void testGetAllWords() throws IOException {
		assertEquals(38, querier.getAllWords().size());
	}

	@Test
	public void testGetDocumentWordSequence() throws IOException {
		List<String> words = querier.getDocumentWordSequence(0);
		assertEquals(19, words.size());
		assertEquals("holm", words.get(0));
		assertEquals("new", words.get(4));
		assertEquals("much", words.get(8));
		assertEquals("apartment", words.get(14));
		assertEquals("on", words.get(15));
		assertEquals("west", words.get(18));
	}

}
