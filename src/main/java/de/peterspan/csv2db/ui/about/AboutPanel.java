package de.peterspan.csv2db.ui.about;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import de.peterspan.csv2db.ui.res.Icons;
import de.peterspan.csv2db.ui.res.Messages;

public class AboutPanel extends JPanel {

	private static final long serialVersionUID = 5008363638498585313L;
	private JLabel lblPlantEvaluationTool;
	private JLabel lblVersion;
	private JLabel lblCopyright;
	private JLabel lblFrederikHahne;
	private JLabel lblLicensedUnderGpl;
	private JButton btnNewButton;

	private final JDialog parentDialog;
	private JLabel btnSourceCode;
	URI sourceCodeUri, tangoIconThemeUri, webSiteUri;
	private JLabel lblTangoIconTheme;
	private JLabel lblWebsite;
	private JLabel label;

	/**
	 * Create the panel.
	 * 
	 * @throws URISyntaxException
	 */
	public AboutPanel(JDialog parentDialog) throws URISyntaxException {
		sourceCodeUri = new URI(Messages.getString("AboutPanel.sourceCode")); //$NON-NLS-1$
		tangoIconThemeUri = new URI("http://tango.freedesktop.org/Tango_Icon_Library");
		webSiteUri = new URI("https://github.com/peterspan/csv2DB");
		this.parentDialog = parentDialog;
		setLayout(new FormLayout(new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51dlu;default)"), }, new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));
		add(getLblPlantEvaluationTool(), "2, 2, left, default"); //$NON-NLS-1$
		add(getLabel(), "4, 2, 1, 12");
		add(getLblVersion(), "2, 4"); //$NON-NLS-1$
		add(getLblCopyright(), "2, 8"); //$NON-NLS-1$
		add(getLblFrederikHahne(), "2, 10"); //$NON-NLS-1$
		add(getLblLicensedUnderGpl(), "2, 14, 3, 1"); //$NON-NLS-1$
		add(getLblTangoIconTheme(), "2, 16, 3, 1");
		add(getLblWebsite(), "2, 18, 3, 1");
		add(getBtnSourceCode(), "2, 20, 3, 1"); //$NON-NLS-1$
		add(getBtnNewButton(), "2, 22, 3, 1, center, default"); //$NON-NLS-1$

	}

	private JLabel getLblPlantEvaluationTool() {
		if (lblPlantEvaluationTool == null) {
			lblPlantEvaluationTool = new JLabel(Messages.getString("AboutPanel.8")); //$NON-NLS-1$
			lblPlantEvaluationTool.setFont(new Font("Dialog", Font.BOLD, 20)); //$NON-NLS-1$
		}
		return lblPlantEvaluationTool;
	}

	private JLabel getLblVersion() {
		if (lblVersion == null) {
			lblVersion = new JLabel(Messages.getString("AboutPanel.version") + " " + Messages.getString("AppWindow.version.code")); //$NON-NLS-1$
		}
		return lblVersion;
	}

	private JLabel getLblCopyright() {
		if (lblCopyright == null) {
			lblCopyright = new JLabel(Messages.getString("AboutPanel.11")); //$NON-NLS-1$
		}
		return lblCopyright;
	}

	private JLabel getLblFrederikHahne() {
		if (lblFrederikHahne == null) {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			lblFrederikHahne = new JLabel(Messages.getString("AboutPanel.12") + " - " + year); //$NON-NLS-1$
		}
		return lblFrederikHahne;
	}

	private JLabel getLblLicensedUnderGpl() {
		if (lblLicensedUnderGpl == null) {
			lblLicensedUnderGpl = new JLabel(Messages.getString("AboutPanel.13")); //$NON-NLS-1$
		}
		return lblLicensedUnderGpl;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton(Messages.getString("AboutPanel.14")); //$NON-NLS-1$
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					parentDialog.dispose();
				}
			});
		}
		return btnNewButton;
	}

	private JLabel getBtnSourceCode() {
		if (btnSourceCode == null) {
			String link = "<HTML><FONT color=\"#000099\"><U>Source Code</U></FONT></HTML>"; //$NON-NLS-1$
			btnSourceCode = new JLabel(link);
			btnSourceCode.setHorizontalAlignment(SwingConstants.CENTER);
			// btnSourceCode.setBorderPainted(false);
			// btnSourceCode.setOpaque(false);
			// btnSourceCode.setBackground(Color.WHITE);
			// btnSourceCode.setRolloverEnabled(false);
			// btnSourceCode.setBorder(null);
			btnSourceCode.setToolTipText(sourceCodeUri.toString());
			// btnSourceCode.setFocusPainted(false);

			btnSourceCode.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					setCursor(new Cursor(Cursor.HAND_CURSOR));

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					open(sourceCodeUri);

				}
			});

		}
		return btnSourceCode;
	}

	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(uri);
			} catch (IOException e) {
				// TODO: error handling
			}
		} else {
			// TODO: error handling
		}
	}

	private JLabel getLblTangoIconTheme() {
		if (lblTangoIconTheme == null) {
			String link = "<HTML><FONT color=\"#000099\"><U>" + Messages.getString("AboutPanel.lblTangoIconTheme.text_1") + "</U></FONT></HTML>"; //$NON-NLS-1$
			lblTangoIconTheme = new JLabel(link); //$NON-NLS-1$
			lblTangoIconTheme.setHorizontalAlignment(SwingConstants.CENTER);
			lblTangoIconTheme.setToolTipText(tangoIconThemeUri.toString());

			lblTangoIconTheme.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					setCursor(new Cursor(Cursor.HAND_CURSOR));

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					open(tangoIconThemeUri);

				}
			});
		}
		return lblTangoIconTheme;
	}

	private JLabel getLblWebsite() {
		if (lblWebsite == null) {
			String link = "<HTML><FONT color=\"#000099\"><U>" + Messages.getString("AboutPanel.lblWebsite.text") + "</U></FONT></HTML>"; //$NON-NLS-1$
			lblWebsite = new JLabel(link); //$NON-NLS-1$
			lblWebsite.setHorizontalAlignment(SwingConstants.CENTER);
			lblWebsite.setToolTipText(webSiteUri.toASCIIString());

			lblWebsite.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					setCursor(new Cursor(Cursor.HAND_CURSOR));

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					open(webSiteUri);

				}
			});
		}
		return lblWebsite;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(Icons.IC_APPLICATION_LARGE); //$NON-NLS-1$
		}
		return label;
	}
}
