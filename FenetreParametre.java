import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreParametre  extends JFrame implements ActionListener{
	
	private JComboBox<Integer> tailleGrille_;
	private JComboBox<Integer> nombresEtoiles_;
	private JButton humains_, ia_;
	
	public FenetreParametre() {
		JPanel panneau = new JPanel();
		panneau.setLayout(new GridLayout(3,2));
		
		Integer[] tailles = new Integer[]{8,10};
		tailleGrille_ = new JComboBox<>(tailles);
		panneau.add(new JLabel("Taille de la grille: "));
		panneau.add(tailleGrille_);
		panneau.add(new JLabel("Nombre d'étoiles par joueur: "));
		Integer[] nbEtoiles = new Integer[]{2,3,4,10};
		nombresEtoiles_ = new JComboBox<>(nbEtoiles);
		panneau.add(nombresEtoiles_);
		
		humains_ = new JButton("1 VS 1");
		humains_.addActionListener(this);
		ia_ = new JButton("1 VS IA");
		ia_.addActionListener(this);
		panneau.add(humains_);
		panneau.add(ia_);
		
		setTitle("Param�tres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panneau);
		setVisible(true);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton bouton = (JButton)arg0.getSource();
		boolean ia = false;
		if(bouton.equals(ia_))
			ia = true;
		new FenetreJeu((Integer)tailleGrille_.getSelectedItem(), (Integer)nombresEtoiles_.getSelectedItem(), ia);
		// Ferme la fenetre
		dispose();
	}

}
