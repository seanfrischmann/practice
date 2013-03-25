package code;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

// This is a comment
public class Gui {
	//Frame Set-up
	private JFrame _frame = new JFrame();
	private JPanel _up = new JPanel();
	private JPanel _down = new JPanel();
	private JPanel _center = new JPanel();
	private JPanel _right = new JPanel();
	private JPanel _left = new JPanel();
	
	//Buttons
	private JButton _read = new JButton("Read File");
	private JButton _write = new JButton("Write File");
	private JButton _scram = new JButton("Scramble");
	private JButton _conv = new JButton("Convert");
	private JTextArea _text = new JTextArea(6,15);
	private String _input = null;
	
	//Menu Bar Set-up
	private JMenuBar _MenuBar = new JMenuBar();
	private JMenu _file = new JMenu("File");
	private JMenuItem _quit = new JMenuItem("Quit");
	
	//State of Buttons
	private Boolean _conversionState = true;
	private Boolean _scrambleState = true;
	
	public Gui(){
		//Building Menu Bar
		_frame.setJMenuBar(_MenuBar);
		_file.add(_quit);
		_MenuBar.add(_file);
		
		//Add Buttons
		_up.add(_read);
		_down.add(_write);
		_center.add(new JScrollPane(_text));
		_right.add(_scram);
		_left.add(_conv);
		
		//Button Abilities
		_text.setLineWrap(true);
		ActionListener scramble = new scrambleListener(this);
		_scram.addActionListener(scramble);
		ActionListener convert = new convertListener(this);
		_conv.addActionListener(convert);
		ActionListener readFile = new readFileListener(this);
		_read.addActionListener(readFile);
		ActionListener writeFile = new writeFileListener(this);
		_write.addActionListener(writeFile);
		
		//Main Frame
		_frame.getContentPane().setLayout(new BorderLayout());
		_frame.getContentPane().add(_up, BorderLayout.NORTH);
		_frame.getContentPane().add(_down, BorderLayout.SOUTH);
		_frame.getContentPane().add(_center, BorderLayout.CENTER);
		_frame.getContentPane().add(_right, BorderLayout.EAST);
		_frame.getContentPane().add(_left, BorderLayout.WEST);		
		
		//Exiting the program
		_frame.addWindowListener(new closeWindow());		
		_quit.addActionListener(new menuQuit());
	}
	public class writeFileListener implements ActionListener{		
		private Gui _other;
		public writeFileListener(Gui other){
			_other=other;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(_frame, "This Button is still underconstruction, :-/");			
		}		
	}
	public class readFileListener implements ActionListener{		
		private Gui _other;
		public readFileListener(Gui other){
			_other=other;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(_frame, "This Button is still underconstruction, :-/");			
		}		
	}
	public class convertListener implements ActionListener{		
		private Gui _other;
		public convertListener(Gui other){
			_other=other;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			_input = _text.getText();
			if(_input.isEmpty()){
				JOptionPane.showMessageDialog(_frame, "Please input something in the given box");
			}
			else{
				if (_conversionState){				
					_input = _other.convertToNumber(_input);
					_text.setText(_input);
				}
				else if (!_conversionState){				
					_input = _other.convertToLetter(_input);
					_text.setText(_input);
				}
			}									
		}		
	}
	//Method to convert String to Integers
	public String convertToNumber(String s){
		_conversionState = false;
		_scrambleState = false;
		char[] input = s.toCharArray();
		String output = "";
		for (char c : input){
			output = output + (c-0) + " ";					
		}		
		return output;
	}
	public String convertToLetter(String s){
		_conversionState = true;
		_scrambleState = true;
		String output = "";
		String x = "";
		for(int i=0; i< s.length(); i++){
			char c = s.charAt(i);
			if (c == ' '){
				int d = Integer.parseInt(x);
				output = output + (Character.toString((char) d));
				x = "";
			}
			else{
				x = x + c;
			}
		}				
		return output;
	}
	public class scrambleListener implements ActionListener{
		
		private Gui _other;
		public scrambleListener(Gui other){
			_other = other;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			_input =_text.getText();
			if(_input.isEmpty()){
				JOptionPane.showMessageDialog(_frame, "Please input something in the given box");
			}
			else{
				if (_scrambleState){						
					_input = _other.scramble(_input);
					_text.setText(_input);
				}
				else{
					JOptionPane.showMessageDialog(_frame, "Please convert back to letters before attempting to Scramble.");
				}
			}			
		}		
	}
	//Method to scramble a String 	
	public String scramble(String s){
		String[] scram = s.split("");//Creates an array of parsed string
		List<String> letters = Arrays.asList(scram); //puts array into a list
		Collections.shuffle(letters);//shuffles list
		StringBuilder output = new StringBuilder(s.length());
		for (String c : letters){
			output.append(c);
		}		
		return output.toString();
	}
	//Method displays a dialog box requesting user to choose whether to exit program or not
	public void closingMessage(){
		final JDialog dialog = new JDialog(_frame, "Where are you goin!", true);
		final JOptionPane optionPane = new JOptionPane("Are you sure you want to leave?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
		dialog.setContentPane(optionPane);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				JOptionPane.showMessageDialog(_frame, "Hasta Luego!");
				System.exit(0);
			}
		});
		optionPane.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent e){
				String prop = e.getPropertyName();
				if(dialog.isVisible() && (e.getSource() == optionPane) && (prop.equals(JOptionPane.VALUE_PROPERTY))){
					dialog.setVisible(false);
				}
			}
		});
		dialog.pack();
		dialog.setVisible(true);
		int value = ((Integer)optionPane.getValue()).intValue();
		if(value == JOptionPane.YES_NO_OPTION){
			JOptionPane.showMessageDialog(_frame, "Hasta Luego!");
			System.exit(0);
		}
		else if(value == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(_frame, "HoOrAy!");
		}
	}
	public class menuQuit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			closingMessage();									
		}		
	}
	public class closeWindow extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			closingMessage();
		}
	}
	public void launchFrame(){
		//Displays Frame
		_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		_frame.pack();//Adjusts panel to components for display
		_frame.setVisible(true);
	}	
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.launchFrame();
	}

}
