package org.loccs.index;

import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;

public class IndexQuerier {
    private Analyzer analyzer;

    private FSDirectory fsDirectory;

    private IndexReader reader;

    private IndexSearcher searcher;

    public IndexQuerier(String directory) throws java.io.IOException {
//begin of modifiable zone(JavaSuper).....C/2b8973b1-fea5-4d1d-848b-aa84bc5ef60b

//end of modifiable zone(JavaSuper).......E/2b8973b1-fea5-4d1d-848b-aa84bc5ef60b
//begin of modifiable zone(JavaCode)......C/2b8973b1-fea5-4d1d-848b-aa84bc5ef60b
    	fsDirectory = FSDirectory.open(Paths.get(directory));
//end of modifiable zone(JavaCode)........E/2b8973b1-fea5-4d1d-848b-aa84bc5ef60b
    }

    void setAnalyzer(Analyzer value) {
//begin of modifiable zone................T/4af62fcb-5ce6-4dde-8c8f-c29708de1a4d
        // Automatically generated method. Please delete this comment before entering specific code.
        this.analyzer = value;
//end of modifiable zone..................E/4af62fcb-5ce6-4dde-8c8f-c29708de1a4d
    }

    public int searchWordForCount(String word) {
//begin of modifiable zone(JavaCode)......C/3866f320-3f01-46f5-9cfc-a814243d366c

//end of modifiable zone(JavaCode)........E/3866f320-3f01-46f5-9cfc-a814243d366c
//begin of modifiable zone(JavaReturned)..C/3866f320-3f01-46f5-9cfc-a814243d366c

//end of modifiable zone(JavaReturned)....E/3866f320-3f01-46f5-9cfc-a814243d366c
    }

    public int searchPhraseForCount(List<String> phrase, int start, int length) {
//begin of modifiable zone(JavaCode)......C/a001743d-b05c-4bde-bd73-360ea80e12e3

//end of modifiable zone(JavaCode)........E/a001743d-b05c-4bde-bd73-360ea80e12e3
//begin of modifiable zone(JavaReturned)..C/a001743d-b05c-4bde-bd73-360ea80e12e3

//end of modifiable zone(JavaReturned)....E/a001743d-b05c-4bde-bd73-360ea80e12e3
    }

    public List<String> getAllWords() {
//begin of modifiable zone(JavaCode)......C/91af9152-f4be-46ec-9a86-bb49b4ae1aa8

//end of modifiable zone(JavaCode)........E/91af9152-f4be-46ec-9a86-bb49b4ae1aa8
//begin of modifiable zone(JavaReturned)..C/91af9152-f4be-46ec-9a86-bb49b4ae1aa8

//end of modifiable zone(JavaReturned)....E/91af9152-f4be-46ec-9a86-bb49b4ae1aa8
    }

    public List<String> getDocumentWordSequence(int id) {
//begin of modifiable zone(JavaCode)......C/45f7a401-bb25-44b1-aa39-c1b050266158

//end of modifiable zone(JavaCode)........E/45f7a401-bb25-44b1-aa39-c1b050266158
//begin of modifiable zone(JavaReturned)..C/45f7a401-bb25-44b1-aa39-c1b050266158

//end of modifiable zone(JavaReturned)....E/45f7a401-bb25-44b1-aa39-c1b050266158
    }

}
