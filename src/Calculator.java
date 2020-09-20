/*
* File name : Calculator.java
* Description of class : This class contains methods which are written in the swing GUI that make up a calculator
* !!!!!! REQUIRES MIGLAYOUT JAR !!!!!! -to be added in project/properties/java build path/classpath/add external jar
*/

import net.miginfocom.swing.MigLayout;//importing the MigLayout manager

import java.awt.event.ActionEvent;//import the action event
import java.awt.event.ActionListener;//import the action listener
import javax.swing.*;//import the java swing components
import java.util.Stack;//import the stack library

public class Calculator extends JFrame implements ActionListener{
	//creating variables
	private boolean decimalPoint;//boolean used to control when the decimal point can be used
	private double result;//double variable showing the outcome of the calculations
	private double number1;//the first number inputed by the user
	private double number2;//second number after an operation sign imputed by the user
	private String value;//string version of the result
	private String num1 = null;//first number inputed as a string
	
	//assign name to JPanel
	private JPanel parentPanel;//main panel
	
	//assign name to JTextField
	private JTextField display;//text field on the top of the panel
	
	//assign names to JButtons
	private JButton backspace;//delete last character button
	private JButton CE;//delete everything
	private JButton C;//delete the current display in the textField
	private JButton plus;//add first number and second number
	private JButton divide;//divide first number by second number
	private JButton multiply;//multiply first number by the second number
	private JButton minus;//take away the second number from the first number
	private JButton equals;//displays equals sign and then the result
	private JButton dot;//displays the decimal point
	private JButton zero;//displays zero
	private JButton one;//displays number one
	private JButton two;//displays number two
	private JButton three;//displays number three
	private JButton four;//displays number four
	private JButton five;//displays number five
	private JButton six;//displays number six
	private JButton seven;//displays number seven
	private JButton eight;//displays number eight
	private JButton nine;//displays number nine
	private JButton plusMinus;//reverses the sign of the display value
	private JButton squareRoot;//calculates the square root of the display value
	private JButton percent;//calculates a certain percentage of the first value inputed
	private JButton power;//calculates the first number to the power of the second number
	private JButton inverse;//one divided by the value of display
	
	//create a stack called stack
	private Stack<String> stack;
	
