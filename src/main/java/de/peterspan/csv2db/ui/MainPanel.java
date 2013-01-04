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
package de.peterspan.csv2db.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.jgoodies.forms.builder.ButtonBarBuilder;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.jidesoft.swing.JideBorderLayout;

import de.peterspan.csv2db.converter.Converter;
import de.peterspan.csv2db.converter.LocationConverter;
import de.peterspan.csv2db.ui.res.Messages;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 7769482649486370036L;

	JFrame parent;
	FileSelectionPanel fileSelectionPanel;
	JButton readInputButton, readLocationButton;
	JProgressBar progressBar;

	public MainPanel(JFrame parent) {
		super();
		this.parent = parent;
		initialize();
	}

	private void initialize() {
		setLayout(new JideBorderLayout());

		add(getFileSelectionPanel(), JideBorderLayout.NORTH);

		FormLayout layout = new FormLayout("fill:pref:grow, 4dlu, right:pref"); //$NON-NLS-1$
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);

		ButtonBarBuilder buttonBarBuilder = new ButtonBarBuilder();
		buttonBarBuilder.addGlue();
		buttonBarBuilder.addButton(getReadLocationButton());
		buttonBarBuilder.addButton(getReadInputButton());

		builder.append(getProgressBar());
		builder.append(buttonBarBuilder.build());
		add(builder.getPanel(), BorderLayout.SOUTH);
	}

	private JButton getReadLocationButton() {
		if (readLocationButton == null) {
			readLocationButton = new JButton();
			readLocationButton.setText("Read Locations"); //$NON-NLS-1$

			readLocationButton.setEnabled(false);

			readLocationButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					progressBar.setVisible(true);
					startLocationConvert();
				}
			});
		}
		return readLocationButton;
	}

	private JButton getReadInputButton() {
		if (readInputButton == null) {
			readInputButton = new JButton();
			readInputButton.setText(Messages.getString("MainPanel.1")); //$NON-NLS-1$

			readInputButton.setEnabled(false);

			readInputButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					progressBar.setVisible(true);
					startConvert();
				}
			});
		}
		return readInputButton;
	}

	private FileSelectionPanel getFileSelectionPanel() {
		if (fileSelectionPanel == null) {
			fileSelectionPanel = new FileSelectionPanel(parent);

			fileSelectionPanel
					.addPropertyChangeListener(new PropertyChangeListener() {

						@Override
						public void propertyChange(PropertyChangeEvent evt) {
							if ("csvFileSelected".equals(evt.getPropertyName())) {
								getReadInputButton().setEnabled(true);
								getReadLocationButton().setEnabled(true);
							}

						}
					});
		}
		return fileSelectionPanel;
	}

	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar(0, 100);
			progressBar.setStringPainted(true);
			progressBar.setVisible(false);
		}
		return progressBar;
	}

	private void startLocationConvert() {
		progressBar.setIndeterminate(true);
		progressBar.setString("Reading File...");

		LocationConverter converter = new LocationConverter(
				getFileSelectionPanel().getInputCsvFile());

		converter.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("readingLines".equals(evt.getPropertyName())) {
					progressBar.setIndeterminate(false);
					progressBar.setStringPainted(true);
				}
				if ("progress".equals(evt.getPropertyName())) {
					getProgressBar().setValue((Integer) evt.getNewValue());
					getProgressBar().setString(
							(Integer) evt.getNewValue() + "%");
				}

				if ("done".equals(evt.getPropertyName())) {
					System.out.println("Done");
					progressBar.setVisible(false);
				}
			}
		});

		converter.execute();
	}

	private void startConvert() {
		progressBar.setIndeterminate(true);
		progressBar.setString("Reading File...");

		Converter converter = new Converter(getFileSelectionPanel()
				.getInputCsvFile());

		converter.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("readingLines".equals(evt.getPropertyName())) {
					progressBar.setIndeterminate(false);
					progressBar.setStringPainted(true);
				}
				if ("progress".equals(evt.getPropertyName())) {
					getProgressBar().setValue((Integer) evt.getNewValue());
					getProgressBar().setString(
							(Integer) evt.getNewValue() + "%");
				}

				if ("done".equals(evt.getPropertyName())) {
					System.out.println("Done");
					progressBar.setVisible(false);
				}
			}
		});

		converter.execute();
	}
}
