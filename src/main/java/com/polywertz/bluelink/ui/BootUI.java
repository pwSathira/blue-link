package com.polywertz.bluelink.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

import com.polywertz.bluelink.logic.CardController;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BootUI extends JPanel {
    private JLabel bootLabel;
    private Timer timer;
    private int angle = 0;

    private CardController ccInstance;

    @Autowired
    public BootUI(CardController ccInstance) {
        this.ccInstance = ccInstance;
        //Background
        setBackground(new Color(0x379B8C));

        //BootLabel
        bootLabel = new JLabel("Blue-Link Police MDT");
        bootLabel.setFont(new Font("Arial", Font.BOLD, 50));
        bootLabel.setForeground(Color.WHITE);

        //ProgressLabel
        JLabel progLabel = new JLabel("Progress 0%");
        progLabel.setFont(new Font("Arial", Font.ITALIC, 30));
        progLabel.setForeground(Color.WHITE);

        // Initialize MigLayout
        MigLayout mLayout = new MigLayout("align center center, wrap");
        setLayout(mLayout);

        // Add bootLabel to the layout
        add(bootLabel, "cell 0 0, grow");

        // Add RotatingCircle to the layout
        add(new RotatingCircle(), "cell 0 1, gaptop 5, gapright 5");

        // Add progLabel to the layout
        add(progLabel, "cell 0 1, gapleft 0");

        // Timer setup to rotate the circle
        RotatingCircleTimer();

        // Progress Label Counting to 100
        ProgLabel(progLabel, 0);
    }
    private void ProgLabel(JLabel progLabel, int delay) {
        Timer timer = new Timer(delay, new ActionListener() {
            private int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 100){
                    Timer switchTimer = new Timer(1000, v -> ccInstance.showCard("login"));
                    switchTimer.setRepeats(false); // Ensure the timer only fires once
                    switchTimer.start();
                }
                if (i <= 100) {
                    progLabel.setText("Progress " + i + "%");
                    i++;
                } else {
                    ((Timer)e.getSource()).stop(); // Stop the timer when it reaches 100%
                }
            }
        });
        timer.start();
    }
    private void RotatingCircleTimer() {
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 10;
                if (angle >= 360) {
                    angle = 0;
                }
                repaint(); // Trigger repaint to show the rotated circle
            }
        });
        timer.start();
    }
    class RotatingCircle extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(5));
            Arc2D.Float arc = new Arc2D.Float(Arc2D.OPEN);
            arc.setFrame(5, 5, 25, 25); //10, 10, 50, 50
            arc.setAngleStart(angle);
            arc.setAngleExtent(270); // 3/4 of the circle
            g2d.draw(arc);
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(40, 40);
        }
    }
}