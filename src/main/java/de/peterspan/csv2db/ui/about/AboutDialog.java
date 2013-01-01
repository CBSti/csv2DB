/**
 *  Copyright 2012-2013 Frederik Hahne, Christoph Stiehm
 *
 * 	This file is part of csv2db.
 *
 *  csv2db is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  csv2db is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with csv2db.  If not, see <http://www.gnu.org/licenses/>.
 */
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

		builder.append(new AboutPanel(this));
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
