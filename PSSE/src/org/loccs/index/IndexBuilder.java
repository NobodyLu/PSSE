package org.loccs.index;

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
//begin of modifiable zone(JavaSuper).....C/1d5fd5cb-67b0-42a1-a18a-1cd903f64495

//end of modifiable zone(JavaSuper).......E/1d5fd5cb-67b0-42a1-a18a-1cd903f64495
//begin of modifiable zone(JavaCode)......C/1d5fd5cb-67b0-42a1-a18a-1cd903f64495

//end of modifiable zone(JavaCode)........E/1d5fd5cb-67b0-42a1-a18a-1cd903f64495
    }

    String getIndexDirectory() {
//begin of modifiable zone................T/6ab3926d-92df-4688-8d3f-bc61e57ebc64
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/6ab3926d-92df-4688-8d3f-bc61e57ebc64
//begin of modifiable zone................T/22524f73-5bc5-488c-a160-8e52817ef919
        return this.indexDirectory;
//end of modifiable zone..................E/22524f73-5bc5-488c-a160-8e52817ef919
    }

    void setIndexDirectory(String value) {
//begin of modifiable zone................T/15846ef7-2944-4a7d-b3b0-f91089373228
        // Automatically generated method. Please delete this comment before entering specific code.
        this.indexDirectory = value;
//end of modifiable zone..................E/15846ef7-2944-4a7d-b3b0-f91089373228
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
