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
package de.peterspan.csv2db.util;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.peterspan.csv2db.ui.ExceptionDialog;
import de.peterspan.csv2db.ui.res.Icons;

public class DialogUtil {

	private static DialogUtil instance;

	private final Log log = LogFactory.getLog(DialogUtil.class);

	JFrame frame;

	private DialogUtil() {
	};

	public static synchronized DialogUtil getInstance() {
		if (instance == null)
			instance = new DialogUtil();
		return instance;
	}
	
	public void setMainFrame(JFrame frame) {
		this.frame = frame;
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public void showStandardDialog(final JDialog dialogToShow) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				dialogToShow.setVisible(true);
			}
		});
	}

	public void showError(final Exception ex) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new ExceptionDialog(frame, ex).setVisible(true);
			}
		});
	}
	
	public int showErrorDialog(String title, String errorMessage) {
		JOptionPane.showMessageDialog(frame, errorMessage, title, JOptionPane.ERROR_MESSAGE, Icons.IC_DIALOG_ERROR_LARGE);
		return 0;
	}
}
