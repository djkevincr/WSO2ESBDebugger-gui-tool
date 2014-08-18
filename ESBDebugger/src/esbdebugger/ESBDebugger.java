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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *This is main class of the WSO2 ESB debugger GUI TCP client tool 
 */

public class ESBDebugger extends javax.swing.JFrame {
       Socket fRequestSocket;
       PrintWriter fRequestWriter;
       BufferedReader fRequestReader;
       Socket fEventSocket;
       BufferedReader fEventReader;
       EventDispatcher eventDispatcher;
       ResponceDispatcher responceDispatcher;
    /**
     * Creates new form 
     */
    public ESBDebugger() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        debuggerTabbedPane = new javax.swing.JTabbedPane();
        adminPanel = new javax.swing.JPanel();
        adminSessionCreatePanel = new javax.swing.JPanel();
        startSessionLabel = new javax.swing.JLabel();
        commandPortLabel = new javax.swing.JLabel();
        eventPortLabel = new javax.swing.JLabel();
        commandPortTextField = new javax.swing.JTextField();
        eventPortTextField = new javax.swing.JTextField();
        createSessionButton = new javax.swing.JButton();
        optionsPanel = new javax.swing.JPanel();
        startServerInstanceCheckBox = new javax.swing.JCheckBox();
        directoryLabel = new javax.swing.JLabel();
        directoryTextField = new javax.swing.JTextField();
        startServerButton = new javax.swing.JButton();
        sessionPanel = new javax.swing.JPanel();
        sessionCommandTextField = new javax.swing.JTextField();
        sessionCommandPortLabel = new javax.swing.JLabel();
        sessionEventPortLabel = new javax.swing.JLabel();
        sessionEventTextField = new javax.swing.JTextField();
        stopButton = new javax.swing.JButton();
        commandLabel = new javax.swing.JLabel();
        breakpointButton = new javax.swing.JButton();
        skipButton = new javax.swing.JButton();
        dataButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        sendCommandButtton = new javax.swing.JButton();
        responceLabel = new javax.swing.JLabel();
        eventLabel = new javax.swing.JLabel();
        eventScrollPane = new javax.swing.JScrollPane();
        eventTextArea = new javax.swing.JTextArea();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        commandTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        responceTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WSO2 ESBDebugger  ");
        setPreferredSize(new java.awt.Dimension(996, 696));
        setResizable(false);

        adminPanel.setPreferredSize(new java.awt.Dimension(980, 660));

