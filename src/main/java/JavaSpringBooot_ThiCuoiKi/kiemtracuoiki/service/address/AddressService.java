package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.address;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.Address;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.User;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveAddress(User user, String address) {
        Address addressSave = Address.builder()
                .addressItem(address)
                .user(user)
                .isDefault(true)
                .build();
        addressRepository.save(addressSave);
    }
}
