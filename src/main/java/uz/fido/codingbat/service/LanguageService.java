package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Language;
import uz.fido.codingbat.entity.Sertificates;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.LanguageDto;
import uz.fido.codingbat.repository.LanguageRepository;
import uz.fido.codingbat.repository.SertificatesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    SertificatesRepository sertificatesRepository;

    public ApiResponce addLanguage(LanguageDto languageDto) {
        boolean existsByLanguage_name = languageRepository.existsByLanguageName(languageDto.getLanguageName());

        if (existsByLanguage_name) return new ApiResponce("Bunday language mavjud", false);
        Language language = new Language();
        language.setLanguageName(language.getLanguageName());
        Optional<Sertificates> optionalSertificates = sertificatesRepository.findById(languageDto.getSertificates_id());
        if (!optionalSertificates.isPresent())
            return new ApiResponce("Bunday sertificates mavjud emas", false);
        Sertificates sertificates = optionalSertificates.get();

        language.setSertificates(sertificates);
        Language save = languageRepository.save(language);
        return new ApiResponce("language qo'shildi", true, save);

    }

    public ApiResponce getOneLanguage(Integer id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (!optionalLanguage.isPresent())
            return new ApiResponce("Bunday sertificates mavjud emas", false);
        Language language = optionalLanguage.get();
        return new ApiResponce("language topildi", true, language);

    }

    public ApiResponce getAllLanguage() {
        List<Language> languages = languageRepository.findAll();
        return new ApiResponce("Languages topildi", true, languages);
    }

    public ApiResponce updateLanguage(LanguageDto languageDto, Integer id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (!optionalLanguage.isPresent())
            return new ApiResponce("Bunday language topilmadi", false);
        Language language = optionalLanguage.get();
        language.setLanguageName(language.getLanguageName());
        Optional<Sertificates> optionalSertificates = sertificatesRepository.findById(languageDto.getSertificates_id());
        if (!optionalSertificates.isPresent())
            return new ApiResponce("Bunday sertificates mavjud emas", false);
        Sertificates sertificates = optionalSertificates.get();

        language.setSertificates(sertificates);
        Language save = languageRepository.save(language);
        return new ApiResponce("language update qilindi", true, save);
    }

    public ApiResponce deleteLanguage(Integer id){
        languageRepository.deleteById(id);
        return new ApiResponce("language o'chirildi", true);
    }
}
