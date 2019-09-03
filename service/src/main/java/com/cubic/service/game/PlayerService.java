package com.cubic.service.game;

import com.cubic.base.SimpleParam;
import com.cubic.dao.game.PlayerDAO;
import com.cubic.exception.ExistException;
import com.cubic.model.game.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerService {
    @Autowired
    private PlayerDAO playerDAO;

    public List<Player> listAccountPlayer(){
        return playerDAO.getByAccount(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    public Player getAccountPlayer(String name){
        Player player=new Player();
        player.setName(name);
        player.setAccount(SecurityContextHolder.getContext().getAuthentication().getName());
        return playerDAO.getOne(player);
    }
    public Player createPlayer(String name) throws ExistException {
        Player player=new Player();
        player.setName(name);
        try{
        if(null!=playerDAO.getOne(player)){
            throw new ExistException("名称存在");
        }}catch (Exception e){

        }
        player.setAccount(SecurityContextHolder.getContext().getAuthentication().getName());
        player.setLevel(1);
        player.setBlood(100);
        player.setMana(100);
        playerDAO.insert(player);
        return player;
    }
}
