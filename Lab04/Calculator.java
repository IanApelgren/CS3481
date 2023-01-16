import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





/**
 * Algorithms contains several algorithms with different complexities.
 * 
 * @author Ian Apelgren
 * @version February 6, 2020
 */
public class Calculator
{
    public JFrame frame = new JFrame("Calculator");
    public JPanel buttonPanel = new JPanel();
    public JPanel resultPanel = new JPanel();
    public JPanel textFieldPanel = new JPanel();
    public JButton addButton = new JButton("add");
    public JButton subButton = new JButton("sub");
    public JButton multButton = new JButton("mult");
    public JButton divButton = new JButton("div");
    public JLabel resultLabel = new JLabel();
    public JTextField input1 = new JTextField();
    public JTextField input2 = new JTextField();
    
    public Calculator()
    {
        
        frame.setSize(500,250);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        addButton.setName("addButton");
        subButton.setName("subButton");
        multButton.setName("multButton");
        divButton.setName("divButton");
        
        //addButton.setSize(100,50);
        //subButton.setSize(100,50);
        //multButton.setSize(100,50);
        //divButton.setSize(100,50);
        
        resultLabel.setName("resultLabel");
        
        input1.setName("LeftOperand");
        input2.setName("RightOperand");
        
        textFieldPanel.add(input1);
        input1.setPreferredSize( new Dimension( 200, 24 ) );
        textFieldPanel.add(input2);
        input2.setPreferredSize( new Dimension( 200, 24 ) );
        
        resultPanel.add(resultLabel);
        
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(multButton);
        buttonPanel.add(divButton); 
        
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(resultPanel, BorderLayout.CENTER);
        frame.add(textFieldPanel, BorderLayout.NORTH);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addButton.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
               String strL = getLeft(); 
               String strR = getRight();
               
               double numL = checkNum(strL);
               double numR = checkNum(strR);
               
               if (numL != -.1 && numR != -.1) 
               {
                   resultLabel.setText("answer = " + (numL + numR));
               }
               else
               {
                   resultLabel.setText("answer = Error");
               }
  
            }

        });
        
        subButton.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                String strL = getLeft(); 
                String strR = getRight();
                
                double numL = checkNum(strL);
                double numR = checkNum(strR);
                
                if (numL != -.1 && numR != -.1) 
                {
                    resultLabel.setText("answer = " + (numL - numR));
                }
                else
                {
                    resultLabel.setText("answer = Error");
                }
            }

        });
        
        multButton.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                String strL = getLeft(); 
                String strR = getRight();
                
                double numL = checkNum(strL);
                double numR = checkNum(strR);
                
                if (numL != -.1 && numR != -.1) 
                {
                    resultLabel.setText("answer = " + (numL * numR));
                }
                else
                {
                    resultLabel.setText("answer = Error");
                }
            }

        });
        
        divButton.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                String strL = getLeft(); 
                String strR = getRight();
                
                double numL = checkNum(strL);
                double numR = checkNum(strR);
                
                if (numL != -.1 && numR != -.1 && numR != 0) 
                {
                    resultLabel.setText("answer = " + (numL / numR));
                }
                else
                {
                    resultLabel.setText("answer = Error");
                }
  
            }

        });
        
    }
    
    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }

    /**
     * frame getter
     * @return frame
     */
    public JFrame getFrame()
    {
        return frame;
    }
    
    /**
     * frame setter
     * @param frame
     */
    public void setFrame(JFrame frame)
    {
        this.frame = frame;
    }
    
    /**
     * frame getter
     * @return str2
     */
    public String getLeft()
    {
        String str1 = input1.getText();
        return str1;
    }

    /**
     * frame getter
     * @return str2
     */
    public String getRight()
    {
        String str2 = input2.getText();
        return str2;
    }

    /**
     * checks to make sure inputs can be passed as int returns -1 if that isnt the case
     * @param str
     * @return checkNum
     */
    public double checkNum(String str)
    {
        double checkNum;
        try {
            checkNum = Double.parseDouble(str);
        }
        catch(NumberFormatException e) 
        {
          checkNum = -.1;  
        }
        return checkNum;
    }










}


