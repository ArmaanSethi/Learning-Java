//Armaan Sethi
//Enloe, Potter
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

// An AWT program inherits from the top-level container java.awt.Frame
public class Input extends Frame implements ActionListener {
   private Label lblCount;    // Declare component Label
   private TextField Box1; // Declare component TextField
   private Button btnCount;   // Declare component Button
   /** Constructor to setup GUI components and event handling */
   public Input () {
       addWindowListener(new WindowAdapter(){
		   public void windowClosing(WindowEvent we){
			   System.exit(0);
		   }
	   });
      setLayout(new FlowLayout());
      lblCount = new Label("Int");  // construct Label
      add(lblCount);                    // "super" Frame adds Label
      Box1 = new TextField("", 10); // construct TextField
      Box1.setEditable(true);       // set to read-only
      add(Box1);                     // "super" Frame adds tfCount
      btnCount = new Button("Input");   // construct Button
      add(btnCount);                    // "super" Frame adds Button
      btnCount.addActionListener(this);
      setTitle("ISOLAint");  // "super" Frame sets title
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
	   String in = Box1.getText();
	   ACSLIsolaINT ACSL = new ACSLIsolaINT(in);
   }
}