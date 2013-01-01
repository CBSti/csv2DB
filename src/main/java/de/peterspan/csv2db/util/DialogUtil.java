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
