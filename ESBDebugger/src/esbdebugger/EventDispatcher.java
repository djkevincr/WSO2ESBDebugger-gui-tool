/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package esbdebugger;

import java.io.BufferedReader;
import javax.swing.JTextArea;
import org.codehaus.jettison.json.JSONObject;

/**
 *This is class that listens on debug events on a separate thread
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