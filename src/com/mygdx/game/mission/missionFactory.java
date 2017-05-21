/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.mission;

/**
 *
 * @author Stefan
 */
public class missionFactory {
    mission mission;
   public missionFactory(){}
      public mission newMission(int type){
          switch (type) {
              case 1: System.out.println("mission added");
                      mission = new myfirstmission();
                  break;
              case 2:
                  break;
              case 3:
                  break;
              case 4:
                  break;
              case 5:
                  break;    
                  
          }
          
          
        return mission;}
        
}
