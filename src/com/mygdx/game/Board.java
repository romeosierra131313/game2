/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import ObserversAndListeners.storyEvent;
import com.mygdx.game.ObserversAndListeners.storyListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Player.player;
import com.mygdx.game.mission.mission;
import com.mygdx.game.mission.missionFactory;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class Board implements storyListener {
   

	Stage stage;
        Skin skin;
	Table container;
        TiledMap board;
          final TextButton accept;
          final TextButton boardback;
          
          final TextButton close;
        player p;
        final Boolean closed = false;
        int storyprogress;
        mission mission;
        missionFactory mf;
        public ArrayList<mission> misionlist ;
        
        
	public Board (Stage stage,Skin skin,TiledMap board,player p,int storyprogress) {
		this.stage = stage;
	        this.skin = skin;
                this.board = board;
                this.p = p;
                this.storyprogress = storyprogress;
                mission = new mission();
                mf = new missionFactory();
                misionlist = new ArrayList();
                //getmissions(storyprogress);
                
                
                
		 Gdx.graphics.setVSync(false);
        
		 boardback = new TextButton(" ", skin);
			   boardback.setSize((Gdx.graphics.getWidth()/2), Gdx.graphics.getHeight());
                           boardback.setPosition(Gdx.graphics.getWidth()/2,0);
                        

			
		

		 close = new TextButton("Close", skin.get("toggle", TextButtonStyle.class));
		close.setPosition((Gdx.graphics.getWidth()/2)+50, 10);
                close.setSize((Gdx.graphics.getWidth()/10), 50);
		close.addListener(new ClickListener() {
			public void clicked (InputEvent event,float x,float y) {
			    
                                  clearstage();  }});
                
                 accept = new TextButton("Accept", skin.get("toggle", TextButtonStyle.class));
		accept.setPosition((Gdx.graphics.getWidth())-((Gdx.graphics.getWidth()/10))-50, 10);
                accept.setSize((Gdx.graphics.getWidth()/10), 50);
		accept.addListener(new ClickListener() {
			public void clicked (InputEvent event,float x,float y) {
			    /////	player.exit();
                                  clearstage();  }});
                
             
        }



    void clearstage() {
                      stage.clear();
                      p.pstate = p.pstate.overworld;}

    private void setmissions() {
                      mission m = misionlist.get(0);
                        System.out.println("stage.clear(); , new textbutton(m.desc,skin)");
                        TextButton miss = new TextButton(m.title,skin);
                        miss.setSize(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/10);
                        miss.setPosition(0,0);
                        miss.addListener(new ClickListener() {
			public void clicked (InputEvent event,float x,float y) {
			   System.out.println("stage.clear(); , new textbutton(m.desc,skin)");
                                  
                        }});
                        stage.addActor(miss);
         
    }
    
    public void addboardbuttons(){
                stage.addActor(boardback);
                stage.addActor(close);
                stage.addActor(accept);
    
    }

    @Override
    public void progress(storyEvent e) {
      
       misionlist.add( mf.newMission(storyprogress));
       System.out.println("boardprogress");
       setmissions();
    
    }

    @Override
    public void random(storyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    

