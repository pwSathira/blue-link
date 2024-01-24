package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.IndictmentService;
import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.db.Profiles;
import com.polywertz.bluelink.logic.*;
import jakarta.annotation.PostConstruct;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.polywertz.bluelink.controller.ProfilesService;

import javax.swing.*;
import java.awt.*;

@Component
public class ProfilesUI extends GenericUI{
    @Autowired
    private ProfilesService profilesService;

    @Autowired
    private IndictmentService indictmentService;

    private ItemContainer profilesContainer;
    private JLayeredPane layeredPane;
    private JPanel profileDetailPanel;
    private JPanel mainPanel;
    @Autowired
    public ProfilesUI(CardController ccInstance) {
        super(ccInstance); // Call the constructor of GenericUI
    }

    private void addProfilesButton() {
        JButton addProfilesButton = new JButton("Add Profiles");
        addProfilesButton.addActionListener(e -> {
            String profile = JOptionPane.showInputDialog("Enter a new profile");
            if (profile != null && !profile.isEmpty()) {
                profilesService.addProfile(profile);
                updateProfilesDisplay("");
            }
        });
        mainPanel.add(addProfilesButton, "dock south, width 500, height 50, span, gapbottom 20, wrap");
    }

    @PostConstruct
    public void init() {
        mainPanel = getMainPanel();
        SearchBarUI searchBar = new SearchBarUI(this::updateProfilesDisplay);
        mainPanel.add(searchBar, "dock north, width 500, height 50, span, gapbottom 20, wrap");
        this.profilesContainer = getGenericContainer();
        mainPanel.add(profilesContainer, "grow, push, wrap"); // Add profilesContainer to mainPanel

        // Set up the layeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(650,500)); // Match the size of mainPanel

       // Add mainPanel to layeredPane

        profilesContainer.setBounds(0, 0,650, 500);
        layeredPane.add(profilesContainer, JLayeredPane.DEFAULT_LAYER);

        // Configure and add profileDetailPanel
        profileDetailPanel = new JPanel();
        profileDetailPanel.setBounds(50, 50, 400, 400); // Adjust size and position as needed
        profileDetailPanel.setOpaque(true); // Make the panel opaque
        profileDetailPanel.setVisible(false); // Initially hidden
        layeredPane.add(profileDetailPanel, JLayeredPane.PALETTE_LAYER);

        // Close button for profileDetailPanel
        JButton closeButton = new JButton("Close");
        //Close Button aligned to top right corner

        closeButton.addActionListener(e -> profileDetailPanel.setVisible(false));
        profileDetailPanel.add(closeButton);
        mainPanel.add(layeredPane);
        layeredPane.setLayer(profilesContainer, JLayeredPane.DEFAULT_LAYER);
        addProfilesToContainer(profilesService.getAllProfiles());
    }

    private void updateProfilesDisplay(String searchTerm) {
        Iterable<Profiles> filteredProfiles = profilesService.findProfilesBySearchTerm(searchTerm);
        addProfilesToContainer(filteredProfiles);
    }

    private void addProfilesToContainer(Iterable<Profiles> profiles) {
        profilesContainer.clearItems(); // Clear existing profiles
        for (Profiles profile : profiles) {
            ItemPanel profilePanel = new ItemPanel(20, Color.BLACK, profile.getProfile());
            profilesContainer.addItem(profilePanel);
            addIndictmentButton(profilePanel, profile);
        }
    }

    private void addIndictmentButton(ItemPanel profilePanel, Profiles profile) {
        JButton indictmentButton = new JButton("Indict");
        indictmentButton.addActionListener(e -> {
            // Set the current profile in the indictment service
            indictmentService.setCurrentProfile(profile);
            // Show the profile detail panel
            profileDetailPanel.setVisible(true);
        });
        profilePanel.add(indictmentButton, "dock east, width 100, height 50, span, gapbottom 20, wrap");
    }
}
