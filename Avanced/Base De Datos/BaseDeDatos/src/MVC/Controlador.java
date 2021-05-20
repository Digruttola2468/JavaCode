package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{

	private Vista view;
	private Modelo model;
	
	public Controlador(Vista view , Modelo model) {
		this.view = view;
		this.model = model;
		
		this.view.btMultiplicar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(view.btMultiplicar == e.getSource()) {
			model.setNumero1(Integer.parseInt(view.txtValor1.getText()));
			model.setNumero2(Integer.parseInt(view.txtValor2.getText()));
			model.Multiplicar();
			
			view.txtResultado.setText(String.valueOf(model.getResultado()));
		}
		
	}
	
}
