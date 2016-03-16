package lucene.test;


import java.io.IOException;
import java.util.List;

import org.apache.lucene.document.Document;


import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;

public class IndexWriterDemo
{

	public void buildDocs(IndexWriter writer) throws Exception{
		//writer.deleteAll();
		List<Student> students = Student.getStudents();
		
		for(Student student: students){
			Document document = new Document();
			document.add(new TextField("id", student.getId().toString(), Store.YES));
			document.add(new TextField("name", student.getName(), Store.YES));
			document.add(new TextField("age", student.getAge().toString(), Store.YES));
			document.add(new TextField("sex", student.getSex().toString(), Store.YES));
			
			writer.addDocument(document);
			
			System.out.println("write: " + student.getId());
		}
		writer.forceMerge(100);
		writer.close();
		
	}
	
	public void searcherDocs(IndexSearcher searcher) throws IOException{
		System.out.println("search.....");
		Term term = new Term("sex", "women");
		TermQuery query = new TermQuery(term);
		TopDocs docs = searcher.search(query, 100);
		for(ScoreDoc doc: docs.scoreDocs) {
			int docID = doc.doc;
			Document document = searcher.doc(docID);
			String msg = String.format("%s,%s,%s", document.get("id"), document.get("name"), document.get("sex"));
			System.out.println(msg);
		}
		
	}
}
