import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

// An AWT program inherits from the top-level container java.awt.Frame
public class Input extends Frame implements ActionListener {
   private Label lblCount;    // Declare component Label
   private TextField Box1; // Declare component TextField
   private TextField Box2; // Declare component TextField
   private TextField Box3; // Declare component TextField
   private TextField Box4; // Declare component TextField
   private TextField Box5; // Declare component TextField
   private TextField Box6; // Declare component TextField
   private TextField Box7; // Declare component TextField
   private TextField Box8; // Declare component TextField
   private Button btnCount;   // Declare component Button
   /** Constructor to setup GUI components and event handling */
   public Input () {
	   addWindowListener(new WindowAdapter(){
		   public void windowClosing(WindowEvent we){
			   System.exit(0);
		   }
	   });
      setLayout(new FlowLayout());
      lblCount = new Label("Senior");  // construct Label
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
      Box5 = new TextField("", 10); // construct TextField
      Box5.setEditable(true);       // set to read-only
      add(Box5);                     // "super" Frame adds tfCount
      Box6 = new TextField("", 10); // construct TextField
      Box6.setEditable(true);       // set to read-only
      add(Box6);                     // "super" Frame adds tfCount
      Box7 = new TextField("", 10); // construct TextField
      Box7.setEditable(true);       // set to read-only
      add(Box7);                     // "super" Frame adds tfCount
      Box8 = new TextField("", 10); // construct TextField
      Box8.setEditable(true);       // set to read-only
      add(Box8);                     // "super" Frame adds tfCount
      btnCount = new Button("Input");   // construct Button
      add(btnCount);                    // "super" Frame adds Button
      btnCount.addActionListener(this);
      setTitle("ACSLLandSR");  // "super" Frame sets title
      setSize(1000, 250);        // "super" Frame sets initial window size
      setVisible(true);         // "super" Frame shows
   }
   /** The entry main() method */
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      Input app = new Input();
   }
   /** ActionEvent handler - Called back upon button-click. */
   @Override
   public void actionPerformed(ActionEvent evt) {
	   String startingCity = Box1.getText();
	   String endingCity = Box2.getText();
	   int hour1 = Integer.valueOf(Box3.getText());
	   String ampm1 = Box4.getText();
	   int hour2 = Integer.valueOf(Box5.getText());
	   String ampm2 = Box6.getText();
	   int speed1 = Integer.valueOf(Box7.getText());
	   int speed2 = Integer.valueOf(Box8.getText());
	   ACSLlandSR ACSL = new ACSLlandSR(startingCity.charAt(0), endingCity.charAt(0), hour1, ampm1.charAt(0), hour2, ampm2.charAt(0), speed1, speed2);
   }
}