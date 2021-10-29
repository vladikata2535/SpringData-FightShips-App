package spring.fundamentals.exam.service;

import spring.fundamentals.exam.models.service.ShipServiceModel;
import spring.fundamentals.exam.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel serviceModel);

    List<ShipViewModel> getAllShipsOrderedByIdAndStatus();

    List<ShipViewModel> getAllLoggedInUserShips();

    List<ShipViewModel> findAllDefendersShips();

    void fire(Long attackerId, Long defenderId);
}
