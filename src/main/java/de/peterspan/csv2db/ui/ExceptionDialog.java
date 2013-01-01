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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jidesoft.dialog.ButtonPanel;
import com.jidesoft.dialog.StandardDialog;
import com.jidesoft.dialog.StandardDialogPane;
import com.jidesoft.swing.JideBoxLayout;

import de.peterspan.csv2db.ui.res.Icons;


public class ExceptionDialog extends StandardDialog {


		private static final long serialVersionUID = -562443043328805520L;

		@SuppressWarnings("unused")
		private final Log log = LogFactory.getLog(ExceptionDialog.class);

		public JComponent _detailsPanel;
		Exception exception;

		public ExceptionDialog(JFrame parent, Exception exception)
				throws HeadlessException {
			super(parent, exception.toString());
			this.exception = exception;
			// setModal(true);
			// setModalityType(ModalityType.APPLICATION_MODAL);
			setIconImage(Icons.IC_DIALOG_ERROR_SMALL.getImage());
			pack();
			setLocationRelativeTo(parent);

		}

		@Override
		public JComponent createBannerPanel() {
			return null;
		}

		public JComponent createDetailsPanel() {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			exception.printStackTrace(pw);
			JTextArea textArea = new JTextArea(sw.toString());
			// textArea.setRows(10);

			JLabel label = new JLabel("Details:");

			JPanel panel = new JPanel(new BorderLayout(6, 6));
			panel.add(new JScrollPane(textArea));
			panel.add(label, BorderLayout.BEFORE_FIRST_LINE);
			label.setLabelFor(textArea);
			panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

			setSize((int) panel.getPreferredSize().getWidth() + 20,
					getHeight() + 95);
			setMinimumSize(getSize());
			setMaximumSize(new Dimension(getSize().width,
					getSize().height + 150));
			panel.setMaximumSize(new Dimension((int) getMaximumSize()
					.getWidth(), 150));
			return panel;
		}

		@SuppressWarnings("serial")
		@Override
		protected StandardDialogPane createStandardDialogPane() {
			DefaultStandardDialogPane dialogPane = new DefaultStandardDialogPane() {
				@Override
				protected void layoutComponents(Component bannerPanel,
						Component contentPanel, ButtonPanel buttonPanel) {
					setLayout(new JideBoxLayout(this, BoxLayout.Y_AXIS));
					if (bannerPanel != null) {
						add(bannerPanel);
					}
					if (contentPanel != null) {
						add(contentPanel);
					}
					add(buttonPanel, JideBoxLayout.FIX);
					_detailsPanel = createDetailsPanel();
					add(_detailsPanel, JideBoxLayout.VARY);
					_detailsPanel.setVisible(false);
				}
			};
			return dialogPane;
		}

		@Override
		public JComponent createContentPanel() {
			// TODO use here nicer layout, maybe with an icon

			JPanel panel = new JPanel(new BorderLayout(10, 10));
			panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));

			JLabel label = new JLabel("<html>An error occured!<br/>"
					+ exception.toString() + "</html>");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			panel.add(label, BorderLayout.CENTER);
			panel.add(new JLabel(Icons.IC_DIALOG_ERROR_LARGE),
					BorderLayout.WEST);
			setSize(panel.getPreferredSize());
			return panel;
		}

		@SuppressWarnings("serial")
		@Override
		public ButtonPanel createButtonPanel() {
			ButtonPanel buttonPanel = new ButtonPanel();
			JButton closeButton = new JButton();
			JButton detailButton = new JButton();
			detailButton.setMnemonic('D');
			closeButton.setName(OK);
			buttonPanel.addButton(closeButton, ButtonPanel.AFFIRMATIVE_BUTTON);
			buttonPanel.addButton(detailButton, ButtonPanel.OTHER_BUTTON);

			closeButton.setAction(new AbstractAction("Close") {
				@Override
				public void actionPerformed(ActionEvent e) {
					setDialogResult(RESULT_AFFIRMED);
					setVisible(false);
					dispose();
				}
			});

			detailButton.setAction(new AbstractAction("Details >>") {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (_detailsPanel.isVisible()) {
						_detailsPanel.setVisible(false);
						putValue(Action.NAME, "Details <<");
						pack();
					} else {
						_detailsPanel.setVisible(true);
						putValue(Action.NAME, "<< Details");
						pack();
					}
				}
			});

			setDefaultCancelAction(closeButton.getAction());
			setDefaultAction(closeButton.getAction());
			getRootPane().setDefaultButton(closeButton);
			buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,
					10));
			buttonPanel.setSizeConstraint(ButtonPanel.NO_LESS_THAN);
			return buttonPanel;
		}
	}
