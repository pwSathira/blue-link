package com.polywertz.bluelink.controller;

import com.polywertz.bluelink.db.Profiles;
import com.polywertz.bluelink.db.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilesService {
    private final ProfilesRepository profilesRepository;
    @Autowired
    public ProfilesService(ProfilesRepository profilesRepository) {
        this.profilesRepository = profilesRepository;
    }
    // Method to add a new profile
    public Iterable<Profiles> findProfilesBySearchTerm(String searchTerm){
        return profilesRepository.findByNameContainingIgnoreCase(searchTerm);
    }

    public void addProfile(String profile) {
        Profiles newProfile = new Profiles(profile);
        profilesRepository.save(newProfile);
    }

    public Iterable<Profiles> getAllProfiles() {
        return profilesRepository.findAll();
    }
}
