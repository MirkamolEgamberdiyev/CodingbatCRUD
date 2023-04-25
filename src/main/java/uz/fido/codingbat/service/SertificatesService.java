package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Sertificates;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.repository.SertificatesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SertificatesService {
    @Autowired
    SertificatesRepository sertificatesRepository;

    public ApiResponce addSertificates(Sertificates sertificates) {
        boolean existsByName = sertificatesRepository.existsByName(sertificates.getSertificates_name());
        if (existsByName) return new ApiResponce("Bunday sertificates qoshgansiz", false);

        Sertificates save = sertificatesRepository.save(sertificates);
        return new ApiResponce("sertificates qo'shildi", true, save);
    }

    public ApiResponce getOneSertificates(Integer id) {
        Optional<Sertificates> optionalSertificates = sertificatesRepository.findById(id);
        if (!optionalSertificates.isPresent())
            return new ApiResponce("Bunday sertificates mavjud emas!", false);
        Sertificates sertificates = optionalSertificates.get();

        return new ApiResponce("sertificates topildi", true, sertificates);
    }

    public ApiResponce getAllSertificates() {
        List<Sertificates> sertificates = sertificatesRepository.findAll();
        return new ApiResponce("sertificates topildi", true, sertificates);
    }

    public ApiResponce updateSertificates(Integer id, Sertificates sertificates) {
        Optional<Sertificates> optionalSertificates = sertificatesRepository.findById(id);
        if (!optionalSertificates.isPresent())
            return new ApiResponce("Bunday sertificates mavjud emas!", false);
        Sertificates sertificates1 = optionalSertificates.get();
        sertificates1.setSertificates_name(sertificates.getSertificates_name());
        sertificates1.setDate(sertificates.getDate());
        Sertificates save = sertificatesRepository.save(sertificates1);
        return new ApiResponce("Achievment update qilindi", true, save);
    }

    public ApiResponce deleteSertificates(Integer id) {
        sertificatesRepository.deleteById(id);
        return new ApiResponce("sertificates o'chirildi", true);
    }

}
