package edu.uark.registerapp.commands.activeUsers;

import edu.uark.registerapp.models.entities.ActiveUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;

public class ActiveUserDeleteCommand {

    private String sessionID;

    public ActiveUserDeleteCommand(String session) {

        this.sessionID = session;
    }

    @Transactional
    public void deleteActive() {

        Optional<ActiveUserEntity> activeUser = activeRepo.findBySessionKey(sessionID);

        if (activeUser.isPresent()) {

            ActiveUserEntity active = activeUser.get();
            activeRepo.delete(active);
        }
    }

    @Autowired
    private ActiveUserRepository activeRepo;
}