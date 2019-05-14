package main.java.triplej.capstone.entities;

import org.springframework.data.jpa.repository.JpaRepository;

// 기본적인 JPA Service 제공 ex> save
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {
}
