package org.loccs.index;

import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Fields;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

public class IndexQuerier {
    private Analyzer analyzer;

    private FSDirectory fsDirectory;

    private IndexReader reader;

    private IndexSearcher searcher;

    public IndexQuerier(String directory, Analyzer analyzer) throws java.io.IOException {
//begin of modifiable zone(JavaSuper).....C/2b8973b1-fea5-4d1d-848b-aa84bc5ef60b

//end of modifiable zone(JavaSuper).......E/2b8973b1-fea5-4d1d-848b-aa84bc5ef60b
//begin of modifiable zone................T/e7a6a039-924a-4679-8c3b-5cb2c556b3c6
        fsDirectory = FSDirectory.open(Paths.get(directory));
        reader = DirectoryReader.open(fsDirectory);
        searcher = new IndexSearcher(reader);
        this.analyzer = analyzer;
//end of modifiable zone..................E/e7a6a039-924a-4679-8c3b-5cb2c556b3c6
    }

    public int getDocumentCount() {
//begin of modifiable zone(JavaCode)......C/2ed5ee71-395f-4fcb-bde5-e3d58939073d

//end of modifiable zone(JavaCode)........E/2ed5ee71-395f-4fcb-bde5-e3d58939073d
//begin of modifiable zone................T/1cf0fb36-da27-4e0f-bd62-06f85553ad87
        return reader.numDocs();
//end of modifiable zone..................E/1cf0fb36-da27-4e0f-bd62-06f85553ad87
    }

    public int searchWordForCount(String word) throws java.io.IOException {
//begin of modifiable zone................T/e2cda6fd-fe92-4472-b797-6d1e18184e0d
        Query query = new TermQuery(new Term(IndexBuilder.CONTENT_FIELD_NAME, word.toLowerCase()));
        TopDocs docs = searcher.search(query, reader.numDocs());
//end of modifiable zone..................E/e2cda6fd-fe92-4472-b797-6d1e18184e0d
//begin of modifiable zone................T/4d724e8c-b90d-4ca6-a907-66ff6fbadeaf
        return docs.scoreDocs.length;
//end of modifiable zone..................E/4d724e8c-b90d-4ca6-a907-66ff6fbadeaf
    }

    public int searchPhraseForCount(List<String> phrase, int start, int length) throws java.io.IOException {
//begin of modifiable zone................T/acd4e4d4-866e-4ddf-af8b-099dab63362f
        PhraseQuery query = new PhraseQuery();
        for (int i = start; i < (start + length); i++) 
            query.add(new Term(IndexBuilder.CONTENT_FIELD_NAME, phrase.get(i).toLowerCase()));
        TopDocs docs = searcher.search(query, reader.numDocs());
//end of modifiable zone..................E/acd4e4d4-866e-4ddf-af8b-099dab63362f
//begin of modifiable zone................T/93a0d418-1945-4652-b37f-b7628b7944e1
        return docs.scoreDocs.length;
//end of modifiable zone..................E/93a0d418-1945-4652-b37f-b7628b7944e1
    }

    public List<String> getAllWords() throws java.io.IOException {
//begin of modifiable zone................T/2f3edb8a-3a63-4304-9ddb-34cd01498e7d
        Vector<String> words = new Vector<String>();
        Fields fields = MultiFields.getFields(reader);
        if (fields != null) {
            Terms terms = fields.terms(IndexBuilder.CONTENT_FIELD_NAME);
            if (terms != null) {
                TermsEnum termsEnum = terms.iterator(null);
                BytesRef bytesRef;
                while ((bytesRef = termsEnum.next()) != null) {
                    words.add(bytesRef.utf8ToString());
                }
            }            
        }
//end of modifiable zone..................E/2f3edb8a-3a63-4304-9ddb-34cd01498e7d
//begin of modifiable zone................T/72f6dfcc-8093-421b-b37d-7e60eff0fa01
        return words;
//end of modifiable zone..................E/72f6dfcc-8093-421b-b37d-7e60eff0fa01
    }

    public List<String> getDocumentWordSequence(int id) throws java.io.IOException {
//begin of modifiable zone................T/6a08b042-1871-4b88-a8ff-79d8e9d1ab65
        Vector<String> words = new Vector<String>();
        Document document = searcher.doc(id);
        if ((document != null) && (analyzer != null)) {
            TokenStream stream = document.getField(IndexBuilder.CONTENT_FIELD_NAME).tokenStream(analyzer, null);
            CharTermAttribute charTermAttribute = stream.addAttribute(CharTermAttribute.class);
            stream.reset();
            while (stream.incrementToken()) {
                words.add(charTermAttribute.toString());
            }
            stream.close();            
        }
//end of modifiable zone..................E/6a08b042-1871-4b88-a8ff-79d8e9d1ab65
//begin of modifiable zone................T/b22c2f7c-0813-47ab-9600-cd2260ede7c9
        return words;
//end of modifiable zone..................E/b22c2f7c-0813-47ab-9600-cd2260ede7c9
    }

}
