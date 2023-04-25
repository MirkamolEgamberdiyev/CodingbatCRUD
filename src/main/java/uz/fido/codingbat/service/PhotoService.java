package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Photo;
import uz.fido.codingbat.entity.User;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.PhotoDto;
import uz.fido.codingbat.repository.PhotoRepository;
import uz.fido.codingbat.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    UserRepository userRepository;

    public ApiResponce addPhoto(PhotoDto photoDto) {
        Photo photo = new Photo();
        photo.setPhoto(photoDto.getPhoto());
        Optional<User> optionalUser = userRepository.findById(photoDto.getUser_id());
        if (!optionalUser.isPresent())
            return new ApiResponce("Bunday user topilmadi", false);

        User user = optionalUser.get();
        photo.setUser(user);
        Photo save = photoRepository.save(photo);
        return new ApiResponce("Photo qo'shildi", true, save);
    }

    public ApiResponce updatePhoto(Integer id, PhotoDto photoDto) {
        Optional<Photo> optionalPhoto = photoRepository.findById(id);
        if (!optionalPhoto.isPresent())
            return new ApiResponce("Bunday photo mavjud emas", false);

        Photo photo = optionalPhoto.get();
        photo.setPhoto(photoDto.getPhoto());
        Optional<User> optionalUser = userRepository.findById(photoDto.getUser_id());
        if (!optionalUser.isPresent())
            return new ApiResponce("Bunday user topilmadi", false);

        User user = optionalUser.get();
        photo.setUser(user);
        Photo save = photoRepository.save(photo);
        return new ApiResponce("Photo qo'shildi", true, save);
    }

    public ApiResponce getOnePhoto(Integer id) {
        Optional<Photo> optionalPhoto = photoRepository.findById(id);
        if (!optionalPhoto.isPresent())
            return new ApiResponce("Bunday idli photo mavjud emas!", false);
        Photo photo = optionalPhoto.get();
        return new ApiResponce("Photo topildi", true, photo);
    }

    public ApiResponce getAllPhoto() {
        List<Photo> photos = photoRepository.findAll();
        return new ApiResponce("Photolar listi topildi", true, photos);
    }

    public ApiResponce deletePhoto(Integer id) {
        photoRepository.deleteById(id);
        return new ApiResponce("user o'chirildi", true);
    }
}
