import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class ventanaPrincipal extends JFrame implements KeyListener,ActionListener{
	convertirMedidas cm = new convertirMedidas();
	private GridBagConstraints gbc = new GridBagConstraints();
	private static final long serialVersionUID = 1L;
	private GridBagLayout gbl = new GridBagLayout();
	private JTextField txt,caja,c1,c2,c3,cAll,cMill,cPies,cIn;
	private JRadioButton a1,a2,a3,all;
	private boolean teclado = false;
	
	
	public  ventanaPrincipal() {
		getContentPane().setLayout(gbl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Calculadora");
        setVisible(true);
        ButtonGroup bg = new ButtonGroup();
        
        txt = new JTextField("     Ingresa Kilometros");
        txt.setBorder(null);
        txt.setEditable(false);
        components(txt, 0, 0, 7, 1);
        
        caja = new JTextField(15);
        caja.setText("2");
        caja.addKeyListener(this);
        components(caja, 0, 2, 4, 1);
        ///////////////////////////////////////////////////////////////////////////
        all = new JRadioButton();
        bg.add(all);
        all.addActionListener(this);
        components(all, 0, 3, 1, 1);
        
        cAll = new JTextField("<<<Todos>>>");
        cAll.setBorder(null);
        cAll.setEditable(false);
        components(cAll, 2, 3, 1, 1);
        
        ////////////////////////////////////////////////////////////////////////////
        a1 = new JRadioButton();
        bg.add(a1);
        a1.addActionListener(this);
        components(a1, 0, 4, 1, 1);
        
        c1 = new JTextField("Millas");
        c1.setBorder(null);
        c1.setEditable(false);
        components(c1, 2, 4, 1, 1);
        
        cMill = new JTextField(6);
        cMill.setEditable(false);
        components(cMill, 3, 4, 1, 1);
        //////////////////////////////////////////////////////////////////////
        a2 = new JRadioButton();
        bg.add(a2);
        a2.addActionListener(this);
        components(a2, 0, 5, 1, 1);
        
        c2 = new JTextField("Pies");
        c2.setBorder(null);
        c2.setEditable(false);
        components(c2, 2, 5, 1, 1);
        
        cPies = new JTextField(6);
        cPies.setEditable(false);
        components(cPies, 3, 5, 1, 1);
        ////////////////////////////////////////////////////////////////////
        a3 = new JRadioButton();
        bg.add(a3);
        a3.addActionListener(this);
        components(a3, 0, 6, 1, 1);
        
        c3 = new JTextField("Pulgadas");
        c3.setBorder(null);
        c3.setEditable(false);
        components(c3, 2, 6, 1, 1);
        
        cIn = new JTextField(6);
        cIn.setEditable(false);
        components(cIn, 3, 6, 1, 1);
        //////////////////////////////////////////////////////////////////////////////
	}
	
	
	
	public void components(JComponent c, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(c, gbc);
        add(c);
    }
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//==================================================
		double a = Double.parseDouble(caja.getText());
		System.out.println(a);
		if(e.getSource()==all) {
			cIn.setText("");
			cMill.setText("");
			cPies.setText("");
			cIn.setText(cm.pulgadas(a)+"");
			cMill.setText(cm.millas(a)+"");
			cPies.setText(cm.pies(a)+"");
			
		}else if(e.getSource()==a1) {
			cIn.setText("");
			cMill.setText("");
			cPies.setText("");
			cMill.setText(cm.millas(a)+"");
		}else if(e.getSource()==a2) {
			cIn.setText("");
			cMill.setText("");
			cPies.setText("");
			cPies.setText(cm.pies(a)+"");
		}else if(e.getSource()==a3) {
			cIn.setText("");
			cMill.setText("");
			cPies.setText("");
			cIn.setText(cm.pulgadas(a)+"");
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	boolean impedirLetras(KeyEvent e) {
		char a = e.getKeyChar();//La tecla que puché
		return !(Character.isDigit(a) || (a == '.' && !teclado));//Si la tecla precionada no es una letra
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		for(char l : caja.getText().toCharArray()) {//Iterando Checamos sobre cada letra de la caja
			
			if(l == '.') { teclado = true; break;}//con esto no permitimos masde un punto
			
		}
		
		if(impedirLetras(e)) e.consume();//si o no escribir el "." .
		
	}
	
}

public class interfaceMedidas {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ventanaPrincipal();
			}
		});
	}
}
