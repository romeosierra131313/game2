package com.mygdx.game.ObserversAndListeners;

import com.mygdx.game.Player.player;

public class calendarEvent{
        player p;
        public calendarEvent(player p){
        this.p = p;    
        
        }
        
        public player getsource(){
           return p;
        
        }


}
