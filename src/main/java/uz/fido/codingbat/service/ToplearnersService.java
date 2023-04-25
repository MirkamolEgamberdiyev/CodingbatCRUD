package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Language;
import uz.fido.codingbat.entity.Profile;
import uz.fido.codingbat.entity.Toplearners;
import uz.fido.codingbat.entity.User;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.ToplearnersDto;
import uz.fido.codingbat.repository.LanguageRepository;
import uz.fido.codingbat.repository.ProfileRepository;
import uz.fido.codingbat.repository.ToplearnersRepository;
import uz.fido.codingbat.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ToplearnersService {
    @Autowired
    ToplearnersRepository toplearnersRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    UserRepository userRepository;

    public ApiResponce addToplearners(ToplearnersDto toplearnersDto) {
        Toplearners toplearners = new Toplearners();
        Optional<Language> optionalLanguage = languageRepository.findById(toplearnersDto.getLanguage_id());
        if (!optionalLanguage.isPresent())
            return new ApiResponce("Bunday language mavjud emas", false);
        Optional<Profile> optionalProfile = profileRepository.findById(toplearnersDto.getProfile_id());
        if (!optionalProfile.isPresent())
            return new ApiResponce("Bunday profile mavjud emas", false);

        Optional<User> optionalUser = userRepository.findById(toplearnersDto.getUser_id());
        if (!optionalUser.isPresent())
            return new ApiResponce("Bunday user mavjud emad", false);
        toplearners.setUser(optionalUser.get());
        toplearners.setLanguage(optionalLanguage.get());
        toplearners.setProfile(optionalProfile.get());
        Toplearners save = toplearnersRepository.save(toplearners);
        return new ApiResponce("toplearns qo'shildi", true, save);
    }

    public ApiResponce updateToplearners(Integer id, ToplearnersDto toplearnersDto) {
        Optional<Toplearners> optionalToplearners = toplearnersRepository.findById(id);
        if (!optionalToplearners.isPresent())
            return new ApiResponce("Bunday toplearners mavjud emas", false);
        Toplearners toplearners = optionalToplearners.get();
        Optional<Language> optionalLanguage = languageRepository.findById(toplearnersDto.getLanguage_id());
        if (!optionalLanguage.isPresent())
            return new ApiResponce("Bunday language mavjud emas", false);
        Optional<Profile> optionalProfile = profileRepository.findById(toplearnersDto.getProfile_id());
        if (!optionalProfile.isPresent())
            return new ApiResponce("Bunday profile mavjud emas", false);

        Optional<User> optionalUser = userRepository.findById(toplearnersDto.getUser_id());
        if (!optionalUser.isPresent())
            return new ApiResponce("Bunday user mavjud emad", false);
        toplearners.setUser(optionalUser.get());
        toplearners.setLanguage(optionalLanguage.get());
        toplearners.setProfile(optionalProfile.get());
        Toplearners save = toplearnersRepository.save(toplearners);
        return new ApiResponce("toplearns qo'shildi", true, save);

    }

    public ApiResponce getOneToplearners(Integer id) {
        Optional<Toplearners> optionalToplearners = toplearnersRepository.findById(id);
        if (!optionalToplearners.isPresent())
            return new ApiResponce("Bunday topleraners mavjud emas!", false);
        Toplearners toplearners = optionalToplearners.get();
        return new ApiResponce("toplearners topildi", true, toplearners);
    }

    public ApiResponce getAllToplearners() {
        List<Toplearners> toplearners = toplearnersRepository.findAll();
        return new ApiResponce("toplearners topildi", true, toplearners);
    }

    public ApiResponce deleteToplearners(Integer id) {
        toplearnersRepository.deleteById(id);
        return new ApiResponce("deleted toplearners", true);
    }
}
