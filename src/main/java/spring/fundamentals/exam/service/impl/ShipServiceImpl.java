package spring.fundamentals.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spring.fundamentals.exam.models.entity.ShipEntity;
import spring.fundamentals.exam.models.service.ShipServiceModel;
import spring.fundamentals.exam.repository.ShipRepository;
import spring.fundamentals.exam.security.CurrentUser;
import spring.fundamentals.exam.service.CategoryService;
import spring.fundamentals.exam.service.ShipService;
import spring.fundamentals.exam.service.UserService;
import spring.fundamentals.exam.view.ShipViewModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }

    @Override
    public void addShip(ShipServiceModel serviceModel) {
        ShipEntity ship = modelMapper.map(serviceModel, ShipEntity.class);
        ship.setCategory(categoryService.findCategoryByName(serviceModel.getCategory()));
        ship.setUser(userService.findUserById(currentUser.getId()));

        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> getAllShipsOrderedByIdAndStatus() {
        return shipRepository.findAllOrderedByIdAndStatus()
                .stream().map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> getAllLoggedInUserShips() {
        return shipRepository
                .findByUser_Id(currentUser.getId())
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findAllDefendersShips() {
        return shipRepository.findAll()
                .stream()
                .filter(shipEntity -> !shipEntity.getUser().getId().equals(currentUser.getId()))
                .map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void fire(Long attackerId, Long defenderId) {
        Optional<ShipEntity> attacker = shipRepository.findById(attackerId);
        Optional<ShipEntity> defender = shipRepository.findById(defenderId);

        defender.get().setHealth(defender.get().getHealth() - attacker.get().getPower());

        if(defender.get().getHealth() <= 0){
            shipRepository.deleteById(defenderId);
        }else {
            shipRepository.save(defender.get());
        }
    }
}
