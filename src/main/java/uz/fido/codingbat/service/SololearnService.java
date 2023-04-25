package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Sololearn;
import uz.fido.codingbat.entity.User;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.SololearnDto;
import uz.fido.codingbat.repository.SololearnRepository;
import uz.fido.codingbat.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SololearnService {
    @Autowired
    SololearnRepository sololearnRepository;
    @Autowired
    UserRepository userRepository;

    public ApiResponce addSololearn(SololearnDto sololearnDto) {

        Sololearn sololearn = new Sololearn();
        Optional<User> optionalUser = userRepository.findById(sololearnDto.getUser_id());
        if (!optionalUser.isPresent())
            return new ApiResponce("Bunday user mavjud emas!", false);
        User user = optionalUser.get();
        sololearn.setName(sololearnDto.getName());
        sololearn.setUser(user);
        Sololearn save = sololearnRepository.save(sololearn);
        return new ApiResponce("sololearn qo'shildi", true, save);
    }

    public ApiResponce updateSololearn(Integer id, SololearnDto sololearnDto) {
        Optional<Sololearn> optionalSololearn = sololearnRepository.findById(id);
        if (!optionalSololearn.isPresent())
            return new ApiResponce("Bunday sololearn topilmadi", false);
        Sololearn sololearn = optionalSololearn.get();
        Optional<User> optionalUser = userRepository.findById(sololearnDto.getUser_id());
        if (!optionalUser.isPresent())
            return new ApiResponce("Bunday user mavjud emas!", false);
        User user = optionalUser.get();
        sololearn.setName(sololearnDto.getName());
        sololearn.setUser(user);
        Sololearn save = sololearnRepository.save(sololearn);
        return new ApiResponce("sololearn qo'shildi", true, save);
    }

    public ApiResponce getOneSololearn(Integer id) {
        Optional<Sololearn> optionalSololearn = sololearnRepository.findById(id);
        if (!optionalSololearn.isPresent())
            return new ApiResponce("Bunday sololearn topilmadi", false);

        Sololearn sololearn = optionalSololearn.get();
        return new ApiResponce("sololearn topildi", true, sololearn);
    }

    public ApiResponce getAllSololearn() {
        List<Sololearn> sololearnList = sololearnRepository.findAll();
        return new ApiResponce("Sololearn list topildi", true, sololearnList);
    }

    public ApiResponce deleteSololearn(Integer id) {
        sololearnRepository.deleteById(id);
        return new ApiResponce("deleted sololeran", true);
    }
}
