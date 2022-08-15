/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.notepad;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.StyledDocument;
import java.awt.Toolkit;
//import javax.swing.text.DefaultEditorKit;
//import javax.swing.text.JTextComponent;
import javax.swing.text.*;

/**
 *
 * @author eric_
 */
public final class Notepad extends JFrame {
    
    JTextPane textPane;
    AbstractDocument doc;
    static final int MAX_CHARACTERS = 900;
    JTextArea changeLog;
    String newline = "\n";
    HashMap<Object, Action> actions;

    public Notepad() {
        super("Notepad");
        
        //Create the text pane and configure it.
        textPane = new JTextPane();
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5,5,5,5));
        //StyledDocument styledDoc = textPane.getStyledDocument();
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(600, 600));
        
       
        //Create the status area.
        JPanel statusPane = new JPanel(new GridLayout(1, 1));

        //Add the components
        getContentPane().add(statusPane, BorderLayout.CENTER);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        //setting up menu bar
        actions=createActionTable(textPane);
        JMenu fileMenu = createFileMenu();
        JMenu editMenu = createEditMenu();
        JMenu styleMenu = createStyleMenu();
        JMenuBar mb = new JMenuBar();
        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(styleMenu);
        setJMenuBar(mb);
    }
    
    protected JMenu createEditMenu() {
        JMenu menu = new JMenu("Edit");
        
        //testAction = new testAction();
        //menu.add(testAction);
        
        //menu.addSeparator();
        
        menu.add(getActionByName(DefaultEditorKit.cutAction));
        
        return menu;
    }
    
    protected JMenu createStyleMenu() {
        JMenu menu = new JMenu("Style");
        
        Action action = new StyledEditorKit.BoldAction();
        action.putValue(Action.NAME, "BOLD");
        menu.add(action);
        
        menu.addSeparator();
        
        menu.add(new StyledEditorKit.FontFamilyAction("ComicSans", 
                                                      "ComicSans"));
        
        menu.add(new StyledEditorKit.FontFamilyAction("Serif", 
                                                      "Serif"));
        
        menu.addSeparator();
        
        
        
        return menu;
    }
    
    protected JMenu createFileMenu() {
        JMenu menu = new JMenu("File");
        
        //public void newWindow(ActionEvent e) {
        //menu.add(newWindow);
        
        return menu;
    }
    
    // to get built in actions
    private HashMap<Object, Action> createActionTable(JTextComponent textComponent) {
        HashMap<Object, Action> actions = new HashMap<Object, Action>();
        Action[] actionsArray = textComponent.getActions();
        for (int i = 0; i < actionsArray.length; i++) {
            Action a = actionsArray[i];
            actions.put(a.getValue(Action.NAME), a);
        }
        return actions;
    }
    
    // calling built in actions
    private Action getActionByName(String name) {
        return actions.get(name);
    }
    
    public static void initialFrame() {
        final Notepad frame = new Notepad();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setVisible(true);
    }

   
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initialFrame();
            }
        });
    }
}