        javax.swing.GroupLayout adminSessionCreatePanelLayout = new javax.swing.GroupLayout(adminSessionCreatePanel);
        adminSessionCreatePanel.setLayout(adminSessionCreatePanelLayout);
        adminSessionCreatePanelLayout.setHorizontalGroup(
            adminSessionCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        adminSessionCreatePanelLayout.setVerticalGroup(
            adminSessionCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        startSessionLabel.setText("Create a new ESBDebug session...");

        commandPortLabel.setText("Command Port #");

        eventPortLabel.setText("Event Port #");

        createSessionButton.setText("Create");
        createSessionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSessionButtonActionPerformed(evt);
            }
        });

        optionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        startServerInstanceCheckBox.setText("Start ESB Server instance in Debug mode");
        startServerInstanceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerInstanceCheckBoxActionPerformed(evt);
            }
        });

        directoryLabel.setText("Directory");

        directoryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directoryTextFieldActionPerformed(evt);
            }
        });

        startServerButton.setText("Start");
        startServerButton.setEnabled(false);
        startServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(startServerInstanceCheckBox)
                        .addGap(0, 252, Short.MAX_VALUE))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(startServerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(directoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addComponent(directoryTextField)))
                .addContainerGap())
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addComponent(startServerInstanceCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directoryLabel)
                    .addComponent(directoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startServerButton)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        directoryLabel.disable();
        directoryTextField.disable();

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminSessionCreatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startSessionLabel)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eventPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(commandPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eventPortTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(commandPortTextField)))
                    .addComponent(createSessionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(startSessionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commandPortLabel)
                    .addComponent(commandPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventPortLabel)
                    .addComponent(eventPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(adminSessionCreatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createSessionButton)
                        .addGap(18, 18, 18)
                        .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        debuggerTabbedPane.addTab("Admin", adminPanel);

        sessionPanel.setPreferredSize(new java.awt.Dimension(980, 660));

        sessionCommandTextField.setEditable(false);
        sessionCommandTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionCommandTextFieldActionPerformed(evt);
            }
        });

        sessionCommandPortLabel.setText("Command Port #");

        sessionEventPortLabel.setText("Event Port #");

        sessionEventTextField.setEditable(false);
        sessionEventTextField.setText(" ");
        sessionEventTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionEventTextFieldActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        commandLabel.setText("Command:");

        breakpointButton.setText("Breakpoint");
        breakpointButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breakpointButtonActionPerformed(evt);
            }
        });

        skipButton.setText("Skip");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        dataButton.setText("Data");
        dataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataButtonActionPerformed(evt);
            }
        });

        resumeButton.setText("Resume");
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });

        sendCommandButtton.setText("Send");
        sendCommandButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendCommandButttonActionPerformed(evt);
            }
        });

        responceLabel.setText("Responce:");

        eventLabel.setText("Event:");

        eventTextArea.setColumns(20);
        eventTextArea.setRows(5);
        eventScrollPane.setViewportView(eventTextArea);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        commandTextArea.setColumns(20);
        commandTextArea.setRows(5);
        jScrollPane1.setViewportView(commandTextArea);

        responceTextArea.setColumns(20);
        responceTextArea.setRows(5);
        jScrollPane2.setViewportView(responceTextArea);

        javax.swing.GroupLayout sessionPanelLayout = new javax.swing.GroupLayout(sessionPanel);
        sessionPanel.setLayout(sessionPanelLayout);
        sessionPanelLayout.setHorizontalGroup(
            sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sessionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventScrollPane)
                    .addGroup(sessionPanelLayout.createSequentialGroup()
                        .addGroup(sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sessionPanelLayout.createSequentialGroup()
                                .addGroup(sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sessionPanelLayout.createSequentialGroup()
                                        .addComponent(sessionCommandPortLabel)
                                        .addGap(3, 3, 3)
                                        .addComponent(sessionCommandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sessionEventPortLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sessionEventTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(commandLabel))
                                .addGap(35, 35, 35)
                                .addComponent(responceLabel))
                            .addComponent(eventLabel)
                            .addComponent(sendCommandButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(sessionPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dataButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(skipButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(breakpointButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resumeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sessionPanelLayout.setVerticalGroup(
            sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sessionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionCommandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sessionCommandPortLabel)
                    .addComponent(sessionEventPortLabel)
                    .addComponent(sessionEventTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(commandLabel)
                    .addComponent(responceLabel))
                .addGroup(sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sessionPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(breakpointButton)
                        .addGap(39, 39, 39)
                        .addComponent(skipButton)
                        .addGap(39, 39, 39)
                        .addComponent(dataButton)
                        .addGap(39, 39, 39)
                        .addComponent(resumeButton))
                    .addGroup(sessionPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sessionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendCommandButtton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(clearButton)
                .addContainerGap())
        );

        debuggerTabbedPane.addTab("Session", sessionPanel);
        debuggerTabbedPane.remove(sessionPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(debuggerTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(debuggerTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sessionEventTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionEventTextFieldActionPerformed
       
    }//GEN-LAST:event_sessionEventTextFieldActionPerformed

    private void sessionCommandTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionCommandTextFieldActionPerformed
        
    }//GEN-LAST:event_sessionCommandTextFieldActionPerformed

    private void startServerInstanceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerInstanceCheckBoxActionPerformed
             
       if(startServerInstanceCheckBox.isSelected()){
            directoryTextField.enable();
            directoryTextField.repaint();
            startServerButton.setEnabled(true);
            directoryLabel.enable();
            directoryLabel.repaint();
            startServerButton.repaint();
    }else{
            directoryTextField.disable();
            directoryTextField.repaint();
            startServerButton.setEnabled(false);
            startServerButton.repaint();
            directoryLabel.disable();
            directoryLabel.repaint();
    }//GEN-LAST:event_startServerInstanceCheckBoxActionPerformed
    }
    private void directoryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directoryTextFieldActionPerformed
         
    }//GEN-LAST:event_directoryTextFieldActionPerformed

    private void createSessionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSessionButtonActionPerformed
        int command_port=Integer.parseInt(commandPortTextField.getText());
        int event_port=Integer.parseInt(eventPortTextField.getText());        
        try {
              fRequestSocket = new Socket("localhost",command_port);
              fRequestWriter = new PrintWriter(fRequestSocket.getOutputStream());
              fRequestReader = new BufferedReader(new InputStreamReader(fRequestSocket.getInputStream()));
              fEventSocket = new Socket("localhost", event_port);
              fEventReader = new BufferedReader(new InputStreamReader(fEventSocket.getInputStream()));
        }catch (IOException e) {}
        eventDispatcher=new  EventDispatcher();
        eventDispatcher.init(fEventReader,eventTextArea);
        eventDispatcher.start();
        responceDispatcher=new  ResponceDispatcher();
        responceDispatcher.init(fRequestReader, responceTextArea);
        responceDispatcher.start(); 
        sessionCommandTextField.setText(commandPortTextField.getText());
        sessionEventTextField.setText(eventPortTextField.getText());       
        debuggerTabbedPane.addTab("Session", sessionPanel);
    }//GEN-LAST:event_createSessionButtonActionPerformed

    private void startServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerButtonActionPerformed
         String directory_path=directoryTextField.getText();
         String cmd[] = {"gnome-terminal", "-x", "sh", "-c", directory_path+"/wso2server.sh"+" -Desb.debug=true"};         
         try{             
               Runtime.getRuntime().exec(cmd);
            } catch (IOException e) {}       
    }//GEN-LAST:event_startServerButtonActionPerformed

    private void breakpointButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breakpointButtonActionPerformed
        String breakpoint="{\"command\":\"set|clear\",\"command-argument\":\"breakpoint\",\"mediation-component\":\"sequence|template|connector\"}";
        try{
              JSONObject json=new JSONObject(breakpoint);
              commandTextArea.setText(json.toString(3));
        }catch(JSONException e){}
        
    }//GEN-LAST:event_breakpointButtonActionPerformed

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        // TODO add your handling code here:
        String skip="{\"command\":\"set|clear\",\"command-argument\":\"skip\",\"mediation-component\":\"sequence|template|connector\"}";
        try{
              JSONObject json=new JSONObject(skip);
              commandTextArea.setText(json.toString(3));
        }catch(JSONException e){}
    }//GEN-LAST:event_skipButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        
              debuggerTabbedPane.remove(sessionPanel);
              try{
                  fRequestSocket.close();
                  fEventSocket.close();
              }catch(Exception ex){}
              eventDispatcher.stop();
              responceDispatcher.stop();       
    }//GEN-LAST:event_stopButtonActionPerformed

    private void dataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataButtonActionPerformed
        String skip="{\"command\":\"set|clear|get\",\"command-argument\":\"property|properties\",\"context\":\"synapse(default)|axis2|transport|axis2-client|operation\"}";
        try{
                JSONObject json=new JSONObject(skip);
                commandTextArea.setText(json.toString(3));
        }catch(JSONException e){}       
    }//GEN-LAST:event_dataButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        // TODO add your handling code here:
        String skip="{\"command\":\"resume\"}";
        try{
             JSONObject json=new JSONObject(skip);
             commandTextArea.setText(json.toString(3));
        }catch(JSONException e){}
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        eventTextArea.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void sendCommandButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendCommandButttonActionPerformed
        try{
              String command=commandTextArea.getText();
              JSONObject command_json=new JSONObject(command);
              fRequestWriter.println(command_json.toString());
              fRequestWriter.flush();          
        }catch(Exception ex){}
    }//GEN-LAST:event_sendCommandButttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {                    
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ESBDebugger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ESBDebugger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ESBDebugger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ESBDebugger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ESBDebugger().setVisible(true);
            }
        });
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JPanel adminSessionCreatePanel;
    private javax.swing.JButton breakpointButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel commandLabel;
    private javax.swing.JLabel commandPortLabel;
    private javax.swing.JTextField commandPortTextField;
    private javax.swing.JTextArea commandTextArea;
    private javax.swing.JButton createSessionButton;
    private javax.swing.JButton dataButton;
    private javax.swing.JTabbedPane debuggerTabbedPane;
    private javax.swing.JLabel directoryLabel;
    private javax.swing.JTextField directoryTextField;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JLabel eventPortLabel;
    private javax.swing.JTextField eventPortTextField;
    private javax.swing.JScrollPane eventScrollPane;
    private javax.swing.JTextArea eventTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JLabel responceLabel;
    private javax.swing.JTextArea responceTextArea;
    private javax.swing.JButton resumeButton;
    private javax.swing.JButton sendCommandButtton;
    private javax.swing.JLabel sessionCommandPortLabel;
    private javax.swing.JTextField sessionCommandTextField;
    private javax.swing.JLabel sessionEventPortLabel;
    private javax.swing.JTextField sessionEventTextField;
    private javax.swing.JPanel sessionPanel;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton startServerButton;
    private javax.swing.JCheckBox startServerInstanceCheckBox;
    private javax.swing.JLabel startSessionLabel;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
