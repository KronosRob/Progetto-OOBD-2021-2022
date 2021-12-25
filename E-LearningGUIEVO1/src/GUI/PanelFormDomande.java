package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelFormDomande extends JPanel
{
	private JTextField DomandaField;
	private JTextField RispostaField;
	private JPanel PanelForm;
	private int NumeroRispostePrecedenti;
	private int aggiorna;
	private int NumeroRisposte;
	public JLabel[] labels=new JLabel[100];
	public JTextField MultiplaRisposta[] = new JTextField[100];
	
	
	public PanelFormDomande() 
	{
		aggiorna=10;
		PanelForm = new JPanel();
		PanelForm.setBounds(273, 184, 434, 441);
		
		PanelForm.setLayout(null);
		
		JLabel NumeroQuizLabel = new JLabel("Quiz : null");
		NumeroQuizLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		NumeroQuizLabel.setBounds(10, 11, 80, 20);
		PanelForm.add(NumeroQuizLabel);
		
		DomandaField = new JTextField();
		DomandaField.setBounds(71, 48, 335, 31);
		PanelForm.add(DomandaField);
		DomandaField.setColumns(10);
		
		JLabel DomandaLabel = new JLabel("Domanda");
		DomandaLabel.setFont(new Font("Source Code Pro", Font.BOLD, 11));
		DomandaLabel.setBounds(10, 53, 66, 20);
		PanelForm.add(DomandaLabel);
		
		JCheckBox RispostaMCheckBox = new JCheckBox("Risposta Multipla");
		
		RispostaMCheckBox.setBounds(10, 97, 111, 23);
		PanelForm.add(RispostaMCheckBox);
		
		JLabel RispostaLabel = new JLabel("Risposta");
		RispostaLabel.setFont(new Font("Source Code Pro", Font.BOLD, 11));
		RispostaLabel.setBounds(10, 143, 66, 31);
		PanelForm.add(RispostaLabel);
		
		RispostaField = new JTextField();
		RispostaField.setBounds(71, 143, 335, 31);
		PanelForm.add(RispostaField);
		RispostaField.setColumns(10);
		
		SpinnerModel model1Model=new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner QuanteMultipleSpinner = new JSpinner(model1Model);
		
		QuanteMultipleSpinner.setEnabled(false);
		QuanteMultipleSpinner.setBounds(121, 97, 36, 23);
		PanelForm.add(QuanteMultipleSpinner);
		
		JPanel DomandePanel = new JPanel();
		DomandePanel.setBounds(0, 197, 434, 233);
		PanelForm.add(DomandePanel);
		DomandePanel.setLayout(null);
		
		
		RispostaMCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
			
				if (RispostaMCheckBox.isSelected()) 
				{
					QuanteMultipleSpinner.setEnabled(true);
					NumeroRisposte=(Integer)QuanteMultipleSpinner.getValue();
					char lettera='A';  
					String letteraString=String.valueOf(lettera);  
					aggiorna=10;
			        for (int i=0;i<NumeroRisposte;i++)
			        {
			            labels[i]=new JLabel(letteraString);
			            lettera++;
			            letteraString=String.valueOf(lettera);
			            labels[i].setFont(new Font("Source Code Pro", Font.BOLD, 11));
			            labels[i].setBounds(33, aggiorna, 48, 31);
			            MultiplaRisposta[i] = new JTextField();
			            MultiplaRisposta[i].setColumns(10);
			    		MultiplaRisposta[i].setBounds(71, aggiorna, 335, 31);
			            aggiorna=aggiorna+40;
			        }
			        for (int i=0;i<NumeroRisposte;i++)
			        {
			            DomandePanel.add(labels[i]);
			            DomandePanel.add(MultiplaRisposta[i]);
			            
			            
			        }
			        DomandePanel.repaint();
			        DomandePanel.revalidate();
					System.out.println("Nellla CheckBox "+NumeroRisposte);
					
				}
				else 
				{
					
					QuanteMultipleSpinner.setEnabled(false);
					System.out.print(NumeroRisposte);
					DomandePanel.removeAll();
					labels[0]=new JLabel("");
					MultiplaRisposta[0]=new JTextField();
					MultiplaRisposta[0].setBounds(0, 0, 0, 0);
					DomandePanel.add(labels[0]);
			        DomandePanel.add(MultiplaRisposta[0]);
			        DomandePanel.repaint();
			        DomandePanel.revalidate();
			        DomandePanel.removeAll();
				}
			}
		});
		//TODO creare Form JPanel Automatici per tot domande
		
	
		QuanteMultipleSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{	
				if(RispostaMCheckBox.isSelected())
				{
					NumeroRispostePrecedenti=NumeroRisposte;
					System.out.println("Precendenti "+NumeroRispostePrecedenti);
					NumeroRisposte=(Integer)QuanteMultipleSpinner.getValue();
					System.out.println("Risposte "+NumeroRisposte);
					if(NumeroRisposte>=1)
					{
						if(NumeroRispostePrecedenti<NumeroRisposte)
						{
							
							NumeroRispostePrecedenti=NumeroRisposte;
							char lettera='A';  
							String letteraString=String.valueOf(lettera);  
							int aggiorna=10;
					        for (int i=0;i<NumeroRisposte;i++)
					        {
					            labels[i]=new JLabel(letteraString);
					            lettera++;
					            letteraString=String.valueOf(lettera);
					            labels[i].setFont(new Font("Source Code Pro", Font.BOLD, 11));
					            labels[i].setBounds(33, aggiorna, 48, 31);
					            MultiplaRisposta[i] = new JTextField();
					            MultiplaRisposta[i].setColumns(10);
					    		MultiplaRisposta[i].setBounds(71, aggiorna, 335, 31);
					            aggiorna=aggiorna+40;
					        }
					        for (int i=0;i<NumeroRisposte;i++)
					        {
					            DomandePanel.add(labels[i]);
					            DomandePanel.add(MultiplaRisposta[i]);
					            
					        }
					        DomandePanel.repaint();
					        DomandePanel.revalidate();
						}
						//2h e 30 min Per farlo mananggia boh
						else 
						{		
							System.out.println("Sono Nel Altra Parte");
							System.out.println("Risposte Vale"+NumeroRisposte);
							DomandePanel.removeAll();
							char lettera='A';  
							String letteraString=String.valueOf(lettera);  
							int aggiorna=10;
					        for (int i=0;i<NumeroRisposte;i++)
					        {
					            labels[i]=new JLabel(letteraString);
					            lettera++;
					            letteraString=String.valueOf(lettera);
					            labels[i].setFont(new Font("Source Code Pro", Font.BOLD, 11));
					            labels[i].setBounds(33, aggiorna, 48, 31);
					            MultiplaRisposta[i] = new JTextField();
					            MultiplaRisposta[i].setColumns(10);
					    		MultiplaRisposta[i].setBounds(71, aggiorna, 335, 31);
					            aggiorna=aggiorna+40;
					        }
					        for (int i=0;i<NumeroRisposte;i++)
					        {
					            DomandePanel.add(labels[i]);
					            DomandePanel.add(MultiplaRisposta[i]);
					            
					        }
					        
							DomandePanel.repaint();
							DomandePanel.revalidate();
						}
					}
					
					
				}
			}
		});
	}
}
