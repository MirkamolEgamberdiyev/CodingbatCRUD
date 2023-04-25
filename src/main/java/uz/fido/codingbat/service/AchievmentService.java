package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Achievment;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.repository.AchievmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AchievmentService {
    @Autowired
    AchievmentRepository achievmentRepository;

    public ApiResponce addAchievment(Achievment achievment) {
        boolean existsByName = achievmentRepository.existsByName(achievment.getName());
        if (existsByName) return new ApiResponce("Bunday achievmentni qoshgansiz", false);

        Achievment save = achievmentRepository.save(achievment);
        return new ApiResponce("achievment qo'shildi", true, save);
    }

    public ApiResponce getOneAchievment(Integer id) {
        Optional<Achievment> optionalAchievment = achievmentRepository.findById(id);
        if (!optionalAchievment.isPresent())
            return new ApiResponce("Bunday achievment mavjud emas!", false);
        Achievment achievment = optionalAchievment.get();

        return new ApiResponce("Addres topildi", true, achievment);
    }

    public ApiResponce getAllAchievment() {
        List<Achievment> achievments = achievmentRepository.findAll();
        return new ApiResponce("Achievments topildi", true, achievments);
    }

    public ApiResponce updateAchievment(Integer id, Achievment achievment) {
        Optional<Achievment> optionalAchievment = achievmentRepository.findById(id);
        if (!optionalAchievment.isPresent())
            return new ApiResponce("Bunday achievment mavjud emas!", false);
        Achievment achievment1 = optionalAchievment.get();
        achievment1.setName(achievment.getName());
        achievment1.setDescription(achievment.getDescription());
        Achievment save = achievmentRepository.save(achievment1);
        return new ApiResponce("Achievment update qilindi", true, save);
    }


    public ApiResponce deleteAchievment(Integer id) {
        achievmentRepository.deleteById(id);
        return new ApiResponce("achievment o'chirildi", true);
    }

}
