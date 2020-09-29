package CompareTwoPDF;

import java.io.IOException;

import de.redsix.pdfcompare.PdfComparator;
import de.redsix.pdfcompare.RenderingException;

public class Test {
	public static void main(String args[]) throws RenderingException, IOException{
		
		String actualpdf= System.getProperty("user.dir")+"//src//test//java//CompareTwoPDF//actual.pdf";
		String expectedpdf= System.getProperty("user.dir")+"//src//test//java//CompareTwoPDF//expected.pdf";
		String result= System.getProperty("user.dir")+"//src//test//java//CompareTwoPDF//result";
		new PdfComparator(expectedpdf, actualpdf).compare().writeTo(result);
		boolean isEquals= new PdfComparator(expectedpdf, actualpdf).compare().writeTo(result);
		System.out.println("Are PDF similar "+isEquals);
		System.out.println("Process Completed");

	}

}
