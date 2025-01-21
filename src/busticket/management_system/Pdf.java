/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busticket.management_system;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.File;

/**
 *
 * @author User
 */
public class Pdf {
    private String dest;
    private PdfWriter writer;
    private PdfDocument pdf;
    private Canvas canvas;
    private PdfCanvas pdfCanvas;
    private Table table;
    
    public Pdf() {
        
        
         try {
             dest = new File("").getAbsolutePath()+" output.pdf" ;

            // Initialize PdfWriter and PdfDocument
             writer = new PdfWriter(dest);
             pdf = new PdfDocument(writer);

            // Set page size
            pdf.setDefaultPageSize(PageSize.A4);

            // Add a new page
             pdfCanvas = new PdfCanvas(pdf.addNewPage());

            // Create a canvas
             canvas = new Canvas(pdfCanvas, pdf, pdf.getDefaultPageSize());

            // Add text at a specific position
            Paragraph text = new Paragraph("Bus Ticket Booking System.").setWidth(150).setPadding(10).setFontSize(12).setBold().setBorder(new SolidBorder(ColorConstants.BLACK, 2));
            
            //images
            
            
            String filePath = new File("").getAbsolutePath().concat("\\src\\busticket\\management_system\\Image\\logo.jpg");
            String imagepath = new File("").getAbsolutePath().concat("\\src\\busticket\\management_system\\Image\\adnansign.png");
          

            Image image = new Image(ImageDataFactory.create(filePath));
             image.setWidth(150); // Set width
             image.setHeight(95); // Set height
             image.setMarginTop(20);
             image.setFixedPosition(100, 650);
             canvas.add(image);
             
                      Image sign= new Image(ImageDataFactory.create(imagepath));
             sign.setWidth(150); // Set width
             sign.setHeight(95); // Set height
             sign.setMarginTop(20);
             sign.setFixedPosition(425, 430);
             canvas.add(sign);
            //endImages
            
            canvas.showTextAligned(
                text,
                250, // X-coordinate
                700, // Y-coordinate
                com.itextpdf.layout.property.TextAlignment.LEFT
            );
            
            //add table
            float[] columnWidths = {40, 120, 265, 30, 30, 30, 30,30}; 
                
table = new Table(columnWidths);

// Add cells to the table
table.addCell(new Cell().add(new Paragraph("Seat#").setBold().setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph("First Name").setBold().setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph("Last Name").setBold().setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph("Gender").setBold().setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph("Phone").setBold().setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph("Location").setBold().setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph("Type").setBold().setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph("Price").setBold().setPaddingLeft(10).setPaddingRight(10)));


//addRow(table, "Seat#","First Name","Last Name","Gender","Phone","Location","Type","Price");





// Set table position and total width dynamically

float totalTableWidth = 0; // Sum of columnWidths
for(float f:columnWidths){
    totalTableWidth+=f;
}
table.setFixedPosition(15, 600, totalTableWidth); // X, Y, and total table width

            // Add table to the canvas
         
            
            //End Table
            


            System.out.println("PDF created with positioned text!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        
    }
    
     public void addRow(String seat,String first_name,String last_name,String gender, String phone, String location, String type,String price){
        table.addCell(new Cell().add(new Paragraph(seat).setPaddingLeft(10).setPaddingRight(10)));
    table.addCell(new Cell().add(new Paragraph(first_name).setPaddingLeft(10).setPaddingRight(10)));
        table.addCell(new Cell().add(new Paragraph(last_name).setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph(gender).setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph(phone).setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph(location).setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph(type).setPaddingLeft(10).setPaddingRight(10)));
table.addCell(new Cell().add(new Paragraph(price).setPaddingLeft(10).setPaddingRight(10)));
    }
    
    
    public void createPdf(){ 
         canvas.add(table);
         canvas.close();
         pdf.close();
    }
    
}
