package org.loccs.statistics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.lucene.analysis.Analyzer;
import org.loccs.index.IndexQuerier;

public class PhraseStats {
    private IndexQuerier querier;

    public PhraseStats(String indexDirectory, Analyzer analyzer) throws java.io.IOException {
//begin of modifiable zone................T/942d5232-b2b7-4fa7-a81d-5748750f832d


//end of modifiable zone..................E/942d5232-b2b7-4fa7-a81d-5748750f832d
//begin of modifiable zone................T/2db243f0-10d8-4d1c-968c-6c2161994461
        querier = new IndexQuerier(indexDirectory, analyzer);
//end of modifiable zone..................E/2db243f0-10d8-4d1c-968c-6c2161994461
    }

    public int getPhraseCount(int length) throws java.io.IOException {
//begin of modifiable zone................T/82794791-5c54-4905-92fa-8625df40d364
        Set<String> phrases = new HashSet<String>();
        int documentCount = querier.getDocumentCount();
        for (int i = 0; i < documentCount; i++) {
            List<String> words = querier.getDocumentWordSequence(i);
            getNewPhraseCount(phrases, words, length);
        }
//end of modifiable zone..................E/82794791-5c54-4905-92fa-8625df40d364
//begin of modifiable zone................T/6c88b0cd-2010-4f92-8834-4d1a1bc3ddca
        return phrases.size();
//end of modifiable zone..................E/6c88b0cd-2010-4f92-8834-4d1a1bc3ddca
    }

    public PhraseStatsResults getPhraseDetailCount(int length) throws java.io.IOException {
//begin of modifiable zone................T/d0b20205-024e-4f8c-befb-ccaac509965d
        int documentCount = querier.getDocumentCount();
        PhraseStatsResults results = new PhraseStatsResults(length, documentCount);
        Set<String> phrases = new HashSet<String>();
        for (int i = 0; i < documentCount; i++) {
            List<String> words = querier.getDocumentWordSequence(i);
            getNewPhraseDetailCount(phrases, words, length, results);
        }
//end of modifiable zone..................E/d0b20205-024e-4f8c-befb-ccaac509965d
//begin of modifiable zone................T/5c318228-d047-4e3c-8de0-7c74309ef30e
        return results;
//end of modifiable zone..................E/5c318228-d047-4e3c-8de0-7c74309ef30e
    }

    private void getNewPhraseCount(Set<String> phrases, List<String> words, int length) {
//begin of modifiable zone................T/e545b2ab-bd9b-4b24-abf6-845e763aef25
        for (int i = 0; i < words.size() - length + 1; i++) {
            String phrase = PhraseUtils.toString(words, i, length);
            if (!phrases.contains(phrase))
                phrases.add(phrase);
        }
//end of modifiable zone..................E/e545b2ab-bd9b-4b24-abf6-845e763aef25
    }

    private void getNewPhraseDetailCount(Set<String> phrases, List<String> words, int length, PhraseStatsResults results) throws java.io.IOException {
//begin of modifiable zone................T/1b51a349-0b5e-45b6-88e6-011154852468
        for (int i = 0; i < words.size() - length + 1; i++) {
            String phrase = PhraseUtils.toString(words, i, length);
            if (!phrases.contains(phrase)) {
                phrases.add(phrase);
                int count = querier.searchPhraseForCount(words, i, length);
                results.increaseDetailCount(count);
            }
        }
//end of modifiable zone..................E/1b51a349-0b5e-45b6-88e6-011154852468
    }

}
