/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import ObserversAndListeners.storyEvent;
import com.mygdx.game.ObserversAndListeners.storyListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Constants.intownstate;
import com.mygdx.game.Constants.playerlocation;
import com.mygdx.game.Player.player;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Stefan
 */
public class worldmenu implements storyListener {
    
    Stage stage;
    Skin skin;
    InputMultiplexer im;
    player p;
    int currentWay;
    Boolean menuopen;
    ArrayList<Vector2>current;
    intownstate intownstate;
    TextButton menuback;
    TextButton Board;
    TextButton market;
    TextButton team ;
    TextButton system;
    TextButton exit;
    TiledMap board ;
    Board b ;
    Set<storyListener> storylisteners;
    int storyprogress = 1;
     Boolean myfirstmenu;
    
    public worldmenu(Stage stage,Skin skin, InputMultiplexer im,player p,
            ArrayList<Vector2>current,int currentWay ,Set<storyListener> storylisteners){
           
            this.skin = skin;
            this.stage =stage;
            this.im = im;
            this.p = p;
            this.current = current;
            this.currentWay = currentWay;
            this.storylisteners =  storylisteners;
            b = new Board(stage , skin,board,p,storyprogress);
            storylisteners.add(b);
            myfirstmenu = true;
             instaniatebuttons();
             myfirstmenu(p);
            
       
             
         }

    public void buildmenu(float x,float y,playerlocation playerlocation) {
        
       // switch(playerlocation){
         //   case Maki:

       menuback.setPosition(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
       Board.setPosition((Gdx.graphics.getWidth()/2)+10,(Gdx.graphics.getHeight()/2)+130);
       market.setPosition((Gdx.graphics.getWidth()/2)+10, (Gdx.graphics.getHeight()/2)+100);
       team.setPosition((Gdx.graphics.getWidth()/2)+10, (Gdx.graphics.getHeight()/2)+70);
       system.setPosition((Gdx.graphics.getWidth()/2)+10, (Gdx.graphics.getHeight()/2)+40);
       exit.setPosition((Gdx.graphics.getWidth()/2)+30, (Gdx.graphics.getHeight()/2)+10);
       
       
       
       stage.addActor(menuback);
       stage.addActor(Board);
       stage.addActor(market);
       stage.addActor(team);
       stage.addActor(system);
       stage.addActor(exit);
       menuopen = true;
       
          //case next town;
          //case next town;
       
    }

  private void instaniatebuttons(){
  
       menuback = new TextButton("", skin, "default");
       menuback.setWidth(120f);
       menuback.setHeight(160f);
       
       
       Board = new TextButton("Board",skin,"default");
       Board.setWidth(100);
       Board.setHeight(22);
       Board.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                 // click.play();
                 //place = place.market;
                 
                  stage.clear();
                   
                   b.addboardbuttons();
                    p.pstate =  p.pstate.intown;
                    intownstate = intownstate.board;
                       
                  
                 } 




       });

       market = new TextButton("Market",skin,"default");
       market.setWidth(100);
       market.setHeight(22);
       market.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                 // click.play();
                 //place = place.market;
                  System.out.println("market");
                  
                  
                 } });
       team = new TextButton("Team",skin,"default");
       team.setWidth(100);
       team.setHeight(22);
       team.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                 // click.play();
                 //place = place.market;
                  System.out.println("team");
                  
                  
                 } });
       system = new TextButton("System",skin,"default");
       system.setWidth(100);
       system.setHeight(22);
       system.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                 // click.play();
                 //place = place.market;
                  System.out.println("system");
                  
                  
                 } });
       exit = new TextButton("Exit",skin,"default");
       exit.setWidth(50);
       exit.setHeight(22);
       exit.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                 // click.play();
                 //place = place.market;
                  stage.clear();
                  System.out.println("exit");
                  p.resetPlayerstates();
                  
                  
                  
                 } });
  
  
  }

    @Override
    public void progress(storyEvent e) {

    if(myfirstmenu){
        System.out.println("my firstmenu");  
            for(storyListener sl : storylisteners){
             sl.progress(e);
         }myfirstmenu = false;
          System.out.println("mysecond menu");  }
    }

    @Override
    public void random(storyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void myfirstmenu(player p) {
        storyEvent  e = new storyEvent(p);  
        progress(e);
         
       
    }
    public void setstoryprogress(int storyprogress){
       this.storyprogress = storyprogress;
    }
    public int getstoryprogress(){
       return storyprogress;
    }

}


