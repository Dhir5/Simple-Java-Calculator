import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
   static JFrame f;
   static JTextField l;
   String s0, s1, s2;

   Calculator() {
      s0 = s1 = s2 = " ";
   }

   public static void main(String[] args) {
      f = new JFrame("Calculator");

      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
         System.err.println(e.getMessage());
      }

      Calculator cal = new Calculator();

      l = new JTextField(16);

      l.setEditable(false);

      JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bSub, bMul, bDiv, bDot, bClr, bEqu;

      b0 = new JButton("0");
      b1 = new JButton("1");
      b2 = new JButton("2");
      b3 = new JButton("3");
      b4 = new JButton("4");
      b5 = new JButton("5");
      b6 = new JButton("6");
      b7 = new JButton("7");
      b8 = new JButton("8");
      b9 = new JButton("9");


      bEqu = new JButton("=");

      bAdd = new JButton("+");
      bSub = new JButton("-");
      bMul = new JButton("*");
      bDiv = new JButton("/");
      bClr = new JButton("C");

      bDot = new JButton(".");

      JPanel pan = new JPanel();


      b0.addActionListener(cal);
      b1.addActionListener(cal);
      b2.addActionListener(cal);
      b3.addActionListener(cal);
      b4.addActionListener(cal);
      b5.addActionListener(cal);
      b6.addActionListener(cal);
      b7.addActionListener(cal);
      b8.addActionListener(cal);
      b9.addActionListener(cal);
      bAdd.addActionListener(cal);
      bSub.addActionListener(cal);
      bMul.addActionListener(cal);
      bDiv.addActionListener(cal);
      bDot.addActionListener(cal);
      bEqu.addActionListener(cal);
      bClr.addActionListener(cal);

      pan.add(l);

      pan.add(b1);
      pan.add(b2);
      pan.add(b3);
      pan.add(bAdd);

      pan.add(b4);
      pan.add(b5);
      pan.add(b6);
      pan.add(bSub);

      pan.add(b7);
      pan.add(b8);
      pan.add(b9);
      pan.add(bMul);

      pan.add(bDot);
      pan.add(b0);
      pan.add(bClr);
      pan.add(bDiv);

      pan.add(bEqu);

      pan.setBackground(Color.DARK_GRAY);

      f.add(pan);
      f.setSize(200, 200);  

      f.show();
   }

   public void actionPerformed(ActionEvent e) {
      String s = e.getActionCommand();
      if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
         if (!s1.equals("")) {
            s2 = s2 + s;
         } else {
            s0 = s0 + s;
         }

         l.setText(s0 + s1 + s2);
      } else if (s.charAt(0) == 'C') {
         s0 = s1 = s2 = "";

         l.setText(s0 + s1 + s2);
      } else if (s.charAt(0) == '=') {
         double te;

         if (s1.equals("+")) {
            te = (Double.parseDouble(s0) + Double.parseDouble(s2));
         } else if (s1.equals("-")) {
            te = (Double.parseDouble(s0) - Double.parseDouble(s2));
         } else if (s1.equals("*")) {
            te = (Double.parseDouble(s0) * Double.parseDouble(s2));

         } else {
            te = (Double.parseDouble(s0) / Double.parseDouble(s2));
         }

         l.setText(s0 + s1 + s2 + "=" + te);

         s0 = Double.toString(te);
         s1 = s2 = "";
      } else {
         if (s1.equals("") || s2.equals("")) {
            s1 = s;
         } else {
            double te;

            if (s1.equals("+")) {
               te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            } else if (s1.equals("-")) {
               te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            } else if (s1.equals("*")) {
               te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            } else {
               te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            }

            s0 = Double.toString(te);

            s1 = s;
            s2 = "";
         }

         l.setText(s0 + s1 + s2);
      }

   }
}
