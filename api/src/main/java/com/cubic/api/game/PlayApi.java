package com.cubic.api.game;

import com.cubic.util.base.ExceptionHandle;
import com.cubic.util.exception.ExistException;
import com.cubic.service.game.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayApi {
    @Autowired
    private PlayerService playerService;
    @RequestMapping("/game/listMyPlayer")
    public Object listPlayer()
    {
       return playerService.listAccountPlayer();
    }
    @RequestMapping("/game/{name}/add")
    public Object createPlayer(@PathVariable("name") String name)
    {
        try {
            return playerService.createPlayer(name);
        } catch (ExistException e) {
           return ExceptionHandle.buildExceptMsg(e);
        }
    }
    @RequestMapping("/game/{name}/get")
    public Object getPlayer(@PathVariable("name") String name)
    {

            return playerService.getAccountPlayer(name);

    }
}
