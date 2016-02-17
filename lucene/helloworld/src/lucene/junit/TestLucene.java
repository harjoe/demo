package lucene.junit;

import static org.junit.Assert.*;
import lucene.test.IndexWriterDemo;

import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Before;
import org.junit.Test;

public class TestLucene
{
	private IndexWriter writer=null;  
    private Directory directory=null;  
    private IndexReader reader = null;  
    private IndexSearcher searcher=null;  
    private IndexWriterDemo demo =new IndexWriterDemo();  
	
	@Before
	public void init() throws Exception
	{
		directory = new RAMDirectory();
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47, new SimpleAnalyzer(Version.LUCENE_47));
		writer = new IndexWriter(directory, config);
		
	}

	@Test
	public void test() throws Exception {
		
		demo.buildDocs(writer);
		
		
		reader = IndexReader.open(directory);
		searcher = new IndexSearcher(reader);
		demo.searcherDocs(searcher);

	}

}
