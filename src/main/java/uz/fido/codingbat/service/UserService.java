package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.*;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.UserDto;
import uz.fido.codingbat.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    SertificatesRepository sertificatesRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    AchievmentRepository achievmentRepository;


    public ApiResponce addUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setXp_amount(userDto.getXp_amount());
        user.setLevel(userDto.getLevel());
        Optional<Language> optionalLanguage = languageRepository.findById(userDto.getLanguage_id());
        if (!optionalLanguage.isPresent())
            return new ApiResponce("Bunday language mavjud emas!", false);

        Optional<Sertificates> optionalSertificates = sertificatesRepository.findById(userDto.getSertificates_id());
        if (!optionalSertificates.isPresent())
            return new ApiResponce("Bunday Sertificates mavjud emas!", false);

        Optional<Achievment> optionalAchievment = achievmentRepository.findById(userDto.getAchievment_id());
        if (!optionalAchievment.isPresent())
            return new ApiResponce("Bunday achievment mavjud emas!", false);

        Optional<Task> optionalTask = taskRepository.findById(userDto.getTask_id());
        if (!optionalTask.isPresent())
            return new ApiResponce("Bunday task mavjud emas!", false);

        user.setLanguage(optionalLanguage.get());
        user.setTask(optionalTask.get());
        user.setAchievment(optionalAchievment.get());
        user.setSertificates(optionalSertificates.get());

        User save = userRepository.save(user);
        return new ApiResponce("User saqlandi", true, save);

    }

    public ApiResponce updateUser(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent())
            return new ApiResponce("Bunday user topilmadi", false);
        User user = optionalUser.get();
        user.setName(userDto.getName());
        user.setXp_amount(userDto.getXp_amount());
        user.setLevel(userDto.getLevel());
        Optional<Language> optionalLanguage = languageRepository.findById(userDto.getLanguage_id());
        if (!optionalLanguage.isPresent())
            return new ApiResponce("Bunday language mavjud emas!", false);

        Optional<Sertificates> optionalSertificates = sertificatesRepository.findById(userDto.getSertificates_id());
        if (!optionalSertificates.isPresent())
            return new ApiResponce("Bunday Sertificates mavjud emas!", false);

        Optional<Achievment> optionalAchievment = achievmentRepository.findById(userDto.getAchievment_id());
        if (!optionalAchievment.isPresent())
            return new ApiResponce("Bunday achievment mavjud emas!", false);

        Optional<Task> optionalTask = taskRepository.findById(userDto.getTask_id());
        if (!optionalTask.isPresent())
            return new ApiResponce("Bunday task mavjud emas!", false);

        user.setLanguage(optionalLanguage.get());
        user.setTask(optionalTask.get());
        user.setAchievment(optionalAchievment.get());
        user.setSertificates(optionalSertificates.get());

        User save = userRepository.save(user);
        return new ApiResponce("User saqlandi", true, save);
    }

    public ApiResponce getOneUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent())
            return new ApiResponce("User topilmadi", false);

        User user = optionalUser.get();
        return new ApiResponce("User topildi", true, user);
    }

    public ApiResponce getAllUser() {
        List<User> userList = userRepository.findAll();
        return new ApiResponce("Userlist topildi", true, userList);
    }

    public ApiResponce deleteUser(Integer id) {
        userRepository.deleteById(id);
        return new ApiResponce("Delete user", true);
    }
}
