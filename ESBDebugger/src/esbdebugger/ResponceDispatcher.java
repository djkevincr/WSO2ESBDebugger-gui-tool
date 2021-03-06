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
import java.io.IOException;
import javax.swing.JTextArea;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *This is class that listens on command responses on a separate thread
 */

public class ResponceDispatcher extends Thread{
    BufferedReader fRequestReader;
    JTextArea responceTextArea; 
    
    public void  init(BufferedReader fRequestReader,JTextArea responceTextArea){
        this.fRequestReader=fRequestReader;
        this.responceTextArea=responceTextArea;
    }
    
    @Override
    public void run(){
     try{ 
          while(true){
            if(fRequestReader.ready()){
            String responce=fRequestReader.readLine();
            JSONObject json=new JSONObject(responce);
            responceTextArea.setText(json.toString(3));
            }
         }
      }catch (IOException | JSONException ex) { }
    }
}
    