import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
 
// An AWT program inherits from the top-level container java.awt.Frame
public class AverageGUI extends Frame implements ActionListener {
   private Label lblCount;    // Declare component Label
   private TextField Box1; // Declare component TextField
   private TextField Box2; // Declare component TextField
   private TextField Box3; // Declare component TextField
   private TextField Box4; // Declare component TextField
   private Button btnCount;   // Declare component Button
   //private int count = 0;     // Counter's value
   //double grade1 = 90;
   //double grade2 = 80;
   //double grade3= 42;
   //String name = "Armaan";
   //char letterGrade= 'C';
   
 
   /** Constructor to setup GUI components and event handling */
   public AverageGUI () {
	   
	   addWindowListener(new WindowAdapter(){
		   public void windowClosing(WindowEvent we){
			   System.exit(0);
		   }
	   });
	   
      setLayout(new FlowLayout());
         // "super" Frame sets its layout to FlowLayout, which arranges the components
         //  from left-to-right, and flow to next row from top-to-bottom.
 
      lblCount = new Label("Name::Grade1::Grade2::Grade3");  // construct Label
      add(lblCount);                    // "super" Frame adds Label
 
      Box1 = new TextField("", 10); // construct TextField
      Box1.setEditable(true);       // set to read-only
      add(Box1);                     // "super" Frame adds tfCount
      Box2 = new TextField("", 10); // construct TextField
      Box2.setEditable(true);       // set to read-only
      add(Box2);                     // "super" Frame adds tfCount
      Box3 = new TextField("", 10); // construct TextField
      Box3.setEditable(true);       // set to read-only
      add(Box3);                     // "super" Frame adds tfCount
      Box4 = new TextField("", 10); // construct TextField
      Box4.setEditable(true);       // set to read-only
      add(Box4);                     // "super" Frame adds tfCount
 
      btnCount = new Button("Input");   // construct Button
      add(btnCount);                    // "super" Frame adds Button
 
      btnCount.addActionListener(this);
         // Clicking Button source fires ActionEvent
         // btnCount registers this instance as ActionEvent listener
 
      setTitle("AverageGUI");  // "super" Frame sets title
      setSize(1000, 250);        // "super" Frame sets initial window size
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
 
      setVisible(true);         // "super" Frame shows
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      AverageGUI app = new AverageGUI();
   }
 
   /** ActionEvent handler - Called back upon button-click. */
   @Override
   public void actionPerformed(ActionEvent evt) {
	   String name = Box1.getText();
	   double grade1= Double.valueOf(Box2.getText());
	   double grade2= Double.valueOf(Box3.getText());
	   double grade3= Double.valueOf(Box4.getText());
	   char letterGrade;
	   //System.out.print(name);
	     double average = (grade1+grade2+grade3)/3.0;
	      if(average >= 90){
	   	   letterGrade='A';
	      }
	      else if(average >= 80){
	   	   letterGrade='B';
	      }
	      else if(average >= 70){
	   	   letterGrade='C';
	      }
	      else if(average >= 60){
	   	   letterGrade='D';
	      }
	      else{
	   	   letterGrade='F';
	      }
	      
	      System.out.print(name+ "   ");
	      System.out.print(average + "   ");
	      System.out.println(letterGrade);
   }
   
}