package name.kugelman.john.kdoom.gui;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

import info.clearthought.layout.*;

import name.kugelman.john.gui.*;
import name.kugelman.john.kdoom.model.*;

import static info.clearthought.layout.TableLayoutConstants.*;

public class LinePanel extends JPanel {
    private Line line;

    private TitledBorder titledBorder;
    private JLabel       startLabel, endLabel;
    private JLabel       flagsLabel;
    private JLabel       leftSideLabel, rightSideLabel;

    public LinePanel() {
        this(null);
    }

    public LinePanel(Line line) {
        titledBorder   = new TitledBorder("");
        startLabel     = new JLabel();
        endLabel       = new JLabel();
        flagsLabel     = new JLabel();
        leftSideLabel  = new JLabel();
        rightSideLabel = new JLabel();

        setBorder(titledBorder);

        double[][] size = {
            { PREFERRED, PREFERRED },
            { PREFERRED, PREFERRED, PREFERRED, PREFERRED }
        };

        setLayout(new TableLayout(size));

        add(new JLabel("Start vertex: "), "0, 0, TRAILING, TOP");
        add(startLabel,                   "1, 0, LEADING,  TOP");
        add(new JLabel("End vertex: "),   "0, 1, TRAILING, TOP");
        add(endLabel,                     "1, 1, LEADING,  TOP");
        add(new JLabel("Flags: "),        "0, 2, TRAILING, TOP");
        add(flagsLabel,                   "1, 2, LEADING,  TOP");
        add(new JLabel("Left side: "),    "0, 3, TRAILING, TOP");
        add(leftSideLabel,                "1, 3, LEADING,  TOP");
        add(new JLabel("Right side: "),   "0, 4, TRAILING, TOP");
        add(rightSideLabel,               "1, 4, LEADING,  TOP");

        show(line);
    }

    public void show(Line line) {
        this.line = line;

        if (line == null) {
            titledBorder  .setTitle("Line");
            startLabel    .setText ("N/A");
            endLabel      .setText ("N/A");
            flagsLabel    .setText ("N/A");
            leftSideLabel .setText ("N/A");
            rightSideLabel.setText ("N/A");
        }
        else {
            titledBorder  .setTitle("Line #" + line.getNumber());
            startLabel    .setText (line.getStart().toString());
            endLabel      .setText (line.getEnd  ().toString());
            flagsLabel    .setText (String.format("0x%04X", line.getFlags()));
            leftSideLabel .setText (line.getLeftSide () == null ? "-" : "#" + line.getLeftSide ().getNumber());
            rightSideLabel.setText (line.getRightSide() == null ? "-" : "#" + line.getRightSide().getNumber());
        }

        repaint();
    }
}
