package de.peterspan.csv2db.ui.about;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URISyntaxException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

public class AboutDialog extends JDialog {

	public AboutDialog(JFrame parent) throws URISyntaxException {
		super();

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());

		FormLayout layout = new FormLayout("fill:pref:grow");
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();

//		builder.append(new AboutPanel(this));
		JPanel innerPanel = builder.getPanel();
		add(innerPanel, BorderLayout.CENTER);

		Dimension innerDimension = innerPanel.getPreferredSize();
		innerDimension.setSize(innerDimension.width + 10, innerDimension.height + 25);
		setSize(innerDimension);

		this.setResizable(false);
		setLocationRelativeTo(parent);
		setModalityType(ModalityType.APPLICATION_MODAL);

		setVisible(true);

	}
}
