/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esbdebugger;

import java.io.BufferedReader;
import javax.swing.JTextArea;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author kevin
 */
public class EventDispatcher extends Thread {
    BufferedReader fEventReader;
    JTextArea eventTextArea;
    
  
    
    public void  init(BufferedReader fEventReader,JTextArea eventTextArea){
        this.fEventReader=fEventReader;
        this.eventTextArea=eventTextArea;
    }
    
    @Override
    public void run(){
     try{ 
          while(true){
          if(fEventReader.ready()){
          String buffer=fEventReader.readLine();
          JSONObject event=new JSONObject(buffer);
          eventTextArea.append(event.toString(3));   
          eventTextArea.append("\n");
          }
          }
      }catch (Exception ex) { }
    }
    
    
    
}