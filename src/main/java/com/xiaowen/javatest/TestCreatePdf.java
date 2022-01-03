package com.xiaowen.javatest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;


import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class TestCreatePdf {
	public static void main(String[] arg){
		byte[] newPdf = null;
		
		try {
			
			FileInputStream fileInputStream = null;
			if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
				fileInputStream = new FileInputStream("C:\\temp\\EnhanceManualEntryInsuranceForm.pdf");
			} else {
				fileInputStream = new FileInputStream("/paperless/apps/portalsync/lib/EnhanceManualEntryInsuranceForm.pdf");
			}
			
			PdfReader reader = new PdfReader(fileInputStream);
			ByteArrayOutputStream baosF = new ByteArrayOutputStream();
			PdfStamper stamper = new PdfStamper(reader, baosF);
			AcroFields form = stamper.getAcroFields();
			form.setField("patient_id", "12345");
			form.setField("patient_name", "patient_name");
			
			form.setField("ins_primary_name", "ins_primary_name");
			form.setField("ins_primary_policy_num", "ins_primary_policy_num");
			form.setField("ins_primary_group_num", "ins_primary_group_num");
			form.setField("ins_primary_effective_date", "ins_primary_effective_date");
			
			form.setField("ins_secondary_name", "ins_secondary_name");
			form.setField("ins_secondary_policy_num", "ins_secondary_policy_num");
			form.setField("ins_secondary_group_num", "ins_secondary_group_num");
			form.setField("ins_secondary_effective_date","ins_secondary_effective_date" );
			
			
			stamper.setFormFlattening(false);
			stamper.close();
			reader.close();
			baosF.flush();
			newPdf = baosF.toByteArray();
			baosF.close();
			
			OutputStream out = new FileOutputStream("C:\\temp\\out.pdf");
			out.write(newPdf);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
}
