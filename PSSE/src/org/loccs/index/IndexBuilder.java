package org.loccs.index;

import java.io.FileInputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.IOUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

public final class IndexBuilder {
    public static final String FILENAME_FIELD_NAME = "filename";

    public static final String CONTENT_FIELD_NAME = "content";

    protected String indexDirectory = "";

    private IndexWriter indexWriter;

    private FSDirectory fsDirectory;

    private IndexWriterConfig indexWriterConfig;

    private Analyzer analyzer;

    public IndexBuilder() {
//begin of modifiable zone(JavaSuper).....C/1d5fd5cb-67b0-42a1-a18a-1cd903f64495

//end of modifiable zone(JavaSuper).......E/1d5fd5cb-67b0-42a1-a18a-1cd903f64495
//begin of modifiable zone................T/bb421899-200c-4b52-aeb4-6a4a104bd523
        analyzer = new SimpleAnalyzer();
//end of modifiable zone..................E/bb421899-200c-4b52-aeb4-6a4a104bd523
    }

    public void prepareIndexDirectory(String directory) throws java.io.IOException {
//begin of modifiable zone................T/d61bada4-3b14-4c64-92af-92fe8a11dab9
        close();
        fsDirectory = FSDirectory.open(Paths.get(directory));
        indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        indexWriter = new IndexWriter(fsDirectory, indexWriterConfig);
//end of modifiable zone..................E/d61bada4-3b14-4c64-92af-92fe8a11dab9
    }

    String getIndexDirectory() {
//begin of modifiable zone................T/6ab3926d-92df-4688-8d3f-bc61e57ebc64
        
//end of modifiable zone..................E/6ab3926d-92df-4688-8d3f-bc61e57ebc64
//begin of modifiable zone................T/22524f73-5bc5-488c-a160-8e52817ef919
        return this.indexDirectory;
//end of modifiable zone..................E/22524f73-5bc5-488c-a160-8e52817ef919
    }

    public void addFile(String path) throws java.io.IOException {
//begin of modifiable zone................T/e2c55a28-e72f-4b52-b8a1-deaf3a34d731
        Document document = new Document();
        document.add(new StringField(FILENAME_FIELD_NAME, path, Field.Store.YES));
        FileInputStream input = new FileInputStream(path);
        String content = IOUtils.toString(input);
        document.add(new TextField(CONTENT_FIELD_NAME, content, Field.Store.YES));
        indexWriter.addDocument(document);
        input.close();
//end of modifiable zone..................E/e2c55a28-e72f-4b52-b8a1-deaf3a34d731
    }

    public void addDirectory(String directory) throws java.io.IOException {
//begin of modifiable zone................T/55fd12ab-d1c3-4687-919f-584b003a80fc
        Path path = Paths.get(directory);
        DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.*");
        for (Path element: stream) {
            if (Files.isDirectory(element))
                addDirectory(element.toString());
            else
                addFile(element.toString());
        }
//end of modifiable zone..................E/55fd12ab-d1c3-4687-919f-584b003a80fc
    }

    public void close() throws java.io.IOException {
//begin of modifiable zone................T/3f6bfe18-7ab8-4199-8ab5-95e1be8da2d4
        if (indexWriter != null) {
            indexWriter.close();
            indexWriter = null;
        }
//end of modifiable zone..................E/3f6bfe18-7ab8-4199-8ab5-95e1be8da2d4
    }

}
