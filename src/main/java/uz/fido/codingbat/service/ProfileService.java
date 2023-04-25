package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Photo;
import uz.fido.codingbat.entity.Profile;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.ProfileDto;
import uz.fido.codingbat.repository.PhotoRepository;
import uz.fido.codingbat.repository.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    PhotoRepository photoRepository;

    public ApiResponce addProfile(ProfileDto profileDto) {
        Profile profile = new Profile();
        Optional<Photo> optionalPhoto = photoRepository.findById(profileDto.getProfile_id());
        if (!optionalPhoto.isPresent())
            return new ApiResponce("Bunday profile topilmadi", false);
        Photo photo = optionalPhoto.get();
        profile.setPhoto(photo);
        Profile save = profileRepository.save(profile);
        return new ApiResponce("profile qo'shildi", true, save);
    }

    public ApiResponce updateProfile(Integer id, ProfileDto profileDto) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (!optionalProfile.isPresent())
            return new ApiResponce("Bunday profile topilmadi", false);

        Profile profile = optionalProfile.get();
        Optional<Photo> optionalPhoto = photoRepository.findById(profileDto.getProfile_id());
        if (!optionalPhoto.isPresent())
            return new ApiResponce("Bunday profile topilmadi", false);
        Photo photo = optionalPhoto.get();
        profile.setPhoto(photo);
        Profile save = profileRepository.save(profile);
        return new ApiResponce("profile qo'shildi", true, save);
    }

    public ApiResponce getOneProfile(Integer id) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (!optionalProfile.isPresent())
            return new ApiResponce("Bunday profile mavjud emas", false);

        Profile profile = optionalProfile.get();
        return new ApiResponce("profile topildi", true, profile);
    }

    public ApiResponce getAllProfile() {
        List<Profile> profiles = profileRepository.findAll();
        return new ApiResponce("Profile listi", true, profiles);
    }

    public ApiResponce deleteProfile(Integer id) {
        profileRepository.deleteById(id);
        return new ApiResponce("delete profile", true);
    }
}
