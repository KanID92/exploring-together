package stats.analyzer.service.impl;

import id.kanygin.stats.avro.UserActionAvro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import stats.analyzer.entity.UserAction;
import stats.analyzer.repository.UserActionRepository;
import stats.analyzer.service.UserActionService;
import stats.analyzer.service.mapper.UserActionMapper;

@Service
@RequiredArgsConstructor
public class GeneralUserActionsService implements UserActionService {

    private final UserActionRepository userActionRepository;
    private final UserActionMapper userActionMapper;

    @Override
    public UserAction save(UserActionAvro userActionAvro) {
        return userActionRepository.save(
                userActionMapper.toUserAction(userActionAvro)
        );
    }
}
