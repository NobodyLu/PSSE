package org.loccs.index;

import java.io.File;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

public final class IndexBuilder {
    protected String indexDirectory = "";

    protected IndexWriter indexWriter;

    protected IndexWriterConfig config;

    protected FSDirectory fsDirectory;

    protected Analyzer analyzer;

    public IndexBuilder() {
//begin of modifiable zone................T/24edd001-b17b-4bdf-b2d0-8a7695b7b409

//end of modifiable zone..................E/24edd001-b17b-4bdf-b2d0-8a7695b7b409
//begin of modifiable zone................T/bb421899-200c-4b52-aeb4-6a4a104bd523
        analyzer = new SimpleAnalyzer();
//end of modifiable zone..................E/bb421899-200c-4b52-aeb4-6a4a104bd523
    }

    public boolean prepareIndexDirectory(String directory) {
//begin of modifiable zone(JavaCode)......C/42a093d6-f589-41b0-9c8b-1d48c86680a1
		fsDirectory = FSDirectory.open(new File(directory));
//end of modifiable zone(JavaCode)........E/42a093d6-f589-41b0-9c8b-1d48c86680a1
//begin of modifiable zone................T/e9763582-34a2-496e-8165-267cef1ac515
        return true;
//end of modifiable zone..................E/e9763582-34a2-496e-8165-267cef1ac515
    }

    String getIndexDirectory() {
//begin of modifiable zone................T/6ab3926d-92df-4688-8d3f-bc61e57ebc64
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/6ab3926d-92df-4688-8d3f-bc61e57ebc64
//begin of modifiable zone................T/22524f73-5bc5-488c-a160-8e52817ef919
        return this.indexDirectory;
//end of modifiable zone..................E/22524f73-5bc5-488c-a160-8e52817ef919
    }

    public boolean addFile(String path) {
//begin of modifiable zone(JavaCode)......C/0a744ac6-327b-4ec0-b784-1fef7fbeaa91

//end of modifiable zone(JavaCode)........E/0a744ac6-327b-4ec0-b784-1fef7fbeaa91
//begin of modifiable zone(JavaReturned)..C/0a744ac6-327b-4ec0-b784-1fef7fbeaa91

//end of modifiable zone(JavaReturned)....E/0a744ac6-327b-4ec0-b784-1fef7fbeaa91
    }

    public boolean addDirectory(String path) {
//begin of modifiable zone(JavaCode)......C/e03d4100-6954-4121-9ed8-7c0537090c4d

//end of modifiable zone(JavaCode)........E/e03d4100-6954-4121-9ed8-7c0537090c4d
//begin of modifiable zone(JavaReturned)..C/e03d4100-6954-4121-9ed8-7c0537090c4d

//end of modifiable zone(JavaReturned)....E/e03d4100-6954-4121-9ed8-7c0537090c4d
    }

    public boolean build() {
//begin of modifiable zone(JavaCode)......C/fd84c382-dfc2-45b1-8c8b-a759b0f7f19f

//end of modifiable zone(JavaCode)........E/fd84c382-dfc2-45b1-8c8b-a759b0f7f19f
//begin of modifiable zone(JavaReturned)..C/fd84c382-dfc2-45b1-8c8b-a759b0f7f19f

//end of modifiable zone(JavaReturned)....E/fd84c382-dfc2-45b1-8c8b-a759b0f7f19f
    }

    public void close() {
//begin of modifiable zone(JavaCode)......C/912f8d2f-771f-4d74-9e50-ded2f88cce14

//end of modifiable zone(JavaCode)........E/912f8d2f-771f-4d74-9e50-ded2f88cce14
    }

}
