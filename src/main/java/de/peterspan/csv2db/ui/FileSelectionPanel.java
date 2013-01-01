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
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FilenameUtils;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import de.peterspan.csv2db.ui.res.Icons;

public class FileSelectionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3152504963068192019L;

	JFrame parent;
	JButton selectCsvFileButton;
	JTextField csvFileNameTextField;
	File inputCsvFile;

	public FileSelectionPanel(JFrame parent) {
		super();
		this.parent = parent;
		setLayout(new BorderLayout());
		init();
	}

	private void init() {
		FormLayout layout = new FormLayout("fill:pref:grow, 4dlu, pref");
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);

		builder.appendSeparator("Select CSV File");
		builder.append(getCsvFilenameTextField());
		builder.append(getSelectCsvSelectButton());

		add(builder.build(), BorderLayout.CENTER);
	}

	private JTextField getCsvFilenameTextField() {
		if (csvFileNameTextField == null) {
			csvFileNameTextField = new JTextField();
			csvFileNameTextField.setEnabled(false);
		}
		return csvFileNameTextField;
	}

	private JButton getSelectCsvSelectButton() {
		if (selectCsvFileButton == null) {
			selectCsvFileButton = new JButton();
			selectCsvFileButton.setText("Select CSV");
			selectCsvFileButton.setIcon(Icons.IC_MIME_CSV_SMALL);

			selectCsvFileButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc = getFileChooser();
					int returnValue = fc.showDialog(parent, "Select CSV");

					if (returnValue == JFileChooser.APPROVE_OPTION) {
						inputCsvFile = fc.getSelectedFile();
						getCsvFilenameTextField().setText(
								inputCsvFile.getAbsolutePath());
						firePropertyChange("csvFileSelected", false, true);
					}

				}
			});
		}
		return selectCsvFileButton;
	}

	public File getInputCsvFile() {
		return inputCsvFile;
	}

	public void setInputCsvFile(File inputCsvFile) {
		this.inputCsvFile = inputCsvFile;
	}

	private JFileChooser getFileChooser() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setAcceptAllFileFilterUsed(false);

		fc.addChoosableFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "CSV Files";
			}

			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return true;
				}

				return FilenameUtils.isExtension(file.getName().toLowerCase(),
						"csv");
			}
		});

		return fc;
	}
}
