package triplej.capstone.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import triplej.capstone.dtos.RestaurantsTimeStampDto;
import triplej.capstone.entities.RestaurantsTimeStampRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class FindFirstTimeService {
    private RestaurantsTimeStampRepository restaurantsTimeStampRepository;

    @Transactional(readOnly = true)
    public Long findFirstTime(String id) {
        List<RestaurantsTimeStampDto> tmp = restaurantsTimeStampRepository.findAllByAsc(Long.parseLong(id)).map(RestaurantsTimeStampDto::new).collect(Collectors.toList());
        return Long.parseLong(tmp.get(0).getId());
    }

    @Transactional(readOnly = true)
    public Long getFirstTime(String id) {
        List<RestaurantsTimeStampDto> tmp = restaurantsTimeStampRepository.findAllByAsc(Long.parseLong(id)).map(RestaurantsTimeStampDto::new).collect(Collectors.toList());
        return Long.parseLong(tmp.get(0).getTime());
    }
}
