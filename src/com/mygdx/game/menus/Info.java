/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.menus;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameObject;

/**
 *
 * @author Stefan
 */
public final class Info extends GameObject {
    
    public String text;
    Skin skin;
     
     public Info(Skin skin){
         
       
        
        
        
        this.skin = skin; 
        text = "author : xxx" ;

        
     }

    @Override
    public void gettexture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {

       }

    @Override
    public void move(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}