	public Calculator(){
	//create a new empty stack 
	stack = new Stack<String>();
		
	//initialize the parentPanel
	parentPanel = new JPanel();
		
	//initialize the textField
	display = new JTextField(20);
	display.setEditable(false);//textField should not be editable
		
	//initialize the buttons
	plusMinus = new JButton("+-");
	squareRoot = new JButton("Root");
	percent = new JButton("%");
	power = new JButton("^");
	inverse = new JButton("1/x");
	backspace = new JButton("<");
	CE = new JButton("CE");
	C = new JButton("C");
	plus = new JButton("+");
	divide = new JButton("/");
	multiply = new JButton("*");
	minus = new JButton("-");
	equals = new JButton("=");
	dot = new JButton(".");
	zero = new JButton("0");
	one = new JButton("1");
	two = new JButton("2");
	three  = new JButton("3");
	four = new JButton("4");
	five = new JButton("5");
	six = new JButton("6");
	seven = new JButton("7");
	eight = new JButton("8");
	nine = new JButton("9");
		
	//add all components to the parentPanel - main panel
	parentPanel.setLayout(new MigLayout("", "[grow, fill]", "[grow, fill]"));//(layout constraints, column constraints, row constraints)
	parentPanel.add(display, "wrap, span");//move whatever is after the textField to the next row and span to the width of the frame
	parentPanel.add(backspace);
	parentPanel.add(CE);
	parentPanel.add(C);
	parentPanel.add(plusMinus);
	parentPanel.add(squareRoot, "wrap");//move the next button to the next row
	parentPanel.add(seven);
	parentPanel.add(eight);
	parentPanel.add(nine);
	parentPanel.add(divide);
	parentPanel.add(percent, "wrap");//move the next button to the next row
	parentPanel.add(four);
	parentPanel.add(five);
	parentPanel.add(six);
	parentPanel.add(multiply);
	parentPanel.add(power, "wrap");//move the next button to the next row
	parentPanel.add(one);
	parentPanel.add(two);
	parentPanel.add(three);
	parentPanel.add(minus);
	parentPanel.add(inverse, "wrap");//move the next button to the next row
	parentPanel.add(zero, "span 2");//span the zero button 2 cells
	parentPanel.add(dot);
	parentPanel.add(plus);
	parentPanel.add(equals);
		
		//action listeners
		//action listener for backspace
		backspace.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String newDisplay = null;//create a variable for the new display number
				newDisplay = display.getText().substring(0, display.getText().length() - 1);//let the newDisplay equal to the numbers already in display minus the last number
				display.setText(newDisplay);//display the remaining numbers
			
				if(display.getText().substring(display.getText().length() - 1).equals(".")){//if last element of display is decimal point
					decimalPoint = false;//set it to false
				}
			}
		});
		
		//action listener for CE
		C.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText("");//clear the display
				result = 0;//clear result
				number1 = 0;//clear the first number
				number2 = 0;//clear the second number
				decimalPoint = false;//set decimal point to false
			
				for (int i = 0; i < stack.size(); i++){//go through every number in the stack\\
					stack.pop();//delete the item
				}
			}
		});
		
		//action listener for C
		CE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText("");//clear the display
			
				for (int i = 0; i < stack.size(); i++){//go through every number in the stack
					stack.pop();//delete the item
				}
			
				decimalPoint = false;//set decimal point to false
			}
		});
		
		//action listener for plus
		plus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set the decimal point to false
				stack.push("+");//add the sign to the stack
					
				if(stack.peek().equals("+")){//if + was added to the stack
					num1 = display.getText();//set num1 the value which is in display
					number1 = Double.parseDouble(num1);//change num1 to a double and set number1 its value
					display.setText("");//clear the display
				}	
			}
		});
		
		//action listener for minus
		seven.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "7");//add number 7 to the textField
			}
		});
		
		//action listener for eight
		eight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "8");//add number 8 to the textField
			}
		});
		
		//action listener for nine
		nine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "9");//add number 9 to the textField
			}
		});
		
		//action listener for divide
		divide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set decimal point to false
				stack.push("/");//add the division sign to the stack
					
				if(stack.peek().equals("/")){//if the last item inputed in the stack is the division sign 
					num1 = display.getText();//set the value of num1 the display value
					number1 = Double.parseDouble(num1);//change num1 to a double and set number1 its value
					display.setText("");//clear the display
				}
			}
		});
		
		//action listener for four
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "4");//add number 4 to the textField
			}
		});
		
		//action listener for five
		five.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "5");//add number 5 to the textField
			}
		});
		
		//action listener for six
		six.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "6");//add number 6 to the textField
			}
		});
		
		//action listener for multiply
		multiply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set decimal point to false
				stack.push("*");//add the multiply sign to the stack
					
				if(stack.peek().equals("*")){//if the last item inputed in the stack is the multiply sign 
					num1 = display.getText();//set num1 the value of the textField
					number1 = Double.parseDouble(num1);//change num1 to a double and set the number1 its value
					display.setText("");//clear the textField
				}
			}
		});
		
		//action listener for one
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "1");//add number 1 to the textField
			}
		});
		
		//action listener for two
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "2");//add number 2 to the textField
			}
		});
		
		//action listener for three
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "3");//add number 3 to the textField
			}
		});
		
		//action listener for minus
		minus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set decimalPoint to false
				stack.push("-");//add the minus sign to the stack
					
				if(stack.peek().equals("-")){//if the last item inputed in the stack is the minus sign
					num1 = display.getText();//set num1 the value of the textField
					number1 = Double.parseDouble(num1);//change num1 to a double and set the number1 variable its value
					display.setText("");//clear the textField
				}
			}
		});
		
		//action listener for zero
		zero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				display.setText(display.getText() + "0");//add zero to the textField
			}
		});
		
		//action listener for dot
		dot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (decimalPoint != true){//if the decimal point has not been used yet
					display.setText(display.getText() + ".");//add the decimal point to the textField
					decimalPoint = true;//set the decimalPoint to true
				}
			}
		});
		
		//action listener for equals
		equals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set decimal point to false
				
				if (stack.peek().equals("+")){//if the last item in the stack is the plus sign
					String num2 = display.getText();//set num2 the value of the textField
					number2 = Double.parseDouble(num2);//change num2 to a double and set number2 its value
					calculatePlus();//calculate the operation method
					display.setText(value);//display the result in the textField
				}
				else if (stack.peek().equals("/")){//if the last item in the stack is the division sign
					String num2 = display.getText();//set num2 the value of the textField
					number2 = Double.parseDouble(num2);//change num2 to a double and set number2 its value
					calculateDivide();//calculate the operation method
					display.setText(value);//display the result in the textField
				}
				else if (stack.peek().equals("*")){//if the last item in the stack is the multiply sign
					String num2 = display.getText();//set num2 the value of the textField
					number2 = Double.parseDouble(num2);//change num2 to a double and set number2 its value
					calculateMultiply();//calculate the operation method
					display.setText(value);//display the result in the textField
				}
				else if (stack.peek().equals("-")){//if the last item in the stack is the minus sign
					String num2 = display.getText();//set num2 the value of the textField
					number2 = Double.parseDouble(num2);//change num2 to a double and set number2 its value
					calculateMinus();//calculate the operation method
					display.setText(value);//display the result in the textField
				}	
				else if (stack.peek().equals("^")){//if the last item in the stack is the power sign
					String num2 = display.getText();//set num2 the value of the textField
					number2 = Double.parseDouble(num2);//change num2 to a double and set number2 its value
					calculatePower();//calculate the operation method
					display.setText(value);//display the result in the textField
				}
				else if (stack.peek().equals("1/x")){//if the last item in the stack is the inverse sign
					calculateInverse();//calculate the operation method
					display.setText(value);//display the result in the textField
				}
			}
		});
		
		//action listener for the plus minus button
		plusMinus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double val = Double.parseDouble(display.getText());//change the value in the textField to a double
				val = val * -1;//the value is the value of the textField multiplied by minus one
				String newVal = Double.toString(val);//change the value to a string
				display.setText("");//clear the textField
				display.setText(newVal);//display the string version of the value
			}
		});
		
		//action listener for the square root button
		squareRoot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set decimal point to false
				stack.push("Root");//add the root sign to the stack
				
				if(stack.peek().equals("Root")){//if the last item in the stack is root
					num1 = display.getText();//set the value of num1 the value in the textField
					number1 = Double.parseDouble(num1);//change num1 to a double
					calculateSquareRoot();//calculate the operation method
					display.setText(value);//display the result
				}
			}
		});
		
		//action listener for the percentage button
		percent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set decimalPoint to false
				stack.push("%");//add the percent sign to the stack
					
				if(stack.peek().equals("%")){//if the last item inputed in the stack is the percent sign
					String num2 = display.getText();//set num2 the value of the textField
					number2 = Double.parseDouble(num2);//change num2 to a double and set number2 its value
					calculatePercent();//calculate the operation method
					display.setText(value);//display the result
				}
			}
		});
		
		//action listener for the power button
		power.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set the decimalPoint to false
				stack.push("^");//add the power sign to the stack
					
				if(stack.peek().equals("^")){//if the last value inputed in the stack is the power sign
					num1 = display.getText();//set the value of num1 the value of the textField
					number1 = Double.parseDouble(num1);//change num1 to a double
					display.setText("");//clear the textField
				}
			}
		});
		
		//action listener for the inverse button
		inverse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				decimalPoint = false;//set the decimal point to false
				stack.push("1/x");//add the inverse sign to the stack
					
				if(stack.peek().equals("1/x")){//if the last item inputed in the stack is the inverse
					num1 = display.getText();//set the value of num1 the value of the textField
					number1 = Double.parseDouble(num1);//change num1 to a double
					calculateInverse();//calculate the operation method
					display.setText(value);//display the result
				}
			}
		});
		
	//add the parent panel to the main frame 
	add(parentPanel);  
	}
	
	//method calculating the addition
	public String calculatePlus(){
		result = number1 + number2;//add number1 and number2
		value = Double.toString(result);//change the result to a string
		return value;
	}
	
	//method calculating the division
	public String calculateDivide(){
		result = number1 / number2;//number1 divided by number2
		value = Double.toString(result);//change the result to a string
		return value;
	}
	
	//method calculating the multiplication
	public String calculateMultiply(){
		result = number1 * number2;//number1 multiplied by number2
		value = Double.toString(result);//change the result to a string
		return value;
	}
	
	//method calculating the subtraction
	public String calculateMinus(){
		result = number1 - number2;//number1 minus number2
		value = Double.toString(result);//change the result to a string
		return value;
	}
	
	//method calculating the square root 
	public String calculateSquareRoot() {
		result = Math.sqrt(number1);//use the Math.sqrt(x) operation to calculate the square root
		value = Double.toString(result);//change the result to a string
		return value;
	}
	
	//method calculating the percentage
	public String calculatePercent(){
		result = number2 / 100;//number2 divided by 100
		result = result * number1;//multiplied by number1
		result = result + number1;//added to the value of number1
		value = Double.toString(result);//change the result to a string
		return value;
	}
	
	//method calculating the power
	public String calculatePower(){
		result = Math.pow(number1, number2);//use the Math.pow(x, y) operation to calculate the power
		value = Double.toString(result);//change the result to a string
		return value;
	}
	
	//method calculating the inverse
	public String calculateInverse(){
		result = 1 / number1;//one divided by the value of number1
		value = Double.toString(result);//change the result to a string
		return value;
	}
	
	//main method
	public static void main(String[] args){
		Calculator calculator = new Calculator();
		calculator.setTitle("Calculator");//set the title of the frame to calculator
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//when the user presses x it would close
		calculator.setSize(500, 500);//the size (width, height)
		calculator.setVisible(true);//show the frame and its components when running
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}